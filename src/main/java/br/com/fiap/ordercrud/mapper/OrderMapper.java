package br.com.fiap.ordercrud.mapper;

import br.com.fiap.ordercrud.core.domain.dto.OrderDto;
import br.com.fiap.ordercrud.core.domain.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderMapper extends BaseMapper<Orders, OrderDto> {
}
