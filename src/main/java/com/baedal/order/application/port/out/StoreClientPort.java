package com.baedal.order.application.port.out;

import com.baedal.order.domain.store.Store;

public interface StoreClientPort {

  Store findByStoreId(Long storeId);

}
