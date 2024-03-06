package com.w4you.orderservice.service;

import com.w4you.orderservice.dto.InventoryResponseDto;
import com.w4you.orderservice.dto.OrderRequestDto;
import com.w4you.orderservice.model.Item;
import com.w4you.orderservice.model.Order;
import com.w4you.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public String createOrder(final OrderRequestDto orderRequest) {

         Order order = Order.builder()
                .build();

        final Set<Item> items = orderRequest.items().stream().map(itemDto -> new Item(itemDto, order)).collect(Collectors.toSet());

        order.setItems(items);

        final Set<String> skus = order.getItems().stream().map(Item::getSku).collect(Collectors.toSet());

        /*
         * call inventory service
         */
        InventoryResponseDto[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skus", skus).build())
                .retrieve()
                .bodyToMono(InventoryResponseDto[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponses))
                    .allMatch(InventoryResponseDto::isInStock);

        if (!allProductsInStock)
            throw new IllegalArgumentException("Product is not in stock, please try again later");

        orderRepository.save(order);

        return "Order Placed Successfully " + order.getId();
    }
}
