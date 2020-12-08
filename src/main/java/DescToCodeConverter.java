import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConvertJavaToJson {
    public static void convert(List<Product> productList) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("D:/projects/csv-to-json/src/main/resources/products_1k_recs.json"), productList);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productList);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertUsingGson(List<Product> productList) {

        Gson gson =  new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(productList);

        try (FileWriter writer = new FileWriter("D:/projects/csv-to-json/src/main/resources/products_1k.json")) {
            gson.toJson(productList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(jsonString);
    }

}
