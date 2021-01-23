package util;

import com.opencsv.CSVReader;
import model.Category;
import model.gpod.SubCategoryGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;

public class CatSubCatShantanuListUtil {


        public static Integer catIdSeq = 1;
        public static void buildSubCats(Set<SubCategoryGpod> subCategorySet) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.CAT_SUBCAT_SHANTANU_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header uncomment below line
            // csvReader.readNext();
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                prepareSubcat(row, subCategorySet);
            }

        }
    }


    public static void prepareSubcat(String[] row, Set<SubCategoryGpod> subCategorySet) {

        String category = row[0];
      ;
        for (int i=1; i<row.length; i++) {
            if(!row[i].equalsIgnoreCase("")){
                SubCategoryGpod subCategoryGpod = new SubCategoryGpod();
                subCategoryGpod.setId(catIdSeq);
                catIdSeq++;
                subCategoryGpod.setActive(true);
                subCategoryGpod.setUpdatedTimestamp(new Date());
                subCategoryGpod.setCreatedTimestamp(new Date());
                subCategoryGpod.setImageName("1598818834.jpg");
                subCategoryGpod.setDesc(row[i]);
                subCategoryGpod.setCode(row[i]);
                subCategoryGpod.getCategories().add(new Category(category,category));
                subCategorySet.add(subCategoryGpod);
            }
        }

    }
}
