package com.example.onlinehardwarestore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinehardwarestore.models.MyCartModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class placeOrderActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed_order);

        auth= FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        List<MyCartModel> list = (List<MyCartModel>) getIntent().getSerializableExtra("itemList");
        if(list != null && list.size()>0 ){

        }

    }
}
