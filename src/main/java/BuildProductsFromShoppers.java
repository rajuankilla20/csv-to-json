import model.gpod.ProductGpod;
import util.CustomProductsUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BuildProductsFromShoppers {


    public static void main(String[] args) throws IOException {
        System.out.println("Section products ");

        Set<ProductGpod> richonsondsProducts = new HashSet<>();
        CustomProductsUtil.buildProducts(richonsondsProducts);
        richonsondsProducts.forEach(System.out::println);
        System.out.println("---size "+ richonsondsProducts.size());
         // pid : 20107

        ConvertJavaToJson.createJsonFile(richonsondsProducts,"richardsons-form"); // Done
    }
}
