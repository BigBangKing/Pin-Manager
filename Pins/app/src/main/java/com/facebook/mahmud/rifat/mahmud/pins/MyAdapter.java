package com.facebook.mahmud.rifat.mahmud.pins;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RAM on 11/28/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset;
    private int p = 0;
    private Del del;
//    ArrayList arrayList;
    RecyclerView recyclerView;

    public MyAdapter(String[] myDataset, ArrayList<String> arrayList, RecyclerView mRecyclerView) {
        mDataset = myDataset;
        recyclerView = mRecyclerView;
        del = new Del(arrayList,mRecyclerView);

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, padding's and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
        final int i = position;
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del.n(i);
            }
        });
/*
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"Test Ok. "+holder.mTextView.getText(),Toast.LENGTH_SHORT).show();

//                Dialog dialog = new Dialog(MainActivity.this);

            }
        });
*/


        if (p < position) {
            animate(holder, true);
        } else {
            animate(holder, false);

        }
        p = position;


    }

    @Override
    public int getItemCount() {
        return mDataset.length;

    }

    private void animate(MyAdapter.ViewHolder holder, boolean b) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.itemView, "translationY", b ? 100 : -100, 0);
        objectAnimator.setDuration(1000);
        ObjectAnimator object = ObjectAnimator.ofFloat(holder.itemView, "translationX", b ? 10 : -30, 0);
        object.setDuration(700);
        animatorSet.playTogether(objectAnimator, object);
        animatorSet.start();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        private int i = 0;
        String s;
        public Button button;

        public ViewHolder(final View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.button3);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loader(v);
                }
            });

        }

        private void loader(View v) {
            s = (String) mTextView.getText();
            my_method(v, s, s);
        }


        private void my_method(View v, String o, String a) {

            Intent intent = new Intent(v.getContext(), detail_webview.class);
            intent.putExtra("url", o);
            intent.putExtra("per", a);

            v.getContext().startActivity(intent);


        }
    }
}
