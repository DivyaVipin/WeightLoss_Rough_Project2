package assignment.android.acadgild.nav;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import assignment.android.acadgild.weightlossfoods.BeansLegumes;
import assignment.android.acadgild.weightlossfoods.BoiledPotatos;
import assignment.android.acadgild.weightlossfoods.ChiaSeeds;
import assignment.android.acadgild.weightlossfoods.Chicken;
import assignment.android.acadgild.weightlossfoods.ChilliPepper;
import assignment.android.acadgild.weightlossfoods.CruciferousVegetables;
import assignment.android.acadgild.weightlossfoods.Eggs;
import assignment.android.acadgild.weightlossfoods.LeafyGreens;
import assignment.android.acadgild.weightlossfoods.Salmon;
import assignment.android.acadgild.weightlossfoods.Tuna;

/**
 * Created by DivyaVipin on 1/16/2017.
 */

public class Pager extends FragmentPagerAdapter {


    int tabCount;
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Chicken chicken_fragment = new Chicken();
                return chicken_fragment;
            case 1:
                Eggs eggs_fragment = new Eggs();
                return eggs_fragment;
            case 2:
                ChiaSeeds chia_fragment = new ChiaSeeds();
                return chia_fragment;
            case 3:
                ChilliPepper chilli_fragment = new ChilliPepper();
                return chilli_fragment;
            case 4:
                LeafyGreens leafyGreens = new LeafyGreens();
                return leafyGreens;


            case 5:
                Salmon salmon = new Salmon();
                return salmon;
           case 6:
                CruciferousVegetables cruciferousVegetables = new CruciferousVegetables();
                return cruciferousVegetables;
            case 7:
                BoiledPotatos boiledPotatos = new BoiledPotatos();
                return boiledPotatos;
            case 8:
                Tuna tuna = new Tuna();
                return tuna;


            case 9:
                BeansLegumes beansLegumes = new BeansLegumes();
                return beansLegumes;





            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
