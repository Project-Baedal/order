package com.baedal.order.adapter.out.persistence.mapper;

import com.baedal.order.adapter.out.persistence.dto.SaveTempOrderDto;
import com.baedal.order.domain.model.TempOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TempOrderPersistenceMapper {

  TempOrder toDomain(SaveTempOrderDto dto);
}
