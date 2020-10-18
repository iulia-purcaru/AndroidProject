package com.fmi.bot;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FullListAdapter extends RecyclerView.Adapter<FullListAdapter.ExampleViewHolder> implements Filterable {
    private List<ModalClass> exampleList;
    private List<ModalClass> exampleListFull;

    class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        ExampleViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.layoutImageId);
            textView1 = itemView.findViewById(R.id.nameTextViewId);
        }
    }
    FullListAdapter(List<ModalClass> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_file,
                parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ModalClass currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView1.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ModalClass> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ModalClass item : exampleListFull) {
                    if (item.getText().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}