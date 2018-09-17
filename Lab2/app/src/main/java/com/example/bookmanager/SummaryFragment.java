package com.example.bookmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SummaryFragment extends Fragment {
    TextView totalCost;
    SimpleBookManager manager;
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            manager = SimpleBookManager.getBookManager();
            setTotalCost(manager.getTotalCost());
        /*
        setAmountOfBooks(manager.count());
        setMostExpensiveItem(manager.getMaxPrice());
        setLeastExpensiveItem(manager.getMinPrice());
        setAveragePrice(manager.getMeanPrice());
        */
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.summary, container, false);
        totalCost = (TextView) view.findViewById(R.id.totalCost_edit);
        return view;
    }


    public void setTotalCost(int totalCost) {
       // final TextView text = view.findViewById(R.id.totalCost_edit);

        String cost = Integer.toString(totalCost);
        this.totalCost.setText(cost + " SEK");
    }
/*
    public void setAmountOfBooks(int amountOfBooks) {
        final TextView text = view.findViewById(R.id.books_in_your_library);
        String amount = Integer.toString(amountOfBooks);
        text.setText(amount + " books in your library.");
    }

    public void setMostExpensiveItem(int mostExpensiveItem) {
        final TextView text = view.findViewById(R.id.mostExpensiveItem_edit);
        String item = Integer.toString(mostExpensiveItem);
        text.setText(item + "SEK");
    }

    public void setLeastExpensiveItem(int leastExpensiveItem) {
        final TextView text = view.findViewById(R.id.cheapestItem_Edit);
        String item = Integer.toString(leastExpensiveItem);
        text.setText(item + " SEK");
    }

    public void setAveragePrice(float averagePrice) {
        final TextView text = view.findViewById(R.id.avgPrice_edit);
        String item = Float.toString(averagePrice);
        text.setText(item + " SEK");
    }
    */

}
