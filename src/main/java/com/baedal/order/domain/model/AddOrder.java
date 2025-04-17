package com.baedal.order.domain.model;

import com.baedal.order.adapter.out.persistence.enums.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddOrder {

  private final Long storeId;
  private final String deliveryAddress;
  private final String phoneNumber;
  private final String paymentMethod;
  private final int totalAmount;
  private final String orderStatus;
  private final LocalDateTime orderDate;
  private final List<AddOrderProduct> products;


  @Builder
  public AddOrder(Long storeId, String deliveryAddress, String phoneNumber,
      String paymentMethod, int totalAmount, List<AddOrderProduct> products) {
    this.storeId = storeId;
    this.deliveryAddress = deliveryAddress;
    this.phoneNumber = phoneNumber;
    this.paymentMethod = paymentMethod;
    this.totalAmount = totalAmount;
    this.orderStatus = OrderStatus.PENDING.toString();
    this.orderDate = LocalDateTime.now();
    this.products = products;
  }

}
