package com.baedal.order.application.mapper;

import com.baedal.order.application.command.AddOrderCommand;
import com.baedal.order.application.command.AddOrderCommand.ProductInfo;
import com.baedal.order.domain.model.AddOrder;
import com.baedal.order.domain.model.AddOrderProduct;
import com.baedal.order.domain.model.Order;
import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import com.baedal.order.domain.model.product.ValidateProductOrderInfo;
import com.baedal.order.domain.model.store.ValidateStoreOrderInfo;
import com.baedal.order.domain.payment.GetPaymentUrl;
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

  AddOrderCommand.Response toResponse(Order order, String storeName, int totalProductAmount);

  @Mapping(target = "productName", source = "name")
  @Mapping(target = "productPrice", source = "price")
  ProductInfo toResponse(AddOrderProduct product);

  @Mapping(target = "partnerOrderId", source = "orderId")
  @Mapping(target = "partnerUserId", source = "userId")
  @Mapping(target = "itemName", source = "req.storeId")
  GetPaymentUrl.Request getPaymentUrlToDomain(
      AddOrderCommand.Request req, String orderId, String userId
  );

  ValidateCartOrderInfo.Request validateCartOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  ValidateProductOrderInfo.Request validateProductOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  ValidateStoreOrderInfo.Request validateStoreOrderInfoToDomain(
      AddOrderCommand.Request req, String orderTransactionId
  );

  AddOrderCommand.Response getPaymentUrlToResponse(GetPaymentUrl.Response res);
}
