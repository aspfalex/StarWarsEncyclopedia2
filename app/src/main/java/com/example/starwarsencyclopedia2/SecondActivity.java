package com.example.starwarsencyclopedia2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.starwarsencyclopedia2.model.People;

import java.util.List;




public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
    }
    public void showList(List<People> input){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(People item){
                Intent intent = new Intent( SecondActivity.this, ThirdActivity.class);
                intent.putExtra("nom", item.getName());
                intent.putExtra("gender", item.getGender());
                intent.putExtra("height", item.getName());
                intent.putExtra("mass", item.getMass());
                intent.putExtra("hair_color", item.getHairColor());
                intent.putExtra("eye_color", item.getEyeColor());
                intent.putExtra("birth_year", item.getBirthYear());
                SecondActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }



}