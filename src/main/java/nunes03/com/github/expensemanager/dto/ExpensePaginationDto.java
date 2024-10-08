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
public final class ExpensePaginationDto extends BasePaginationDto {

    List<ExpenseDto> elements = new ArrayList<>();

    public ExpensePaginationDto(Integer totalElements, Integer totalPages, List<ExpenseDto> elements) {
        super(totalElements, totalPages);
        this.elements = elements;
    }
}
