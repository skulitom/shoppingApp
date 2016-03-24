package back.end;

/**
 * Created by skulitom on 03/03/2016.
 */
public class item {
    private String _name = "";
    private int _pounds = 0;
    private int _pennies = 0;
    private int _quantity = 0;
    private double _totalPrice = 0;

    public void setName(String _name){
        this._name = _name;
    }

    public void setPounds(int _pounds){
        this._pounds = _pounds;
    }

    public void setPennies(int _pennies){
        this._pennies = _pennies;
    }

    public void setQuantity(int _quantity){
        this._quantity = _quantity;
    }

    public void setTotalPrice(double _totalPrice){this._totalPrice = Math.round(_totalPrice*this._quantity*100)/100;}



    public double getTotalPrice(){return _totalPrice;}
    public String getName(){return _name;}
    public int getPounds(){
        return _pounds;
    }
    public int getPennies(){
        return _pennies;
    }
    public int getQuantity(){
        return _quantity;
    }
}
