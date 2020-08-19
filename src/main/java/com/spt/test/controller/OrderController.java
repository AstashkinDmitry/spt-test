package com.spt.test.controller;

import com.spt.test.dto.ProductOrderDto;
import com.spt.test.entity.ProductOrder;
import com.spt.test.mapper.ProductOrderMapper;
import com.spt.test.service.ProductOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final ProductOrderService productOrderService;
    private final ProductOrderMapper productOrderMapper;

    public OrderController(ProductOrderService productOrderService, ProductOrderMapper productOrderMapper) {
        this.productOrderService = productOrderService;
        this.productOrderMapper = productOrderMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductOrderDto>> getAllOrders() {
        List<ProductOrder> orders = productOrderService.getAll();
        return ResponseEntity.ok(orders.stream().map(productOrderMapper::toDto).collect(Collectors.toList()));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductOrderDto> createOrder(@Valid @RequestBody ProductOrderDto dto) {
        ProductOrder order = productOrderMapper.toEntity(dto);
        ProductOrder createdOrder = productOrderService.createOrder(order);
        return ResponseEntity.ok(productOrderMapper.toDto(createdOrder));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
