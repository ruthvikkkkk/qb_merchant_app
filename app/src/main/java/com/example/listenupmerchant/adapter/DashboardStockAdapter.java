package com.example.listenupmerchant.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listenupmerchant.R;
import com.example.listenupmerchant.models.Stock;

import java.util.List;

public class DashboardStockAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Stock> merchantStock;

    public DashboardStockAdapter(List<Stock> merchantStock){
        this.merchantStock = merchantStock;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.merchant_dashboard_stock_card, parent, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Stock stock = merchantStock.get(position);
        ((StockViewHolder) holder).stockBind(stock);
    }

    @Override
    public int getItemCount() {
        return merchantStock.size();
    }

    public class StockViewHolder extends RecyclerView.ViewHolder{
        View view;

        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void stockBind(Stock stock){
            ((TextView) view.findViewById(R.id.stock_card_name)).setText(stock.getProductName());
            ((TextView) view.findViewById(R.id.stock_card_price)).setText(String.valueOf(stock.getPrice()));
            ((TextView) view.findViewById(R.id.stock_card_qty)).setText(String.valueOf(stock.getQuantity()));
            Glide.with(view.getContext()).load(stock.getImage()).into(((ImageView) view.findViewById(R.id.stock_card_image)));
        }
    }
}
