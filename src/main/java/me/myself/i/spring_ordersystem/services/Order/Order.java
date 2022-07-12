package me.myself.i.spring_ordersystem.services.Order;

import me.myself.i.spring_ordersystem.services.product.Product;

import java.util.List;

public record Order(
        int id,
        List<Product> products
) {
}
