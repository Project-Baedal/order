package com.baedal.order.adapter.out.persistence.repository;

import com.baedal.order.adapter.out.persistence.entity.OrderReasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReasonJpaRepository extends JpaRepository<OrderReasonEntity, Long> {

}
