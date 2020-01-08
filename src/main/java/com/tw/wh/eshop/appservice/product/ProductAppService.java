package com.tw.wh.eshop.appservice.product;

import com.tw.wh.eshop.domain.product.Product;
import com.tw.wh.eshop.domain.product.ProductFactory;
import com.tw.wh.eshop.domain.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductAppService {

  private ProductRepository productRepository;

  public ProductAppService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public String createProduct(CreateProductCommand command) {
    Product product =
        ProductFactory.create(command.getName(), command.getDescription(), command.getPrice());
    productRepository.save(product);
    return product.getId();
  }

  public ProductPTO byId(String id) {
    Product product = productRepository.byId(id);
    return new ProductPTO(
        product.getId(), product.getName(), product.getDescription(), product.getPrice());
  }
}
