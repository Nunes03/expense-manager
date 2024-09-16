package nunes03.com.github.expensemanager.services.interfaces;

import nunes03.com.github.expensemanager.dto.ExpenseDto;
import nunes03.com.github.expensemanager.dto.ExpensePaginationDto;

import java.util.UUID;

public interface ExpenseService extends BaseCrudService<ExpenseDto, ExpensePaginationDto, UUID> {
}
