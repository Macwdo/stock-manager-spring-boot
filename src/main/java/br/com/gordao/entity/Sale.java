package br.com.gordao.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Table(name = "sale")
@Entity(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "buyer")
    private String buyer;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    @Column(name = "offset_date_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime saledAt;

    public Sale(){};

    public Sale(String buyer, Product product, OffsetDateTime saledAt) {
        this.buyer = buyer;
        this.product = product;
        this.saledAt = saledAt;
    }
}
