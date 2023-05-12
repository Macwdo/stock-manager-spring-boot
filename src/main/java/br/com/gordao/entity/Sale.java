package br.com.gordao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Table(name = "sale")
@Entity(name = "sale")
@Getter
@Setter
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotBlank
    @Column(name = "buyer")
    private String buyer;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NotNull
    @Column(name = "offset_date_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime saledAt;

    public Sale(String buyer, Product product, OffsetDateTime saledAt) {
        this.buyer = buyer;
        this.product = product;
        this.saledAt = saledAt;
    }
}
