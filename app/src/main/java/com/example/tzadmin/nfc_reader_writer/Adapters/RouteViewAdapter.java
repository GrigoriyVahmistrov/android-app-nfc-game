package com.example.tzadmin.nfc_reader_writer.Adapters;

import android.content.Context;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tzadmin.nfc_reader_writer.Models.Route_State;
import com.example.tzadmin.nfc_reader_writer.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kim on 22.06.2017.
 */

public class RouteViewAdapter extends BaseAdapter implements View.OnClickListener {

    Context context;
    LayoutInflater inflater;
    ArrayList<Route_State> states;

    public RouteViewAdapter(Context context, ArrayList<Route_State> state){
        this.context = context;
        this.states = state;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 0;
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
        if(convertView == null){
            convertView = inflater.inflate(R.layout.route_item,null);
        }
        TextView myrectangle = (TextView)convertView.findViewById(R.id.route_rectangle);
        TextView square = (TextView)convertView.findViewById(R.id.route_square);

        Route_State state = states.get(position);

        myrectangle.setText(state.GetRouteName());
        square.setText(state.GetRouteCount());

        myrectangle.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {

    }
}

