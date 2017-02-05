package com.facebook.mahmud.rifat.mahmud.pins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String[] myDataset;

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myDataset = new String[10];
        arrayList = new ArrayList<String>();
        arrayList.add("www.google.com");
//        myDataset = arrayList;
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView2);
        if (textView != null) {
            textView.setText("no pins now.");
        }

        update();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null) {
                    editText.setText("");
                    textView.setText("no pins now. edit_text was null.");

                } else {
                    arrayList.add(editText.getText().toString());
//                    textView.setText(arrayList.toString());
//                    for (int i = 0;i<arrayList.1`)
//                    myDataset= arrayList.;
//                    textView.setText(arrayList.size());
                    textView.setText("XX"+myDataset+" \n"+arrayList);
                    update();
                }
            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset,arrayList,mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);


    }

    private void update() {
        if (arrayList!=null) {

            myDataset = arrayList.toArray(new String[0]);
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


            // specify an adapter (see also next example)
            //ignore...

            Del up  = new Del(myDataset,mRecyclerView,arrayList);
            up.m();
//            mAdapter
        }
    }

}
