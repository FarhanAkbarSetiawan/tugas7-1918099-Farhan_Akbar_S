package com.example.tugas_sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MovieList> MovieList;
    public CustomListAdapter(Activity activity, List<MovieList> MovieList) {
        this.activity = activity;
        this.MovieList = MovieList;
    }
    @Override
    public int getCount() {
        return MovieList.size();
    }
    @Override
    public Object getItem(int location) {
        return MovieList.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView title = (TextView)
                convertView.findViewById(R.id.text_judul);
        TextView genre = (TextView)
                convertView.findViewById(R.id.text_genre);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        MovieList m = MovieList.get(position);
        title.setText("Title : "+ m.get_Judul());
        genre.setText("Genre : "+ m.get_genre());
        return convertView;
    }
}
