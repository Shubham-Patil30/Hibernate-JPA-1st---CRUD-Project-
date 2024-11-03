package com.ait.test;

import java.time.LocalDateTime;

import com.ait.dao.impl.ProductDaoImpl;
import com.ait.entity.ProductEntity;

public class ProductTest {

	public static void main(String[] args) {
	ProductDaoImpl productdaoImpl = new ProductDaoImpl(); 
	//===============================
//	 Saving The Product 
//	ProductEntity p1 = new ProductEntity(); 
//	p1.setProductName("Headphone");
//	p1.setProductId(101);
//	p1.setQuantity(1);
//	p1.setUnitPrice(500.00);
//	
//	ProductEntity p2 = new ProductEntity(); 
//	p2.setProductName("Charger");
//	p2.setProductId(102);
//	p2.setQuantity(1);
//	p2.setUnitPrice(300.00);
//	
//	productdaoImpl.saveProduct(p2);
//	
//	ProductEntity headphone = productdaoImpl.saveProduct(p1);
	//==========================================
	// LOading the Product
//	ProductEntity p3 = productdaoImpl.loadProductById(101);
//	System.out.println(p3);
	
	//===================== Updating the product ===============
//	productdaoImpl.updateProductById(p2, 600.00);
	
	//============= Deleting the Product ========== 
	productdaoImpl.deleteProductById(102);
	}
	
	
	
	

}
