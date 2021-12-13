import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class GroceryListParser {
        private String nameItem;
        private Double priceItem;
        private String typeItem;
        private String expiration;

    public





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
//            [:]
//    // a key and its following key are separated by (:, @, ^, *, % !)
//            [:@ ^ * % !]
    // each item in the list is separated by (##)



    // In JerkSON Key and Value could be seperated by using a any of the following (:, @, ^, *, %) and (!)
    // Json Key and Value pairs are seperated by a ',' in JerkSON its '##

//    [:, @, ^, *, %]
//    .\d{2}

    public GroceryItem parseOneItemGrocery (String OneUnitOfItem) throws Exception  {

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

        if ( mt.matches()) {
            String nameItem = mt.group(2).toLowerCase();
            Double priceItem = Double.valueOf(mt.group(4).toLowerCase());
            return new GroceryItem ( nameItem,priceItem);

        } else {
            throw new Exception();
        }


    }








}
