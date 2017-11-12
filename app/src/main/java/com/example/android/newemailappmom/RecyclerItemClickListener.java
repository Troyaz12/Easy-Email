package com.example.android.newemailappmom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by TroysMacBook on 12/4/16.
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;


    public interface OnItemClickListener {
        public void onClick(View view, int position);

    }

    public RecyclerItemClickListener(Context context, RecyclerView rv,OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                System.out.println("Clicked!");

                return true;
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
      //  System.out.println("Clicked!" + mGestureDetector.onTouchEvent(e)+ " "+e);

        Log.d("Clicked","onInterceptTouchEvent "+mGestureDetector.onTouchEvent(e)+" "+e);
        System.out.println("Clicked!");

        View childView = view.findChildViewUnder(e.getX(), e.getY());       //Find the topmost view under the given point.
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {  //gestureDetector.onTouchEvent(e)) If this method is used to detect click actions, it is recommended that the actions be performed by implementing and calling performClick(). This will ensure consistent system behavior, including:

            mListener.onClick(childView, view.getChildPosition(childView));
            return true;
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
     //   System.out.println("Clicked!");



    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
