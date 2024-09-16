package nunes03.com.github.expensemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nunes03.com.github.expensemanager.database.entities.CategoryEntity;
import nunes03.com.github.expensemanager.database.entities.ExpenseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    UUID id;

    String name;

    String description;

    BigDecimal value;

    LocalDate date;

    CategoryDto category;

    public ExpenseDto(UUID id) {
        this(
            id,
            null,
            null,
            null,
            null,
            null
        );
    }

    public static ExpenseDto toDto(ExpenseEntity expenseEntity) {
        final var categoryDto = new CategoryDto(expenseEntity.getCategory().getId());

        return new ExpenseDto(
            expenseEntity.getId(),
            expenseEntity.getName(),
            expenseEntity.getDescription(),
            expenseEntity.getValue(),
            expenseEntity.getDate(),
            categoryDto
        );
    }

    public static ExpenseEntity toEntity(ExpenseDto expenseDto) {
        final var category = new CategoryEntity(expenseDto.getCategory().getId());

        return new ExpenseEntity(
            expenseDto.getId(),
            expenseDto.getName(),
            expenseDto.getDescription(),
            expenseDto.getValue(),
            expenseDto.getDate(),
            category
        );
    }
}
