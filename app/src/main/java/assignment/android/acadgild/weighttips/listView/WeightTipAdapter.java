package assignment.android.acadgild.weighttips.listView;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import assignment.android.acadgild.R;

/**
 * Created by DivyaVipin on 1/20/2017.
 */

public class WeightTipAdapter extends RecyclerView.Adapter<WeightTipAdapter.ViewHolder>{
    private String[] tips = {"Drink Green Tea", "Eat Spices", "Eat Eggs", "Drink plenty of water", "Start your day with a glass of water",
            "Drink glass of water before your meal", "If you do have a craving for fruit juice then go for fresh fruit juice",
            "Eat fresh fruit instead of drinking fruit juice","Include in your diet things that contain more water " +
            "like tomatoes and water melons","Stay away from sweetened bottle drinks,especially sodas",
            "Eat More Fiber","Do Aerobic Excercise" ,"Eat Spicy Foods","Use smaller plates","Drink Coffee","Cook with Coconut Oil","Cut Back on Added Sugar","Eat less Refined Carbs"};
    class ViewHolder extends RecyclerView.ViewHolder{



        public int currentItem;



        public TextView itemTitle;





        public ViewHolder(View itemView) {

            super(itemView);


            itemTitle = (TextView)itemView.findViewById(R.id.weightTip);




            itemView.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {

                    int position = getAdapterPosition();


;



                }

            });

        }

    }
    @Override

    public WeightTipAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())

                .inflate(R.layout.weighttip_cardview, viewGroup, false);

        WeightTipAdapter.ViewHolder viewHolder = new WeightTipAdapter.ViewHolder(v);

        return viewHolder;

    }



    @Override

    public void onBindViewHolder(WeightTipAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemTitle.setText(tips[i]);


    }



    @Override

    public int getItemCount() {

        return tips.length;

    }
}



