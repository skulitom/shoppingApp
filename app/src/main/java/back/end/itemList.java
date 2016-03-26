package back.end;

import java.util.ArrayList;

/**
 * Created by skulitom on 03/03/2016.
 */
public class itemList {
    private String name;
    private ArrayList<item> list = new ArrayList<item>();

    public void addItem(item product){
        list.add(product);
    }

    public item getItem(int index){
        return list.get(index);
    }



    public int getItemListLength(){
        return list.size();
    }

    public void removeList(int index){
        list.remove(index);
    }

    public void setName(String name){this.name=name;}

    public String getName(){return name;}
}
