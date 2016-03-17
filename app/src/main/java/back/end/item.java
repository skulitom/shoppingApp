package back.end;

/**
 * Created by skulitom on 03/03/2016.
 */
public class item {
    private String name = "";
    private int pounds = 0;
    private int pennies = 0;
    private int quantity = 0;
    private int totalPrice = 0;

    public void setName(String name){
        this.name = name;
    }

    public void setPounds(int pounds){
        this.pounds = pounds;
    }

    public void setPennies(int pennies){
        this.pennies = pennies;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getTotalPrice(){
        totalPrice = 0;

        if(this.pennies>= 50){
            totalPrice++;
        }
        totalPrice+= pounds;
        return totalPrice;
    }

    public String getName(){
        return name;
    }
    public int getPounds(){
        return pounds;
    }
    public int getPennies(){
        return pennies;
    }
    public int getQuantity(){
        return quantity;
    }
}
