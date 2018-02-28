package com.test.jsondemo.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.jsondemo.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.view.LayoutInflater;

/**
 * Created by Elijah Hezekiah  on 22/02/2018.
 */

public class DisplayDataAdapter extends RecyclerView.Adapter<DisplayDataAdapter.ItemViewHolder> {

    private final LayoutInflater inflater;
    private final List<Joke> Items = new LinkedList<>();

    public DisplayDataAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(inflater.inflate(R.layout.user_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(Items.get(position));
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public void addJokes(ArrayList<Joke> value) {
        Items.addAll(value);
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView mDisplayJokes;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mDisplayJokes = itemView.findViewById(R.id.tvjokes);
        }

        void bind(Joke value) {
            mDisplayJokes.setText(value.getJoke());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Items.remove(position);
            notifyItemRemoved(position);
        }
    }


}
