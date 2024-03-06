package com.w4you.orderservice.model;

import com.w4you.orderservice.dto.ItemDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Item")
@Table(name = "sales_order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "sku", "price", "quantity"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private BigDecimal price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "sales_order_id")
    private Order order;
    public Item(final ItemDto itemDto, final Order order) {
        this.sku = itemDto.sku();
        this.price = itemDto.price();
        this.quantity = itemDto.quantity();
        this.order = order;
    }
}
