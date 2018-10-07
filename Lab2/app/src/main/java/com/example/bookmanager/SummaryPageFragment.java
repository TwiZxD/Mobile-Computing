package com.example.bookmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SummaryPageFragment extends Fragment {
    SimpleBookManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = SimpleBookManager.getBookManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary, container, false);

        setTotalCost(manager.getTotalCost(),view);
        setAmountOfBooks(manager.count(), view);
        setMostExpensiveItem(manager.getMaxPrice(),view);
        setLeastExpensiveItem(manager.getMinPrice(),view);
        setAveragePrice(manager.getMeanPrice(),view);
        return view;
    }

    public void setTotalCost(int totalCost, View view) {
        final TextView text = view.findViewById(R.id.totalCost_edit);
        String cost = Integer.toString(totalCost);
        text.setText(cost + " SEK");
    }

    public void setAmountOfBooks(int amountOfBooks, View view) {
        final TextView text = view.findViewById(R.id.books_in_your_library);
        String amount = Integer.toString(amountOfBooks);
        text.setText(amount + " books in your library.");
    }

    public void setMostExpensiveItem(int mostExpensiveItem, View view) {
        final TextView text = view.findViewById(R.id.mostExpensiveItem_edit);
        String item = Integer.toString(mostExpensiveItem);
        text.setText(item + "SEK");
    }

    public void setLeastExpensiveItem(int leastExpensiveItem, View view) {
        final TextView text = view.findViewById(R.id.cheapestItem_Edit);
        String item = Integer.toString(leastExpensiveItem);
        text.setText(item + " SEK");
    }

    public void setAveragePrice(float averagePrice, View view) {
        final TextView text = view.findViewById(R.id.avgPrice_edit);
        String item = Float.toString(averagePrice);
        text.setText(item + " SEK");
    }

}
