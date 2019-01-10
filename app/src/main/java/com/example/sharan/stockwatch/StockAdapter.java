package com.example.sharan.stockwatch;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Locale;

public class StockAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Stock> stockList;
    private MainActivity mainAct;

    public StockAdapter(List<Stock> stockList, MainActivity ma) {
        this.stockList = stockList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_list, parent, false);

        itemView.setOnClickListener(mainAct);
        itemView.setOnLongClickListener(mainAct);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Stock stock = stockList.get(position);

        if(stock.getPriceChange() < 0){
            //color red
            holder.companySymbol.setTextColor(Color.parseColor("red"));
            holder.companyName.setTextColor(Color.parseColor("red"));
            holder.price.setTextColor(Color.parseColor("red"));
            holder.priceChange.setTextColor(Color.parseColor("red"));
            holder.changePercentage.setTextColor(Color.parseColor("red"));
            holder.caret.setImageResource(R.drawable.baseline_arrow_drop_down_white_24);
            holder.caret.setColorFilter(Color.parseColor("red"));
        }
        else{
            //color green
            holder.companySymbol.setTextColor(Color.parseColor("green"));
            holder.companyName.setTextColor(Color.parseColor("green"));
            holder.price.setTextColor(Color.parseColor("green"));
            holder.priceChange.setTextColor(Color.parseColor("green"));
            holder.changePercentage.setTextColor(Color.parseColor("green"));
            holder.caret.setImageResource(R.drawable.baseline_arrow_drop_up_white_24);
            holder.caret.setColorFilter(Color.parseColor("green"));
        }

        holder.companySymbol.setText(stock.getCompanySymbol());
        holder.companyName.setText(stock.getCompanyName());
        holder.price.setText(String.format(Locale.US, "%.2f", stock.getPrice()));
        holder.priceChange.setText(String.format(Locale.US, "%.2f", stock.getPriceChange()));
        holder.changePercentage.setText(String.format(Locale.US, "(%.2f%%)", stock.getChangePercentage()));
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }
}
