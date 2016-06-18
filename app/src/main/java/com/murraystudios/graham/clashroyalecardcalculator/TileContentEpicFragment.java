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
public class TileContentEpicFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        TileContentEpicFragment.ContentAdapter adapter = new TileContentEpicFragment.ContentAdapter(recyclerView.getContext());
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
        public ViewHolder (LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
        }
    }
    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<TileContentFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        private final String[] eName;

        private final Drawable[] eFullPictures;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            eName = resources.getStringArray(R.array.eCard_name);
            TypedArray a = resources.obtainTypedArray(R.array.eCard_picture);
            eFullPictures = new Drawable[a.length()];
            for (int i = 0; i < eFullPictures.length; i++) {
                eFullPictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public TileContentFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TileContentFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(TileContentFragment.ViewHolder holder, int position) {
            holder.picture.setImageDrawable(eFullPictures[position % eFullPictures.length]);
            holder.name.setText(eName[position % eName.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}

