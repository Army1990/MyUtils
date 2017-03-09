package com.shanpiao.common.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by 刘大军 on 2015/12/17.
 */


public class AnimationAction {

    /**
     * 显示组件动画
     */
    public static void ShowAlphaAction(View view,int time) {

       //渐变动画
        Animation mShowAction = new AlphaAnimation(0.1f, 0.7f);

        mShowAction.setDuration(time);
        view.startAnimation(mShowAction);
        view.setVisibility(View.VISIBLE);
    }

    public static void showTranslate(View view){
      //  位移动画
        TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        view.setAnimation(mShowAction);

    }


    /**
     * 隐藏组件动画
     */
    public static void HiddenAlphaAction(View view,int time) {
//        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
//                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
//                -1.0f);
        Animation mHiddenAction = new AlphaAnimation(0.7f, 0.1f);
        mHiddenAction.setDuration(time);
        view.startAnimation(mHiddenAction);
        view.setVisibility(View.GONE);
    }
}
