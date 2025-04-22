package com.baedal.order.adapter.in.web.controller;

public class OrderMappingURL {

  private final String BASE_URL;

  public OrderMappingURL(String BASE_URL, int port) {
    this.BASE_URL = BASE_URL + port + "/api/order";
  }

  private final String ADD_ORDER = "/";

  public String getAddOrder() {
    return BASE_URL + ADD_ORDER;
  }
}
