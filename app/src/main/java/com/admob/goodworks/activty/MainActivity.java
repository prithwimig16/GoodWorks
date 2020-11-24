package com.admob.goodworks.activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.admob.goodworks.MyAdapter;
import com.admob.goodworks.R;
import com.admob.goodworks.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> userList = null;
    TextView tvLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUserItemList();
        tvLoad = (TextView)findViewById(R.id.tvload);
        tvLoad.setVisibility(View.VISIBLE);
        tvLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvLoad.setVisibility(View.GONE);
                setRcv();
            }
        });




    }

    private void setRcv(){
        // Create the recyclerview.

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // Create recycler view data adapter with user item list.
        MyAdapter myAdapter = new MyAdapter(userList,this);
        // Set data adapter.
        recyclerView.setAdapter(myAdapter);
    }

    private void initializeUserItemList() {
        if(userList == null)
        {
            userList = new ArrayList<User>();

            for(int i=1;i<=20;i++){
                User user = new User();
                user.setId("id: "+i);
                user.setName("Name:Tom"+i);
                user.setImage( R.drawable.tom);
                userList.add(user);
            }

        }
    }
    }
