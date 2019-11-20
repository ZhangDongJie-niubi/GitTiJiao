package com.example.zuoye2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Shi extends BaseAdapter {
    private Context context;
    private List<Food.DataBean> list=new ArrayList<>();

    public Shi(Context context ) {
        this.context = context;
    }

    public Shi(MainActivity mainActivity, List<Food.DataBean> list) {
        this.list = list;
    }

    public void add(List<Food.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.two, null);
            viewHolder.tv = convertView.findViewById(R.id.tv);
            viewHolder.iv = convertView.findViewById(R.id.iv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Food.DataBean dataBean = list.get(position);
        viewHolder.tv.setText(dataBean.getTitle());
        new Yi(viewHolder.iv).execute(dataBean.getPic());
        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView iv;
    }
    class Yi extends AsyncTask<String,View, Bitmap>{
     ImageView imageView;

        public Yi(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String param = params[0];
            try {
                URL url = new URL(param);
                InputStream is = url.openConnection().getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }
}
