package back.end;

/**
 * Created by skulitom on 09/04/2016.
 */
public class Currency {
    private char symbol;
    private String bigCurrency;
    private String smallCurrency;

    public Currency(){
        this.symbol = '£';
        this.bigCurrency = "pounds";
        this.smallCurrency = "pence";
    }

    public void setCurrency(int lang){
        switch (lang){
            case 0:
                this.symbol = '£';
                this.bigCurrency = "pounds";
                this.smallCurrency = "pence";
                break;
            case 1:
                this.symbol = '$';
                this.bigCurrency = "dollars";
                this.smallCurrency = "cents";
                break;
            default:
                this.symbol = '£';
                this.bigCurrency = "pounds";
                this.smallCurrency = "pence";
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
        return smallCurrency;
    }
}
