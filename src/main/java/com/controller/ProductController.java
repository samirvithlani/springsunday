package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;

	@RequestMapping("/addproduct")
	public void addProduct(ProductBean productBean) {

		int res = productDao.addProduct(productBean);

		System.out.println(res);
	}

	@RequestMapping("/viewproduct")
	public List<ProductBean> productList() {

		List<ProductBean> list = productDao.productList();

		return list;
	}
}
