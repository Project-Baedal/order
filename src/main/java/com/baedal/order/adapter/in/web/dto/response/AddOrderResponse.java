package com.baedal.order.adapter.in.web.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddOrderResponse {

  @Schema(description = "결제 고유 번호")
  private String tid;

  @Schema(description = "APP 결제 URL")
  private String nextRedirectAppUrl;

  @Schema(description = "Mobile 결제 URL")
  private String nextRedirectMobileUrl;

  @Schema(description = "PC 결제 URL")
  private String nextRedirectPcUrl;

  @Schema(description = "ANDROID 내부 서비스 결제 URL")
  private String androidAppScheme;

  @Schema(description = "IOS 내부 서비스 결제 URL")
  private String iosAppScheme;

  @Schema(description = "결제 준비 요청 시간")
  private String createdAt;


}
