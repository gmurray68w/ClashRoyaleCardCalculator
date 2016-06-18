package com.murraystudios.graham.clashroyalecardcalculator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Graham on 6/14/2016.
 */
public class TileContentRareFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        TileContentRareFragment.ContentAdapter adapter = new TileContentRareFragment.ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<TileContentRareFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        private final String[] rName;

        private final Drawable[] rFullPictures;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            rName = resources.getStringArray(R.array.rCard_name);
            TypedArray a = resources.obtainTypedArray(R.array.rCard_picture);
            rFullPictures = new Drawable[a.length()];
            for (int i = 0; i < rFullPictures.length; i++) {
                rFullPictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public TileContentRareFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TileContentRareFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(rFullPictures[position % rFullPictures.length]);
            holder.name.setText(rName[position % rName.length]);
        }



        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}

