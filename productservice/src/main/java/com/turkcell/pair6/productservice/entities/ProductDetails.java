package com.turkcell.pair6.productservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "product_details")
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "offer_name")
    private String offerName;

    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "spec_id")
    private String specId;

    @OneToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
