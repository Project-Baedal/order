package com.baedal.order.adapter.out.api.mapper;

import com.baedal.order.adapter.out.api.dto.GetCartResponse;
import com.baedal.order.domain.cart.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartApiMapper {

  Cart responseToDomain(GetCartResponse response);
}
