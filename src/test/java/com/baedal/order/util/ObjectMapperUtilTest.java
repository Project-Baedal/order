package com.baedal.order.util;

import com.baedal.order.domain.model.cart.ValidateCartOrderInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ObjectMapperUtilTest {

  @Test
  @DisplayName("parameter가 string 이면 결과가 json이 아님.")
  void mapString() {
    String stringMessage = "hello";

    String json = ObjectMapperUtil.toJson(stringMessage);
    System.out.println("json1 = " + json);
  }

  @Test
  void mapObject() {
    ValidateCartOrderInfo.Request req = ValidateCartOrderInfo.Request.builder()
        .storeId(1L)
        .customerId(12L)
        .build();

    String json = ObjectMapperUtil.toJson(req);
    System.out.println("json2 = " + json);
  }
}