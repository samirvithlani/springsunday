package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addProduct(ProductBean productBean) {

		return jdbcTemplate.update("insert into product(pname,pprice)values(?,?)", productBean.getpName(),
				productBean.getpPrice());
	}

	private final static class ProductMapper implements RowMapper<ProductBean> {

		public ProductBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductBean productBean = new ProductBean();
			productBean.setpId(rs.getInt("pid"));
			productBean.setpName(rs.getString("pname"));
			productBean.setpPrice(rs.getInt("pprice"));

			return productBean;
		}

	}
	
	public List<ProductBean> productList(){
		
		
		return jdbcTemplate.query("select * from product", new ProductMapper());
	}
}
