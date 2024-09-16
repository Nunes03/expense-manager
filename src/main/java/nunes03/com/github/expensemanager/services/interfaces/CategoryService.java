package nunes03.com.github.expensemanager.services.interfaces;

import nunes03.com.github.expensemanager.dto.CategoryDto;
import nunes03.com.github.expensemanager.dto.CategoryPaginationDto;

import java.util.UUID;

public interface CategoryService extends BaseCrudService<CategoryDto, CategoryPaginationDto, UUID> {
}
