package com.baedal.order.adapter.out.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetPaymentUrlResponse {
  private String tid;
  private String nextRedirectAppUrl;
  private String nextRedirectMobileUrl;
  private String nextRedirectPcUrl;
  private String androidAppScheme;
  private String iosAppScheme;
  private String createdAt;
}
