package com.aravindh.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aravindh.cnp.model.Coupon;
import com.aravindh.cnp.util.ConnectionUtil;

public class CouponDAO {
	
	public void save(Coupon coupon) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO coupon (code,discount,exp_date) VALUES (?,?,?)");
			stmt.setString(1, coupon.getCode());
			stmt.setBigDecimal(2, coupon.getDiscount());
			stmt.setString(3, coupon.getExp_date());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Coupon findByCode(String code) {
		Coupon coupon = new Coupon();
		
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM coupon WHERE code = ?");
			stmt.setString(1, code);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				coupon.setId(rs.getInt(1));
				coupon.setCode(rs.getString(2));
				coupon.setDiscount(rs.getBigDecimal(3));
				coupon.setExp_date(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coupon;
		
	}
	
}
