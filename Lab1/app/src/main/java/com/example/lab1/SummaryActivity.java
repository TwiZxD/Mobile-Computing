package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    SimpleBookManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        manager = SimpleBookManager.getBookManager();
        setAmountOfBooks(manager.count());
        setTotalCost(manager.getTotalCost());
        setMostExpensiveItem(manager.getMaxPrice());
        setLeastExpensiveItem(manager.getMinPrice());
        setAveragePrice(manager.getMeanPrice());
    }


    public void setTotalCost(int totalCost) {
        final TextView text = findViewById(R.id.totalCost_edit);
        String cost = Integer.toString(totalCost);
        text.setText(cost + " SEK");
    }

    public void setAmountOfBooks(int amountOfBooks) {
        final TextView text = findViewById(R.id.books_in_your_library);
        String amount = Integer.toString(amountOfBooks);
        text.setText(amount + " books in your library.");
    }

    public void setMostExpensiveItem(int mostExpensiveItem) {
        final TextView text = findViewById(R.id.mostExpensiveItem_edit);
        String item = Integer.toString(mostExpensiveItem);
        text.setText(item + "SEK");
    }

    public void setLeastExpensiveItem(int leastExpensiveItem) {
        final TextView text = findViewById(R.id.cheapestItem_Edit);
        String item = Integer.toString(leastExpensiveItem);
        text.setText(item + " SEK");
    }

    public void setAveragePrice(float averagePrice) {
        final TextView text = findViewById(R.id.avgPrice_edit);
        String item = Float.toString(averagePrice);
        text.setText(item + " SEK");
    }
}
