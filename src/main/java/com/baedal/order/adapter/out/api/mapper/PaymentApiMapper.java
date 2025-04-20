package com.baedal.order.adapter.out.api.mapper;

import com.baedal.order.adapter.out.api.dto.GetPaymentUrlRequest;
import com.baedal.order.adapter.out.api.dto.GetPaymentUrlResponse;
import com.baedal.order.domain.payment.GetPaymentUrl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentApiMapper {

  // 결제 요청
  GetPaymentUrlRequest getPaymentUrlToRequest(GetPaymentUrl.Request req);
  GetPaymentUrl.Response getPaymentUrlResponse(GetPaymentUrlResponse res);
}
