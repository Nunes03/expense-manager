package nunes03.com.github.expensemanager.routes;

import nunes03.com.github.expensemanager.dto.ExpenseDto;
import nunes03.com.github.expensemanager.dto.ExpensePaginationDto;
import nunes03.com.github.expensemanager.services.interfaces.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/expense")
public class ExpenseRestController {

    final ExpenseService expenseService;

    public ExpenseRestController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ExpenseDto getId(@PathVariable UUID id) {
        return expenseService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public ExpensePaginationDto get(
        @RequestParam Integer pageNumber,
        @RequestParam Integer pageSize
    ) {
        return expenseService.findAll(pageNumber, pageSize);
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public ExpenseDto post(@RequestBody ExpenseDto expenseDto) {
        return expenseService.save(expenseDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ExpenseDto put(
        @PathVariable UUID id,
        @RequestBody ExpenseDto expenseDto
    ) {
        expenseDto.setId(id);
        return expenseService.save(expenseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        expenseService.delete(id);
    }
}
