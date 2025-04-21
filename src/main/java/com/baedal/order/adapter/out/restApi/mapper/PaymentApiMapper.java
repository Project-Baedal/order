package com.baedal.order.adapter.out.restApi.mapper;

import com.baedal.order.adapter.out.restApi.dto.GetPaymentUrlRequest;
import com.baedal.order.adapter.out.restApi.dto.GetPaymentUrlResponse;
import com.baedal.order.domain.model.payment.GetPaymentUrl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentApiMapper {

  // 결제 요청
  GetPaymentUrlRequest getPaymentUrlToRequest(GetPaymentUrl.Request req);
  GetPaymentUrl.Response getPaymentUrlResponse(GetPaymentUrlResponse res);
}
