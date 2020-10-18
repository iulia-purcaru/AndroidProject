package com.fmi.bot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<ModalClass> mList; // full list
//    private List<ModalClass> mmList; // selected list
    Context context;

    Button share;


    public CustomAdapter(List<ModalClass> mList, Context context) {
        this.mList = mList;
        this.context = context;
//        mmList = new ArrayList<>(mList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_file,parent,false);

        share = view.findViewById(R.id.sp_share);
        setUpShareButton();

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setUpShareButton(){
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Give me five!");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                context.startActivity(shareIntent);
            }
        });
    }

//    @Override
//    public Filter getFilter() {
//        return filter;
//    }

//    private Filter filter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence charSequence) {
//            List<ModalClass> filteredList = new ArrayList<>();
//
//            if(charSequence == null || charSequence.length() == 0){
//                filteredList.addAll(mList);
//            }else{
//                String filtredPattern = charSequence.toString().toLowerCase().trim();
//                for(ModalClass item : mList){
//                    if(item.getText().toLowerCase().contains(filtredPattern)){
//                        filteredList.add(item);
//                    }
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults results) {
//            mmList.clear();
//            mmList.addAll((List) results.values);
//            notifyDataSetChanged();
//        }
//    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.layoutImageId);
            textView = itemView.findViewById(R.id.nameTextViewId);
        }
    }


}
