package com.bluapp.viewsnippet;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class DocHistoryItemAdapter extends AbstractItem<DocHistoryItemAdapter, DocHistoryItemAdapter.ViewHolder> {


    private final int VIEW_TYPE = 2222;

    private DocHistoryModel docHistoryModel;


    public DocHistoryItemAdapter(DocHistoryModel docHistoryModel) {
        this.docHistoryModel = docHistoryModel;
    }

    public DocHistoryModel getDocHistoryModel() {
        return docHistoryModel;
    }


    @NonNull
    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.doc_history_item_layout;
    }


    public static class ViewHolder extends FastAdapter.ViewHolder<DocHistoryItemAdapter>{
        private AppCompatTextView historyDatetime;
        private AppCompatTextView historyName;
        private AppCompatTextView historyDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            historyDatetime = (AppCompatTextView)itemView.findViewById(R.id.datetime);
            historyName = (AppCompatTextView)itemView.findViewById(R.id.name);
            historyDetails = (AppCompatTextView)itemView.findViewById(R.id.details);



        }

        @Override
        public void bindView(@NonNull DocHistoryItemAdapter item, @NonNull List<Object> payloads) {
            historyDatetime.setText(item.getDocHistoryModel().getDateTime());
            historyName.setText(item.getDocHistoryModel().getName());
            historyDetails.setText(item.getDocHistoryModel().getDetails());
        }

        @Override
        public void unbindView(@NonNull DocHistoryItemAdapter item) {
            historyDatetime.setText(null);
            historyName.setText(null);
            historyDetails.setText(null);
        }
    }
}
