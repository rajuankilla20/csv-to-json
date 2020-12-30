package util;

import com.opencsv.CSVReader;
import model.gpod.ProductCategoryGpod;
import model.gpod.ProductImageGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class ProductImageUtil {


    public static void buildProductImage(Set<ProductImageGpod> brandGpodSet) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.PRODUCT_IMAGE_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                brandGpodSet.add(prepareProductImage(row));
            }

        }
    }


    public static ProductImageGpod prepareProductImage(String[] row ){
        int pid = Integer.parseInt(row[1]); // 1-pid
        String imageName = row[2]; // 2-image
        //int id, String desc, String code, String imageName, boolean isActive, Date createdTimestamp, Date updatedTimestamp
       return new ProductImageGpod(pid,imageName);
    }
}
