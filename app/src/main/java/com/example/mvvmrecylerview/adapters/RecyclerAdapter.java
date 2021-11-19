package com.example.mvvmrecylerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmrecylerview.R;
import com.example.mvvmrecylerview.models.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

//************************************************************
public class RecyclerAdapter
        extends RecyclerView.Adapter
        <ViewHolder>
//************************************************************
{
        private List<User> mList=new ArrayList<>();
        private Context mContext;

    public RecyclerAdapter(List<User> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.textView.setText(mList.get(position).getTitle());

        RequestOptions requestOptions=new RequestOptions()
                .error(R.drawable.ic_image);
        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(mList.get(position).getImageUrl())
                .into(holder.imageView);

    

        
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

//************************************************************
class ViewHolder extends RecyclerView.ViewHolder
//************************************************************
{
    public CircleImageView imageView;
    public TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.iv_profile_image);
        textView=itemView.findViewById(R.id.tv_user_name); }
}
