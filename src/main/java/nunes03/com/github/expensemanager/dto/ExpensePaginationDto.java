package nunes03.com.github.expensemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensePaginationDto {

    Integer totalElements = 0;

    Integer totalPages = 0;

    List<ExpenseDto> expenses = new ArrayList<>();
}
