package com.mateusjose98.dummyapp;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductAttrService {

    private final ProductAttrRepository productAttrRepository;
    private final CacheService<ProductAttr> cacheService;

    public ProductAttrService(ProductAttrRepository productAttrRepository, CacheService<ProductAttr> cacheService) {
        this.productAttrRepository = productAttrRepository;
        this.cacheService = cacheService;
    }

    public ProductAttr get(Integer id) {
        var formCache = cacheService.get(String.valueOf(id));
        if (formCache != null) {
            return formCache;
        }
        return productAttrRepository.findById(id).orElse(null);
    }

    public ProductAttr create(ProductAttr request) {
        request = productAttrRepository.save(request);
        cacheService.save(String.valueOf(request.getId()), request);
        return request;
    }
}
