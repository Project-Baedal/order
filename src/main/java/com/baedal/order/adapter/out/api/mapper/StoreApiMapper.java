package com.baedal.order.adapter.out.api.mapper;

import com.baedal.order.adapter.out.api.dto.GetStoreResponse;
import com.baedal.order.domain.store.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreApiMapper {

  Store responseToDomain(GetStoreResponse response);
}
