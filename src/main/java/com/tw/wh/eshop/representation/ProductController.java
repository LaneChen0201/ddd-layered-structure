package com.tw.wh.eshop.representation;

import com.tw.wh.eshop.appservice.product.CreateProductCommand;
import com.tw.wh.eshop.appservice.product.ProductAppService;
import com.tw.wh.eshop.appservice.product.ProductPTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductAppService productAppService;

    public ProductController(ProductAppService productAppService) {
        this.productAppService = productAppService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public String createProduct(@RequestBody @Valid CreateProductCommand command) {
        return productAppService.createProduct(command);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ProductPTO byId(@PathVariable(name = "id") String id) {
        // TODO: 获取单个Product详情
        return productAppService.byId(id);
    }

}
