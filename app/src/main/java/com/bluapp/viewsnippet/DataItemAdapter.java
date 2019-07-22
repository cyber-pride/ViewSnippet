package com.bluapp.viewsnippet;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;

public class DataItemAdapter extends AbstractItem<DataItemAdapter, DataItemAdapter.ViewHolder> {
    private final int VIEW_TYPE = 2222;
    private DataModel dataModel;

    public DataItemAdapter(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public DataModel getDataModel() {
        return dataModel;
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
        return R.layout.view_item_layout2;
    }


    public static class ViewHolder extends FastAdapter.ViewHolder<DataItemAdapter>{
        private AppCompatTextView title;
        private AppCompatTextView details;
        private AppCompatTextView help;
        private CircleProgressBar progressBar;
        private ConstraintLayout logoLayout;
        private AppCompatImageView logo;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (AppCompatTextView)itemView.findViewById(R.id.title);
            details = (AppCompatTextView)itemView.findViewById(R.id.details);
            help = (AppCompatTextView)itemView.findViewById(R.id.help);
            progressBar = (CircleProgressBar) itemView.findViewById(R.id.progress);
            logoLayout = (ConstraintLayout) itemView.findViewById(R.id.logoLayout);
            logo = (AppCompatImageView) itemView.findViewById(R.id.logo);
        }

        @Override
        public void bindView(@NonNull DataItemAdapter item, @NonNull List<Object> payloads) {
            title.setText(item.getDataModel().getTitle());
            details.setText(item.getDataModel().getDetails());
            help.setTextColor(Color.parseColor(item.getDataModel().getColor()));
            logoLayout.setBackgroundColor(Color.parseColor(item.getDataModel().getColor()));
            logo.setImageResource(item.getDataModel().getImagePath());
            progressBar.setProgress(Integer.valueOf(item.getDataModel().getProgress()));
            progressBar.setMaxValue(100);
            progressBar.setStrokeWidth(5);
            progressBar.setBackgroundWidth(5);
            progressBar.setBackgroundColor("#A2A2A2");
            progressBar.setProgressColor(Color.parseColor(item.getDataModel().getColor()));
            progressBar.setText(item.getDataModel().getProgress());
            progressBar.setTextColor(Color.parseColor(item.getDataModel().getColor()));
            progressBar.setSuffix("%");
            progressBar.setPrefix(" ");
        }

        @Override
        public void unbindView(@NonNull DataItemAdapter item) {
            title.setText(null);
            details.setText(null);
        }
    }
}
