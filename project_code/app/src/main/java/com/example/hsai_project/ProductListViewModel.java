package com.example.hsai_project;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class ProductListViewModel extends AndroidViewModel {
    private ProductRepository repository;
    private MutableLiveData<String>searchQuery = new MutableLiveData<String>();
    private LiveData<List<ProductEntity>>allProducts;
    private LiveData<List<ProductEntity>>allWishlistProducts;/*= Transformations.switchMap(searchQuery, query -> {repository.getAllProducts(query)});*/

    public ProductListViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
        allProducts = repository.getAllProducts();
        allWishlistProducts = repository.getAllWishlistProducts();
    }

    public void insert(ProductEntity productEntity){
        repository.insert(productEntity);
    }

    public void update(ProductEntity productEntity){
        repository.update(productEntity);
    }

    public void delete(ProductEntity productEntity){
        repository.delete(productEntity);
    }

    public LiveData<List<ProductEntity>>getAllProducts(){
        return allProducts;
    }

    public LiveData<List<ProductEntity>>getAllWishlistProducts(){
        return allWishlistProducts;
    }
}