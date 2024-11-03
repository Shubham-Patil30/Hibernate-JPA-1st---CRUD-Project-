package com.ait.dao.impl;

import com.ait.dao.ProductDao;
import com.ait.entity.ProductEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductDaoImpl implements ProductDao{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		EntityManager entityManager = factory.createEntityManager(); 
		EntityTransaction tx = entityManager.getTransaction(); 
		tx.begin();
		try {
			ProductEntity existingProduct = entityManager.find(ProductEntity.class, product.getProductId());
			
			if(existingProduct != null) {
				System.out.println("Product Allready added..");
			}
			else {
				 entityManager.persist(product);
				  System.out.println("Product Successfully inserted into databse...");
				  tx.commit();
			}
		} catch (Exception e) {
			tx.rollback();
			System.out.println(" can not insert product into database");
		}
		finally {
		 entityManager.close();
		}
		return product;
	}
	@Override
	public ProductEntity loadProductById(Integer productId) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity p = entityManager.find(ProductEntity.class, productId);
		entityManager.close();
		return p;
	}
	@Override
	public void deleteProductById(Integer productId) {
		EntityManager entityManager = factory.createEntityManager(); 
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			ProductEntity product = entityManager.find(ProductEntity.class, productId);
			if(product != null) {
				entityManager.remove(product);
				System.out.println("Product Successfully deleted from database .... ");
			}
			else {
				System.out.println("Product not found ..");
			}
			tx.commit();
		}
		catch(Exception e ){
			tx.rollback();
			System.out.println(e.getMessage());
			System.out.println("can not delete product from database");
			
		}
		finally {
			entityManager.close();
		}
		
	}
	@Override
	public ProductEntity updateProductById(ProductEntity product, Double newProductPrice) {
		EntityManager entityManager = factory.createEntityManager(); 
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			ProductEntity existingProduct = entityManager.find(ProductEntity.class,product.getProductId() );
			if(existingProduct != null) {
				existingProduct.setUnitPrice(newProductPrice);
				entityManager.merge(existingProduct);
				System.out.println("Product Successfully updated in database...");
				tx.commit();
			}
			else {
				 System.out.println("Product not found with ID: " + product.getProductId());
			}
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("can not update the product");
			
		}
		finally {
			entityManager.close();
		}
		return product;
	}
}
