package util;

import com.opencsv.CSVReader;
import model.gpod.BrandGpod;
import model.gpod.RolesGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

public class RolesUtil {


    public static void buildBrands(Map<Integer, RolesGpod> rolesGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ROLES_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int roleId = Integer.parseInt(row[0]);
                rolesGpodMap.put(roleId, buildRoleGpod(row));
            }

        }
    }


    public static RolesGpod buildRoleGpod(String[] row ){
        int id = Integer.parseInt(row[0]); // 0-id
        String name = row[1]; //1-name
        Date createdTimestamp = DateUtil.getDate(row[2]); // 2-created_at
        Date updatedTimestamp = DateUtil.getDate(row[3]); //3-updated_at
        //int id, String name, Date createdTimestamp, Date updatedTimestamp, boolean isActive
       return new RolesGpod(id,name,createdTimestamp,updatedTimestamp,true);
    }
}
