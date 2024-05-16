package com.mateusjose98.dummyapp;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductAttrController {

    private final ProductAttrService productAttrService;

    public ProductAttrController(ProductAttrService productAttrService) {
        this.productAttrService = productAttrService;
    }

    @GetMapping("/{id}")
    public ProductAttr get(@PathVariable("id") Integer id) {
        System.out.println("GET /product_attr/" + id);
        return productAttrService.get(id);
    }

    @PostMapping
    public ProductAttr post(@RequestBody ProductAttr request) {
        System.out.println("POST /product_attr");
        return productAttrService.create(request);
    }
}
