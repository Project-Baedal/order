package com.baedal.order.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddOrder {

  private final Long storeId;
  private final Long paymentId;
  private final String deliveryAddress;
  private final String phoneNumber;
  private final String orderStatus;
  private final LocalDateTime orderDate;
  private final List<AddOrderProduct> products;


  @Builder
  public AddOrder(
      Long storeId, Long paymentId, String deliveryAddress, String phoneNumber,
      List<AddOrderProduct> products
  ) {
    this.storeId = storeId;
    this.paymentId = paymentId;
    this.deliveryAddress = deliveryAddress;
    this.phoneNumber = phoneNumber;
    this.orderStatus = OrderStatus.PENDING.toString();
    this.orderDate = LocalDateTime.now();
    this.products = products;
  }

}
