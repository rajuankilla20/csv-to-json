import com.opencsv.CSVReader;
import model.*;
import model.gpod.*;
import util.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class BuildMerrimackData {

    List<Product> productList = new ArrayList<>();

    //D:/projects/csv-json-proj/csv-to-json/src/main/resources/1K-Rec-all-cat-sub-cat-csv-V1.csv



    private static  Map<String, String> descToCodeMap = new HashMap<String, String>();
    private static Map<Integer, ProductGpod> productMap = new HashMap<>();

    public static Map<Integer,CategoryGpod> categoryGpodMap = new HashMap<>();
    public static Map<Integer,SubCategoryGpod> subCategoryGpodMap = new HashMap<>();
    public static Map<Integer,BrandGpod> brandGpodMap = new HashMap<>();
    public static Map<Integer,AttributeGpod> attributeGpodMap = new HashMap<>(); // atid ,25-type,26-store,27-weight,28-spice level
    public static Map<Integer,AttributeOptionsGpod> attributeOptionsGpodMap = new HashMap<>(); //atid,title(type & value)
    public static Map<Integer,Set<ProductAttributeOptionsGpod>> productAttributeOptionsGpoMap = new HashMap<>(); // key-> productId
    public static Map<Integer,Set<Integer>> productCategoryGpodMap = new HashMap<>();
    public static Map<Integer,Set<Integer>> productSubCategoryGpodMap = new HashMap<>();
    public static Set<ProductImageGpod> productImageGpodSet = new HashSet<>();
    public static Map<Integer,RolesGpod> rolesGpodMap = new HashMap<>();
    public static Map<Integer,RoleUserGpod> roleUserGpodMap = new HashMap<>();
    public static Map<Integer,UserGpod> userGpodMap = new HashMap<>();
    public static Map<Integer,WishlistGpod> wishlistGpodMap = new HashMap<>();
    public static Set<WishlistGpod> userFavourites = new HashSet<>();
    public static Map<Integer,OrderStatusGpod> orderStatusGpodMap = new HashMap<>();
    public static Map<Integer,Set<OrderItemsGpod>> orderItemsGpodMap = new HashMap<>();
    public static Map<Integer,Set<OrderStatusChangeGpod>> orderStatusChangeGpodMap = new HashMap<>();
    public static Map<Integer,OrdersGpod> ordersGpodMap = new HashMap<>();
    public static Map<Integer,Set<PosOrdersGpod>> posOrdersGpodMap = new HashMap<>();
    public static List<FinalUserOrders>  finalUserOrders = new ArrayList<>();

    public static List<UserOrders>  finalOrders = new ArrayList<>();
    public static Set<String> favMissingProductList = new HashSet<>(Arrays.asList("8651","13240","9065","10657","10535","10658","13004","13125","13005","6900","13003","13008","13006","9631","9752","13253","9754","7577","5829","13136","4731","8416","4613","14109","10544","9641","9646","13100","5718","12812","10516","5719","10518","10517","12816","9638","13222","14317","10510","12811","5714","5715","12930","7472","12949","13597","5726","7486","10295","10294","5739","6707","10297","5611","4402","9538","5614","6706","13452","5630","10503","10625","10507","10509","10508","5624","6714","9202","8237","4552","6731","7148","6729","5632","5633","6727","13546","6741","6733","5523","10285","10287","13085","14295","5781","13089","8378","5784","7721","4454","9460","5775","5776","10376","5778","10375","4569","12676","9232","5791","5794","9115","4465","5786","4577","4457","7725","6758","14502","15480","4230","5563","9368","13186","8271","6766","12773","4107","8707","4109","10358","14282","8964","14288","10361","14286","7074","9130","5566","10362","15461","6790","13162","6793","14012","13165","13166","15463","9269","14010","13043","9022","10339","12872","10451","6788","5698","12873","6787","12870","14014","12750","10331","14015","12876","10455","10576","10457","12753","14018","4381","13171","13056","4388","14022","9390","10349","10348","12762","4379","10464","9702","13058","10584","14268","10466","10587","10468","12765","13265","8631","13141","14110","7544","8632","13142","8194","5480","12738","13026","8509","13029","6581","9299","5496","9733","14002","14241","13153","10328","12741","14006","4710","12860","14004","10564","10322","10567","10325","4714","10566"));
    private static Set<ProductGpod> missFavProductsShantanuList = new HashSet<>();



//    public static Map<Integer,ProductImageGpod> productImageGpodMap = new HashMap<>();
//    public static Map<Integer,AttributeGpod> attributeGpodMap = new HashMap<>(); // atid ,25-type,26-store,27-weight,28-spice level
//    public static Map<Integer,AttributeOptionsGpod> attributeOptionsGpodMap = new HashMap<>(); //atid,title(type & value)
//    public static Map<Integer,ProductAttributeOptionsGpod> productAttributeOptionsGpoMap = new HashMap<>(); // pid - ao_id -> atid,title (25-type, 27-weight), atid - 25 (at-table)

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
        // preparing categories with status==0 in categories.csv
         CatAndSubCatUtil.buildCategoriesAndSubcategory(categoryGpodMap,subCategoryGpodMap);
//         ConvertJavaToJson.createJsonFile(categoryGpodMap.values(),"categories"); // Done
//         ConvertJavaToJson.createJsonFile(subCategoryGpodMap.values(),"sub-categories"); // Done
        System.out.println("-----------Category :"+categoryGpodMap.values().size());
        System.out.println("-----------Sub-Cats :"+subCategoryGpodMap.values().size());
       BrandsUtil.buildBrands(brandGpodMap); // done
        System.out.println("-----------Brands :"+brandGpodMap.values().size());
//          ConvertJavaToJson.createJsonFile(brandGpodMap.values(),"brands"); // Done
//          System.out.println("-----------Brands conversion done---------------");
          AttributesUtil.buildAttributes(attributeGpodMap);
//          System.out.println("-----------Attributes conversion done---------------");
          AttributeOptionsUtil.buildAttributeOptions(attributeOptionsGpodMap);
//          System.out.println("-----------AttributesOptions  conversion done---------------");
          ProductAttributeOptionsUtil.buildProductAttributeOptions(productAttributeOptionsGpoMap); //key-productId
//          System.out.println("-----------AttributesOptions  conversion done---------------");
           ProductCategoryUtil.buildProductCategory(productCategoryGpodMap,productSubCategoryGpodMap, categoryGpodMap.values().stream().map(CategoryGpod::getId).collect(Collectors.toSet()));
//          System.out.println("-----------ProductCategory  conversion done---------------");
          ProductImageUtil.buildProductImage(productImageGpodSet);
        System.out.println("-----------Product- Images :"+productImageGpodSet.size());
//        System.out.println("-----------ProductImage  conversion done---------------");

        System.out.println("-----------User  conversion done---------------"+productMap.size());
        RolesUtil.buildRoles(rolesGpodMap);
        System.out.println("-----------Roles :"+rolesGpodMap.values().size());
//        ConvertJavaToJson.createJsonFile(rolesGpodMap.values(),"roles"); // Done

        System.out.println("-----------Roles  conversion done---------------");
        RolesUserUtil.buildRoleUser(roleUserGpodMap);

        System.out.println("-----------Role-User  conversion done---------------");
        System.out.println("--------------EMAIL START ----------------------");
        UsersUtil.buildUsers(userGpodMap,roleUserGpodMap,rolesGpodMap);
        System.out.println("-----------Users :"+userGpodMap.values().size());

        userGpodMap.entrySet().stream()                // ...
                .forEach(e -> System.out.println("Email : " + e.getValue().getEmail()));
        System.out.println("--------------EMAIL END ----------------------");


//        ConvertJavaToJson.createJsonFile(userGpodMap.values(),"users"); // Done


       /* System.out.println("-----------wishlist  conversion done---------------");
        OrderStatusUtil.buildOrderStatus(orderStatusGpodMap);
        //ConvertJavaToJson.createJsonFile(orderStatusGpodMap.values(),"order-status"); // Done

        System.out.println("-----------orderstatus  conversion done---------------");
        OrderItemsUtil.buildOrderItems(orderItemsGpodMap);

        buildProductData();*/
       // System.out.println("-----------Products :"+productMap.values().size());
//        System.out.println("-----------Product  conversion done---------------"+productMap.size());
//          productMap.forEach((k,v) -> {
//            System.out.println(v);
//        });

        /* Getting missing favourite products from existing users as we are retaining only ordered items and we might miss
        * user favourite orders, so after filtering data from retain orders below orders are missing and getting those products
        * from here
        * */
/*
        System.out.println("Missing prodcuts size : "+ favMissingProductList.size());
        favMissingProductList.forEach(pid -> {
            if(productMap.containsKey(Integer.parseInt(pid))){
                missFavProductsShantanuList.add(productMap.get(Integer.parseInt(pid)));
            }else{
                System.out.println("---pid not found "+pid);
            }

        });
*/

//        System.out.println("Missing prodcuts after getting size : "+ missFavProductsShantanuList.size());
//        ConvertJavaToJson.createJsonFile(missFavProductsShantanuList,"missing-favourites-shantanu-products");


        // NOTE For ajay confirmation validated below
//        identifyDuplicateProductCodes(productMap);
        /*
        ConvertJavaToJson.createJsonFile(productMap.values(),"products"); // Done
        OrderStatusChangeUtil.buildOrderStatusChange(orderStatusChangeGpodMap);
//        System.out.println("-----------orderstatus change  conversion done---------------");
        OrdersUtil.buildOrders(ordersGpodMap);
        System.out.println("-----------Total orders : "+ordersGpodMap.size());

        Set<Integer> invalidOrders = new HashSet<>();
        AtomicInteger count= new AtomicInteger();
        orderStatusChangeGpodMap.forEach((k,v) -> {
            OrderStatusChangeGpod gpod = v.stream().filter(change -> change.getOsId() == 7).findAny().orElse(null);
            if(gpod == null){
//                System.out.println(" Order Id "+ k +" : Issue not Completed "+ count.getAndIncrement()) ;
                invalidOrders.add(k);
            }
        });

       // PosOrdersUtil.buildPosOrders(posOrdersGpodMap);
        *//*
            This is user-orders, where it will have order with respect to eah user.
         *//*
        FinalOrdersUtil.buildUserOrders(finalUserOrders,orderStatusGpodMap,orderStatusChangeGpodMap,ordersGpodMap,orderItemsGpodMap,productMap,userGpodMap);
        System.out.println("-----------UserOrders :"+finalUserOrders.size());

        *//*
            This is orders, where it will have all orders for entire app
         *//*
        OrdersUtil.buildFinalOrders(finalUserOrders,finalOrders);
        ConvertJavaToJson.createJsonFile(finalOrders,"orders");

//        ConvertJavaToJson.createJsonFile(finalUserOrders,"user-orders"); // Done
//        System.out.println("-----------final userOrders");
//        finalUserOrders.forEach(System.out::print);

        WishlistUtil.buildWishlist(wishlistGpodMap,productMap,userGpodMap);
//        System.out.println("-----------UserFavourites :"+wishlistGpodMap.values().size());
        // NOTE : adding email id instead of user id for user-favourites
        wishlistGpodMap.values().forEach(wishlistGpod -> {
//            wishlistGpod.setUserId(userGpodMap.get(Integer.parseInt(wishlistGpod.getUserId())).getEmail());
            if(null != userGpodMap.get(Integer.parseInt(wishlistGpod.getUserId()))){
                String email = userGpodMap.get(Integer.parseInt(wishlistGpod.getUserId())).getEmail();
                wishlistGpod.setUserId(email);
                userFavourites.add(wishlistGpod);
            }else{
                System.out.println("Userid not found : "+ wishlistGpod.getUserId());
            }
        });
        //ConvertJavaToJson.createJsonFile(userFavourites,"user-favorites"); // Done
            // Note: creating CSV for shantanu
//        JavaToExcelCSVConverter.writeDataLineByLine(productMap,QueryConstants.ALL_PRODUCTS_CSV_FILE);
//          JavaToExcelCSVConverter.writeAllOrderedProducts(finalUserOrders,productMap,QueryConstants.ORDERED_PRODUCTS_CSV_FILE);

//    printFiles();
*/
    }

    private static void identifyDuplicateProductCodes(Map<Integer, ProductGpod> productMap) {

        Map<String, ProductGpod> duplicateCodes = new HashMap<>();

        productMap.values().forEach(productGpod -> {

            if(duplicateCodes.containsKey(productGpod.getCode())){

                System.out.println("Exist pid :" + duplicateCodes.get(productGpod.getCode()).getId() + "cur pid : "+productGpod.getId());
            }else{
                duplicateCodes.put(productGpod.getCode(),productGpod);
            }
        });
    }

    private static void printFiles() throws IOException {
        Set<String> files = getExistingImages();

        Set<String> found = new HashSet<>();
        Set<String> notFound = new HashSet<>();
        productMap.values().forEach(productGpod -> {
            if(files.contains(productGpod.getDefaultImage())){
                System.out.println("Found");
                found.add(productGpod.getId()+ ", "+productGpod.getDesc() + ","+ productGpod.getDefaultImage());
            }else{
                notFound.add(productGpod.getId()+ ", "+productGpod.getDesc() + ","+ productGpod.getDefaultImage());
            }
        });
        ConvertJavaToJson.createJsonFile(found,"found");
        ConvertJavaToJson.createJsonFile(notFound,"not-found");
    }

    private static void buildProductData( ) throws IOException {


        Set<String> existingImages = getExistingImages();


        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.PRODUCT_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
             ) {
            // Reading Records One by One in a String array  to avoid header
            csvReader.readNext();

            String[] row;
            while ((row = csvReader.readNext()) != null) {

                ProductGpod p  = new ProductGpod();

                int productId =Integer.parseInt(row[0]);
                p.setId(productId); //0-"pid"
                if(row[1].equalsIgnoreCase("NULL")){
                    p.setAiselNo("N/A"); //1-"aisle_no"
                }else{
                    p.setAiselNo(row[1]); //1-"aisle_no"
                }
                p.setDesc(row[2]); // 2-"title"

                // setting NO Image.jpg if no image found in existing product images
                if(existingImages.contains(row[3])){
                    p.setDefaultImage(row[3]); // 3-"main_image"
                    p.setImageName(row[3]); // 3-"main_image"
                }else{
                    p.setDefaultImage("No Image.jpg"); // 3-"main_image"
                    p.setImageName("No Image.jpg"); // 3-"main_image"
                }


                p.getTags().add(row[2]); // used for algolia search in future we can add more search key words for that product
                p.setCode(row[5]); // 5-"slug"
                p.setSku(row[6]); // 6-"sku"

                // 7-"bid" - brandId
                BrandGpod brandGpod = brandGpodMap.get(Integer.parseInt(row[7]));
                p.getBrands().add(new Brand(brandGpod.getCode(), brandGpod.getDesc()));
                // 8-"special_offers_meesage"
                // 9-"highlight"
                // 10-"body"
                // 11-"cost" - float
                // 12-"mrp" - float
                 p.setPrice(new Price(Double.parseDouble(row[11]), Double.parseDouble(row[11])));
                 p.setTax(Double.parseDouble(row[13])); // 13-"taxed"
                // 14-"specification"
                //  15-"parent_pid"
                p.setActive((Integer.parseInt(row[16]) == 1) ? true :  false ); // 16-"status" -int
                p.setCreatedTimestamp(DateUtil.getDate(row[17]));  //  17-"created_at" - timestamp
                p.setUpdatedTimestamp(DateUtil.getDate(row[18])); // 18-"updated_at" - timestamp

//                System.out.println("for orderid: "+ productId);
//                // set quantity from order items
//                p.setQuantity(productOrderItemMap.get(productId).getQuantity());

                // for Home pages sections
                p.setNewlyAdded(false); // default to all products
                p.setDealsEnabled(false); // default to all products
                // categorires
                 Set<Integer> catList= productCategoryGpodMap.get(productId);
                 catList.forEach(catId -> {
                     CategoryGpod categoryGpod = categoryGpodMap.get(catId);
                     p.getCategories().add(new Category(categoryGpod.getCode(), categoryGpod.getDesc()));
                 });

                // sub-cats
                Set<Integer> subCatList= productSubCategoryGpodMap.get(productId);
                subCatList.forEach(catId -> {
                    SubCategoryGpod subCategoryGpod = subCategoryGpodMap.get(catId);
                    p.getSubCategories().add(new SubCategory(subCategoryGpod.getCode(), subCategoryGpod.getDesc()));
                });

                // types & weight
                // step.1) product_att_options -> i/p = pid, o/p=ao_id, atid =>
                // step.2) att_option - i/p = ao_id, o/p= atid, value( types,weights)
                // step.3) attr -> i/p = atid, o/p= title (25-type,26-store (N/A),27-weight,28-Spice level(N/A))
                Set<ProductAttributeOptionsGpod> productAttributeOptionsGpod=productAttributeOptionsGpoMap.get(productId);


                productAttributeOptionsGpod.forEach(productAttributeOptionsGpod1 -> {
                    AttributeOptionsGpod attributeOptionsGpod = attributeOptionsGpodMap.get(productAttributeOptionsGpod1.getAoId());
                    // 25 for type
                    if(attributeOptionsGpod.getAtid() == 25){
                        p.setType(new Type(attributeOptionsGpod.getDesc(),attributeOptionsGpod.getDesc()));
                    }
                    // 27 for weight
                    if(attributeOptionsGpod.getAtid() == 27){
                        p.setWeight(attributeOptionsGpod.getDesc());
                        p.setWeightType(attributeOptionsGpod.getDesc());
                    }
                });

                productMap.put(productId,p);
            }

            System.out.println("-----------Unique : "+ productMap.size());
        }
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

