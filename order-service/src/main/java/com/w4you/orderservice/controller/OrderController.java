package com.w4you.orderservice.controller;

import com.w4you.orderservice.dto.OrderRequestDto;
import com.w4you.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    final private OrderService orderService;
    @PostMapping
    @Transactional
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> createOrder(@RequestBody @Valid final OrderRequestDto orderRequest, UriComponentsBuilder uriBuilder) {
        return CompletableFuture.supplyAsync(() -> orderService.createOrder(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequestDto orderRequest, UriComponentsBuilder uriBuilder, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please order later");
    }
}
