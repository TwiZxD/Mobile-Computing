package com.example.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    SimpleBookManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        manager = SimpleBookManager.getBookManager();
        ListAdapter adapter = new ListAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        //String message = "testmessage";
        intent.putExtra("index", i);
        startActivity(intent);
    }

    //How to create list view: https://www.youtube.com/watch?v=FKUlw7mFXRM
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

        private void starttActivity() {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            String message = "testmessage";
            intent.putExtra("TestMessage", message);
            startActivity(intent);
        }
    }
}
