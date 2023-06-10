package com.example.informationbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informationbook.R;
import com.example.informationbook.activities.CountriesActivity;
import com.example.informationbook.activities.LeadersActivity;
import com.example.informationbook.activities.MuseumsActivity;
import com.example.informationbook.activities.WondersActivity;
import com.example.informationbook.models.ModelClass;

import java.util.ArrayList;

public class RecyclerAdapterClass extends RecyclerView.Adapter<RecyclerAdapterClass.CardViewHolder> {

    private ArrayList<ModelClass> modelList;
    private Context context;

    public RecyclerAdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //which design will be displayed in th recyclerview

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);

        //return new object from CardViewHolder (the inner class)
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        //what should be done when the design we created is connected to the recyclerview

        ModelClass model = modelList.get(position);
        holder.textViewSplash.setText(model.getCategoryName());
        holder.imageViewSplash.setImageResource(context.getResources().getIdentifier(model.getImageName(), "drawable", context.getPackageName()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.getAdapterPosition() == 0) {
                    Intent intent = new Intent(context, CountriesActivity.class);
                    context.startActivity(intent);
                }
                if (holder.getAdapterPosition() == 1) {
                    Intent intent = new Intent(context, LeadersActivity.class);
                    context.startActivity(intent);
                }
                if (holder.getAdapterPosition() == 2) {
                    Intent intent = new Intent(context, MuseumsActivity.class);
                    context.startActivity(intent);
                }
                if (holder.getAdapterPosition() == 3) {
                    Intent intent = new Intent(context, WondersActivity.class);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewSplash;
        private TextView textViewSplash;
        private CardView cardView;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSplash = itemView.findViewById(R.id.imageViewSplash);
            textViewSplash = itemView.findViewById(R.id.textViewSplash);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
