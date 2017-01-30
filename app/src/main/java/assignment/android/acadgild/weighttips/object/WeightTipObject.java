package assignment.android.acadgild.weighttips.object;

/**
 * Created by DivyaVipin on 1/20/2017.
 */

public class WeightTipObject {
    public WeightTipObject()
    {

    }
    public WeightTipObject(String weightLossTip) {
        this.weightLossTip = weightLossTip;
    }

    public String getWeightLossTip() {
        return weightLossTip;
    }

    public void setWeightLossTip(String weightLossTip) {
        this.weightLossTip = weightLossTip;
    }

    private String weightLossTip;
}
