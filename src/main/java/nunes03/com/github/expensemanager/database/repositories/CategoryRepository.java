package nunes03.com.github.expensemanager.database.repositories;

import nunes03.com.github.expensemanager.database.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}
