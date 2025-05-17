package com.baedal.order.adapter.out.persistence.entity;

import com.baedal.order.adapter.out.persistence.enums.OrderEntityStatus;
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

  @Column(nullable = false)
  private Long paymentId;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private List<ProductEntity> products;

  @Column(nullable = false)
  private String deliveryAddress;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private OrderEntityStatus orderStatus;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Builder
  public OrderEntity(Long storeId, Long paymentId, List<ProductEntity> products,
      String deliveryAddress, String phoneNumber, OrderEntityStatus orderStatus,
      LocalDateTime createdAt) {
    this.storeId = storeId;
    this.paymentId = paymentId;
    this.products = products;
    this.deliveryAddress = deliveryAddress;
    this.phoneNumber = phoneNumber;
    this.orderStatus = orderStatus;
    this.createdAt = createdAt;
  }
}
