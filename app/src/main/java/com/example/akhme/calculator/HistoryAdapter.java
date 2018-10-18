package com.example.akhme.calculator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    private LayoutInflater inflater;
    List<String> prevResults;

    HistoryAdapter(Context context, List<String> prevResults) {
        this.prevResults = prevResults;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        String note = prevResults.get(position);
        holder.note.setText(note);
    }

    @Override
    public int getItemCount() {
        return prevResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView note;
        ViewHolder(View view){
            super(view);
            note = (TextView) view.findViewById(R.id.table);
        }
    }
}
