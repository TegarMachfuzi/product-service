package com.example.productservice.service;

import com.example.productservice.dto.SpecDto;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    //hjh
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) {
        SpecDto categoryDto = new SpecDto();
        categoryDto.setRam(productRequest.getSpec().getRam());
        categoryDto.setProcessor(productRequest.getSpec().getProcessor());
        categoryDto.setDisplay(productRequest.getSpec().getDisplay());
        categoryDto.setKonektifitas(productRequest.getSpec().getKonektifitas());
        categoryDto.setOpticalDrive(productRequest.getSpec().getOpticalDrive());
        categoryDto.setHardDrive(productRequest.getSpec().getHardDrive());
        categoryDto.setSistemOperasi(productRequest.getSpec().getSistemOperasi());
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).spec(categoryDto)
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
        return product;
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
        //test
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
