package com.baedal.order.application.mapper;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.command.AddOrderCommand.ProductInfo;
import com.baedal.order.application.command.OrderValidateCommand;
import com.baedal.order.application.command.store.RequestStoreOrderCommand;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.AddOrderValidate;
import com.baedal.order.domain.model.FailOrder;
import com.baedal.order.domain.model.TempOrder;
import com.baedal.order.domain.model.ValidateResult;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.payment.GetPaymentUrl;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.rider.AddRiderQueueRequest;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;
import java.util.List;
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

  @Mapping(target = "productIds", expression = "java(getProductId(productInfo))")
  ValidateCartOrderInfo.Request validateCartOrderInfoToDomain(
      String orderTransactionId, Long customerId, List<ProductInfo> productInfo, Long storeId
  );

  default List<Long> getProductId(List<ProductInfo> productInfo) {
    return productInfo.stream().map(ProductInfo::getProductId).toList();
  }

  ;

  ValidateProductOrderInfo.Request validateProductOrderInfoToDomain(
      List<AddOrderCommand.ProductInfo> productInfo,
      String orderTransactionId,
      Long storeId
  );

  ValidateStoreOrderInfo.Request validateStoreOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  AddOrderCommand.Response getPaymentUrlToResponse(
      GetPaymentUrl.Response res, String orderTransactionId
  );

  // 주문 검증
  ValidateResult orderValidateResultToDomain(OrderValidateCommand.Request req);

  AddOrderValidate addOrderValidateToDomain(OrderValidateCommand.Request req);

  AddRiderQueueRequest addRiderQueueRequest(Long orderId);

  // 주문 성공
  AddOrder tempOrderToDomain(TempOrder tempOrder);

  RequestStoreOrderCommand.Request addOrderToDomain(AddOrder addOrder);

  // 만료 주문 취소
  FailOrder.Request cancelExpiredOrderToDomain(String orderTransactionId, String domain);
}
