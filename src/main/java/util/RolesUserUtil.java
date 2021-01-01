package util;

import com.opencsv.CSVReader;
import model.gpod.RolesGpod;
import model.gpod.RoleUserGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

public class RolesUserUtil {


    public static void buildRoleUser(Map<Integer, RoleUserGpod> rolesUserGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.ROLE_USER_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int userId = Integer.parseInt(row[2]);
                rolesUserGpodMap.put(userId, buildRoleUserGpod(row));
            }

        }
    }


    public static RoleUserGpod buildRoleUserGpod(String[] row ){
        int id = Integer.parseInt(row[0]); // 0-id
        int roleId = Integer.parseInt(row[1]); // 1-role_id
        int userId = Integer.parseInt(row[2]); // 2-user_id

        // NOTE: both dates are null so using todays date
        Date createdTimestamp =  new Date();//DateUtil.getDate(row[3]); // 3-created_at
        Date updatedTimestamp = new Date(); //DateUtil.getDate(row[4]); //4-updated_at
        //int id, int roleId, int userId, Date createdTimestamp, Date updatedTimestamp
       return new RoleUserGpod(id,roleId,userId,createdTimestamp,updatedTimestamp);
    }
}
