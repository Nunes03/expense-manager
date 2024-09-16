package nunes03.com.github.expensemanager.routes;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import nunes03.com.github.expensemanager.dto.CategoryDto;
import nunes03.com.github.expensemanager.dto.CategoryPaginationDto;
import nunes03.com.github.expensemanager.services.interfaces.CategoryService;
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
@RequestMapping(value = "/api/category")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryRestController {

    CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryDto getId(
        @PathVariable UUID id
    ) {
        return categoryService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryPaginationDto get(
        @RequestParam Integer pageNumber,
        @RequestParam Integer pageSize
    ) {
        return categoryService.findAll(pageNumber, pageSize);
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public CategoryDto post(
        @RequestBody CategoryDto expenseDto
    ) {
        return categoryService.save(expenseDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CategoryDto put(
        @PathVariable UUID id,
        @RequestBody CategoryDto expenseDto
    ) {
        expenseDto.setId(id);
        return categoryService.save(expenseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(
        @PathVariable UUID id
    ) {
        categoryService.delete(id);
    }
}
