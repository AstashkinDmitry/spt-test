package com.spt.test.mapper;

import com.spt.test.dto.ProductOrderDto;
import com.spt.test.entity.ProductOrder;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = ProductMapper.class,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface ProductOrderMapper {

    ProductOrder toEntity(ProductOrderDto dto);

    ProductOrderDto toDto(ProductOrder order);

}
