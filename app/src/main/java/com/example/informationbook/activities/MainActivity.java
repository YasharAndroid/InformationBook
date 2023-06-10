package com.example.informationbook.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informationbook.R;
import com.example.informationbook.adapters.RecyclerAdapterClass;
import com.example.informationbook.models.ModelClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ArrayList<ModelClass> arrayList;


    private RecyclerAdapterClass adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        arrayList = new ArrayList<>();

        ModelClass modelClass1 = new ModelClass("countries", "The Countries");
        ModelClass modelClass2 = new ModelClass("leaders", "The Leaders");
        ModelClass modelClass3 = new ModelClass("museums", "The Museums");
        ModelClass modelClass4 = new ModelClass("wonders", "Seven Wonders");

        arrayList.add(modelClass1);
        arrayList.add(modelClass2);
        arrayList.add(modelClass3);
        arrayList.add(modelClass4);

        adapter = new RecyclerAdapterClass(arrayList, this);
        recyclerView.setAdapter(adapter);


    }
}