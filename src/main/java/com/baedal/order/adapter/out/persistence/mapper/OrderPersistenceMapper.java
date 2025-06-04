package com.baedal.order.adapter.out.persistence.mapper;

import com.baedal.order.adapter.out.persistence.dto.OrderValidateDto;
import com.baedal.order.adapter.out.persistence.dto.SaveTempOrderDto;
import com.baedal.order.adapter.out.persistence.entity.OrderEntity;
import com.baedal.order.adapter.out.persistence.entity.ProductEntity;
import com.baedal.order.adapter.out.persistence.enums.OrderEntityStatus;
import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.AddOrderProduct;
import com.baedal.order.domain.model.AddOrderValidate;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.TempOrder;
import com.baedal.order.domain.model.OrderStatus;
import com.baedal.order.domain.model.TempOrder;
import com.baedal.order.domain.model.ValidateResult;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

  OrderEntity toEntity(Order order);

  @Mapping(target = "createdAt", source = "orderDate")
  OrderEntity toEntity(AddOrder addOrder);

  ProductEntity toEntity(AddOrderProduct productDTO);

  @Mapping(target = "orderId", source = "id")
  @Mapping(target = "orderDate", source = "createdAt")
  @Mapping(target = "productInfo", source = "products")
  Order toDomain(OrderEntity entity);

  // 검증 추가
  OrderValidateDto addOrderValidateToDto(AddOrderValidate req);

  // 검증 조회
  Set<ValidateResult> getOrderValidateToDomain(Set<OrderValidateDto> res);

  // 주문 임시 저장
  SaveTempOrderDto saveTempOrderToDto(AddOrderCommand.Request req);

  OrderEntityStatus mapStatusEnum(OrderStatus status);

  TempOrder toDomain(SaveTempOrderDto dto);

  // 임시 주문 조회
  TempOrder saveTempOrderToTempOrder(SaveTempOrderDto dto);
}
