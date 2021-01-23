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
    public static void buildProducts(Set<ProductGpod> productsSet,boolean sizeMixed, int productIdSeq, boolean productIdExist) throws IOException {
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
                productsSet.add(prepareProduct(row, existingImages,sizeMixed,productIdSeq++,productIdExist));
            }

        }
    }


    public static ProductGpod prepareProduct(String[] row,Set<String> existingImages, boolean sizeMixed,int productIdSeq,boolean productIdExist){

//        0-Product ID
//        1-Category
//        2-Sub Category
//        3-Type
//        4-Brand
//        5-Product Name
//        6-UPC Code
//        7-Product Description
//        8-Price
//        9-Tax
//        10-Store
//        11-Size
//        12-UOM
//        13-Image
//        14-Spice Level
//        15-Aisle No.



        ProductGpod p  = new ProductGpod();

        if(productIdExist){
            p.setId(Integer.parseInt(row[0])); // 0- productId
        }else{
            p.setId(productIdSeq);
        }

        p.getCategories().add(new Category(row[1], row[1])); // 1- category
        p.getSubCategories().add(new SubCategory(row[2], row[2])); // 2- sub-category
        p.setType(new Type(row[3],row[3])); // 3-type

        // used for algolia search in future we can add more search key words for that product
        p.getTags().add(row[3]); // 3-type

        p.getBrands().add(new Brand(row[4],row[4])); //4-brand
        p.setDesc(row[5]);  //5-Product
        p.setCode(row[5]);  //5-Product
        p.setUpcCode(row[6]); //6-UPC Code
        p.setShortDesc(row[7]); // 7-Product Description
        p.setPrice(new Price(Double.parseDouble(row[8]), Double.parseDouble(row[8]))); // 8-price
        p.setTax(Double.parseDouble(row[9])); // 9-Tax
        p.setStore(row[10]); // 10-store

        if(sizeMixed){
            p.setWeight(row[11]); // 11-size
            p.setWeightType(row[11]); //12-uom
        }else{
            p.setWeight(row[11] + " "+row[12]); // 11-size
            p.setWeightType(row[11] + " "+row[12]); //12-uom
        }

      if( (row[13].charAt(0) == 'X' || row[13].charAt(0) == 'x') || (existingImages.contains(row[13])) ){
            p.setDefaultImage(row[13]); // 13-Image
            p.setImageName(row[13]); // 13-Image
        }else {
            p.setDefaultImage("No Image.jpg"); // 13-Image
            p.setImageName("No Image.jpg"); // 13-Image
        }
        p.setSpiceLevel(row[14]);  // 14-Spice Level
        p.setAiselNo(row[15]); // 15-aisel No

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
