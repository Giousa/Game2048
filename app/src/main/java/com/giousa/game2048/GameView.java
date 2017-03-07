package com.giousa.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/7
 * Time:下午3:30
 */

public class GameView extends GridLayout {

    public GameView(Context context) {
        this(context,null);
    }

    public GameView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initGameView();
    }


    private void initGameView(){
        System.out.println("----");
    }
}
