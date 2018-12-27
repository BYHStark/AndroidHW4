package com.example.gym;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GymAdapter extends RecyclerView.Adapter<GymAdapter.ViewHolder> {
    private List<ItemGym> mItemContentList;
    private Fragment fragment;
    public GymAdapter(Fragment f,List<ItemGym> ItemContentList) {
        fragment=f;
        mItemContentList = ItemContentList;
    }
    static public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        Button itemButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image_gym);
            itemName = (TextView)itemView.findViewById(R.id.item_text_gym);
            itemButton=(Button)itemView.findViewById(R.id.go_button);
        }
    }

    @Override
    public GymAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gym,parent,false);
        GymAdapter.ViewHolder viewHolder = new GymAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(GymAdapter.ViewHolder holder, int position) {
        ItemGym mContent = mItemContentList .get(position);
        holder.itemImage.setImageResource(mContent.getImageId());
        holder.itemName.setText(mContent.getName());
        holder.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(fragment.getActivity(),BaiduMap.class);
                fragment.getActivity().startActivity(intent);

            }
        });

    }
    @Override
    public int getItemCount() {
        return mItemContentList.size();
    }



}
