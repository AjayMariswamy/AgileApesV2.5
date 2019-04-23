package com.example.agileapes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/*
This class was obtained from https://www.youtube.com/watch?v=uTVu3HsRIEE and adapted to fit the application
The video demonstrated how to implement a RecyclerView to display data from an ArrayList. This included the implementation
of a TextAdapter. This TextAdapter was used to make the LearningActivity functional. The list_item_text xml file was
also obtained from the video but we implemented the use of a CardView to enhance the UI.
 */

public class TextAdapter extends RecyclerView.Adapter {

    private List<String> learningList = new ArrayList<>();

    public void setItems(List<String> items) {
        learningList = items;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == 0 )
        return TextViewHolder.inflate(viewGroup);
        else
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if(holder instanceof TextViewHolder){
            ((TextViewHolder)  holder).bind(learningList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return learningList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView tvLearningLit;

        public static TextViewHolder inflate(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_text, parent, false);
            return new TextViewHolder(view);

        }
        public TextViewHolder(View itemView) {
                super(itemView);

                tvLearningLit = itemView.findViewById(R.id.tvLearningLit);
            }

            public void bind (String learningContent ){
                tvLearningLit.setText(learningContent);
            }
        }




}

