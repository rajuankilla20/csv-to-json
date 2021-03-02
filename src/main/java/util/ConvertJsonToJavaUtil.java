package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.json.BrandsJson;
import model.json.CategoryJson;
import model.json.SubCategoryJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class ConvertJsonToJavaUtil {

    public static void main(String[] args) {
       // new ConvertJsonToJavaUtil().convertJsonBrandsToJava("D:/projects/csv-json-proj/csv-to-json/src/main/resources/weekly-uploaded-products-input/production-brands.json");
    }

    public static void convertJsonBrandsToJava(String filePath,Set<BrandsJson> brandsSet)   {

        System.out.println("---file path : "+ filePath);
        final ObjectMapper objectMapper = new ObjectMapper();
        BrandsJson[] brands = {};
        try {
            brands =   objectMapper.readValue(
                    new File(filePath),
                    BrandsJson[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---"+brands.length);
        Collections.addAll(brandsSet, brands);
//        return  brandsSet;
    }

    public  static void convertJsonCategoriesToJava(String filePath,Set<CategoryJson> categoriesSet)   {

        System.out.println("---file path : "+ filePath);
        final ObjectMapper objectMapper = new ObjectMapper();
        CategoryJson[] categories = {};
        try {
            categories =   objectMapper.readValue(
                    new File(filePath),
                    CategoryJson[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---"+categories.length);
        Collections.addAll(categoriesSet, categories);
    }

    public static void convertJsonSubCategoriesToJava(String filePath,Set<SubCategoryJson> subCategoriesSet)   {

        System.out.println("---file path : "+ filePath);
        final ObjectMapper objectMapper = new ObjectMapper();
        SubCategoryJson[] subCategories = {};
        try {
            subCategories =   objectMapper.readValue(
                    new File(filePath),
                    SubCategoryJson[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---"+subCategories.length);
        Collections.addAll(subCategoriesSet, subCategories);
    }


    public static void createJsonFile(Object printObject,String fileName) {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
//        String jsonString = gson.toJson(printObject);
//        System.out.println(" File : "+ fileName + " -->\n" + jsonString);
        try (FileWriter writer = new FileWriter("D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-output/"+fileName+".json")) {
            gson.toJson(printObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
