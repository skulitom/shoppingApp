package back.end;

/**
 * Created by skulitom on 08/04/2016.
 */
public class PriceColor {
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
        if(num < 5){this.green = 255;}
        else if(num < 10){this.green = 205;}
        else if(num < 20){this.green = 180;}
        else if(num < 40){this.green = 140;}
        else if(num < 70){this.green = 90;}
        else if(num < 100){this.green = 40;}
        else{this.green = 0;}
        return this.green;
    }

    public int getItemRed(double num){
        return (255 - getItemGreen(num));
    }
    public int getItemGreen(double num){
        if(num < 1){this.itemGreen = 255;}
        else if(num < 2){this.itemGreen = 205;}
        else if(num < 3){this.itemGreen = 180;}
        else if(num < 5){this.itemGreen = 140;}
        else if(num < 10){this.itemGreen = 90;}
        else if(num < 20){this.itemGreen = 40;}
        else{this.itemGreen = 0;}
        return this.itemGreen;
    }
}
