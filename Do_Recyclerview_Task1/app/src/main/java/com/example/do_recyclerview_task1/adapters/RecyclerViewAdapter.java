package com.example.do_recyclerview_task1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_recyclerview_task1.R;
import com.example.do_recyclerview_task1.UserViewDetails;
import com.example.do_recyclerview_task1.models.UserViewDetail;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<UserViewDetail> mData;


    public RecyclerViewAdapter(Context mContext, List<UserViewDetail> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.userview_details, parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_user_title.setText(mData.get(position).getTitle());
        holder.img_user_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, UserViewDetails.class);


                //passing the data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());

                //start the activityb
                mContext.startActivity(intent);


            }
        });





    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static  class  MyViewHolder extends   RecyclerView.ViewHolder{

        TextView tv_user_title;
        ImageView img_user_thumbnail;
        CardView cardView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);



            tv_user_title = (TextView) itemView.findViewById(R.id.userview_title_id);
            img_user_thumbnail = (ImageView) itemView.findViewById(R.id.userview_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }



}
