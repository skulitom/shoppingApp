package back.end;

/**
 * Created by skulitom on 08/04/2016.
 */
public class ProductsDictionary {
            private static ProductsDictionary instance = new ProductsDictionary();
            private ProductsDictionary(){}

            public static ProductsDictionary getInstance(){
                    return instance;
            }

            private String food[]={
                      "asparagus", "apples", "avacado"
                    , "alfalfa"
                    , "acorn squash"
                    , "almond", "arugala"
                    , "artichoke", "applesauce"
                    , "asiannoodles"
                    , "antelope"
                    , "ahi tuna"
                    , "albacore tuna"
                    , "Apple juice"
                    , "Avocado roll"
                    , "Bruscetta"
                    , "bacon", "bannana"
                    , "black beans"
                    , "bagels"
                    , "baked beans", "BBQ"
                    , "bison", "barley"
                    , "beer", "bisque"
                    , "bluefish", "bread"
                    , "broccoli", "buritto"
                    , "babaganoosh"
                    , "Cabbage", "cake"
                    , "carrots", "carne asada", "celery"
                    , "cheese", "chicken"
                    , "catfish", "chips"
                    , "chocolate", "chowder"
                    , "clams","coca cola", "coffee", "coke"
                    , "cookies", "corn"
                    , "cupcakes", "crab"
                    , "curry", "cereal"
                    , "chimichanga"
                    , "dates", "dips"
                    , "duck", "dumplings"
                    , "donuts", "eggs", "enchilada"
                    , "eggrolls", "English muffins", "edimame", "eel sushi"
                    , "fajita", "falafel", "fish", "franks"
                    , "fondu", "French toast", "French dip"
                    , "Garlic", "ginger"
                    , "gnocchi", "goose"
                    , "granola", "grapes", "green beans", "Guancamole"
                    , "gumbo", "grits", "Graham crackers"
                    , "ham, halibut", "hamburger", "honey", "huenos rancheros", "hash browns", "hot dogs", "haiku roll", "hummus"
                    , "ice cream", "Irish stew", "Indian food", "Italian bread"
                    , "jambalaya", "jelly", "jam", "jerky", "jalapeño"
                    , "kale"
                    , "kabobs", "ketchup"
                    , "kiwi", "kidney beans", "kingfish"
                    , "lobster"
                    , "Lamb", "Linguine"
                    , "Lasagna"
                    , "Meatballs", "Moose"
                    , "Milk", "Milkshake"
                    , "Noodles"
                    , "Ostrich"
                    , "Pizza"
                    , "Pepperoni", "Porter"
                    , "Pancakes"
                    , "Quesadilla", "Quiche"
                    , "Reuben"
                    , "Spinach"
                    , "Spaghetti","Tater tots", "Toast"
                    , "Venison"
                    , "Waffles", "Wine"
                    , "Walnuts","Yogurt"
                    , "Ziti", "Zucchini"
            };

            public String getCoresponFood(String typedIn){
                String result = " ";
                for(String element : this.food){
                        if(element.trim().length()>typedIn.trim().length()) {
                                if (element.substring(0, typedIn.trim().length()).toLowerCase().trim().equals(typedIn.toLowerCase().trim())) {
                                        result = element;
                                        break;
                                }
                        }
                }
                return result;
            }

}
