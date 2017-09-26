package com.gentler.custombanner.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gentler.custombanner.R;
import com.gentler.custombanner.model.BannerModel;
import com.gentler.custombanner.utils.ScreenUtils;
import com.gentler.custombanner.utils.SizeUtils;


import java.util.List;

/**
 * Created by Jiantao on 2016/8/26.
 */
public class VpAdapter extends PagerAdapter {
    private List<BannerModel> list;
    private Context context;
    private LayoutInflater inflater;

    public VpAdapter(Context context, List<BannerModel> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size()+2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.vp_item, container, false);
//        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.width= ScreenUtils.getScreenWidth(context)/4;
//        params.height=200;
//        view.setLayoutParams(params);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);

//
//        LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        params2.width= ScreenUtils.getScreenWidth(context)/4;
//        params2.height=200;
//        iv.setLayoutParams(params2);

        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(view);
        BannerModel bean=null;
        if (position == 0) {// 将最前面一页设置成本来最后的那页
            bean=list.get(list.size()-1);
        } else if (position == list.size() + 1) {// 将最后面一页设置成本来最前的那页
            bean=list.get(0);
        } else {
            bean=list.get(position-1);
        }
        iv.setImageResource(bean.getImg());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
