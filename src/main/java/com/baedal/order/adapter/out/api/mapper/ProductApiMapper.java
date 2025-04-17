package com.baedal.order.adapter.out.api.mapper;

import com.baedal.order.adapter.out.api.dto.GetProductResponse;
import com.baedal.order.domain.product.Product;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductApiMapper {

  List<Product> responseToDomain(List<GetProductResponse> response);
}
