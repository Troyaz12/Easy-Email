package com.example.android.newemailappmom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

/**
 * Created by TroysMacBook on 12/4/16.
 */

public class contactsDisplayAdapter extends RecyclerView.Adapter<contactsDisplayAdapter.ViewHolder>{

    int[] imagesFile;

    public contactsDisplayAdapter(int[] folderFile) {
        imagesFile = new int[folderFile.length];
        for(int i=0;i<folderFile.length;i++){
            imagesFile[i] = folderFile[i];
        }
    }

    @Override
    public contactsDisplayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_display, parent, false);
        return new contactsDisplayAdapter.ViewHolder(view);        }

    @Override
    public void onBindViewHolder(contactsDisplayAdapter.ViewHolder holder, int position) {
        int imageFile = imagesFile[position];

        holder.contact1.setBackgroundResource(imageFile);
    }


    @Override
    public int getItemCount() {
        return imagesFile.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox contact1;



        public ViewHolder(View itemView) {
            super(itemView);
            // get checkbox
            contact1 = (CheckBox) itemView.findViewById(R.id.contact1);
        }
    }
}
