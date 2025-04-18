package com.baedal.order.application.mapper;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.product.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderApplicationMapper {

  // 주문 등록
  @Mapping(target = "products", source = "products")
  @Mapping(target = "paymentMethod", source = "req.paymentInfo.paymentMethod")
  AddOrder toAddOrder(AddOrderCommand.Request req, List<Product> products);

  AddOrderCommand.Response toResponse(Order order);

}
