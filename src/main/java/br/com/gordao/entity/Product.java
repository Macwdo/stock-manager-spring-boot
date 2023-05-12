package br.com.gordao.entity;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "product")
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "value")
    private Float value;
    @Column(name = "coust")
    private Float coust;
    @Column(name = "stockQuantity")
    private int stockQuantity;

    public Product(){}

    public Product(String productName, Float value, Float coust, int stockQuantity) {
        this.productName = productName;
        this.value = value;
        this.coust = coust;
        this.stockQuantity = stockQuantity;
    }
}
