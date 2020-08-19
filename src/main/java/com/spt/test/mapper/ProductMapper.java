package com.spt.test.mapper;

import com.spt.test.dto.ProductDto;
import com.spt.test.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto dto);

    ProductDto toDTO(Product product);
}
