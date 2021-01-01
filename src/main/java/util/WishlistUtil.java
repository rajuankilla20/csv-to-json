package util;

import com.opencsv.CSVReader;
import model.gpod.ProductGpod;
import model.gpod.UserGpod;
import model.gpod.WishlistGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

public class WishlistUtil {


    public static void buildBrands(Map<Integer, WishlistGpod> wishlistGpodMap,Map<Integer, ProductGpod> productMap,Map<Integer, UserGpod> userMap ) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.WISHLIST_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                WishlistGpod wishlistGpod = buildwishlistGpod(row,productMap,userMap);
                wishlistGpodMap.put(1, wishlistGpod);
            }

        }
    }


    public static WishlistGpod buildwishlistGpod(String[] row, Map<Integer, ProductGpod> productMap, Map<Integer, UserGpod> userMap  ){
        WishlistGpod w = new WishlistGpod();


        int id = Integer.parseInt(row[0]); // 0-id
        int productId = Integer.parseInt(row[1]); // 1-product_id
        int userId = Integer.parseInt(row[2]); // 2-user_id
        Date createdTimestamp = DateUtil.getDate(row[3]); // 3-created_at
        Date updatedTimestamp = DateUtil.getDate(row[4]); //4-updated_at
        //int id, String desc, String code, String imageName, boolean isActive, Date createdTimestamp, Date updatedTimestamp

       return w;
    }
}
