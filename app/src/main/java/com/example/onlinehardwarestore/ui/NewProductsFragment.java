package com.example.onlinehardwarestore.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import com.example.onlinehardwarestore.R;

public class NewProductsFragment extends Fragment {
    public NewProductsFragment(){

    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_products,container,false);
    }


}
