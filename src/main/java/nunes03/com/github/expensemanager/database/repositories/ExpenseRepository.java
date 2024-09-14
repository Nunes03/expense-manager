package nunes03.com.github.expensemanager.database.repositories;

import nunes03.com.github.expensemanager.database.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID> {
}
