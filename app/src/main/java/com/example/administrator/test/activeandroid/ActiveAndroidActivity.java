package com.example.administrator.test.activeandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.example.administrator.test.R;
import java.util.ArrayList;
import java.util.List;

public class ActiveAndroidActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    Button addBtn,delBtn,updateBtn;
    List<Book> datas=new ArrayList<>();
    ActiveAdapter activeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_android);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        ActiveAndroid.beginTransaction();
//        try {
//            for (int i = 0; i < 15; i++) {
//                Book book = new Book(i, "aa" + i, "bb" + i);
//                book.save();
//            }
//            ActiveAndroid.setTransactionSuccessful();
//        }finally {
//            ActiveAndroid.endTransaction();
//        }

//        Book bk=new Book();
//        bk.bookName="231231";
//        bk.save();

        datas=new Select().from(Book.class).execute();

//        for (int i = 0; i < 15; i++) {
//            Book book = new Book(i, "aa" + i, "bb" + i);
//            datas.add(book);
//        }
        activeAdapter=new ActiveAdapter(datas);
        recyclerView.setAdapter(activeAdapter);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void init(){
        addBtn=(Button)findViewById(R.id.add);
        addBtn.setOnClickListener(this);
        delBtn=(Button)findViewById(R.id.del);
        delBtn.setOnClickListener(this);
        updateBtn=(Button)findViewById(R.id.update);
        updateBtn.setOnClickListener(this);
        recyclerView=(RecyclerView)findViewById(R.id.active_recyler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:
                Book book = new Book(12, "aa" + 123, "bb" + 123);
//                book.save();
                activeAdapter.addItem(book);
                break;
            case R.id.del:
                activeAdapter.delItem(2);
                break;
            case R.id.update:
                new Update(Book.class).set("BookName= ? ","西游记").where("BookId= ? ",10).execute();
                activeAdapter.notifyItemRangeChanged(10, activeAdapter.getItemCount());
                break;

        }
    }
}
