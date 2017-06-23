package com.example.tzadmin.nfc_reader_writer;

import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class ThrowCubes extends AppCompatActivity implements View.OnClickListener {

    LinearLayout ll_cube_block1;
    LinearLayout ll_cube_block2;
    LinearLayout ll_cube_block3;

    Integer mark1, mark2, mark3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw_cubes);


        mark1 = 0;
        mark2 = 0;
        mark3 = 0;


        ll_cube_block1 = (LinearLayout) findViewById(R.id.ll_cube_block1);
        ll_cube_block2 = (LinearLayout) findViewById(R.id.ll_cube_block2);
        ll_cube_block3 = (LinearLayout) findViewById(R.id.ll_cube_block3);

        setAllClickListner(getAllByBlock(ll_cube_block1));
        setAllClickListner(getAllByBlock(ll_cube_block2));
        setAllClickListner(getAllByBlock(ll_cube_block3));

    }

    private Collection<Button> getAllByBlock(ViewGroup group) {
        Collection<Button> buttons = new ArrayList<>();

        int collectionCout = group.getChildCount();

        for (int i = 0; i < collectionCout; i++) {
            View v = group.getChildAt(i);
            if (v instanceof ViewGroup) {
                buttons.addAll(getAllByBlock((ViewGroup) v));
            } else if (v instanceof Button){
                buttons.add((Button) v);
            }
        }

        return buttons;
    }


    private void setAllClickListner(Collection<Button> buttons) {
        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }

    private Integer getValueFromButton(Button btn) {
        String text = btn.getText().toString();

        Integer retData = Integer.getInteger(text, -1);
        if (retData != -1) return retData;

        if (text.equals("Нос")) return 1;
        if (text.equals("Глаз")) return 2;
        if (text.equals("Ухо")) return 3;
        if (text.equals("Крылья")) return 4;
        if (text.equals("Лапа")) return 5;
        if (text.equals("Хвост")) return 6;

        return 0;
    }

    private void checkResult() {
        if (mark1 != 0 && mark2 != 0 && mark3 != 0) {
            //TODO DONE ALL
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String tag = (String) btn.getTag();

        Collection<Button> buttons = new ArrayList<>();

        Integer result = getValueFromButton(btn);

        if (tag.equals("pnl1")) {
            buttons = getAllByBlock(ll_cube_block1);
            mark1 = result;
        }
        if (tag.equals("pnl2")) {
            buttons = getAllByBlock(ll_cube_block2);
            mark2 = result;
        }
        if (tag.equals("pnl3")) {
            buttons = getAllByBlock(ll_cube_block3);
            mark3 = result;
        }


        for (Button b : buttons) {
            b.setBackgroundColor(Color.TRANSPARENT);
        }

        btn.setBackgroundColor(Color.GREEN);


        checkResult();

    }
}
