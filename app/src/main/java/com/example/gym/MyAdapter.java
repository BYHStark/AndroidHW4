package com.example.gym;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.example.gym.MyAdapter.ViewHolder.OnRecyclerViewItemClickListener;
import org.w3c.dom.Text;
import android.widget.Toast;
import java.util.List;
import android.net.Uri;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ItemContent> mItemContentList;

    public MyAdapter(List<ItemContent> ItemContentList) {
        mItemContentList = ItemContentList;
    }
    static public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        Button itemButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemName = (TextView)itemView.findViewById(R.id.item_text);
            itemButton=(Button)itemView.findViewById(R.id.call_button);
        }
        public static interface OnRecyclerViewItemClickListener {
            void onItemClick(View view , String data);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemContent mContent = mItemContentList .get(position);
        holder.itemImage.setImageResource(mContent.getImageId());
        holder.itemName.setText(mContent.getName());
        holder.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "18801379269");
                intent.setData(data);
                v.getContext().startActivity(intent);


            }
        });
    }
    @Override
    public int getItemCount() {
        return mItemContentList.size();
    }

}
