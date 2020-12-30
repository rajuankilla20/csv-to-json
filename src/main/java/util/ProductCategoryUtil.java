package util;

import com.opencsv.CSVReader;
import model.gpod.BrandGpod;
import model.gpod.ProductCategoryGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProductCategoryUtil {


    public static void buildProductCategory(Map<Integer, Set<Integer>> prodCatsMap,Map<Integer, Set<Integer>> prodSubCatsMap,Set<Integer> catSet) throws IOException {
//        Map<Integer, Set<Integer>> prodCatsMap = new HashMap<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.PRODUCT_CATEGORY_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                ProductCategoryGpod  gpod = prepareProductCategory(row);

                // if true means these are categories [1,31,38,48,23,7,16,11] others are sub-cats
                if(catSet.contains(gpod.getCategoryId())){
                    if(prodCatsMap.containsKey(gpod.getProductId())){
                        Set<Integer> categorySet = prodCatsMap.get(gpod.getProductId());
                        categorySet.add(gpod.getCategoryId());
                        prodCatsMap.put(gpod.getProductId(),categorySet);
                    }else{
                        Set<Integer> categorySet= new HashSet<Integer>();
                        categorySet.add(gpod.getCategoryId());
                        prodCatsMap.put(gpod.getProductId(),categorySet);
                    }
                }else{ // all sub-cats
                    if(prodSubCatsMap.containsKey(gpod.getProductId())){
                        Set<Integer> categorySet = prodSubCatsMap.get(gpod.getProductId());
                        categorySet.add(gpod.getCategoryId());
                        prodSubCatsMap.put(gpod.getProductId(),categorySet);
                    }else{
                        Set<Integer> categorySet= new HashSet<Integer>();
                        categorySet.add(gpod.getCategoryId());
                        prodSubCatsMap.put(gpod.getProductId(),categorySet);
                    }
                }

            }

        }
        System.out.println("Test-");
    }


    public static ProductCategoryGpod prepareProductCategory(String[] row ){
        int pid = Integer.parseInt(row[1]); // 1-pid
        int cid = Integer.parseInt(row[2]); // 2-cid
        //int id, String desc, String code, String imageName, boolean isActive, Date createdTimestamp, Date updatedTimestamp
       return new ProductCategoryGpod(pid,cid);
    }
}
