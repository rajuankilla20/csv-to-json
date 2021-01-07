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

}

