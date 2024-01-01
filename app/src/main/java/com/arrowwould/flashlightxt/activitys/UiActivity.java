package com.arrowwould.flashlightxt.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.arrowwould.flashlightxt.R;
import com.arrowwould.flashlightxt.adapter.RecyclerContactAdapter;
import com.arrowwould.flashlightxt.model.ContactModel;
import com.google.rvadapter.AdmobNativeAdAdapter;


import java.util.ArrayList;

public class UiActivity extends AppCompatActivity implements RecyclerContactAdapter.OnContactItemClickListener {

    //    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerContactAdapter adapter;
    private ArrayList<ContactModel> arrContacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        RecyclerView recyclerView = findViewById(R.id.recyclerContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Populate your contact list (replace this with your data)
        arrContacts.add(new ContactModel(R.drawable.lighton, "LED Bulb 1.1N", "01/1/2024"));
        arrContacts.add(new ContactModel(R.drawable.ui, "Flash Light V.1.1", "23/1/2024"));
        arrContacts.add(new ContactModel(R.drawable.ui, "Flash Light 0.1KK", "23/1/2024"));
        arrContacts.add(new ContactModel(R.drawable.ui, "Flash Light 4.0.1AI", "23/1/2024"));
        arrContacts.add(new ContactModel(R.drawable.ui, "Flash Light 0.3.1NK", "23/1/2024"));
        arrContacts.add(new ContactModel(R.drawable.ui, "Flash Light 0.1Eve", "23/1/2024"));
        // Add more items if needed...


//        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        adapter = new RecyclerContactAdapter(this, arrContacts);
        adapter.setOnContactItemClickListener(this);
        recyclerView.setAdapter(adapter); // Set the adapter to the RecyclerView

        //NativeAds loop
        String nativeAdUnitId = getString(R.string.native_ad_unit_id);
        AdmobNativeAdAdapter admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.Companion
                .with(
                        nativeAdUnitId,//Create a native ad id from admob console
                        adapter,//The adapter you would normally set to your recyClerView
                        "medium"//Set it with "small","medium" or "custom"
                )
                .adItemIterval(2)//native ad repeating interval in the recyclerview
                .build();
        recyclerView.setAdapter(admobNativeAdAdapter);//set your RecyclerView adapter with the admobNativeAdAdapter

    }


    public void onContactItemClick(ContactModel contact) {
        // Handle item click, open different activities based on the contact data
        if (contact.getName().equals("LED Bulb 1.1N")) {
            Intent intent = new Intent(this, FlashLightPro.class);
            startActivity(intent);
            finish();

        } else if (contact.getName().equals("Flash Light V.1.1") || contact.getName().equals("Flash Light 0.1KK") || contact.getName().equals("Flash Light 4.0.1AI") || contact.getName().equals("Flash Light 0.3.1NK") || contact.getName().equals("Flash Light 0.1Eve")) {
            Intent intent = new Intent(this, CommingSoonActivity.class);
            startActivity(intent);
            finish();
//        } else if (contact.getName().equals("Flash Light V.1.1 || Flash Light 0.1KK || Flash Light 4.0.1AI ||Flash Light 0.3.1NK||Flash Light 0.1Eve")) {
//            Intent intent = new Intent(this, CommingSoonActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }
}

}
