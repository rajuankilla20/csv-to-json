package util;

import com.opencsv.CSVReader;
import model.gpod.FavouritesGpod;
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


    public static void buildWishlist(Map<Integer, WishlistGpod> wishlistGpodMap, Map<Integer, ProductGpod> productMap, Map<Integer, UserGpod> userMap ) throws IOException {

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
                int userId = Integer.parseInt(row[2]); // 2-user_id - email
                int productId = Integer.parseInt(row[1]); // 1-product_id - few info

                if(wishlistGpodMap.containsKey(userId)){
                    WishlistGpod w = wishlistGpodMap.get(userId);
                    if(null!=productMap.get(productId)){
                        w.getFavourites().add(buildFavourites(row,productMap.get(productId)));
                        wishlistGpodMap.put(userId, w);
                    }
                }else{
                    if(null!=productMap.get(productId)){
                        WishlistGpod w =  new WishlistGpod();
                        int id = Integer.parseInt(row[0]); // 0-id
                        w.setUserId(userId+"");
                        w.getFavourites().add(buildFavourites(row,productMap.get(productId)));
                        wishlistGpodMap.put(userId, w);
                    }
                }
            }

        }
    }

    private static FavouritesGpod buildFavourites(String[] row,ProductGpod p) {
        FavouritesGpod f = new FavouritesGpod();
        f.setCode(p.getDesc());
        f.setId(p.getId()+"");
        f.setImage(p.getImageName());
        f.setPrice(p.getPrice());
        f.setWeight(p.getWeight());
        f.setWeightType(p.getWeightType());
        f.setActive(p.isActive());
        f.setCreatedTimestamp(DateUtil.getDate(row[3]));// 3-created_at
        f.setUpdatedTimestamp(DateUtil.getDate(row[4]));//4-updated_at
        return  f;
    }

}
