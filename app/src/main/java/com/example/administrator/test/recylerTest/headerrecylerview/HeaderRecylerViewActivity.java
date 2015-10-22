package com.example.administrator.test.recylerTest.headerrecylerview;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.test.R;
import com.example.administrator.test.recylerTest.headerfooterrecyclerview.IRecyclerViewIntermediary;
import com.example.administrator.test.recylerTest.headerfooterrecyclerview.RecyclerViewHeaderFooterAdapter;

import java.util.ArrayList;
import java.util.List;

public class HeaderRecylerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerViewHeaderFooterAdapter adapter;

    RecyclerView.LayoutManager manager;
    private IRecyclerViewIntermediary mIntermediary;
    List<String> datas= new ArrayList<>();
    boolean isLoadingMore=false;

    boolean isLoadingData=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_recyler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.header_recyler_list);
        manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        for (int i=0;i<15;i++){
            datas.add(i+"");
        }

        mIntermediary = new HeaderIntermediary(this,datas);
        adapter=new RecyclerViewHeaderFooterAdapter(manager,mIntermediary);
        adapter.addHeader(getView(this, "广告区域"));
        adapter.addFooter(getView(this, "查看更多"));
        recyclerView.setAdapter(adapter);


        recyclerView.setOnScrollListener(new OnRcvScrollListener(){
            @Override
            public void onBottom() {
                super.onBottom();
                if (!isLoadingData) {
//                    Log.d(TAG, "loading old data");
//                    adapter.loadOldData();
                    Snackbar.make(recyclerView, "加载中", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    isLoadingData = true;
                }else{
                    isLoadingData = false;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    public static View getView(Context context, String title){
        TextView view = new TextView(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setGravity(Gravity.CENTER);
        view.setTextSize(30);
        view.setPadding(12, 12, 12, 12);
        view.setBackgroundColor(0x777777);
        view.setText(title);
        return view;
    }

}
