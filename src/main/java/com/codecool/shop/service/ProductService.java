package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import java.util.ArrayList;

import java.util.List;

public class ProductService{
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;

    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }

    public List<Product> getProductsFromSupplier(int id){
        List<Product> productsFromSupplier = new ArrayList<>();
        for (Product product : productDao.getAll()){
            if (product.getSupplier().getId() == id){
                productsFromSupplier.add(product);
            }
        }
        return  productsFromSupplier;
    }

    public List<Product> getProductsFromSupplierAndCategory(int categoryId, int supplierId){
        List<Product> productsByCategory = getProductsForCategory(categoryId);
        List<Product> productsFromTheSameSupplierAndCategory = new ArrayList<>();
        for (Product product : productsByCategory){
            if (product.getSupplier().getId() == supplierId){
                productsFromTheSameSupplierAndCategory.add(product);
            }
        }
        return productsFromTheSameSupplierAndCategory;
    }


    public List<Product> getAllProducts(){
        return productDao.getAll();
    }


}
