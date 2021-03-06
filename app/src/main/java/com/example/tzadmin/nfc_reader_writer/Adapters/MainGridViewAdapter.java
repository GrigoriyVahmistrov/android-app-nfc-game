package com.example.tzadmin.nfc_reader_writer.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tzadmin.nfc_reader_writer.Fonts.SingletonFonts;
import com.example.tzadmin.nfc_reader_writer.R;

/**
 * Created by tzadmin on 09.06.17.
 */

public class MainGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public MainGridViewAdapter(Context c, String[] web, int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setTypeface(SingletonFonts.getInstanse(mContext).getKarlson());
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = convertView;
        }

        return grid;
    }
}
