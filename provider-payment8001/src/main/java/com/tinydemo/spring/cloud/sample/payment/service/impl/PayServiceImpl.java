package com.tinydemo.spring.cloud.sample.payment.service.impl;

import com.tinydemo.spring.cloud.sample.payment.entities.Pay;
import com.tinydemo.spring.cloud.sample.payment.mapper.PayMapper;
import com.tinydemo.spring.cloud.sample.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

	private final PayMapper payMapper;

	@Override
	public Pay getById(Integer id) {
		return payMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public boolean save(Pay pay) {
		return this.payMapper.save(pay) == 1;
	}

	@Override
	@Transactional
	public boolean update(Pay pay) {
		return this.payMapper.updateByPrimaryKey(pay) == 1;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		return this.payMapper.deleteByPrimaryKey(id) == 1;
	}

	@Override
	public List<Pay> list() {
		return this.payMapper.selectAll();
	}

}
