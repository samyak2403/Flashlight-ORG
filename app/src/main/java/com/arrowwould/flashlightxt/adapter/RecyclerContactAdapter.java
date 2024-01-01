package com.arrowwould.flashlightxt.adapter;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arrowwould.flashlightxt.R;


import com.arrowwould.flashlightxt.model.ContactModel;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;


import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {


    private Context context;
    private ArrayList<ContactModel> arrayContacts;
    private OnContactItemClickListener listener;

    public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrayContacts) {
        this.context = context;
        this.arrayContacts = arrayContacts;
    }


    // Interface for item click listener
    public interface OnContactItemClickListener {
        void onContactItemClick(ContactModel contact);
    }

    // Setter for the item click listener
    public void setOnContactItemClickListener(OnContactItemClickListener listener) {
        this.listener = listener;
    }

    // ViewHolder class for the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtNumber;
        ImageView imgContact;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);

//            TemplateView templateView = v.findViewById(R.id.my_template);
        }


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for the RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Retrieve contact information for the current position
        ContactModel contact = arrayContacts.get(position);

        // Set data to the views in the ViewHolder
        holder.imgContact.setImageResource(contact.getImg());
        holder.txtName.setText(contact.getName());
        holder.txtNumber.setText(contact.getNumber());

        // Set OnClickListener for the item in the RecyclerView
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Pass the clicked contact through the listener
                if (listener != null) {
                    listener.onContactItemClick(contact);
                }
            }
        });


// Assuming this code is within a fragment or activity method


    }

    @Override
    public int getItemCount() {
        return arrayContacts.size();
    }


}
