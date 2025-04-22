package com.baedal.order.adapter.out.restApi.adapters;

import com.baedal.order.adapter.out.restApi.client.PaymentServiceClient;
import com.baedal.order.adapter.out.restApi.dto.GetPaymentUrlRequest;
import com.baedal.order.adapter.out.restApi.dto.GetPaymentUrlResponse;
import com.baedal.order.adapter.out.restApi.mapper.PaymentApiMapper;
import com.baedal.order.application.port.out.PaymentClientPort;
import com.baedal.order.domain.model.payment.GetPaymentUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentServiceAdapter implements PaymentClientPort {

  private final PaymentApiMapper paymentMapper;
  private final PaymentServiceClient paymentServiceClient;

  @Override
  public GetPaymentUrl.Response getPaymentUrl(GetPaymentUrl.Request req) {
    GetPaymentUrlRequest request = paymentMapper.getPaymentUrlToRequest(req);
    GetPaymentUrlResponse response = paymentServiceClient.getPaymentUrl(request);
    return paymentMapper.getPaymentUrlResponse(response);
  }
}
