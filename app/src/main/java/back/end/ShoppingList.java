package back.end;

/**
 * Created by skulitom on 10/04/2016.
 */
public interface ShoppingList {

    int getItemListLength();

    void removeList(int index);

    void setName(String _name);

    String getName();
}
