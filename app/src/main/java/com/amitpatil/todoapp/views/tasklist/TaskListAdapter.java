package com.amitpatil.todoapp.views.tasklist;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.amitpatil.todoapp.R;
import com.amitpatil.todoapp.database.TodoData;
import com.amitpatil.todoapp.databinding.RowTaskListBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.MyViewHolder> {

    private List<TodoData> mList;
    private PublishSubject<TodoData> modelPublishSubject = PublishSubject.create();
    private LayoutInflater mLayoutInflater;

    public TaskListAdapter(Context context) {
        this.mList = new ArrayList<>();
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public TaskListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowTaskListBinding mBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.row_task_list, parent, false);
        return new MyViewHolder(mBinding);
    }

    public void setItems(List<TodoData> list) {
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TaskListAdapter.MyViewHolder holder, final int position) {
        TodoData model = mList.get(position);
        holder.binding.setModel(model);


        holder.binding.main.setOnClickListener(v -> modelPublishSubject.onNext(model));


    }

    public Observable<TodoData> getItemClick() {
        return modelPublishSubject.hide();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private RowTaskListBinding binding;

        public MyViewHolder(RowTaskListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
