package com.baedal.order.domain.model.payment;

import lombok.Builder;
import lombok.Getter;


public class GetPaymentUrl {

  @Getter
  public static class Request {
    private String partnerOrderId;
    private String partnerUserId;
    private String itemName;
    private Integer quantity;
    private Integer totalAmount;
    private Integer taxFreeAmount;

    @Builder
    public Request(String partnerOrderId, String partnerUserId, String itemName,
        Integer totalAmount) {
      this.partnerOrderId = partnerOrderId;
      this.partnerUserId = partnerUserId;
      this.itemName = itemName;
      this.quantity = 1;
      this.totalAmount = totalAmount;
      this.taxFreeAmount = 0;
    }
  }

  @Getter
  @Builder
  public static class Response {
    private String tid;
    private String nextRedirectAppUrl;
    private String nextRedirectMobileUrl;
    private String nextRedirectPcUrl;
    private String androidAppScheme;
    private String iosAppScheme;
    private String createdAt;
  }

}
