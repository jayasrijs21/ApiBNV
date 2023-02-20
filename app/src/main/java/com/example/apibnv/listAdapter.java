package com.example.apibnv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import retrofit2.Callback;

public class listAdapter extends BaseAdapter {
    Context context;
    String[] names;


    public listAdapter (Context context , String[] names ) {
        this.context = context;
        this.names = names;

    }



    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null) {

            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_view,viewGroup,false);
        }

        TextView text = view.findViewById(R.id.textView);


        text.setText(names[position]);
        return view;


    }
}
