package me.myself.i.spring_ordersystem.controller;

import me.myself.i.spring_ordersystem.services.Order.Order;
import me.myself.i.spring_ordersystem.services.ShopService;
import me.myself.i.spring_ordersystem.services.product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/api/products")
    public List<Product> listOfProducts(){
        return shopService.listProducts();
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable int id){
        return shopService.getProduct(id);
    }

    @GetMapping("/api/orders")
    public List<Order> listOfOrders(){
        return shopService.listOrders();
    }

    @GetMapping("/api/orders/{id}")
    public Order getOrder(@PathVariable int id){
        return shopService.getOrder(id);
    }

    @PostMapping(path="/api/orders/{id}")
    public void addOrder(@PathVariable int id, @RequestBody List<Integer> orderArray) {
        shopService.addOrder(id, orderArray);
    }

}
