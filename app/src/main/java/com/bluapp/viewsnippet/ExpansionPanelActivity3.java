package com.bluapp.viewsnippet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpansionPanelActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expansion_panel3);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        final List<Object> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Object());
        }
        adapter.setItems(list);


    }




    public final static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
        private static final List<Object> list = new ArrayList<>();
        private final ExpansionLayoutCollection expansionsCollection = new ExpansionLayoutCollection();
        public RecyclerAdapter() {
            expansionsCollection.openOnlyOne(true);
        }
        @Override
        public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return RecyclerHolder.buildFor(parent);
        }
        @Override
        public void onBindViewHolder(RecyclerHolder holder, int position) {
            holder.bind(position);
            expansionsCollection.add(holder.getExpansionLayout());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void setItems(List<Object> items) {
            this.list.addAll(items);
            notifyDataSetChanged();
        }

        public final static class RecyclerHolder extends RecyclerView.ViewHolder {
            private static final int LAYOUT = R.layout.expansion_panel_recyclerview;
            ExpansionLayout expansionLayout;
            TextView content;
            TextView name;

            public static RecyclerHolder buildFor(ViewGroup viewGroup){
                return new RecyclerHolder(LayoutInflater.from(viewGroup.getContext()).inflate(LAYOUT, viewGroup, false));
            }

            public RecyclerHolder(View itemView) {
                super(itemView);
                expansionLayout = itemView.findViewById(R.id.expansionLayout);
                name = itemView.findViewById(R.id.name);
            }

            public void bind(int position){
                expansionLayout.collapse(false);
            }

            public ExpansionLayout getExpansionLayout() {
                return expansionLayout;
            }
        }
    }
}
