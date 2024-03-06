package com.w4you.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Order")
@Table(name = "sales_order")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "number"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<Item> items;

    public static class OrderBuilder {
        private String number = generateOrderNumber();

        private static String generateOrderNumber() {
            final LocalDateTime now = LocalDateTime.now();
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            final String formattedDateTime = now.format(formatter);
            return formattedDateTime.concat("-").concat(UUID.randomUUID().toString());
        }
    }
}
