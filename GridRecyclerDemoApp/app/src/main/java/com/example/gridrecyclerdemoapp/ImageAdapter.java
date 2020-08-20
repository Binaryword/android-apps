package com.example.gridrecyclerdemoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter <ImageAdapter.ImageViewHolder>{

    int imagefile[] ;
    List<String> imageName ;
    Context mContext ;

    public ImageAdapter(int imageFile[] , List<String> imageName, Context context){
        this.imagefile = imageFile;
        this.imageName = imageName ;
        this.mContext = context ;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_layout , parent , false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, mContext , imagefile);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        holder.mImageView.setImageResource(imagefile[position]);
        holder.mTextView.setText(imageName.get(position));
    }

    @Override
    public int getItemCount() {
        return imagefile.length;
    }

    public class  ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mImageView ;
        TextView mTextView ;
        View view ;
        Context context ;
        int[] imgFile ;

        public ImageViewHolder(@NonNull View itemView, Context context , int[] imgFile) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageViewHolder_id);
            mTextView = itemView.findViewById(R.id.imageNameHolder_id);
            view = itemView ;
            this.context = context ;
            this.imgFile = imgFile ;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context , DisplayActivity.class);
            intent.putExtra("IMAGE_KEY" , imgFile[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
