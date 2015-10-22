package com.example.administrator.test.activeandroid;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.example.administrator.test.R;

import java.util.List;

/**
 * Created by Administrator on 2015/10/21 0021.
 */
public class ActiveAdapter extends RecyclerView.Adapter<ActiveAdapter.ViewHoler>{

    List<Book> datas;


    public ActiveAdapter(List<Book> datas){
        this.datas=datas;
        Log.e("count",datas.size()+"");
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=View.inflate(parent.getContext(),R.layout.active_item,null);
        return new ViewHoler(v);
    }

    public void addItem(Book book){
        book.save();
        datas.add(0,book);
        notifyItemInserted(0);
        notifyItemChanged(0,getItemCount());
    }

    public void delItem(int position){
        notifyItemRemoved(position);
        datas.remove(position);
        notifyItemRangeChanged(position, getItemCount());
        new Delete().from(Book.class).where("BookId = ?", position).execute();

    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        holder.textView.setText(datas.get(position).getBookName()+"");
    }

    @Override
    public int getItemCount() {

        return datas.size();
    }

    public static class ViewHoler extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHoler(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.active_item_text);
        }
    }
}
