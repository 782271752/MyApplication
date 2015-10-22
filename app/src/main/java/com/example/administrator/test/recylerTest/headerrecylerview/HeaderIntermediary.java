package com.example.administrator.test.recylerTest.headerrecylerview;

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
import com.example.administrator.test.recylerTest.defaultrecylerview.RecylerViewActivity;
import com.example.administrator.test.recylerTest.headerfooterrecyclerview.IRecyclerViewIntermediary;

import java.util.List;

/**
 * Created by Administrator on 2015/10/20 0020.
 */
public class HeaderIntermediary implements IRecyclerViewIntermediary {

    List<String> datas;
    int width,height;
    Context context;
    int[] drawables={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e};
    public HeaderIntermediary(Context context,List<String> datas){
        this.datas=datas;
        this.context=context;
        DisplayMetrics dm = new DisplayMetrics();
        ((HeaderRecylerViewActivity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        width=dm.widthPixels;
        height=dm.heightPixels;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int type) {
        View v=View.inflate(viewGroup.getContext(),R.layout.default_item,null);
        return new ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void populateViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).textView.setText(datas.get(position));

        int x=position%datas.size();
        BitmapDrawable bd = (BitmapDrawable)context.getResources().getDrawable(drawables[x]);
        Bitmap bitmap = bd.getBitmap();
        float scale=1.0f*width/2/bitmap.getWidth();
        Matrix matrix=new Matrix();
        matrix.setScale(scale,scale);
        Bitmap bp=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,false);
        ((ViewHolder)holder).imgView.setImageBitmap(bp);
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imgView=(ImageView)itemView.findViewById(R.id.default_item_img);
            textView=(TextView)itemView.findViewById(R.id.default_item_text);
        }
    }
}
