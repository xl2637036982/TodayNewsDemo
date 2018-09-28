package com.example.administrator.todaynewsdemo;

import android.support.v4.app.FragmentActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/9/11.
 */

public class Viewadapter extends BaseAdapter {
    private News news;
    private ArrayList<News> data;

    public Viewadapter(FragmentActivity activity, ArrayList<News> data) {
        this.data = data;
    }


    public int getItemViewType(int position) {
        news = data.get(position);
        if (news.getType() == 1) {
            return 0;
        } else if (news.getType() == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public News getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item_pic, null);
                ImageView imageView1 = convertView.findViewById(R.id.pic1);
                ImageView imageView2 = convertView.findViewById(R.id.pic2);
                ImageView imageView3 = convertView.findViewById(R.id.pic3);
                imageView1.setImageResource(news.getImage1());
                imageView2.setImageResource(news.getImage2());
                imageView3.setImageResource(news.getImage3());

            }
        } else if (itemViewType == 1) {

            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item_text, null);

               TextView  textView1 = convertView.findViewById(R.id.name);
               textView1.setText(news.getText1());

            }


        } else {

            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item_pic_text, null);
                TextView textView1 = convertView.findViewById(R.id.time);
                TextView textView = convertView.findViewById(R.id.text_view);
                ImageView imageView = convertView.findViewById(R.id.pic4);
                ImageView imageView2 = convertView.findViewById(R.id.pic5);
                ImageView imageView3= convertView.findViewById(R.id.pic6);
                textView .setText(news.getText1());
                textView1.setText(news.getText2());
               imageView.setImageResource(news.getImage1());
               imageView2.setImageResource(news.getImage2());
                imageView3.setImageResource(news.getImage3());

            }
        }
        return convertView;

    }





}