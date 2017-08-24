package com.gentler.custombanner.model;

import java.io.Serializable;

/**
 * Created by Jiantao on 2017/7/31.
 */

public class BannerModel implements Serializable {
    private int img;
    private String title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MeiGLauncherBean{" +
                "img=" + img +
                ", title='" + title + '\'' +
                '}';
    }
}
