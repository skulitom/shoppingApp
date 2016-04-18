package back.end;

/**
 * Created by skulitom on 09/04/2016.
 */
public class Currency {
    private char symbol;
    private String bigCurrency;
    private String smallCurrency;
    private String [] weights= new String [17];

    public Currency(){
        this.symbol = '£';
        this.bigCurrency = "pounds";
        this.smallCurrency = "pence";
        this.weights[0]= "10 grams";
        this.weights[1]= "50 grams";
        this.weights[2]= "100 grams";
        this.weights[3]= "200 grams";
        this.weights[4]= "300 grams";
        this.weights[5]= "400 grams";
        this.weights[6]= "500 grams";
        this.weights[7]= "1 kilogram";
        this.weights[8]= "10 kilograms";
        this.weights[9]= "100 kilograms";
        this.weights[10]= "100 mililitres";
        this.weights[11]= "200 mililitres";
        this.weights[12]= "500 mililitres";
        this.weights[13]= "1 litre";
        this.weights[14]= "2 litres";
        this.weights[15]= "5 litres";
        this.weights[16]= "10 litres";
    }

    public void setCurrency(int lang){
        switch (lang){
            case 0:
                this.symbol = '£';
                this.bigCurrency = "pounds";
                this.smallCurrency = "pence";
                this.weights[0]= "10 grams";
                this.weights[1]= "50 grams";
                this.weights[2]= "100 grams";
                this.weights[3]= "200 grams";
                this.weights[4]= "300 grams";
                this.weights[5]= "400 grams";
                this.weights[6]= "500 grams";
                this.weights[7]= "1 kilogram";
                this.weights[8]= "10 kilograms";
                this.weights[9]= "100 kilograms";
                this.weights[10]= "100 mililitres";
                this.weights[11]= "200 mililitres";
                this.weights[12]= "500 mililitres";
                this.weights[13]= "1 litre";
                this.weights[14]= "2 litres";
                this.weights[15]= "5 litres";
                this.weights[16]= "10 litres";
                break;
            case 1:
                this.symbol = '$';
                this.bigCurrency = "dollars";
                this.smallCurrency = "cents";
                this.weights[0]= "10 ounce";
                this.weights[1]= "50 ounce";
                this.weights[2]= "100 ounce";
                this.weights[3]= "200 ounce";
                this.weights[4]= "300 ounce";
                this.weights[5]= "400 ounce";
                this.weights[6]= "500 ounce";
                this.weights[7]= "1 pound";
                this.weights[8]= "10 pounds";
                this.weights[9]= "100 pounds";
                this.weights[10]= "100 mililitres";
                this.weights[11]= "200 mililitres";
                this.weights[12]= "500 mililitres";
                this.weights[13]= "1 litre";
                this.weights[14]= "2 litres";
                this.weights[15]= "5 litres";
                this.weights[16]= "10 litres";
                break;
            default:
                this.symbol = '£';
                this.bigCurrency = "pounds";
                this.smallCurrency = "pence";
                this.weights[0]= "10 grams";
                this.weights[1]= "50 grams";
                this.weights[2]= "100 grams";
                this.weights[3]= "200 grams";
                this.weights[4]= "300 grams";
                this.weights[5]= "400 grams";
                this.weights[6]= "500 grams";
                this.weights[7]= "1 kilogram";
                this.weights[8]= "10 kilograms";
                this.weights[9]= "100 kilograms";
                this.weights[10]= "100 mililitres";
                this.weights[11]= "200 mililitres";
                this.weights[12]= "500 mililitres";
                this.weights[13]= "1 litre";
                this.weights[14]= "2 litres";
                this.weights[15]= "5 litres";
                this.weights[16]= "10 litres";
                break;
        }

    }

    public char getSymbol(){
        return this.symbol;
    }

    public String getBigCurrency(){
        return this.bigCurrency;
    }

    public String getSmallCurrency() {
        return this.smallCurrency;
    }

    public String [] getWeights(){return this.weights;}
}
