package com.example.administrator.test.asynchttp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.administrator.test.R;

public class AsyncHttpActivity extends AppCompatActivity implements View.OnClickListener{


    Button getBtn,postBtn,postFileBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getBtn=(Button)findViewById(R.id.async_get);
        getBtn.setOnClickListener(this);
        postBtn=(Button)findViewById(R.id.async_post);
        postBtn.setOnClickListener(this);
        postFileBtn=(Button)findViewById(R.id.post_file);
        postFileBtn.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
