package br.com.gordao.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

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
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Float value;

    @Column(name = "coust")
    private Float coust;

    @Column(name = "stockQuantity")
    private int stockQuantity;

    public Product(String name, Float value, Float coust, int stockQuantity) {
        this.name = name;
        this.value = value;
        this.coust = coust;
        this.stockQuantity = stockQuantity;
    }
}
