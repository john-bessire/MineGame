package com.aqume.gridlab1;

import android.content.Context;
import android.widget.ImageView;

public class GameSquareImageView extends ImageView {

    GameSquareImageView imageView;

    public GameSquareImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    private int imgRecId;
    public int getImageResId() {
        return imgRecId;
    }
    public void setImageRecId(int imgRecId) {
        this.imgRecId = imgRecId;
    }

    public void setBomb (int position){

            imageView.setImageResource(position);
            imageView.setImageRecId(R.drawable.mine1);

    }
}
