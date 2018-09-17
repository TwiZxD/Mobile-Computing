package com.example.bookmanager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {
    SimpleBookManager manager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        manager = SimpleBookManager.getBookManager();

        final EditText title = findViewById(R.id.addBookTitle);
        final EditText author = findViewById(R.id.addBookAuthor);
        final EditText course = findViewById(R.id.addBookCourse);
        final EditText ISBN = findViewById(R.id.addBookCourse);
        final EditText price = findViewById(R.id.addBookCourse);


        final Button button = findViewById(R.id.addBookAddButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.createBook("Eva, Kuve", "Linear Algebra", 649, "231289632", "MTA215");
               /* manager.createBook(
                        author.getText().toString(),
                        title.getText().toString(),
                        Integer.parseInt(price.getText().toString()),
                        ISBN.getText().toString(),
                        course.getText().toString()
                );*/
            }
        });
    }
}
