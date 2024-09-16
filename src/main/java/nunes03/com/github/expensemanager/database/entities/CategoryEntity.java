package nunes03.com.github.expensemanager.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = "category")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "name", length = 100, nullable = false)
    String name;

    @Column(name = "description", length = 500)
    String rgbColor;

    public CategoryEntity(UUID id) {
        this.id = id;
    }

    public CategoryEntity(String name, String rgbColor) {
        this.name = name;
        this.rgbColor = rgbColor;
    }
}
