package com.kevohmunene.roombooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FacilityActivity extends AppCompatActivity {
    String item []=new String [] {"1.reception","2.AC,Wi-Fi,Fridge,Minibar","3.Traditional Restaurant","4.Swimming Pool(indoor)","5.Night Club","6.SPA Centre and Fitness",
            "7.Parking","8.Laundry Services","9.Money Exchange,Taxi Services","10.and many more..."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility);
ListView listView=findViewById(R.id.ListView);
ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,item);
listView.setAdapter(adapter);

    }
}
