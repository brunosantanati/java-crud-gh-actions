package me.brunosantana.service;

import me.brunosantana.exception.ResourceNotFoundException;
import me.brunosantana.model.Product;
import me.brunosantana.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

  @Mock private ProductRepository productRepository;

  @InjectMocks private ProductServiceImpl productService;

  @Test
  public void shouldDeleteProductSuccessfully() {
    Product product =
        Product.builder()
            .id(1L)
            .name("Test")
            .description("Test")
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();

    Optional<Product> optional = Optional.of(product);

    when(productRepository.findById(any())).thenReturn(optional);

    productService.deleteProduct(1L);

    verify(productRepository, times(1)).findById(anyLong());
    verify(productRepository, times(2)).delete(optional.get());
  }

  @Test
  public void shouldThrowExceptionWhenCannotFindProductWhileDeletingProduct() {
    when(productRepository.findById(any())).thenReturn(Optional.empty());

    ResourceNotFoundException ex =
        assertThrows(
            ResourceNotFoundException.class,
            () -> {
              productService.deleteProduct(1L);
            });

    assertEquals("Record not found with id: 1", ex.getMessage());
  }
}
