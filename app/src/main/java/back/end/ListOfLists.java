package back.end;

import java.util.ArrayList;

/**
 * Created by skulitom on 03/03/2016.
 */
public class ListOfLists {
    private String _name;
    private ArrayList<itemList> _list = new ArrayList<itemList>();

    public ListOfLists(){
        this._name = "All saved lists";
    }

    public void addItem(itemList product){
        _list.add(product);
    }

    public itemList getItem(int index){
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
