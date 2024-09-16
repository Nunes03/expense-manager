package nunes03.com.github.expensemanager.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "expense")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "name", length = 100, nullable = false)
    String name;

    @Column(name = "description", length = 500)
    String description;

    @Column(name = "value", precision = 7, scale = 2, nullable = false)
    BigDecimal value;

    @Column(name = "date", nullable = false)
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    CategoryEntity category;

    public ExpenseEntity(UUID id) {
        this(
            id,
            null,
            null,
            null,
            null,
            null
        );
    }

    public ExpenseEntity(String name, String description, BigDecimal value, LocalDate date, CategoryEntity category) {
        this(
            null,
            name,
            description,
            value,
            date,
            category
        );
    }
}
