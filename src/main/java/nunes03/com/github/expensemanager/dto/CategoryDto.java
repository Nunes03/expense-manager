package nunes03.com.github.expensemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nunes03.com.github.expensemanager.database.entities.CategoryEntity;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CategoryDto {

    UUID id;

    String name;

    String rgbColor;

    public CategoryDto(UUID id) {
        this(
            id,
            null,
            null
        );
    }

    public static CategoryDto toDto(CategoryEntity categoryEntity) {
        return new CategoryDto(
            categoryEntity.getId(),
            categoryEntity.getName(),
            categoryEntity.getRgbColor()
        );
    }

    public static CategoryEntity toEntity(CategoryDto expenseDto) {
        return new CategoryEntity(
            expenseDto.getId(),
            expenseDto.getName(),
            expenseDto.getRgbColor()
        );
    }
}
