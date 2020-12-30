import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CategoryModel;
import model.Product;
import model.SubCategory;
import model.SubCategoryModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertJavaToJson {

    public static void convertProductsToJson(List<Product> productList) {

        System.out.println("---products : "+ productList.size());
        createJsonFile(productList,"products.json");
//
//        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
//        String jsonString = gson.toJson(productList);
//
//        try (FileWriter writer = new FileWriter("D:/projects/csv-to-json/src/main/resources/products_testing.json")) {
//            gson.toJson(productList, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static void convertCatToSubCatToJson(List<CategoryModel> categoryModelList, List<SubCategoryModel> subCategoryModelList) {
        System.out.println("---categories : "+ categoryModelList.size());
        createJsonFile(categoryModelList,"categories.json");
        System.out.println("---sub-categories : "+ subCategoryModelList.size());
        createJsonFile(subCategoryModelList,"sub-categories.json");
    }

    private static void createJsonFile(Object printObject,String fileName) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
//        String jsonString = gson.toJson(printObject);
//        System.out.println(" File : "+ fileName + " -->\n" + jsonString);

        try (FileWriter writer = new FileWriter("D:/projects/csv-json-proj/csv-to-json/src/main/resources/"+fileName)) {
            gson.toJson(printObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
