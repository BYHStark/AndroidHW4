package com.example.gym;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import okhttp3.*;
public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {
    //private OnItemClickListener mOnItemClickListener=null;

    private List<ItemClass> mItemContentList;
    private Fragment fragment;
    public ClassAdapter(Fragment f, List<ItemClass> ItemContentList) {
        fragment=f;
        mItemContentList = ItemContentList;
    }

//    public static interface OnItemClickListener{
//        void onItemClick(View view, int position);
//    }

//    @Override
//    public void onClick(View v) {
//        if(mOnItemClickListener!=null){
//            mOnItemClickListener.onItemClick(v,(int)v.getTag());
//        }
//    }
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        TextView itemText;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_class_image);
            itemName = (TextView)itemView.findViewById(R.id.item_class_title);
            itemText=(TextView)itemView.findViewById(R.id.item_class_text);
        }
    }

    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class,parent,false);
        ClassAdapter.ViewHolder viewHolder = new ClassAdapter.ViewHolder(view);
       // viewHolder.setOnItemClickListener(this);



        viewHolder.itemImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(fragment.getActivity(),VideoPlayer.class);
                fragment.getActivity().startActivity(intent);
            }
        });


        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ClassAdapter.ViewHolder holder, int position) {
        ItemClass mContent = mItemContentList .get(position);
        holder.itemImage.setImageResource(mContent.getImageId());
        holder.itemName.setText(mContent.getName());
        holder.itemText.setText(mContent.getText());

    }
    @Override
    public int getItemCount() {
        return mItemContentList.size();
    }
//    public  static android.graphics.Bitmap getVideoThumb(String path) {
//
//        MediaMetadataRetriever media = new MediaMetadataRetriever();
//
//        media.setVi(Uri.parse(path));
//
//        return  media.getFrameAtTime();
//
//    }

//    public Bitmap getPic(String url) {
//        //获取okHttp对象get请求
//        try {
//            OkHttpClient client = new OkHttpClient();
//            //获取请求对象
//            Request request = new Request.Builder().url(url).build();
//            //获取响应体
//            new Thread(new Runable(){
//                public void run{
//                    try{
//                        ResponseBody body = client.newCall(request).execute().body();
//                        //获取流
//                        InputStream in = body.byteStream();
//                        //转化为bitmap
//                        Bitmap bitmap = BitmapFactory.decodeStream(in);
//                    }catch ()
//                }
//            })
//
//
//            return bitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
