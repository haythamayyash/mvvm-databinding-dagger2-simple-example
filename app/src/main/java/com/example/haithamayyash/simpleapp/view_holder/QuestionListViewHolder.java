package com.example.haithamayyash.simpleapp.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.haithamayyash.simpleapp.databinding.QuestionListRowItemBinding;

public class QuestionListViewHolder extends RecyclerView.ViewHolder {
   public QuestionListRowItemBinding itemBinding;

    public QuestionListViewHolder(QuestionListRowItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
    }
}
