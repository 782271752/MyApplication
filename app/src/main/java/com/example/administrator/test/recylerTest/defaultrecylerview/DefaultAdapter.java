package com.example.administrator.test.recylerTest.defaultrecylerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.test.R;

import java.util.List;

/**
 * Created by Administrator on 2015/10/20 0020.
 */
public class DefaultAdapter extends RecyclerView.Adapter<DefaultAdapter.ViewHolder>{

    List<String> data;
    Context context;
    int[] drawables={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e};
    int width,height;

    public DefaultAdapter(Context context,List<String> data){
        this.data=data;
        this.context=context;
        DisplayMetrics dm = new DisplayMetrics();
        ((RecylerViewActivity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        width=dm.widthPixels;
        height=dm.heightPixels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= View.inflate(parent.getContext(),R.layout.default_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
        int x=position%data.size();
        BitmapDrawable bd = (BitmapDrawable)context.getResources().getDrawable(drawables[x]);
        Bitmap bitmap = bd.getBitmap();
        float scale=1.0f*width/2/bitmap.getWidth();
        Matrix matrix=new Matrix();
        matrix.setScale(scale,scale);
        Bitmap bp=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,false);
        holder.imgView.setImageBitmap(bp);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imgView=(ImageView)itemView.findViewById(R.id.default_item_img);
            textView=(TextView)itemView.findViewById(R.id.default_item_text);
        }

    }
}
