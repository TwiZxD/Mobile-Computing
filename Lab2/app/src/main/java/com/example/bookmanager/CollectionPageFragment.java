package com.example.bookmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CollectionPageFragment extends Fragment implements AdapterView.OnItemClickListener {
    SimpleBookManager manager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_list, container, false);
        ListView listview = view.findViewById(R.id.listView);
        manager = SimpleBookManager.getBookManager();
        ListAdapter adapter = new ListAdapter();
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        return view;

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("index", i);
        startActivity(intent);

    }

    class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return manager.count();
        }

        @Override
        public Object getItem(int i) {
            Log.d("Debug", "getItem");
            return manager.getBook(i);
        }

        @Override
        public long getItemId(int i) {
            Log.d("Debug", "getItemId");
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlistview,null);
            TextView textView = view.findViewById(R.id.customlistViewText);
            textView.setText(manager.getAllBooks().get(i).getTitle());

            return view;
        }


    }
}
