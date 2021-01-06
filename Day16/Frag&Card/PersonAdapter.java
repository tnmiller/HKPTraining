package com.example.fragments_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list){
        people=list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNames;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNames = itemView.findViewById(R.id.tvNames);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvNames.setText(people.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
