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
//        System.out.println("-----------Cat & Sub-Cats conversion done---------------");
          BrandsUtil.buildBrands(brandGpodMap); // done
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
//        System.out.println("-----------ProductImage  conversion done---------------");

        System.out.println("-----------User  conversion done---------------"+productMap.size());
        RolesUtil.buildRoles(rolesGpodMap);
//        ConvertJavaToJson.createJsonFile(rolesGpodMap.values(),"roles"); // Done

        System.out.println("-----------Roles  conversion done---------------");
        RolesUserUtil.buildRoleUser(roleUserGpodMap);

        System.out.println("-----------Role-User  conversion done---------------");
        UsersUtil.buildUsers(userGpodMap,roleUserGpodMap,rolesGpodMap);
//        ConvertJavaToJson.createJsonFile(userGpodMap.values(),"users"); // Done


        System.out.println("-----------wishlist  conversion done---------------");
        OrderStatusUtil.buildOrderStatus(orderStatusGpodMap);
//        ConvertJavaToJson.createJsonFile(orderStatusGpodMap.values(),"order-status"); // Done

        System.out.println("-----------orderstatus  conversion done---------------");
        OrderItemsUtil.buildOrderItems(orderItemsGpodMap);

        buildProductData();

        System.out.println("-----------Product  conversion done---------------"+productMap.size());
//          productMap.forEach((k,v) -> {
//            System.out.println(v);
//        });
//        ConvertJavaToJson.createJsonFile(productMap.values(),"products"); // Done
        OrderStatusChangeUtil.buildOrderStatusChange(orderStatusChangeGpodMap);
        System.out.println("-----------orderstatus change  conversion done---------------");
        OrdersUtil.buildOrderStatus(ordersGpodMap);
        System.out.println("-----------orderstatus change  conversion done---------------");



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
        FinalOrdersUtil.buildUserOrders(finalUserOrders,orderStatusGpodMap,orderStatusChangeGpodMap,ordersGpodMap,orderItemsGpodMap,productMap,userGpodMap);

//        ConvertJavaToJson.createJsonFile(finalUserOrders,"user-orders"); // Done
        System.out.println("-----------final userOrders");
//        finalUserOrders.forEach(System.out::print);

        System.out.println("-----------User  conversion done---------------");
        WishlistUtil.buildWishlist(wishlistGpodMap,productMap,userGpodMap);

        // NOTE : adding emailid instead of user id for user-favourites
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

    }


    private static void buildProductData( ) throws IOException {



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
                p.setId(productId+""); //0-"pid"
                if(row[1].equalsIgnoreCase("NULL")){
                    p.setAiselNo("N/A"); //1-"aisle_no"
                }else{
                    p.setAiselNo(row[1]); //1-"aisle_no"
                }
                p.setDesc(row[2]); // 2-"title"
                p.setDefaultImage(row[3]); // 3-"main_image"
                p.setImageName(row[3]); // 3-"main_image"
                p.setShortName(row[4]); // 4-"short_name"
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


}

