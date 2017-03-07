package com.giousa.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/7
 * Time:下午3:30
 */

public class GameView extends GridLayout {

    private static final int COUNT = 4;

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

        setColumnCount(COUNT);
        setBackgroundColor(0xffbbada0);

        this.setOnTouchListener(new OnTouchListener() {

            private float startX,startY,offsetX,offsetY;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){

                    case MotionEvent.ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();

                        break;

                    case MotionEvent.ACTION_UP:
                        offsetX = motionEvent.getX() - startX;
                        offsetY = motionEvent.getY() - startY;

                        if(Math.abs(offsetX) > Math.abs(offsetY)){
                            //水平滑动
                            if(offsetX < -5){
                                //向左
                                swipeLeft();

                            }else if(offsetX > 5){
                                //向右
                                swipeRight();
                            }
                        }else{
                            //垂直滑动
                            if(offsetY < -5){
                                //向上
                                swipeUp();

                            }else if(offsetY > 5){
                                //向下
                                swipeDown();

                            }

                        }
                        break;

                }

                return true;
            }
        });
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int cardWidth = (Math.min(w,h)-10)/COUNT;
        addCards(cardWidth,cardWidth);
    }

    private void addCards(int cardWidth,int cardHeight){

        Card c;

        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                c = new Card(getContext());
                c.setNum(2);
                addView(c,cardWidth,cardHeight);
            }
        }
    }

    private void swipeLeft(){

    }

    private void swipeRight(){

    }

    private void swipeUp(){

    }

    private void swipeDown(){

    }
}
