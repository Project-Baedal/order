package com.baedal.order.adapter.in.web.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.baedal.order.adapter.in.web.dto.request.AddOrderRequest;
import com.baedal.order.adapter.out.api.client.CartServiceClient;
import com.baedal.order.adapter.out.api.client.ProductServiceClient;
import com.baedal.order.adapter.out.api.client.StoreServiceClient;
import com.baedal.order.global.test.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class OrderTest extends IntegrationTest {

  private OrderMappingURL orderMappingURL;

  @BeforeEach
  void setUp() {
    this.orderMappingURL = new OrderMappingURL(baseUrl, port);
  }


  @Mock
  private CartServiceClient cartServiceClient;
  @Mock
  private StoreServiceClient storeServiceClient;
  @Mock
  private ProductServiceClient productServiceClient;

  @Test
  @DisplayName("addOrder 성공")
  void addOrder() {
    // given
    AddOrderRequest req = fixtureMonkey.giveMeOne(AddOrderRequest.class);

    // when
    ResponseEntity<String> response = restTemplate.postForEntity(
        orderMappingURL.getAddOrder(),
        req,
        String.class
    );

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

  }
}