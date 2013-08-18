package com.aqume.gridlab1;


import com.immersion.uhl.Launcher;

import com.aqume.gridlab1.GameSquareImageView.*;

import java.lang.Object;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnTouchListener;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.widget.GridView;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends Activity {
	private String TAG = "MainActivity";
	protected Launcher mUhlLauncher;

    String DEBUG_TAG = "--- Grid1 ---";

    ImageAdapter imageAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    try {
        	mUhlLauncher = new Launcher(this);
        } catch (Exception e) {
        	Log.e(TAG, "Attempting instatiation of new UHL Launcher - exception: " + e.getMessage());
        }	    
	    
	    final TextView coordView = (TextView)findViewById(R.id.coordView);

	    final GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));

        final ImageAdapter imageAdaptor = null;

        gridview.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = MotionEventCompat.getActionMasked(motionEvent);

                switch(action) {
                    case (MotionEvent.ACTION_DOWN) :
                        Log.d(DEBUG_TAG, "motionEvent.getSource()" + motionEvent.getSource());
                        motionEvent.describeContents();

                        //imageAdaptor.placeMine(44);
                        //imageAdaptor.placeMine(45);


                        Log.d(DEBUG_TAG,"Action was DOWN " + motionEvent);
                        return true;
                    case (MotionEvent.ACTION_MOVE) :

                        int x = (int)motionEvent.getX();
                        int y = (int)motionEvent.getY();

                        int position =   gridview.pointToPosition(x,y);
                        Log.d(DEBUG_TAG,"GridView Move, position = " + position + ",x = " + x + ",y = " + y);
                        imageAdaptor.placeMine(position);

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

            }
        });


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
