package com.tinydemo.spring.cloud.sample.payment.service;

import com.tinydemo.spring.cloud.sample.payment.entities.Pay;

import java.util.List;

public interface PayService {

	Pay getById(Integer id);

	boolean save(Pay pay);

	boolean update(Pay pay);

	boolean delete(Integer id);

	List<Pay> list();

}
