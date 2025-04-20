package com.baedal.order.adapter.out.api.adapter;

import com.baedal.order.adapter.out.api.client.PaymentServiceClient;
import com.baedal.order.adapter.out.api.dto.GetPaymentUrlRequest;
import com.baedal.order.adapter.out.api.dto.GetPaymentUrlResponse;
import com.baedal.order.adapter.out.api.mapper.PaymentApiMapper;
import com.baedal.order.application.port.out.PaymentClientPort;
import com.baedal.order.domain.payment.GetPaymentUrl;
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
