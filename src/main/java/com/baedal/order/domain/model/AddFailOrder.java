package com.baedal.order.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddFailOrder {

  private String reason;
  private final Long storeId;
  private final Long paymentId;
  private final String deliveryAddress;
  private final String phoneNumber;
  private final String orderStatus;
  private final LocalDateTime orderDate;
  private final List<AddOrderProduct> products;

}
