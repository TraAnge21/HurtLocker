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



// A method to write the file text containing the Hamlet.txt

    public void fileWriting ( String hamletText) throws FileNotFoundException {

        String textFileName = "RawData.txt";
        FileOutputStream outputStream = new FileOutputStream(textFileName);
        Formatter formatter= new Formatter(outputStream);
        formatter.format(hamletText);

    }



}
