package com.tinydemo.spring.cloud.sample.payment.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名：t_pay 表注释：支付交易表
 */
@Table(name = "t_pay")
@Schema(description = "支付交易表")
@Data
@Accessors(chain = true)
public class Pay {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 支付流水号
	 */
	@Column(name = "pay_no")
	private String payNo;

	/**
	 * 订单流水号
	 */
	@Column(name = "order_no")
	private String orderNo;

	/**
	 * 用户账号ID
	 */
	@Column(name = "user_id")
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
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

}