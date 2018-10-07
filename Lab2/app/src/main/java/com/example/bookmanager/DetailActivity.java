package com.example.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    SimpleBookManager manager;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Debug", "Starting DetailActivity");
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);

        manager = SimpleBookManager.getBookManager();
        setTitle(manager.getBook(index).getTitle());
        setAuthor(manager.getBook(index).getAuthor());
        setCourse(manager.getBook(index).getCourse());
        setPrice(manager.getBook(index).getPrice());
        setISBN(manager.getBook(index).getIsbn());
    }

    private void setTitle(String title) {
        final TextView titleText = (TextView) findViewById(R.id.Title_edit);
        titleText.setText(title);
    }

    private void setAuthor(String author) {
        final TextView titleText = (TextView) findViewById(R.id.Author_edit);
        titleText.setText(author);
    }

    private void setCourse(String course) {
        final TextView text = findViewById(R.id.Course_edit); {
            text.setText(course);
        }
    }

    public void setPrice(int price) {
        if(price < 0) {
            final TextView text = findViewById(R.id.Price_edit); {
                text.setText("");
            }
        } else {
            final TextView text = findViewById(R.id.Price_edit); {
                text.setText(String.valueOf(price));
            }
        }

    }

    public void setISBN(String ISBN) {
        final TextView text = findViewById(R.id.ISBN_Edit); {
            text.setText(ISBN);
        }
    }

    public void removeBook(View view){
        try {
            manager.removeBook(manager.getBook(index));
            Toast.makeText(this, "Book removed!", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Error e) {
            Toast.makeText(this, "Something went wrong; book was not removed!", Toast.LENGTH_LONG).show();
        }
    }
}
