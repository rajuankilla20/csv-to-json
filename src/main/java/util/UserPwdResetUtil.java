package util;

import com.opencsv.CSVReader;
import model.UsersPwdResetDto;
import model.gpod.BrandGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;

public class UserPwdResetUtil {


    public static void buildUsers(Set<UsersPwdResetDto> pwdResetList) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.USERS_PWD_RESET_VALID_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                pwdResetList.add(prepareUser(row));
            }

        }
    }


    public static UsersPwdResetDto prepareUser(String[] row ){
        UsersPwdResetDto dto = new UsersPwdResetDto();

        dto.setId(row[0]);
        dto.setName(row[1]);
        dto.setLname(row[2]);
        dto.setEmail(row[3]);
        dto.setPhone(row[4]);

        String phone = row[4];

        if (phone.length() > 4)
        {
            dto.setPwd(row[2]+phone.substring(phone.length() - 4));
        }
        else
        {
            System.out.println(("------ phonumber < 4"+ row[3]));
        }

       return dto;
    }
}
