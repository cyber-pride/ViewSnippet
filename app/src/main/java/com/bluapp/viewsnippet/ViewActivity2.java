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

public class ViewActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter<DataItemAdapter> otheritemAdapter;
    private FastAdapter<DataItemAdapter> otherfastAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        initRecyclerView();
        listDoctor(getData());
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void listDoctor(List<DataModel> doctorList) {
        otheritemAdapter = new ItemAdapter<>();
        otherfastAdapter = FastAdapter.with(otheritemAdapter);
        recyclerView.setAdapter(otherfastAdapter);
        List<DataItemAdapter> dataSource = new ArrayList<>();
        for (DataModel model : doctorList) {
            dataSource.add(new DataItemAdapter(model));
        }
        otheritemAdapter.add(dataSource);
        otherfastAdapter.withOnClickListener((v, adapter, item, position) -> {
            String name = item.getDataModel().getTitle();

            return false;
        });
    }


    public static List<DataModel> getData(){
        List<DataModel> alldata = new ArrayList<>();
        alldata.add(new DataModel("Lorem ipsum dolor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "10", "#D81B60", R.drawable.interview_item_image));
        alldata.add(new DataModel("Lorem ipsum dolor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "0", "#008577", R.drawable.interview_item_image));
        alldata.add(new DataModel("Lorem ipsum dolor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "50", "#00574B", R.drawable.interview_item_image));
        return alldata;
 }


}
