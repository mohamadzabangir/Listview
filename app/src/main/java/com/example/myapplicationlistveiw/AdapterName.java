package com.example.myapplicationlistveiw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterName extends RecyclerView.Adapter<AdapterName.NameViewHolder> {

    String [] name ={};
    int [] ids ={};
    public AdapterName(){
        TempListItem tempListItem = new TempListItem();
        name = tempListItem.getName();
        ids = tempListItem.getAvatar();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item , parent , false);
        return new AdapterName.NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setItems(name[position] , ids[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView1;
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
        }
        public void setItems(String name , int imageId){
            textView1.setText(name);
            imageView.setImageResource(imageId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), name, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
