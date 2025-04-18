package com.baedal.order.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {

  private Long orderId;
  private Long storeId;
  private List<AddOrderProduct> productInfo;
  private String deliveryAddress;
  private String phoneNumber;
  private String paymentMethod;
  private int totalAmount;
  private int deliveryAmount;
  private String orderStatus;
  private LocalDateTime orderDate;

}
