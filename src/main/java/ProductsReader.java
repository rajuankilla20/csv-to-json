import com.opencsv.CSVReader;
import model.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class ProductsReader {

    List<Product> productList = new ArrayList<>();

    //D:/projects/csv-json-proj/csv-to-json/src/main/resources/1K-Rec-all-cat-sub-cat-csv-V1.csv
    private static final String PRODUCTS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/1K-Rec-all-cat-sub-cat-csv-V1.csv";
    private static final String DEAL_Buy_1_GET_1_50_PER_OFF_CSV = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/buy1get1-50per-off.csv";
    private static final String DEAL_Buy_1_GET_1_FREE_CSV = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/buy1get1free.csv";
    private static final String DEAL_Buy_2_GET_1_CSV = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/buy2get1free.csv";
    private static final String NEWLY_ADDED_PRODUCTS = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/newly_added_products.csv";


    private static  Map<String, String> descToCodeMap = new HashMap<String, String>();
    private static Map<String, Product> productMap = new HashMap<>();
    private static Map<String, Product> duplicateProductMap = new HashMap<>();


    private static final int PRODUCT_NAME=1;
    private static final int PRODUCT_WEIGHT_NAME=2;
    public static int productId=10000;
    public static int categoryIdSequence=1000;
    public static int subCategoryIdSequence=2000;

    private static Map<String, String> categoriesMap = new HashMap<>();
    private static Map<String, Set<String>> subCategoriesMap = new HashMap<>();

//    public  static List<Categories> categories = new ArrayList<>();
//    public static List<SubCategory> subCategoryList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        // preparing categories and sub-categories master data with code and desc

        buildProductData(PRODUCTS_CSV_FILE,false,"", false);
        buildProductData(DEAL_Buy_1_GET_1_50_PER_OFF_CSV,true,"Buy 1 get 1 50% off", false);
        buildProductData(DEAL_Buy_1_GET_1_FREE_CSV,true,"Buy 1 get 1 free", false);
        buildProductData(DEAL_Buy_2_GET_1_CSV,true,"Buy 2 get 1 free", false);
        buildProductData(DEAL_Buy_2_GET_1_CSV,true,"Buy 2 get 1 free", false);
        buildProductData(NEWLY_ADDED_PRODUCTS,false,"", true);


        // write products  to json file
          ConvertJavaToJson.convertProductsToJson(new ArrayList(productMap.values()));


        // Write categories to Json file
        // ConvertJavaToJson.convertCatToSubCatToJson(buildCategories(categoriesMap), buildSubCat(subCategoriesMap));


    }

    private static void buildProductData(String filePath, boolean isDealsEnabled, String dealName, boolean isNewlyAdded) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.ISO_8859_1);
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


                // prepare categories and sub category map
                buildCatAndSubCat(category,subCategory);

                if(productMap.containsKey(productName)){
                    Product p = productMap.get(productName);

                     // check category
                        boolean catFound=false;
                        for(Category cat : p.getCategories()){
                            if(category.equals(cat.getDesc())){
                                catFound=true;
                                break;
                            }
                        }
                    // check category
                    boolean subCatFound=false;
                    for(SubCategory subCat : p.getSubCategories()){
                        if(subCategory.equals(subCat.getDesc())){
                            subCatFound=true;
                            break;
                        }
                    }
                    // check brand
                    boolean brandFound=false;
                    for(Brand brand1 : p.getBrands()){
                        if(brand.equals(brand1.getDesc())){
                            brandFound=true;
                            break;
                        }
                    }

                    // if 3 found then and its having diff size then its new product
                    if( (catFound && subCatFound && brandFound) && (!size.equalsIgnoreCase(p.getWeight()))){
                        productMap.put((productName+" : "+size + " "+weightType),getProductData(row,new Product(), PRODUCT_WEIGHT_NAME,isDealsEnabled, dealName,isNewlyAdded));

                    }else{
                        if(catFound){
                        // p.getCategories().add(new Category(convertDescToCode(category), category));
                            p.getCategories().add(new Category(category, category));
                        }

                        if(subCatFound){
                            //p.getSubCategories().add(new SubCategory(convertDescToCode(subCategory), subCategory));
                            p.getSubCategories().add(new SubCategory(subCategory, subCategory));
                        }
                        if(brandFound){
                            //p.getBrands().add(new Brand(convertDescToCode(brand), brand));
                              p.getBrands().add(new Brand(brand, brand));
                        }
                        if (catFound || subCatFound || brandFound){
                            productMap.put(productName,p);
                        }
                    }

                }else{
                    productMap.put(productName,getProductData(row,new Product(),PRODUCT_NAME, isDealsEnabled, dealName,isNewlyAdded));
                }
            }

            System.out.println("---Unique : "+ productMap.size());
            System.out.println("---Duplicates : "+ duplicateProductMap.size());
        }
    }

    private static List<SubCategoryModel> buildSubCat(Map<String, Set<String>> subCategoriesMap) {
        List<SubCategoryModel> subCategoryModelList = new ArrayList<>();

        subCategoriesMap.forEach((k, v) -> {
            SubCategoryModel subCategoryModel= new SubCategoryModel();
            subCategoryModel.setId((subCategoryIdSequence++)+"");
            subCategoryModel.setDesc(k);
            //subCategoryModel.setCode(convertDescToCode(k));
            subCategoryModel.setCode(k);

            v.forEach(category -> {
            //  subCategoryModel.getCategories().add(new Category(convertDescToCode(category), category));
                subCategoryModel.getCategories().add(new Category(category, category));

            });

            subCategoryModelList.add(subCategoryModel);

        });

        return  subCategoryModelList;

    }

    private static List<CategoryModel> buildCategories(Map<String, String> categoriesMap) {

        List<CategoryModel> categoriesList = new ArrayList<>();
            categoriesMap.forEach((k, v) -> categoriesList.add(new CategoryModel((categoryIdSequence++)+"",k,v)));
        return categoriesList;
    }

    private static void buildCatAndSubCat(String category, String subCategory) {

        if(!categoriesMap.containsKey(category)){
            //categoriesMap.put(category, convertDescToCode(category));
            categoriesMap.put(category, category);
        }
        if(subCategoriesMap.containsKey(subCategory)){
             subCategoriesMap.get(subCategory).add(subCategory);
        }else{
            subCategoriesMap.put(subCategory, new HashSet<String>(){{
                add(category);
            }} );
        }

    }

    private static Product getProductData(String[] row, Product p, int productNameType, boolean isDealsEnabled, String dealName, boolean isNewlyAdded){

        String productName= row[4];
        String category =row[0];
        String subCategory =row[1];
        String brand =row[3];
        String size = row[10];
        String weightType =row[11];

        productId++;
        p.setId(productId+"");

        if(productNameType == PRODUCT_NAME){
            //p.setCode(convertDescToCode(row[4]));
            p.setCode(row[4]);
        }else if(productNameType == PRODUCT_WEIGHT_NAME){
//            System.out.println("-- weight Name : "+productId);
            //p.setCode(convertDescToCode(productName+" : "+size + " "+weightType));
            p.setCode(productName+" : "+size + " "+weightType);
        }

        // setting deals to condition the data, but in real this this will happen from console app.
        if(isDealsEnabled){
            p.setDealsEnabled(true);
            p.setDeal(new Deal(dealName,dealName));
        }else{
            p.setDealsEnabled(false);
        }

        // p.getCategories().add(new Category(convertDescToCode(category),category));
        p.getCategories().add(new Category(category,category));
        //p.getSubCategories().add(new SubCategory(convertDescToCode(subCategory),subCategory));
        p.getSubCategories().add(new SubCategory(subCategory,subCategory));
        p.setType(new Type(row[2],row[2]));
        // p.getBrands().add(new Brand(convertDescToCode(brand),brand));
        p.getBrands().add(new Brand(brand,brand));
        p.setWeightType(weightType);

        //  setting product name as description as desc column is empty
        p.setDesc(productName);

        p.setPrice(new Price(Double.parseDouble(row[6]),Double.parseDouble(row[6])));
        p.setTax(Double.parseDouble(row[7]));
        p.setImageName(row[8]);
        p.setStore(row[9]);
        p.setWeight(row[10]);
        p.setSpiceLevel(row[12]);
        p.setAiselNo(row[13]);
        p.setActive(true);

        // Newly added flag
        p.setNewlyAdded( isNewlyAdded? true: false);

        return  p;
    }


    /**
     * Convert desc to code by removing space and ',' with '-' and '&' with '-'
     * @param desc
     * @return
     * @throws IOException
     */
    private  static  String convertDescToCode(String desc) {

        String output="";
        if(descToCodeMap.containsKey(desc)){
            output = descToCodeMap.get(desc);
        }else{
            output = desc.substring(0, 1).toLowerCase() + desc.substring(1);
            output = output.replaceAll(" ", "");
            output = output.replaceAll(",", "_");
            output = output.replaceAll("&", "_");
            descToCodeMap.put(desc,output);
        }

        return output;
     }


}
