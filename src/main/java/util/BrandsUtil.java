package util;

import com.opencsv.CSVReader;
import model.Category;
import model.gpod.BrandGpod;
import model.gpod.CategoryGpod;
import model.gpod.SubCategoryGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BrandsUtil {


    public static void buildBrands(Map<Integer,BrandGpod> brandGpodSet) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.BRANDS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                BrandGpod brandGpod = buildBrandGpod(row);
                brandGpodSet.put(brandGpod.getId(), brandGpod);
            }

        }
    }


    public static BrandGpod buildBrandGpod(String[] row ){
        int id = Integer.parseInt(row[0]); // 0-bid
        String desc = row[1]; //1-title
        String code = row[2]; //2-slug
        String imageName = row[3]; // 3-image
        boolean isActive = (Integer.parseInt(row[4]) == 1) ? true :  false ; //6 -status
        Date createdTimestamp = DateUtil.getDate(row[5]); // 7-created_at
        Date updatedTimestamp = DateUtil.getDate(row[6]); //8-updated_at
        //int id, String desc, String code, String imageName, boolean isActive, Date createdTimestamp, Date updatedTimestamp
       return new BrandGpod(id,desc,code,imageName,isActive,createdTimestamp,updatedTimestamp);
    }
}
