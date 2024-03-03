package com.tinydemo.spring.cloud.sample.order.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class PayDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String payNo;

	private String orderNo;

	private Integer userId;

	private BigDecimal amount;

}
