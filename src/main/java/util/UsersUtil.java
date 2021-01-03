package util;

import com.opencsv.CSVReader;
import model.gpod.BrandGpod;
import model.gpod.RoleUserGpod;
import model.gpod.RolesGpod;
import model.gpod.UserGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

public class UsersUtil {


    public static void buildUsers(Map<Integer, UserGpod> userGpodMap, Map<Integer, RoleUserGpod> roleUserGpodMap, Map<Integer,RolesGpod> rolesGpodMap) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.USERS_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                int userId = Integer.parseInt(row[0]);
                userGpodMap.put(userId, buildRoleGpod(row,roleUserGpodMap,rolesGpodMap));
            }

        }
    }


    public static UserGpod buildRoleGpod(String[] row ,Map<Integer, RoleUserGpod> roleUserGpodMap,Map<Integer,RolesGpod> rolesGpodMap){

        UserGpod u = new UserGpod();
        int userId =Integer.parseInt(row[0]);
        u.setId(userId); // 0-id
        u.setName(row[1]); //1-name
        u.setLastName(row[2]); //2-lname
        u.setEmail(row[3]); //3-lname
        u.setPhone(row[4]); //4-phone
        u.setUniversity(row[5]); //5-university
        u.setCampus(row[6]); //6-campus
        u.setMackId(row[7]); //7-mack_id
        u.setUserType(row[8]); //8-user_role , it should be user_type
        // user_role - i/p =uid, o/p=rid
        // role - i/p=rid, o/p=name
       RoleUserGpod  roleUserGpod =  roleUserGpodMap.get(userId);
       RolesGpod rolesGpod = rolesGpodMap.get(roleUserGpod.getRoleId());
        u.setUserRole(rolesGpod.getName());
        u.setSchoolYear(row[9]); //9-school_year
        u.setGraduationDate(row[10]);; //10-graduation_date, no calculation so keeping as string as few have Null values
        u.setEmpId(row[11]); //11-employee_id
        u.setLicense(row[12]); //12-license
        u.setLicenseType(row[13]); //13-license_type
        u.setLicenseState(row[14]); //14-license_state
        u.setVregistration(row[15]); //15-vregistration
        u.setLocationId(row[16]); //16-location_id
        u.setPassword(row[17]); //17-password
        u.setActive((Integer.parseInt(row[18]) == 1) ? true :  false ); //18-"status"
        u.setRememberToken(row[20]); //20-"remember_token"
        u.setApiToken(row[21]); //21-"api_token"
        u.setCreatedTimestamp(DateUtil.getDate(row[22])); // 22-created_at
        u.setUpdatedTimestamp(DateUtil.getDate(row[23])); //23-updated_at

       return u;
    }
}
