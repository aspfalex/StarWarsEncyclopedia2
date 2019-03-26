package com.example.starwarsencyclopedia2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.starwarsencyclopedia2.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        showData();
    }

    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String HEIGHT = "height";
    private static final String MASS = "mass";
    private static final String HAIR_COLOR = "hair_color";
    private static final String EYE_COLOR = "eye_color";
    private static final String BIRTH_YEAR = "birth_year";

    public void showData() {

        TextView NameView = (TextView) findViewById(R.id.textView_name);
        TextView GenderView = (TextView) findViewById(R.id.textView_gender);
        TextView HeightView = (TextView) findViewById(R.id.textView_height);
        TextView MassView = (TextView) findViewById(R.id.textView_mass);
        TextView HairColorView = (TextView) findViewById(R.id.textView_hair_color);
        TextView EyeColorView = (TextView) findViewById(R.id.textView_eye_color);
        TextView BirthYearView = (TextView) findViewById(R.id.textView_birth_year);



        final String name = getIntent().getStringExtra(NAME);
        final String gender = getIntent().getStringExtra(GENDER);
        final String height = getIntent().getStringExtra(HEIGHT);
        final String mass = getIntent().getStringExtra(MASS);
        final String hair_color = getIntent().getStringExtra(HAIR_COLOR);
        final String eye_color = getIntent().getStringExtra(EYE_COLOR);
        final String birth_year = getIntent().getStringExtra(BIRTH_YEAR);

        NameView.setText(getString(R.string.Text_name,name));
        GenderView.setText(getString(R.string.Text_gender,gender));
        HeightView.setText(getString(R.string.Text_height,height));
        MassView.setText(getString(R.string.Text_mass,mass));
        HairColorView.setText(getString(R.string.Text_hairColor,hair_color));
        EyeColorView.setText(getString(R.string.Text_eyeColor,eye_color));
        BirthYearView.setText(getString(R.string.Text_birthYear,birth_year));





    }
}
