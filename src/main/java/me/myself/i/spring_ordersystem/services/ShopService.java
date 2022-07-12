package me.myself.i.spring_ordersystem.services;

import me.myself.i.spring_ordersystem.services.Order.Order;
import me.myself.i.spring_ordersystem.services.Order.OrderRepo;
import me.myself.i.spring_ordersystem.services.product.Product;
import me.myself.i.spring_ordersystem.services.product.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

            private final ProductRepo productRepo;
            private final OrderRepo orderRepo;

            public ShopService(
                    ProductRepo productRepo,
                    OrderRepo orderRepo) {
                this.productRepo = productRepo;
                this.orderRepo = orderRepo;
            }

            public Product getProduct(int id) {
                return productRepo.getProduct(id);
            }

            public List<Product> listProducts() {
                return productRepo.listProducts();
            }

            public void addOrder(int orderId, List<Integer> productIds) {
                List<Product> products = new ArrayList<>();
                for (int productId : productIds) {
                    Product product = productRepo.getProduct(productId);
                    products.add(product);
                }

                Order order = new Order(orderId, products);
                orderRepo.addOrder(order);
            }

            public Order getOrder(int orderId) {
                return orderRepo.getOrder(orderId);
            }

            public List<Order> listOrders() {
                return orderRepo.listOrders();
            }
}
