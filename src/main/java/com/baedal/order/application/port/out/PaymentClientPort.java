package com.baedal.order.application.port.out;

import com.baedal.order.domain.model.payment.GetPaymentUrl;

public interface PaymentClientPort {

  GetPaymentUrl.Response getPaymentUrl(GetPaymentUrl.Request req);
}
