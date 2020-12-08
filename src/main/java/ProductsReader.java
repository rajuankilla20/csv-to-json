import com.opencsv.CSVReader;
import model.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductsReader {

    List<Product> productList = new ArrayList<>();


    private static final String SAMPLE_CSV_FILE_PATH = "D:/projects/csv-to-json/src/main/resources/products_1k-recs.csv";

    private static  Map<String, String> categoriesMap = new HashMap<String, String>();
    private static  Map<String, String> subCategoriesMap = new HashMap<String, String>();
    private static Map<String, Product> productMap = new HashMap<>();
    private static Map<String, Product> duplicateProductMap = new HashMap<>();

    private static final String CATEGORIES="categories";
    private static final String SUB_CATEGORIES="subCategories";

    private static final String CATEGORIES_FILE = "D:/projects/grocerspod-data-conversion/src/main/resources/categories.txt";
    private static final String SUB_CATEGORIES_FILE = "D:/projects/grocerspod-data-conversion/src/main/resources/subcategories.txt";
    private static final int PRODUCT_NAME=1;
    private static final int PRODUCT_WEIGHT_NAME=2;
    public static int productId=10000;

    public static void main(String[] args) throws IOException {
        // preparing categories and sub-categories master data with code and desc
//        convert(CATEGORIES_FILE, CATEGORIES);
//        convert(SUB_CATEGORIES_FILE, SUB_CATEGORIES);

        System.out.println("desc to code conversion completed..");
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
             ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();

            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {

                String productName= row[4];
                String category =row[0];
                String subCategory =row[1];
                String brand =row[3];
                String size = row[10];
                String weightType =row[11];



                if(productMap.containsKey(productName)){
                    Product p = productMap.get(productName);

                     // check category
                        boolean catFound=false;
                        for(Category cat : p.getCategories()){
                            if(category.equals(cat.getCode())){
                                catFound=true;
                                break;
                            }
                        }
                    // check category
                    boolean subCatFound=false;
                    for(SubCategory subCat : p.getSubCategories()){
                        if(subCategory.equals(subCat.getCode())){
                            subCatFound=true;
                            break;
                        }
                    }
                    // check brand
                    boolean brandFound=false;
                    for(Brand brand1 : p.getBrands()){
                        if(brand.equals(brand1.getCode())){
                            brandFound=true;
                            break;
                        }
                    }

                    // if 3 found then its duplicate
                    if( (catFound && subCatFound && brandFound) && (!size.equalsIgnoreCase(p.getWeight()))){
                        System.out.println(productName + " -> "+ (productId+1));
                        productMap.put((productName+" : "+size + " "+weightType),getProductData(row,new Product(), PRODUCT_WEIGHT_NAME));

                    }else{
                        if(catFound){
                        }
                            p.getCategories().add(new Category(category, category));
                        if(subCatFound){
                            p.getSubCategories().add(new SubCategory(subCategory, subCategory));
                        }
                        if(brandFound){
                            p.getBrands().add(new Brand(brand, brand));
                        }
                        if (catFound || subCatFound || brandFound){
                            productMap.put(productName,p);
                        }
                    }

                }else{
                    productMap.put(productName,getProductData(row,new Product(),PRODUCT_NAME));
                }

            }

            System.out.println("---Unique : "+ productMap.size());
            System.out.println("---Duplicates : "+ duplicateProductMap.size());
        }
        // write to json file
          ConvertJavaToJson.convertUsingGson(new ArrayList(productMap.values()));

    }

    private static Product getProductData(String[] row, Product p, int productNameType){

        String productName= row[4];
        String category =row[0];
        String subCategory =row[1];
        String brand =row[3];
        String size = row[10];
        String weightType =row[11];

        productId++;
        p.setId(productId+"");

        if(productNameType == PRODUCT_NAME){
            p.setCode(row[4]);
        }else if(productNameType == PRODUCT_WEIGHT_NAME){
            System.out.println("-- weight Name : "+productId);
            p.setCode(productName+" : "+size + " "+weightType);
        }

        p.getCategories().add(new Category(category,category));
        p.getSubCategories().add(new SubCategory(subCategory,subCategory));
        p.setType(new Type(row[2],row[2]));
        p.getBrands().add(new Brand(brand,brand));
        p.setWeightType(weightType);
        p.setDesc(row[5]);
        p.setPrice(new Price(Double.parseDouble(row[6]),Double.parseDouble(row[6])));
        p.setTax(Double.parseDouble(row[7]));
        p.setImageName(row[8]);
        p.setStore(row[9]);
        p.setWeight(row[10]);
        p.setSpiceLevel(row[12]);
        p.setAiselNo(row[13]);
        p.setActive(true);


        return  p;
    }


    private static void convert(String fileName, String type) throws IOException {
        System.out.println("------------------------");
        // convert description to code like below
        // Body Wash, Soap & Hair Care -> bodyWash_Soap_HairCare
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVReader csvReader = new CSVReader(reader,'|');
        ) {

            String[] nextRecord;
            int count=0;
            while ((nextRecord = csvReader.readNext()) != null) {

                for(String line: nextRecord){
                    String output = line.substring(0, 1).toLowerCase() + line.substring(1);
                    output = output.replaceAll(" ", "");
                    output = output.replaceAll(",", "_");
                    output = output.replaceAll("&", "_");
                    if(type.equalsIgnoreCase(CATEGORIES)){
                        categoriesMap.put(line,output);
                    }
                    else if(type.equalsIgnoreCase(SUB_CATEGORIES)){
                        subCategoriesMap.put(line,output);
                    }

                }
            }
        }
    }

}
