package com.tinydemo.spring.cloud.sample.order.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Pay {

	private Integer id;

	/**
	 * 支付流水号
	 */
	private String payNo;

	/**
	 * 订单流水号
	 */
	private String orderNo;

	/**
	 * 用户账号ID
	 */
	private Integer userId;

	/**
	 * 交易金额
	 */
	private BigDecimal amount;

	/**
	 * 删除标志，默认0不删除，1删除
	 */
	private Byte deleted;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

}