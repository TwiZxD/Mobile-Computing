package com.example.bookmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        final EditText ISBN = findViewById(R.id.addBookISBN);
        final EditText price = findViewById(R.id.addBookPrice);

        final Button button = findViewById(R.id.addBookAddButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Plese enter a title",Toast.LENGTH_SHORT).show();
                else {
                    String pricecheck = price.getText().toString();
                    try {
                        manager.createBook(
                                author.getText().toString(),
                                title.getText().toString(),
                                (!pricecheck.equals("") ? Integer.parseInt(pricecheck) : -1),
                                ISBN.getText().toString(),
                                course.getText().toString()

                        );
                        author.setText("");
                        title.setText("");
                        price.setText("");
                        ISBN.setText("");
                        course.setText("");
                        recreate();
                        Toast.makeText(getApplicationContext(), title.getText().toString() + " has been added.", Toast.LENGTH_SHORT).show();

                    } catch(NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Price must be a number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
