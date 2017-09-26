package com.gentler.custombanner.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gentler.custombanner.R;
import com.gentler.custombanner.adapter.VpAdapter;
import com.gentler.custombanner.model.BannerModel;
import com.gentler.custombanner.transformer.ScaleTransformer;
import com.gentler.custombanner.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager viewPager;
    private int[] mImgRes=new int[]{R.drawable.p001,R.drawable.p002,R.drawable.p003,R.drawable.p004,R.drawable.p005};
    private String[] names={"设置","社交","购物","交通","系统"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        RelativeLayout mPagerContainer= (RelativeLayout) findViewById(R.id.pager_container);
        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) viewPager.getLayoutParams();
        params.width= (int) (ScreenUtils.getScreenWidth(this)/3);
//        params.height=200;
        viewPager.setLayoutParams(params);

//        RelativeLayout.LayoutParams params1= (RelativeLayout.LayoutParams) mPagerContainer.getLayoutParams();
//        params1.width=ScreenUtils.getScreenWidth(this)/3;


    }

    private void initData() {
        final List<BannerModel> list = new ArrayList<>();
        BannerModel bean;
        for (int i=0;i<mImgRes.length;i++){
            bean=new BannerModel();
            bean.setImg(mImgRes[i]);
            bean.setTitle(names[i]);
            list.add(bean);
        }
        VpAdapter adater = new VpAdapter(this, list);
        viewPager.setAdapter(adater);
        viewPager.setPageTransformer(false, new ScaleTransformer());
        viewPager.setOffscreenPageLimit(5);
        int margine= (int) (ScreenUtils.getScreenWidth(this)*0.14/3);
        viewPager.setPageMargin(-margine);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG,"positionOffset:"+positionOffset);
                Log.e(TAG,"positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    // 闲置中
                    case ViewPager.SCROLL_STATE_IDLE:
                        // “偷梁换柱”
                        if (viewPager.getCurrentItem() == 0) {
                            viewPager.setCurrentItem(list.size(), false);
                        } else if (viewPager.getCurrentItem() == list.size() + 1) {
                            viewPager.setCurrentItem(1, false);
                        }
                        break;
                }
            }
        });
    }

}
