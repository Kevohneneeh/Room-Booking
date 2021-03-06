package com.kevohmunene.roombooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RoomActivity extends AppCompatActivity {
ListView mListView;

int[] images = {R.drawable.singleone,
                R.drawable.doubleone,
                R.drawable.trippleone,
                R.drawable.quadrupleone};
String[] Names = {"Single Room",
                  "Double Room",
                  "Triple Room",
                  "Quadruple Room"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mListView =findViewById(R.id.listview2);
        CustomAdaptor customAdaptor =new CustomAdaptor();
        mListView.setAdapter(customAdaptor);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    startActivity(new Intent(getApplicationContext(),ConfirmActivity.class));
                }else if (position==1){
                   startActivity(new Intent(getApplicationContext(),ConfirmActivity.class));
                }else if (position==2){
                    startActivity(new Intent(getApplicationContext(),ConfirmActivity.class));
                }else if (position==3){
                    startActivity(new Intent(getApplicationContext(),ConfirmActivity.class));
                }
            }
        });
    }
    class CustomAdaptor extends BaseAdapter{
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView mImageview = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.textView2);

            mImageview.setImageResource(images[position]);
            mTextView.setText(Names[position]);

            return view;
        }
    }
}
