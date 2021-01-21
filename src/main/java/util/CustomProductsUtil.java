package util;

import com.opencsv.CSVReader;
import model.*;
import model.gpod.ProductGpod;
import model.gpod.RolesGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomProductsUtil {


    public static int productCounter=20000;
    public static void buildProducts(Set<ProductGpod> productsSet) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.RICHARTSON_PRODUCTS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            Set<String> existingImages = getExistingImages();

            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                productsSet.add(prepareProduct(row, existingImages));
            }

        }
    }


    public static ProductGpod prepareProduct(String[] row,Set<String> existingImages ){
//                0-Catagory
//                1-Sub Catagory
//                2-Type
//                3-Brand
//                4-product
//                5-UPC Code
//                6-Product Description
//                7-Price
//                8-Tax
//                9-Store
//                10-Size
//                11-UOM
//                12-Image
//                13-Spice Level
//                14-Aisle No.


        ProductGpod p  = new ProductGpod();
        int productId = productCounter++;
        p.setId(productId);

        p.getCategories().add(new Category(row[0], row[0])); // 0- category
        p.getSubCategories().add(new SubCategory(row[1], row[1])); // 1- sub-category
        p.setType(new Type(row[2],row[2])); // 2-type
        p.getBrands().add(new Brand(row[3],row[3])); //3-brand
        p.setDesc(row[4]);  //4-Product
        p.setCode(row[4]);  //4-Product

        // used for algolia search in future we can add more search key words for that product
        p.getTags().add(row[4]);

        p.setShortDesc(row[6]); // 6-Product Description
        p.setPrice(new Price(Double.parseDouble(row[7]), Double.parseDouble(row[7]))); // 7-price
        p.setTax(Double.parseDouble(row[8])); // 8-Tax
        p.setStore(row[9]); // 9-store

        p.setWeight(row[10] + " "+row[11]); // 10-size
        p.setWeightType(row[10] + " "+row[11]); //11-uom

      //  if(existingImages.contains(row[12])){
            p.setDefaultImage(row[12]); // 12-Image
            p.setImageName(row[12]); // 12-Image
//        }else{
//            p.setDefaultImage("No Image.jpg"); // 12-Image
//            p.setImageName("No Image.jpg"); // 12-Image
//        }
        p.setAiselNo(row[14]); // 14-aisel No

        p.setQuantity(0);
        p.setNewlyAdded(false); // default to all products
        p.setDealsEnabled(false); // default to all products
        p.setActive(true);

        p.setCreatedTimestamp(new Date());
        p.setUpdatedTimestamp(new Date());

       return p;
    }


    private static Set<String> getExistingImages() throws IOException {
        Set<String> existingImages = new HashSet<>();
        Files.walk(Paths.get("D:/projects/bit-merrimack/merrimack-master/uploads/products"))
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    existingImages.add(file.getFileName().toString());
                });
        return existingImages;
    }

}
