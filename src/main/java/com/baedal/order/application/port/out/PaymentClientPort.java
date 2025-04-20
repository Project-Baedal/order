package com.baedal.order.application.port.out;

import com.baedal.order.domain.payment.GetPaymentUrl;

public interface PaymentClientPort {

  GetPaymentUrl.Response getPaymentUrl(GetPaymentUrl.Request req);
}
