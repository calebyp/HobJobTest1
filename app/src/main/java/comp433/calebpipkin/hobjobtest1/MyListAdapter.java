package comp433.calebpipkin.hobjobtest1;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebyp on 11/30/17.
 */

public class MyListAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public MyListAdapter(Context context, int resource, ArrayList<String> item) {
        super(context, resource, item);
        this.list = list;
    }

    static class LayoutHandler{
        TextView type, event, description;
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.single_post,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.type = (TextView)row.findViewById(R.id.TOR);
            layoutHandler.event = (TextView)row.findViewById(R.id.TOE);
            layoutHandler.description = (TextView)row.findViewById(R.id.extrainfo);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler = (LayoutHandler)row.getTag();
        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.type.setText(dataProvider.getType());
        layoutHandler.event.setText(dataProvider.getEvent());
        layoutHandler.description.setText(dataProvider.getDescription());

        return row;
    }
}