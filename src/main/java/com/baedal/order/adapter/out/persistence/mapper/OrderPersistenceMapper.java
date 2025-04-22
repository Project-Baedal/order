package com.baedal.order.adapter.out.persistence.mapper;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.entity.ProductEntity;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.AddOrderProduct;
import com.baedal.order.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

  @Mapping(target = "createdAt", source = "orderDate")
  OrderEntity toEntity(AddOrder addOrder);

  ProductEntity toEntity(AddOrderProduct productDTO);

  @Mapping(target = "orderId", source = "id")
  @Mapping(target = "orderDate", source = "createdAt")
  @Mapping(target = "productInfo", source = "products")
  Order toDomain(OrderEntity entity);

}
