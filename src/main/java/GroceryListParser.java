import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class GroceryListParser {


//    A method to find the nameToBeReplaced
    public Boolean isNameFound ( String nameTobeReplaced) {

        Pattern ptInText= Pattern.compile(nameTobeReplaced);
        Matcher nameMatcher= ptInText.matcher("RawData.txt");
        return nameMatcher.find();
    }

    // naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##
    [:@ ^ * % !] or [.]
            \w+  macthe one or more words
            (r|s|a)
            //naMe:Milk;
            (\w+)[:](\w+)[:@ ^ * % !]
            // price:3.23;
            (\w+)[:](\d+.?\d+) [:@ ^ * % !]
            // type:Food;
            (\w+)[:](\w+)[:@ ^ * % !]
            // expiration:1/25/2016



    // 4 groups to match name, price, type and expiration
    // key and value are separated by (:)
            [:]
    // a key and its following key are separated by (:, @, ^, *, % !)
            [:@ ^ * % !]
    // each item in the list is separated by (##)



    // In JerkSON Key and Value could be seperated by using a any of the following (:, @, ^, *, %) and (!)
    // Json Key and Value pairs are seperated by a ',' in JerkSON its '##

//    [:, @, ^, *, %]
//    .\d{2}

// A method to write the file text containing the Hamlet.txt

    public void fileWriting ( String hamletText) throws FileNotFoundException {

        String textFileName = "RawData.txt";
        FileOutputStream outputStream = new FileOutputStream(textFileName);
        Formatter formatter= new Formatter(outputStream);
        formatter.format(hamletText);

    }



}
