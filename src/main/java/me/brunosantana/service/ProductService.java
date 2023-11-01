package me.brunosantana.service;

import me.brunosantana.model.Product;

import java.util.List;

public interface ProductService {
  Product createProduct(Product product);

  Product updateProduct(Product product);

  List<Product> getAllProduct();

  Product getProductById(long productId);

  void deleteProduct(long id);
}
