package com.baedal.order.adapter.out.persistence.mapper;

import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.entity.OrderReasonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderReasonPersistenceMapper {

  OrderReasonEntity toEntity(OrderEntity orderEntity);
}
