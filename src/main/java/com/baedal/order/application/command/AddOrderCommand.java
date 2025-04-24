package com.baedal.order.application.command;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class AddOrderCommand {

  @Getter
  @Builder
  public static class Request {

    private Long customerId;
    private Long storeId;
    private List<ProductInfo> productIds;
    private String deliveryAddress;
    private String phoneNumber;
    private PaymentInfo paymentInfo;
    private int deliveryAmount;
  }

  @Getter
  @Builder
  public static class ProductInfo {
    private Long productId;
    private String productName;
    private int price;
  }

  @Getter
  @Builder
  public static class Response {

    private String tid;
    private String orderTransactionId;
    private String nextRedirectAppUrl;
    private String nextRedirectMobileUrl;
    private String nextRedirectPcUrl;
    private String androidAppScheme;
    private String iosAppScheme;
    private String createdAt;

  }

  @Getter
  @Builder
  public static class PaymentInfo {
    private String paymentMethod;
    private int totalAmount;
  }

}
