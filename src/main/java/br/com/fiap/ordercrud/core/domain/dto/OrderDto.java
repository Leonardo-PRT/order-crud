package br.com.fiap.ordercrud.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class OrderDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private BigDecimal totalValue;

    private Long customerCode;

    private Instant orderDate;

    private Instant createdAt;
}
