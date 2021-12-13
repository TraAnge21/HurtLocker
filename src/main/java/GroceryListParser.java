
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;


public class GroceryListParser <Item> {
    private String nameItem;
    private Double priceItem;
    private String typeItem;
    private String expiration;
    private Item item;


    public GroceryListParser(String nameItem, Double priceItem, String typeItem, String expiration) {
        this.nameItem = nameItem;
        this.priceItem = priceItem;
        this.typeItem = typeItem;
        this.expiration = expiration;
    }

    public List<Item> parseGroceryItemList(String groceryListToParse) throws Exception {
        List<String> groceryList = new ArrayList<String>();
        while (groceryListToParse != null) {
            groceryList.add(groceryListToParse.split("##").toString());
        }

        List <Item> itemList = new ArrayList <Item>();

        for (String g : groceryList) {
            itemList.add(parseOneItemGrocery(g));

        }
        return itemList;
    }


    // naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##
//    [:@ ^ * % !] or [.]
//            \w+  macthe one or more words
//            \w or [a-zA-Z]
//            (r|s|a)
//            //naMe:Milk;
//            \w+ : \w+ [;:@ ^ * % !]
//            // price:3.23;
//            \w+ : \d+\.?\d+ [;:@ ^ * % !]
//            // type:Food;
//            \w+ : \w+ [;:@ ^ * % !]
//            // expiration:1/25/2016
//            \w+ : \d {1,2}/\\d{1,2}/\\d{4}


    // 4 groups to match name, price, type and expiration
    // key and value are separated by (:)
// a key and its following key are separated by (:, @, ^, *, % !)
//  [:@ ^ * % !]
    // each item in the list is separated by (##)
    // In JerkSON Key and Value could be seperated by using a any of the following (:, @, ^, *, %) and (!)
    // Json Key and Value pairs are seperated by a ',' in JerkSON its '##


    public Item parseOneItemGrocery(String OneUnitOfItem) throws Exception {
        String nameItem;
        Double priceItem;
        String typeItem;
        String expiration;
        // naMe:Milk;
        // price:3.23;
        // type:Food;
        // expiration:1/25/2016##

        String regX = "(\\w+)" + ":" + "(\\w+)" + "[;:@ ^ * % !]" +
                "(\\w+)" + ":" + "(\\d+\\.?\\d+)" + "[;:@ ^ * % !]" +
                "\\w+" + ":" + "\\d+\\.?\\d+" + "[;:@ ^ * % !]" +
                "\\w+" + ":" + "\\d {1,2}/\\d{1,2}/\\d{4}" + "##";

        Pattern pt = Pattern.compile(regX);
        Matcher mt = pt.matcher(OneUnitOfItem);

        if (mt.matches()) {
            nameItem = mt.group(2).toLowerCase();
            priceItem = Double.valueOf(mt.group(4).toLowerCase());
            typeItem = mt.group(6).toLowerCase();
            expiration = mt.group(8).toLowerCase();


//            Item item = new Item (nameItem,priceItem, typeItem, expiration);
            return item;

//            return mt.group(2).toLowerCase();
//            return new GroceryListParser( nameItem,priceItem, "","");

        } else {
            throw new Exception();
        }


    }
    
}
    






