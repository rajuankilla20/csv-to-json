package util;

import com.opencsv.CSVReader;
import model.gpod.BrandGpod;
import model.gpod.CategoryGpod;
import model.gpod.ProductGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;

public class ProductUtil {

    public static ProductGpod buildProduct(String[] row ){

        ProductGpod p  = new ProductGpod();
//        0-"pid" - int
//        1-"aisle_no"- int
//        2-"title"
//        3-"main_image"
//        4-"short_name"
//        5-"slug"
//        6-"sku"
//        7-"bid" - int
//        8-"special_offers_meesage"
//        9-"highlight"
//        10-"body"
//        11-"cost" - float
//        12-"mrp" - float
//        13-"taxed"
//        14-"specification"
//        15-"parent_pid"
//        16-"status" -int
//        17-"created_at" - timestamp
//        18-"updated_at" - timestamp
//
        p.setId(Integer.parseInt(row[0])+""); //0-"pid"
        p.setAiselNo(Integer.parseInt(row[1])+""); //1-"aisle_no"
        p.setDesc(row[2]); // 2-"title"
        p.setDefaultImage(row[3]); // 3-"main_image"
        p.setImageName(row[3]); // 3-"main_image"
        p.setShortName(row[4]); // 4-"short_name"
        p.setCode(row[5]); // 5-"slug"
        p.setSku(row[6]); // 6-"sku"

//        p.getBrands().add(Integer.parseInt(row[6])); //7-"bid" - int




       return  null;//new ProductGpod(id,desc,code,imageName,isActive,createdTimestamp,updatedTimestamp);
    }
}
