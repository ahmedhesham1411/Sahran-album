package com.example.sahranalbum;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SubCatAdapter extends RecyclerView.Adapter<SubCatAdapter.ViewHolder> {

    List<MyModel> myModels;
    Context context;
    Preferences preferences;
    public SubCatAdapter(List<MyModel> myModels, Context context) {
        this.myModels = myModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Boolean FavStatus = myModels.get(position).getFav();
        if (FavStatus == true){
            holder.emptyFav.setVisibility(View.GONE);
            holder.fullFav.setVisibility(View.VISIBLE);
        }
        else if (FavStatus == false){
            holder.fullFav.setVisibility(View.GONE);
            holder.emptyFav.setVisibility(View.VISIBLE);
        }
        holder.emptyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.emptyFav.setVisibility(View.GONE);
                holder.fullFav.setVisibility(View.VISIBLE);

                Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.pop_anim);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                holder.fullFav.startAnimation(myAnim);

            }
        });
        holder.fullFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fullFav.setVisibility(View.GONE);
                holder.emptyFav.setVisibility(View.VISIBLE);

                Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.pop_anim);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                holder.emptyFav.startAnimation(myAnim);

            }
        });

        holder.textView.setText(myModels.get(position).getSongName());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.Save_name(context,myModels.get(position).getPrename());
                preferences.Save_nameee(context,myModels.get(position).getSongName());
                Intent intent = new Intent(context,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fullFav,emptyFav;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emptyFav = itemView.findViewById(R.id.whiteheart);
            fullFav = itemView.findViewById(R.id.redheart);
            textView = itemView.findViewById(R.id.song_name);
        }

    }

    class MyBounceInterpolator implements android.view.animation.Interpolator {
        private double mAmplitude = 1;
        private double mFrequency = 10;

        MyBounceInterpolator(double amplitude, double frequency) {
            mAmplitude = amplitude;
            mFrequency = frequency;
        }

        public float getInterpolation(float time) {
            return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                    Math.cos(mFrequency * time) + 1);
        }
    }
}
