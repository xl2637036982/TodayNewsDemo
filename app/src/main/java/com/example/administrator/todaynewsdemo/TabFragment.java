package com.example.administrator.todaynewsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class TabFragment extends Fragment {
    private ArrayList<News> data = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        ListView listView = view.findViewById(R.id.listview);
        Viewadapter Viewadapter = new Viewadapter(getActivity(),data);
        listView.setAdapter(Viewadapter);
        initData();
        return view;

    }
    private void initData() {
        for (int i = 0; i < 3; i++)  {
            News news3 = new News(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, "习近平重申“两个毫不动摇”力拨千斤！" +
                "坚持公有制为主体、多种所有制经济共同发展的基本经济制度不动摇。", "文字填充测试6", 2);
        News news1 = new News(R.mipmap.game1,R.mipmap.game2,R.mipmap.game3,"玩家在网吧开挂完《无限法则》，导致电脑被封，网友：网吧要倒闭了","游戏新闻",3);
        data.add(news1);
            News news2 = new News(R.mipmap.hua1, R.mipmap.hua2, R.mipmap.hua3, "华为04年开始做芯片，苹果晚了六年，为什么苹果芯片能超过麒麟？",
                    "悟空问答", 3);
            data.add(news2);

            data.add(news3);
        News news4 = new News(R.mipmap.sj1,R.mipmap.sj2,R.mipmap.sj3,"假如美国不愿意把硬件卖给中国，国产手机会不会除了华为，其他都会倒闭？","华为手机",3);
       data.add(news4);
            News news5 = new News(R.mipmap.yao1, R.mipmap.yao2, R.mipmap.yao3, "文字填充测试9", "文字填充测试10", 1);
            data.add(news5);
//        News news6 = new News(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,"文字填充测试11","文字填充测试12",2);
//        data.add(news6);


        }
    }
}