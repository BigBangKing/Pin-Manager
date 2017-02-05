package com.facebook.mahmud.rifat.mahmud.pins;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

/**
 * Created by RAM on 2/2/2017.
 */
public class Del {
    ArrayList<String> arrayList;
    String[] myDataset;
    RecyclerView mRecyclerView;
    MyAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    public Del(String[] myDataset, RecyclerView mRecyclerView, ArrayList<String> arrayList) {
        this.myDataset = myDataset;
        this.arrayList = arrayList;
        this.mRecyclerView = mRecyclerView;
    }


// *5000*200*19#

    public Del(ArrayList<String> arrayList, RecyclerView mRecyclerView) {

        this.arrayList = arrayList;
        this.mRecyclerView = mRecyclerView;

    }

    //    MainActivity m = new MainActivity();
    public void m() {


        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myDataset, arrayList, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void n(int p) {

        arrayList.remove(p);

        myDataset = (String[]) arrayList.toArray(new String[1]);

//        m();
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
