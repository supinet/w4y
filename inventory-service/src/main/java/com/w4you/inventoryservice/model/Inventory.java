package com.w4you.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Inventory")
@Table(name = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private Integer quantity;
}
