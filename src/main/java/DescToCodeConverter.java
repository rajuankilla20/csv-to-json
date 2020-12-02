import com.opencsv.CSVReader;
import model.Categories;
import model.SubCategory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DescToCodeConverter {
    public static Map<String, Categories> catSubCatMap = new HashMap<String, Categories>() ;


    private static final String CATEGORIES = "D:/projects/grocerspod-data-conversion/src/main/resources/categories.txt";
    private static final String SUB_CATEGORIES = "D:/projects/grocerspod-data-conversion/src/main/resources/subcategories.txt";

    private static final String PRODUCTS_JSON_FILE = "D:/projects/csv-to-json/src/main/resources/products.csv";

    public static void main(String[] args) throws IOException {


        buildCatSubCat(PRODUCTS_JSON_FILE);
//        convert(SUB_CATEGORIES);



    }

    private static void buildCatSubCat(String fileName) throws IOException {
        System.out.println("------------------------");
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVReader csvReader = new CSVReader(reader);
             ) {
            // Reading Records One by One in a String array
            String[] row;
            while ((row = csvReader.readNext()) != null) {

                    if(catSubCatMap.containsKey(row[0])){
                        Categories categories = catSubCatMap.get(row[0]);
                        boolean foundSubCat=false;
                      for(SubCategory subCategory : categories.getSubCategories()){

                             if(subCategory.getCode().equalsIgnoreCase(row[1])){
                                 categories.getSubCategories().add(new SubCategory(row[1],row[1]));
                                 catSubCatMap.put(row[0],categories);
                                 foundSubCat=true;
                                 break;
                             }
                         }

                }else{
                        Categories categories = new Categories(row[0], row[0]);
                        categories.getSubCategories().add(new SubCategory(row[1], row[1]));
                        catSubCatMap.put(row[0], categories);

                    }
            }

            System.out.println(" testing");
            System.out.println("CAT - SUB CAT : "+ catSubCatMap.values().toString());
        }
    }

    private static String convertDescToCode(String line) {
        String output = line.substring(0, 1).toLowerCase() + line.substring(1);
         output = output.replaceAll(" ", "");//.replaceAll(",", "_").replaceAll("&", "_");
        output = output.replaceAll(",", "_");
        output = output.replaceAll("&", "_");
        System.out.println(line +"=>"+output);
        return  output;
    }


}
