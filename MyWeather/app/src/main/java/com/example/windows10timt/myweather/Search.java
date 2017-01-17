package com.example.windows10timt.myweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    private EditText mEdit1;
    private EditText mEdit2;
    private Button btnSearch;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mEdit1 = (EditText) findViewById(R.id.mEdit1);
        mEdit2 = (EditText) findViewById(R.id.mEdit2);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        back = (ImageView) findViewById(R.id.back);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = mEdit1.getText().toString().trim();
                String country = mEdit2.getText().toString().trim();

                if (city != null && !city.isEmpty() ) {
                    Intent intent = new Intent();
                    intent.putExtra("city",city);
                    intent.putExtra("country",country);
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(Search.this, "Don't find location", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}
