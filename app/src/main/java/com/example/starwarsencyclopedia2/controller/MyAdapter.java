package com.example.starwarsencyclopedia2.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starwarsencyclopedia2.R;
import com.example.starwarsencyclopedia2.model.People;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava>
{


    public interface OnItemClickListener{
        void onItemClick(People item);
    }



    private List<People> listValues;
    private final OnItemClickListener listener;



    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<People> listValues, OnItemClickListener listener)
    {
        this.listValues = listValues;
        this.listener = listener;
    }







    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class CelluleJava extends RecyclerView.ViewHolder
    {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public CelluleJava(View v)
        {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    public void add(int position, People item)
    {
        listValues.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position)
    {
        listValues.remove(position);
        notifyItemRemoved(position);
    }




    // Create new views (invoked by the layout manager)
    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final People currentPeople = listValues.get(position);
        final String name = currentPeople.getName();
        final String gender = currentPeople.getGender();
        final String height = currentPeople.getHeight();
        final String mass = currentPeople.getMass();

        final String hair_color = currentPeople.getHairColor();
        final String eye_color = currentPeople.getEyeColor();
        final String birth_year = currentPeople.getBirthYear();


        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentPeople);
            }

        });

        holder.txtFooter.setText("Gender : " + gender);
        holder.txtFooter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentPeople);
            }

        });

        holder.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentPeople);
            }

        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }


}
