package back.end;

/**
 * Created by skulitom on 08/04/2016.
 */
public class PriceColor {
    ////- Result green
    private static final int greenLevel1 = 40;
    private static final int greenLevel2 = 90;
    private static final int greenLevel3 = 140;
    private static final int greenLevel4 = 180;
    private static final int greenLevel5 = 205;
    private static final int greenLevel6 = 255;
    ////
    ////- Button Text green
    private static final int greenButtonLevel1 = 40;
    private static final int greenButtonLevel2 = 90;
    private static final int greenButtonLevel3 = 140;
    private static final int greenButtonLevel4 = 180;
    private static final int greenButtonLevel5 = 205;
    private static final int greenButtonLevel6 = 255;
    ////

    private int green, red, itemGreen, itemRed;
    public PriceColor(){
        this.green = 0;
        this.red= 0;
        this.itemGreen =0;
        this.itemRed = 0;
    }
    public int getRed(double num){
        return (255 - getGreen(num));
    }
    public int getGreen(double num){
        // green for final result
        if(num < 5){this.green = greenLevel6;}
        else if(num < 10){this.green = greenLevel5;}
        else if(num < 20){this.green = greenLevel4;}
        else if(num < 40){this.green = greenLevel3;}
        else if(num < 70){this.green = greenLevel2;}
        else if(num < 100){this.green = greenLevel1;}
        else{this.green = 0;}
        return this.green;
    }

    public int getItemRed(double num){
        return (255 - getItemGreen(num));
    }
    public int getItemGreen(double num){
        // green for buttons
        if(num < 1){this.itemGreen = greenButtonLevel6;}
        else if(num < 2){this.itemGreen = greenButtonLevel5;}
        else if(num < 3){this.itemGreen = greenButtonLevel4;}
        else if(num < 5){this.itemGreen = greenButtonLevel3;}
        else if(num < 10){this.itemGreen = greenButtonLevel2;}
        else if(num < 20){this.itemGreen = greenButtonLevel1;}
        else{this.itemGreen = 0;}
        return this.itemGreen;
    }
}
