package com.baedal.order.adapter.in.web.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.baedal.order.adapter.in.web.dto.request.AddOrderRequest;
import com.baedal.order.adapter.out.api.client.CartServiceClient;
import com.baedal.order.adapter.out.api.client.ProductServiceClient;
import com.baedal.order.adapter.out.api.client.StoreServiceClient;
import com.baedal.order.adapter.out.api.dto.GetStoreResponse;
import com.baedal.order.adapter.out.messaging.KafkaSender;
import com.baedal.order.global.test.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class OrderTest extends IntegrationTest {

  private OrderMappingURL orderMappingURL;

  @BeforeEach
  void setUp() {
    this.orderMappingURL = new OrderMappingURL(baseUrl, port);
  }


  @MockitoBean
  private CartServiceClient cartServiceClient;
  @MockitoBean
  private StoreServiceClient storeServiceClient;
  @MockitoBean
  private ProductServiceClient productServiceClient;
  @MockitoBean
  private KafkaSender kafkaSender;

  @Test
  @DisplayName("addOrder 성공")
  void addOrder() {
    // given
    AddOrderRequest req = fixtureMonkey.giveMeOne(AddOrderRequest.class);

    // when
    when(storeServiceClient.findByStoreId(any())).thenReturn(GetStoreResponse.builder().build());

    ResponseEntity<String> response = restTemplate.postForEntity(
        orderMappingURL.getAddOrder(),
        req,
        String.class
    );

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

  }
}