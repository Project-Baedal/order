package com.baedal.order.adapter.out.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long storeId;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private List<ProductEntity> products;

  @Column(nullable = false)
  private String deliveryAddress;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private String paymentMethod;

  @Column(nullable = false)
  private int deliveryAmount;

  @Column(nullable = false)
  private int totalAmount;

  @Column(nullable = false)
  private String orderStatus;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Builder
  public OrderEntity(Long storeId, List<ProductEntity> products, String deliveryAddress,
      String phoneNumber, String paymentMethod, int deliveryAmount, int totalAmount,
      String orderStatus, LocalDateTime createdAt) {
    this.storeId = storeId;
    this.products = products;
    this.deliveryAddress = deliveryAddress;
    this.phoneNumber = phoneNumber;
    this.paymentMethod = paymentMethod;
    this.deliveryAmount = deliveryAmount;
    this.totalAmount = totalAmount;
    this.orderStatus = orderStatus;
    this.createdAt = createdAt;
  }
}
