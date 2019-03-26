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

    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String HEIGHT = "height";
    private static final String MASS = "mass";
    private static final String HAIR_COLOR = "hair_color";
    private static final String EYE_COLOR = "eye_color";
    private static final String BIRTH_YEAR = "birth_year";


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
                intent.putExtra(NAME, item.getName());
                intent.putExtra(GENDER, item.getGender());
                intent.putExtra(HEIGHT, item.getHeight());
                intent.putExtra(MASS, item.getMass());
                intent.putExtra(HAIR_COLOR, item.getHairColor());
                intent.putExtra(EYE_COLOR, item.getEyeColor());
                intent.putExtra(BIRTH_YEAR, item.getBirthYear());
                SecondActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }



}