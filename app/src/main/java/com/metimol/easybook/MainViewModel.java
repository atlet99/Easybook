package com.metimol.easybook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<Integer> statusBarHeight = new MutableLiveData<>();
    private final MutableLiveData<List<Category>> categories = new MutableLiveData<>();

    public void setStatusBarHeight(int height) {
        statusBarHeight.setValue(height);
    }

    public LiveData<Integer> getStatusBarHeight() {
        return statusBarHeight;
    }

    public LiveData<List<Category>> getCategories() {
        return categories;
    }

    public void fetchCategories() {
        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category("1", "Fantasy", R.drawable.ic_category_fantasy));
        categoryList.add(new Category("2", "Detective", R.drawable.ic_category_detective));
        categoryList.add(new Category("3", "Business", R.drawable.ic_category_business));
        categoryList.add(new Category("4", "Audio Play", R.drawable.ic_category_audiospektakl));
        categoryList.add(new Category("5", "Biography", R.drawable.ic_category_biography));
        categoryList.add(new Category("6", "Kids", R.drawable.ic_category_kids));

        categories.setValue(categoryList);
    }
}