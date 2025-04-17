package com.baedal.order.application.port.out;

import com.baedal.order.domain.product.Product;
import java.util.List;

public interface ProductClientPort {

  List<Product> findByProductIds(List<Long> productIds);
}
