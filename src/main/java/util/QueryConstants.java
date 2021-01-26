package util;

public class QueryConstants {

    public static final String GET_ALL_CATEGORIES = "SELECT * FROM categories where p_cid=0";
    public static final String GET_ALL_SUB_CATEGORIES = "SELECT * FROM categories where p_cid!=0";
    public static final String GET_ALL_BRANDS = "SELECT * FROM brands";
    public static final String GET_ALL_PRODUCT_CATEGORY = "SELECT * FROM product_category";

    // FILE NAMES
    public static final String CATEGORIES_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/categories.csv";
    public static final String BRANDS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/brands.csv";
    public static final String ATTRIBUTES_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/attributes.csv";
    public static final String ATTRIBUTES_OPTIONS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/attribute_options.csv";
    public static final String PRODUCT_ATTRIBUTES_OPTIONS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/product_attribute_options.csv";
    public static final String PRODUCT_CATEGORY_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/product_category.csv";
    public static final String PRODUCT_IMAGE_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/product_images.csv";
    public static final String PRODUCT_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/products.csv";
    public static final String ROLES_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/roles.csv";
    public static final String ROLE_USER_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/role_user.csv";
    public static final String USERS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/users.csv";
    public static final String WISHLIST_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/wishlists.csv";
    public static final String ORDER_STATUS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/order_status.csv";
    public static final String ORDER_ITEMS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/order_items.csv";
    public static final String ORDER_STATUS_CHANGE_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/order_status_changes.csv";
    public static final String ORDER_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/orders.csv";
    public static final String POS_ORDERS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/merrimack/pos_orders.csv";

    public static final String ALL_PRODUCTS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/excel/all_products.csv";
    public static final String ORDERED_PRODUCTS_CSV_FILE = "D:/projects/csv-json-proj/csv-to-json/src/main/resources/excel/ordered_products.csv";

    // Custome products uploaded directly from Gp temam
    public static final String RICHARTSON_PRODUCTS_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/section-products-input/richardsons-farm.csv";;
    public static final String CAT_SUBCAT_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/Catagory-Sub-Catagory.csv";;
    public static final String RETAIN_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/Products_Retain_Csv.csv";;
    public static final String UPLOAD_PROD_WITH_IDS_SAME_SIZE_UOW_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/Prod_upload_with_id_same_size_uow_csv.csv";
    public static final String UPLOAD_PROD_WITHOUT_IDS_SAME_SIZE_UOW_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/Prod_upload_without_id_same_size_uow_csv.csv";
    public static final String RICHARDSONSFARM_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/richardsons-form_csv.csv";
    public static final String PROTEIN_BARS_DRINKS_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/protein-bars-drinks_csv.csv";
    public static final String GAME_MOVIE_NIGHTS_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/game-night-movie-nights_csv.csv";
    public static final String CANDIES_JERKIES_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/candies-jerkies_csv.csv";
    public static final String CHIPS_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/chips_csv.csv";
    public static final String SODA_AND_DRINKS_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/soda-drinks_csv.csv";
    public static final String PRODUCE_YOUR_CHOICE_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/produce-your-choice_csv.csv";
    public static final String FREEZING_FAV_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/freezing-favourites_csv.csv";
    public static final String MEAT_YOUR_CHOICE_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/meat-of-your-choice_csv.csv";
    public static final String DORM_NEEDS_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/dorm-needs_csv.csv";
    public static final String BREAKFAST_ESSEN_PROD_SHANTANU_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/shantanu-input/breakfast-essentials_csv.csv";

    // Users pwd reset data
    public static final String USERS_PWD_RESET_VALID_CSV_FILE =  "D:/projects/csv-json-proj/csv-to-json/src/main/resources/users/valid-customers.csv";








}

