package back.end;

import java.util.ArrayList;

/**
 * Created by skulitom on 03/03/2016.
 */
public class itemList implements ShoppingList{
    private String _name;
    private ArrayList<item> _list = new ArrayList<item>();

    public itemList(){
        this._name = "Current List";
    }

    public void addItem(item product){
        _list.add(product);
    }

    public item getItem(int index){
        return _list.get(index);
    }

    public int getItemListLength(){
        return _list.size();
    }

    public void removeList(int index){
        _list.remove(index);
    }

    public void setName(String _name){this._name=_name;}

    public String getName(){return _name;}
}
