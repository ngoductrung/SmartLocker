package com.example.smartlocker;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class LockerAdapter extends RecyclerView.Adapter<LockerAdapter.ViewHolder>{
    private List<LockerHolder> lockerHolders;
    public LockerAdapter(List<LockerHolder> lockerHolders){
        this.lockerHolders = lockerHolders;
    }


    @NonNull
    @Override
    public LockerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_locker,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LockerAdapter.ViewHolder holder, int position) {
        holder.textView.setText(""+ lockerHolders.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return lockerHolders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageButton imageButton;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.locker_number);
            imageButton = itemView.findViewById(R.id.locker_button);


        }
    }
}
