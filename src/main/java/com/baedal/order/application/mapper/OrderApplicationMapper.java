package com.baedal.order.application.mapper;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;
import com.baedal.order.domain.model.payment.GetPaymentUrl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderApplicationMapper {

  // 주문 요청

  @Mapping(target = "partnerOrderId", source = "orderId")
  @Mapping(target = "partnerUserId", source = "userId")
  @Mapping(target = "itemName", source = "req.storeId")
  @Mapping(target = "totalAmount", source = "req.paymentInfo.totalAmount")
  GetPaymentUrl.Request getPaymentUrlToDomain(
      AddOrderCommand.Request req, String orderId, String userId
  );

  ValidateCartOrderInfo.Request validateCartOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  @Mapping(target = "totalAmount", source = "req.paymentInfo.totalAmount")
  ValidateProductOrderInfo.Request validateProductOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  ValidateStoreOrderInfo.Request validateStoreOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  AddOrderCommand.Response getPaymentUrlToResponse(GetPaymentUrl.Response res);
}
