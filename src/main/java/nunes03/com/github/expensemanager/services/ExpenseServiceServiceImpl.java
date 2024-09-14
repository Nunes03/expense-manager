package nunes03.com.github.expensemanager.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import nunes03.com.github.expensemanager.database.entities.ExpenseEntity;
import nunes03.com.github.expensemanager.database.repositories.ExpenseRepository;
import nunes03.com.github.expensemanager.dto.ExpenseDto;
import nunes03.com.github.expensemanager.dto.ExpensePaginationDto;
import nunes03.com.github.expensemanager.services.interfaces.ExpenseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenseServiceServiceImpl implements ExpenseService {

    ExpenseRepository expenseRepository;

    public ExpenseServiceServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseDto findById(UUID id) {
        final var expenseEntity = expenseRepository.findById(id);

        if (expenseEntity.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Expense '%s' not found."
            );
        }

        return ExpenseDto.toDto(expenseEntity.get());
    }

    @Override
    public ExpensePaginationDto findAll(Integer pageNumber, Integer pageSize) {
        final var page = expenseRepository.findAll(PageRequest.of(pageNumber, pageSize));

        final var expensesDto = page
            .get()
            .map(ExpenseDto::toDto)
            .collect(Collectors.toList());

        return new ExpensePaginationDto(
            page.getNumberOfElements(),
            page.getTotalPages(),
            expensesDto
        );
    }

    @Override
    public ExpenseDto save(ExpenseDto dto) {
        ExpenseEntity expenseEntity;

        if (dto.getId() == null) {
            expenseEntity = create(dto);
        } else {
            expenseEntity = update(dto);
        }

        return ExpenseDto.toDto(expenseEntity);
    }

    @Override
    public void delete(UUID id) {
        expenseRepository.deleteById(id);
    }

    private ExpenseEntity create(ExpenseDto expenseDto) {
        var expenseEntity = new ExpenseEntity(
            expenseDto.getName(),
            expenseDto.getDescription(),
            expenseDto.getValue(),
            expenseDto.getDate()
        );

        return expenseRepository.save(expenseEntity);
    }

    private ExpenseEntity update(ExpenseDto expenseDto) {
        final var currentExpenseDto = findById(expenseDto.getId());

        var expenseEntity = new ExpenseEntity(
            currentExpenseDto.getId(),
            expenseDto.getName(),
            expenseDto.getDescription(),
            expenseDto.getValue(),
            expenseDto.getDate()
        );

        return expenseRepository.save(expenseEntity);
    }
}
