import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CategoryModel;
import model.Product;
import model.SubCategoryModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UsersJavaToJson {

    public static void convertProductsToJson(List<Product> productList) {

        System.out.println("---products : "+ productList.size());
        createJsonFile(productList,"products.json");

    }


    public static void createJsonFile(Object printObject,String fileName) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
//        String jsonString = gson.toJson(printObject);
//        System.out.println(" File : "+ fileName + " -->\n" + jsonString);
        try (FileWriter writer = new FileWriter("D:/projects/csv-json-proj/csv-to-json/src/main/resources/users-output/"+fileName+".json")) {
            gson.toJson(printObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
