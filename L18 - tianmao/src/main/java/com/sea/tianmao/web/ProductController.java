package com.sea.tianmao.web;

import com.sea.tianmao.pojo.Product;
import com.sea.tianmao.service.ProductService;
import com.sea.tianmao.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid,
                                        @RequestParam(value = "start", defaultValue = "0") int start,
                                        @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Product> page = productService.list(cid, start, size, 5);
        return page;
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") int id) throws Exception {
        productService.delete(id);
        return null;
    }

    @PostMapping("/products")
    public Product add(@RequestBody Product product) throws Exception {
        product.setCreateDate(new Date());
        productService.add(product);
        return product;
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) throws Exception {
        Product product = productService.get(id);
        return product;
    }

    @PutMapping("/products")
    public Product update(@RequestBody Product product) throws Exception {
        productService.update(product);
        return product;
    }
}
