package com.tinydemo.spring.cloud.sample.payment.controller;

import com.tinydemo.spring.cloud.sample.commons.web.api.ResultData;
import com.tinydemo.spring.cloud.sample.commons.web.api.ReturnCodeEnum;
import com.tinydemo.spring.cloud.sample.payment.entities.Pay;
import com.tinydemo.spring.cloud.sample.payment.entities.PayDTO;
import com.tinydemo.spring.cloud.sample.payment.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Tag(name = "支付服务")
@Slf4j
public class PayController {

	private final PayService payService;

	@GetMapping("/{id}")
	@Operation(description = "根据id查询支付信息")
	public ResultData<Pay> getPay(@PathVariable("id") Integer id) {
		return ResultData.success(payService.getById(id));
	}

	@GetMapping("/timeout")
	@Operation(description = "测试超时")
	public ResultData<Void> timeout() throws InterruptedException {
		log.info("calling timeout...");
		TimeUnit.SECONDS.sleep(30);
		return ResultData.success();
	}

	@PostMapping("/")
	@Operation(description = "保存支付信息")
	public ResultData<Pay> savePay(@RequestBody PayDTO payDTO) {
		Pay pay = new Pay();
		pay.setOrderNo(payDTO.getOrderNo())
			.setPayNo(payDTO.getPayNo())
			.setUserId(payDTO.getUserId())
			.setAmount(payDTO.getAmount())
			.setDeleted(Byte.valueOf("0"))
			.setCreateTime(new Date())
			.setUpdateTime(new Date());
		if (payService.save(pay)) {
			return ResultData.success();
		}
		else {
			return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "保存失败");
		}
	}

	@PutMapping("/")
	@Operation(description = "更新支付信息")
	public ResultData<Pay> updatePay(@RequestBody PayDTO payDTO) {
		Pay pay = this.payService.getById(payDTO.getId());
		if (pay != null) {
			pay.setOrderNo(payDTO.getOrderNo())
				.setPayNo(payDTO.getPayNo())
				.setUserId(payDTO.getUserId())
				.setAmount(payDTO.getAmount())
				.setDeleted(payDTO.getDeleted())
				.setUpdateTime(new Date());
			if (payService.update(pay)) {
				return ResultData.success();
			}
			else {
				return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "更新失败");
			}
		}
		else {
			return ResultData.fail(ReturnCodeEnum.RC404.getCode(), "更新失败");
		}
	}

	@DeleteMapping("/{id}")
	@Operation(description = "删除支付信息")
	public ResultData<Pay> deletePay(@PathVariable("id") Integer id) {
		if (payService.delete(id)) {
			return ResultData.success();
		}
		else {
			return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "删除失败");
		}
	}

	@GetMapping("/all")
	@Operation(description = "查询所有支付信息")
	public ResultData<List<Pay>> listPay() {
		return ResultData.success(payService.list());
	}

}
