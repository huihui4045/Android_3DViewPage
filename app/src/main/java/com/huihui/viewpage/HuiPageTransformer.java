package com.huihui.viewpage;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by molu_ on 2017/7/2.
 */

public class HuiPageTransformer implements ViewPager.PageTransformer {
    private String TAG=this.getClass().getSimpleName();
    @Override
    public void transformPage(View page, float position) {

        Log.e(TAG,"transformPage position:"+position);

        if (position>-1&&position<1){


            if (page instanceof ViewGroup){


                ViewGroup viewGroup = (ViewGroup) page;

                int childCount = viewGroup.getChildCount();


                for (int i = 0; i < childCount; i++) {

                    float random = (float) Math.random();

                    View view = viewGroup.getChildAt(i);

                    if (view.getTag()==null){

                        view.setTag(random);
                    }else {

                        random= (float) view.getTag();
                    }





                    view.setTranslationX(random*position*viewGroup.getWidth()*2);
                }

            }



          /* //效果1
           page.setScaleY(1-Math.abs(position));
            page.setScaleX(1-Math.abs(position));

          //效果2
           *//* page.setScaleY(Math.max(0.9f,1-Math.abs(position)));
            page.setScaleX(Math.max(0.9f,1-Math.abs(position)));*//*

            //3D旋转
           *//* page.setPivotX(position>0?0f:page.getWidth());

            page.setRotationY(position*90f);*//*

            page.setPivotX(position>0?0f:page.getWidth());
            page.setPivotY(page.getHeight()*0.5f);

            page.setRotationY(-position*45f);


            *//*page.setPivotX(page.getWidth()*0.5f);
            page.setPivotY(page.getHeight()*0.5f);

            page.setRotationY(-position*45f);*/


        }
    }
}
