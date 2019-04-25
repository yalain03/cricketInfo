package com.example.cricketinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayerItemView extends LinearLayout {
    TextView textView;
    int playerId;

    public PlayerItemView(Context context) {
        super(context);
        init(context);
    }

    public PlayerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item, this, true);

        textView = (TextView) findViewById(R.id.textView3);
    }

    public TextView getTextView() {
        return textView;
    }

    public void setValue(String value) {
        textView.setText(value);
    }

    public void setPlayerId(int id) {
        playerId = id;
    }

    public int getPlayerId() {
        return playerId;
    }
}
