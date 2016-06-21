package com.example.joelbuhrman.wakeupbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JoelBuhrman on 16-06-21.
 */
public class BuddiesAdapter extends BaseAdapter {
    String[] buddiesNames;
    Context context;
    private static LayoutInflater inflater = null;

    public BuddiesAdapter(Context applicationContext, String[] buddiesNames) {
        this.context = applicationContext;
        this.buddiesNames = buddiesNames;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return buddiesNames.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.custom_list_row, null);
        TextView name= (TextView)rowView.findViewById(R.id.custom_list_row_name);
        name.setText(buddiesNames[i]);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You Clicked "+buddiesNames[i], Toast.LENGTH_LONG).show();

            }
        });
        return rowView;
    }
}
