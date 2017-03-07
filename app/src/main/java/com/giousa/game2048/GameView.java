package com.giousa.game2048;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/3/7
 * Time:下午3:30
 */

public class GameView extends GridLayout {

    private static final int COUNT = 4;
    private Card[][] cardsMap = new Card[COUNT][COUNT];
    private List<Point> emptyPoints = new ArrayList<>();

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

        startGame();
    }

    private void startGame() {
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                cardsMap[i][j].setNum(0);
            }
        }

        addRandomNum();
        addRandomNum();
    }

    private void addCards(int cardWidth,int cardHeight){

        Card c;

        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                c = new Card(getContext());
                c.setNum(0);
                addView(c,cardWidth,cardHeight);

                cardsMap[i][j] = c;
            }
        }
    }

    private void addRandomNum(){
        
        emptyPoints.clear();
        
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                if(cardsMap[i][j].getNum() <= 0){
                    emptyPoints.add(new Point(i,j));
                }
            }
        }

        Point p = emptyPoints.remove((int) (Math.random() * emptyPoints.size()));
        cardsMap[p.x][p.y].setNum(Math.random() > 0.1 ? 2: 4);
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
