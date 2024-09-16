package nunes03.com.github.expensemanager.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import nunes03.com.github.expensemanager.database.entities.CategoryEntity;
import nunes03.com.github.expensemanager.database.repositories.CategoryRepository;
import nunes03.com.github.expensemanager.dto.CategoryDto;
import nunes03.com.github.expensemanager.dto.CategoryPaginationDto;
import nunes03.com.github.expensemanager.services.interfaces.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto findById(UUID id) {
        final var expenseEntity = categoryRepository.findById(id);

        if (expenseEntity.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Category '%s' not found."
            );
        }

        return CategoryDto.toDto(expenseEntity.get());
    }

    @Override
    public CategoryPaginationDto findAll(Integer pageNumber, Integer pageSize) {
        final var page = categoryRepository.findAll(PageRequest.of(pageNumber, pageSize));

        final var dtos = page
            .get()
            .map(CategoryDto::toDto)
            .toList();

        return new CategoryPaginationDto(
            page.getNumberOfElements(),
            page.getTotalPages(),
            dtos
        );
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        CategoryEntity categoryEntity;

        if (dto.getId() == null) {
            categoryEntity = create(dto);
        } else {
            categoryEntity = update(dto);
        }

        return CategoryDto.toDto(categoryEntity);
    }

    @Override
    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }

    private CategoryEntity create(CategoryDto categoryDto) {
        var categoryEntity = new CategoryEntity(
            categoryDto.getName(),
            categoryDto.getRgbColor()
        );

        return categoryRepository.save(categoryEntity);
    }

    private CategoryEntity update(CategoryDto categoryDto) {
        final var currentCategoryDto = findById(categoryDto.getId());

        var expenseEntity = new CategoryEntity(
            currentCategoryDto.getId(),
            categoryDto.getName(),
            categoryDto.getRgbColor()
        );

        return categoryRepository.save(expenseEntity);
    }
}
