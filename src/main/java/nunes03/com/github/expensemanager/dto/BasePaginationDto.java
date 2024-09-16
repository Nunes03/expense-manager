package nunes03.com.github.expensemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePaginationDto {

    Integer totalElements = 0;

    Integer totalPages = 0;
}
