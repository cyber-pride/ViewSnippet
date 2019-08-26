package com.bluapp.viewsnippet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

public class DocProfileActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter<DocHistoryItemAdapter> otheritemAdapter;
    private FastAdapter<DocHistoryItemAdapter> otherfastAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_profile);
        recyclerView = (RecyclerView) findViewById(R.id.list);

        initRecyclerView();
        listHistory(getDoctorHistory());

    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void listHistory(List<DocHistoryModel> docHistoryList) {
        otheritemAdapter = new ItemAdapter<>();
        otherfastAdapter = FastAdapter.with(otheritemAdapter);
        recyclerView.setAdapter(otherfastAdapter);
        List<DocHistoryItemAdapter> dataSource = new ArrayList<>();
        for (DocHistoryModel model : docHistoryList) {
            dataSource.add(new DocHistoryItemAdapter(model));
        }
        otheritemAdapter.add(dataSource);
        otherfastAdapter.withOnClickListener((v, adapter, item, position) -> {
            String name = item.getDocHistoryModel().getName();
            return false;
        });
    }

    public static List<DocHistoryModel> getDoctorHistory(){
        List<DocHistoryModel> alldoctor = new ArrayList<>();
        alldoctor.add(new DocHistoryModel("6 May, 5:16PM", "Regular Diabetes checkup", "A disease in which the body's ability to produce or respond to the hormone insulin is impaired"));
        alldoctor.add(new DocHistoryModel("6 May, 5:16PM", "Regular Diabetes checkup", "A disease in which the body's ability to produce or respond to the hormone insulin is impaired"));
        alldoctor.add(new DocHistoryModel("6 May, 5:16PM", "Regular Diabetes checkup", "A disease in which the body's ability to produce or respond to the hormone insulin is impaired"));
        alldoctor.add(new DocHistoryModel("6 May, 5:16PM", "Regular Diabetes checkup", "A disease in which the body's ability to produce or respond to the hormone insulin is impaired"));
        alldoctor.add(new DocHistoryModel("6 May, 5:16PM", "Regular Diabetes checkup", "A disease in which the body's ability to produce or respond to the hormone insulin is impaired"));
        alldoctor.add(new DocHistoryModel("6 May, 5:16PM", "Regular Diabetes checkup", "A disease in which the body's ability to produce or respond to the hormone insulin is impaired"));
        return alldoctor;
    }



}
