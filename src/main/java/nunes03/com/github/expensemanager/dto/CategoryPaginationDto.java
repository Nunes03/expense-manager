package nunes03.com.github.expensemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class CategoryPaginationDto extends BasePaginationDto {

    List<CategoryDto> elements = new ArrayList<>();

    public CategoryPaginationDto(Integer totalElements, Integer totalPages, List<CategoryDto> elements) {
        super(totalElements, totalPages);
        this.elements = elements;
    }
}
