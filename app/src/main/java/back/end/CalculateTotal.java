package back.end;

import java.util.ArrayList;

/**
 * Created by skulitom on 03/03/2016.
 */
public class CalculateTotal {
    private int quantity;
    // 0 == pound
    // 1 == 5 pound note (green)
    // 2 == 10 pound note (orange)
    // 3 == 20 pound note (purple)
    private int typeOfMoney;

    public int getQuantity(){
        return quantity;
    }

    public int getTypeOfMoney(){
        return typeOfMoney;
    }

    public int getTotalFromList(itemList list){
        int total = 0;
        item currentItem;
        for(int i = 0; i<list.getItemListLength();i++){
            currentItem = list.getItem(i);
            total += currentItem.getTotalPrice();
        }
        return total;
    }

    public int calcAmount(int amount){
        quantity=0;
        typeOfMoney = 0;
        if(amount <= 4){
            while(amount >= 1){
                quantity++;
                amount--;
            }
        }
        else if(amount <= 9){
            quantity++;
            typeOfMoney = 1;
            amount -= 5;
        }
        else if(amount <= 19){
            quantity++;
            typeOfMoney = 2;
            amount -= 10;
        }
        else{
            typeOfMoney = 3;
            while(amount >= 20){
                quantity++;
                amount -= 20;
            }
        }

        return amount;

    }
}
