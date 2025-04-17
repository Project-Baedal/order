package com.baedal.order.application.command;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class AddOrderCommand {

  @Getter
  @Builder
  public static class Request {

    private Long customerId;
    private Long storeId;
    private List<Long> productIds;
    private String deliveryAddress;
    private String phoneNumber;
    private String paymentMethod;
    private int totalAmount;
  }

  @Getter
  @Builder
  public static class Response {

    private String orderStatus;
    private String storeName;
    private LocalDateTime orderDate;
    private Long orderId;
    private List<ProductInfo> productInfo;
    private int totalAmount;
    private int totalProductAmount;
    private int deliveryAmount;
    private String paymentMethod;
    private String deliveryAddress;
    private String phoneNumber;

  }

  @Getter
  @Builder
  public static class ProductInfo {
    private String productName;
    private int productPrice;
  }

}
