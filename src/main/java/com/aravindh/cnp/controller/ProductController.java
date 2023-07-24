package com.aravindh.cnp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aravindh.cnp.dao.CouponDAO;
import com.aravindh.cnp.dao.ProductDAO;
import com.aravindh.cnp.model.Coupon;
import com.aravindh.cnp.model.Product;


@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	CouponDAO cdao = new CouponDAO();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String couponCode = request.getParameter("couponCode");
		Coupon coupon = cdao.findByCode(couponCode);
		
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		
		pdao.save(product);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h3>Product Created</h3>");
		out.print("<br><a href = 'index.html'>Home</a>");
		
		
		
	}

}
