package sqljdbc;

import model.Category;
import model.gpod.BrandGpod;
import model.gpod.CategoryGpod;
import model.gpod.ProductCategoryGpod;
import model.gpod.SubCategoryGpod;
import org.apache.commons.collections.map.HashedMap;
import util.QueryConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * @author Crunchify.com
 * Simple Hello World MySQL Tutorial on how to make JDBC connection, Add and Retrieve Data by App Shah
 *
 */

public class MySqlConnection {
    Map<Integer, CategoryGpod> categoryGpodMap = new HashedMap();
    Map<String, SubCategoryGpod> subCategoryGpodMap = new HashedMap();
    Map<Integer, BrandGpod> brandsGpodMap = new HashedMap();
    Map<Integer, ProductCategoryGpod> productCategoryGpodMap = new HashedMap();

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;

    public static void main(String[] argv) {
            MySqlConnection mySqlConnection = new MySqlConnection();
        try {
            log("-------- Simple Crunchify Tutorial on how to make JDBC connection to MySQL DB locally on macOS ------------");
            mySqlConnection.makeJDBCConnection();
            mySqlConnection.getCategories();
            mySqlConnection.getAllSubCategories();
            mySqlConnection.getAllBrands();
            mySqlConnection.getAllProductsCategories();
            mySqlConnection.getAllProducts();


            preparedStatement.close();
            connection.close(); // connection close

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private  void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
          //  connection = DriverManager.getConnection("jdbc:mysql://grocerspod.com:3306/grocedw9_grocer", "grocedw9_grocer", "DeX4^9oU8B(z");
            connection = DriverManager.getConnection("jdbc:mysql://34.201.207.213:8888/merrimack", "root", "7rwoK6GhoYos");
            if (connection != null) {
                log("Connection Successful! Enjoy. Now it's time to push data");
            } else {
                log("Failed to make connection!");
            }
        } catch (SQLException e) {
            log("MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }



    }

    public void getCategories() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM categories where p_cid=0";

            preparedStatement = connection.prepareStatement(QueryConstants.GET_ALL_CATEGORIES);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cid");
                String desc = rs.getString("title");
                String code = rs.getString("slug");
                String imageName = rs.getString("image");

                boolean isActive = (rs.getInt("status") == 1) ? true :  false ;
                int prodCatId = Integer.parseInt("p_cid"); // 5-p_cid
                Date createdTimestamp = rs.getTimestamp("created_at");
                Date updatedTimestamp = rs.getTimestamp("updated_at");
                categoryGpodMap.put(id,new CategoryGpod(id,desc,code,imageName,prodCatId,isActive,createdTimestamp,updatedTimestamp));
//                System.out.format("%s, %s, %s, %s, %s, %s \n", id, title, slug, imageName ,created_at , updated_at);
            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }
        System.out.println("------------categories");
        categoryGpodMap.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    public void getAllBrands() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM brands";

            preparedStatement = connection.prepareStatement(QueryConstants.GET_ALL_BRANDS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("bid");
                String desc = rs.getString("title");
                String code = rs.getString("slug");
                String imageName = rs.getString("image");
                boolean isActive = (rs.getInt("status") == 1) ? true :  false ;
                Date createdTimestamp = rs.getTimestamp("created_at");
                Date updatedTimestamp = rs.getTimestamp("updated_at");
                brandsGpodMap.put(id,new BrandGpod(id,desc,code,imageName,isActive,createdTimestamp,updatedTimestamp));
//                System.out.format("%s, %s, %s, %s, %s, %s \n", id, title, slug, imageName ,created_at , updated_at);
            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }
        System.out.println("------------brands");
        brandsGpodMap.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    private  void getAllSubCategories() {

        try {

            preparedStatement = connection.prepareStatement(QueryConstants.GET_ALL_SUB_CATEGORIES);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cid");
                String desc = rs.getString("title");
                String code = rs.getString("slug");
                String imageName = rs.getString("image");
                int prod_cat_id = rs.getInt("p_cid");
                boolean isActive = (rs.getInt("status") == 1) ? true :  false ;
                Date createdTimestamp = rs.getTimestamp("created_at");
                Date updatedTimestamp = rs.getTimestamp("updated_at");

                CategoryGpod categoryGpod = categoryGpodMap.get(prod_cat_id);

                if(categoryGpod != null)
                {
                    if(subCategoryGpodMap.containsKey(desc)){
                        SubCategoryGpod model = subCategoryGpodMap.get(desc);
                        model.getCategories().add(new Category(categoryGpod.getCode(),categoryGpod.getDesc()));
                        subCategoryGpodMap.put(desc,model);
                    }else{
                        SubCategoryGpod subCategoryGpod = new SubCategoryGpod();
                        subCategoryGpod.getCategories().add(new Category(categoryGpod.getCode(),categoryGpod.getDesc()));
                        subCategoryGpod.setCode(code);
                        subCategoryGpod.setDesc(desc);
                        subCategoryGpod.setImageName(imageName);
                        subCategoryGpod.setActive(isActive);
                        subCategoryGpod.setCreatedTimestamp(createdTimestamp);
                        subCategoryGpod.setUpdatedTimestamp(updatedTimestamp);
                        subCategoryGpod.setId(id);
                        subCategoryGpodMap.put(desc,subCategoryGpod);
                    }
                }

            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }

        System.out.println("-----all sub-cats");

        subCategoryGpodMap.forEach((k, v) -> {
            System.out.println(v);
        });

    }

    public void getAllProductsCategories() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM products";

            preparedStatement = connection.prepareStatement(QueryConstants.GET_ALL_PRODUCT_CATEGORY);
            ResultSet rs = preparedStatement.executeQuery();



            while (rs.next()) {
                        int productId = rs.getInt("pid");
                        int categoryId = rs.getInt("cid");
                        productCategoryGpodMap.put(productId,new ProductCategoryGpod(productId,categoryId));
                    }


        } catch (

                SQLException e) {
            e.printStackTrace();
        }
        System.out.println("------------brands");
        brandsGpodMap.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    public void getAllProducts() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM products";

            preparedStatement = connection.prepareStatement(QueryConstants.GET_ALL_BRANDS);
            ResultSet rs = preparedStatement.executeQuery();



            while (rs.next()) {
                int id = rs.getInt("pid");
                String desc = rs.getString("title");
                String imageName = rs.getString("main_image");
                String shortName = rs.getString("short_name");
                String code = rs.getString("slug");
                int brandId = rs.getInt("bid");
                float cost = rs.getFloat("cost");
                float mrp = rs.getFloat("mrp");
                float tax = rs.getFloat("taxed");
                boolean isActive = (rs.getInt("status") == 1) ? true :  false ;
                Date createdTimestamp = rs.getTimestamp("created_at");
                Date updatedTimestamp = rs.getTimestamp("updated_at");

                brandsGpodMap.put(id,new BrandGpod(id,desc,code,imageName,isActive,createdTimestamp,updatedTimestamp));
//                System.out.format("%s, %s, %s, %s, %s, %s \n", id, title, slug, imageName ,created_at , updated_at);
            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }
        System.out.println("------------brands");
        brandsGpodMap.forEach((k, v) -> {
            System.out.println(v);
        });
    }


    // Simple log utility
    private static void log(String string) {
        System.out.println(string);

    }

}
