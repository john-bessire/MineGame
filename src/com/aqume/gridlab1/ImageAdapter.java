package com.aqume.gridlab1;

import java.lang.Object;
import java.lang.Math;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String TAG = "ImageAdapter";
    private String DEBUG_TAG = "ImageAdapter";

    public GameSquareImageView imageView;

    public ImageAdapter(Context c) {
    	Log.d(TAG, "constructor - Context: " + c);
        mContext = c;
    }

    public int getCount() {
    	Log.d(TAG, "getCount: " + mThumbIds.length);
        return mThumbIds.length;
    }

    public Object getItem(int position) {
    	Log.d(TAG, "getItem - position: " + position);
        return null;
    }

    public long getItemId(int position) {
    	Log.d(TAG, "getItemId - position: " + position);
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	Log.d(TAG, "getView position: " + position + " | convertView: " + convertView + " | parent: " + parent);
    	final int mPosition = position;
        //ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new GameSquareImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(60, 60));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (GameSquareImageView) convertView;
        }
        
        imageView.setOnTouchListener(new View.OnTouchListener() {

            /*
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//coordView.setText("Touch coordinates : " +
	                //String.valueOf(event.getX()) + "x " + String.valueOf(event.getY()) + "y");
				Log.d(TAG, "+++>> position: " + mPosition + " | onTouch - view: " + v + " | MotionEvent: " + event);

                placeMine(mPosition);

				return true;
			}

			*/

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = MotionEventCompat.getActionMasked(motionEvent);

                switch(action) {
                    case (MotionEvent.ACTION_DOWN) :
                        Log.d(DEBUG_TAG, "motionEvent.getSource()" + motionEvent.getSource());
                        motionEvent.describeContents();

                        //placeMine(1);
                        //placeMine(2);
                        //placeMine(5);

                        Log.d(DEBUG_TAG,"Action was DOWN " + motionEvent);

                        return true;
                    case (MotionEvent.ACTION_MOVE) :

                        int x = (int)motionEvent.getX();
                        int y = (int)motionEvent.getY();

                        int position =5;

                        //int position =   imageView.pointToPosition(x,y);
                        Log.d(DEBUG_TAG,"Move Image Adaptor, position = " + position + ",x = " + x + ",y = " + y);

                        return true;
                    case (MotionEvent.ACTION_UP) :
                        Log.d(DEBUG_TAG,"Action was UP");
                        return true;
                    case (MotionEvent.ACTION_CANCEL) :
                        Log.d(DEBUG_TAG,"Action was CANCEL");
                        return true;
                    case (MotionEvent.ACTION_OUTSIDE) :
                        Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                                "of current screen element");
                        return true;
                    default :
                        return true;
                    //return super.onTouchEvent(motionEvent);
                }
            };

	    });

        for(int i = 0; i < 200; i++) {
        	mThumbIds[i] = R.drawable.grid_square_2;
        }

        imageView.setImageRecId(R.drawable.grid_square_2);
        imageView.setImageResource(mThumbIds[position]);

        imageView.setImageResource(mThumbIds[position]);
        Log.d(TAG, "getView BOTTOM - imageView: " + imageView);
        return imageView;
    }

    public void placeMine (int position){

        Log.d("Mine", "Before placing at " + position);
        imageView.setImageRecId(R.drawable.mine1);
        imageView.setImageResource(mThumbIds[position]);

        Log.d("Mine", "After placing");
    }

    // references to our images
    private Integer[] mThumbIds = new Integer[200];


}
