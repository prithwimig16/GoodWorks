package com.goodworks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.admob.goodworks.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UserRecyclerViewItemHolder> {

    private List<User> userList;
    private Context context;

    public MyAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context=context;
    }

    @Override
    public UserRecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View userItemView = layoutInflater.inflate(R.layout.single_item, parent, false);



        UserRecyclerViewItemHolder ret = new UserRecyclerViewItemHolder(userItemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(UserRecyclerViewItemHolder holder, int position) {
        if(userList !=null) {
            final User userItem = userList.get(position);

            if(userItem != null) {
                holder.id.setText(userItem.getId());
                holder.name.setText(userItem.getName());
                holder.image.setImageResource(userItem.getImage());

                holder.image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(context, NextActivity.class);
                        intent.putExtra("data",userItem);
                        context.startActivity(intent);


                    }
                });
            }
        }
    }


    @Override
    public int getItemCount() {
        int ret = 0;
        if(userList !=null)
        {
            ret = userList.size();
        }
        return ret;
    }

    public class UserRecyclerViewItemHolder extends RecyclerView.ViewHolder {

        private TextView id = null;
        private TextView name = null;
        private ImageView image = null;


        public UserRecyclerViewItemHolder(View itemView) {
            super(itemView);

            if(itemView != null)
            {
                id = (TextView)itemView.findViewById(R.id.tv_id);
                name = (TextView)itemView.findViewById(R.id.tv_name);
                image = (ImageView)itemView.findViewById(R.id.iv_image);
            }
        }


    }
}
