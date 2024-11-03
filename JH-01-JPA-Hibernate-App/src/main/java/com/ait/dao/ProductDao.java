package com.ait.dao;

import com.ait.entity.ProductEntity;

public interface ProductDao {

		ProductEntity saveProduct(ProductEntity product);
		
		ProductEntity loadProductById(Integer productId);
		
		ProductEntity updateProductById(ProductEntity product , Double newProductPrice);
		
		void deleteProductById(Integer productId);
}
