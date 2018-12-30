package com.example.haithamayyash.simpleapp.questions_list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.haithamayyash.simpleapp.R;
import com.example.haithamayyash.simpleapp.databinding.QuestionListRowItemBinding;
import com.example.haithamayyash.simpleapp.questions_list.model.Question;
import com.example.haithamayyash.simpleapp.view_holder.QuestionListViewHolder;

import java.util.List;

import androidx.databinding.DataBindingUtil;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListViewHolder> {
    private Context context;
    private List<Question> questionList;
    private QuestionListRowItemBinding itemBinding;

    public QuestionListAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @Override
    public QuestionListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context)
                , R.layout.question_list_row_item, parent, false);
        return new QuestionListViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(QuestionListViewHolder holder, int position) {
        holder.itemBinding.setQuestion(questionList.get(position));
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
