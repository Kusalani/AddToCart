package com.example.onlinehardwarestore.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinehardwarestore.R;
import com.example.onlinehardwarestore.adapters.NavCategoryAdapter;
import com.example.onlinehardwarestore.adapters.PopularAdapters;
import com.example.onlinehardwarestore.databinding.FragmentCategoryBinding;
import com.example.onlinehardwarestore.models.NavCategoryModel;
import com.example.onlinehardwarestore.models.PopularModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {


    FirebaseFirestore db;
    RecyclerView recyclerView;
    List<NavCategoryModel> categoryModelsList;
    NavCategoryAdapter navCategoryAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_category , container , false);


        db=FirebaseFirestore.getInstance();
        recyclerView = root.findViewById(R.id.cat_rec);

        //popular items
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        categoryModelsList=new ArrayList<>();
        navCategoryAdapter = new NavCategoryAdapter(getActivity(),categoryModelsList);
        recyclerView.setAdapter(navCategoryAdapter);

        db.collection("NavCategory")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                NavCategoryModel navCategoryModel=document.toObject(NavCategoryModel.class);
                                categoryModelsList.add(navCategoryModel);
                                navCategoryAdapter.notifyDataSetChanged();


                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
