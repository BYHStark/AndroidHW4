package com.example.gym;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<ItemNews> mItemContentList;
    public NewsAdapter(List<ItemNews> ItemContentList) {
        mItemContentList = ItemContentList;
    }
    static public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        TextView itemText;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_news_img);
            itemName = (TextView)itemView.findViewById(R.id.item_news_name);
            itemText=(TextView)itemView.findViewById(R.id.item_news_text);
        }
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        NewsAdapter.ViewHolder viewHolder = new NewsAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        ItemNews mContent = mItemContentList .get(position);
        holder.itemImage.setImageResource(mContent.getImageId());
        holder.itemName.setText(mContent.getName());
        holder.itemText.setText(mContent.getText());
    }
    @Override
    public int getItemCount() {
        return mItemContentList.size();
    }

}
