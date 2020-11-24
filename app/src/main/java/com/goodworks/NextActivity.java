package com.goodworks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.admob.goodworks.R;

public class NextActivity extends AppCompatActivity {
    TextView tvId,tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        tvId = (TextView)findViewById(R.id.tv_id);
        tvName = (TextView)findViewById(R.id.tv_name);
        if(getIntent()!=null&&getIntent().getExtras()!=null){
        User user = getIntent().getExtras().getParcelable("data");
        if(user!=null){
            tvId.setText(user.getId());
            tvName.setText(user.getName());
        }


        }
    }
}