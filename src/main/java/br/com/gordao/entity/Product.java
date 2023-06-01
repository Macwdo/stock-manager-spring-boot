package br.com.gordao.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", updatable = false, unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Float value;

    @Column(name = "cost")
    private Float cost;

    @Column(name = "stockQuantity")
    private int stockQuantity;

    public Product(String name, Float value, Float cost, int stockQuantity) {
        this.name = name;
        this.value = value;
        this.cost = cost;
        this.stockQuantity = stockQuantity;
    }
}
