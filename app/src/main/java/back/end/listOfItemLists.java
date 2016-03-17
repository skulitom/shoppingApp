package back.end;

/**
 * Created by skulitom on 17/03/2016.
 */

import java.util.ArrayList;

public class listOfItemLists {
    private ArrayList<item> list = new ArrayList<item>();

    public void addItem(item newList){
        list.add(newList);
    }

    public item getItem(int index){
        return list.get(index);
    }

    public int getItemListLength(){
        return list.size();
    }

    public void removeItem(int index){
        list.remove(index);
    }
}
