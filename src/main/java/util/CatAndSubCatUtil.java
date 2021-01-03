package util;

import com.opencsv.CSVReader;
import model.Category;
import model.gpod.CategoryGpod;
import model.gpod.SubCategoryGpod;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CatAndSubCatUtil {


    public static void buildCategoriesAndSubcategory(Map<Integer,CategoryGpod> categoryGpodMap, Map<Integer,SubCategoryGpod> subCategoryGpodSet ) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(QueryConstants.CATEGORIES_CSV_FILE), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            Set<CategoryGpod> tempCategoryGpodList= new HashSet<>();
            String[] row;
            int count=1;
            while ((row = csvReader.readNext()) != null) {
                tempCategoryGpodList.add(buildCategoryGop(row));
            }

            Set<CategoryGpod> categoryGpodsSet = new HashSet<>();
            categoryGpodsSet.addAll(tempCategoryGpodList.stream().filter( categoryGpod -> categoryGpod.getProductCateogryId() ==0).collect(Collectors.toSet()));

            // cat map
            categoryGpodsSet.forEach(categoryGpod -> categoryGpodMap.put(categoryGpod.getId(),categoryGpod));


            buildSubcategory(categoryGpodMap,tempCategoryGpodList,subCategoryGpodSet);
        }

    }

    private static void buildSubcategory(Map<Integer,CategoryGpod> onlycategoryGpodList,Set<CategoryGpod> tempCategoryGpodList, Map<Integer,SubCategoryGpod> subCategoryGpodList) {

        tempCategoryGpodList.forEach(categoryGpod -> {
                    // p_cid = 0 is category, =1 is subcat
                   if(categoryGpod.getProductCateogryId() !=0){
                       CategoryGpod category = onlycategoryGpodList.values().stream().filter(category1 -> (category1.getId() == categoryGpod.getProductCateogryId())).findAny().orElse(null);
                       SubCategoryGpod subCategory = subCategoryGpodList.values().stream().filter(subCat -> subCat.getDesc().equalsIgnoreCase(categoryGpod.getDesc())).findAny().orElse(null);
                        if(null == subCategory){
                            subCategoryGpodList.put(categoryGpod.getId(), prepareSubCategoryObject(categoryGpod,category));
                        }else{
                            subCategory.getCategories().add(new Category(category.getCode(),category.getDesc()));
                            subCategoryGpodList.put(subCategory.getId(),subCategory);
                        }

                   }
        });
    }

    private static SubCategoryGpod prepareSubCategoryObject(CategoryGpod subCat,CategoryGpod cat) {
        SubCategoryGpod subCategoryGpod = new SubCategoryGpod();

        subCategoryGpod.setId(subCat.getId());
        subCategoryGpod.setActive(subCat.isActive());
        subCategoryGpod.setUpdatedTimestamp(subCat.getUpdatedTimestamp());
        subCategoryGpod.setCreatedTimestamp(subCat.getCreatedTimestamp());
        subCategoryGpod.setImageName(subCat.getImageName());
        subCategoryGpod.setDesc(subCat.getDesc());
        subCategoryGpod.setCode(subCat.getCode());
        subCategoryGpod.getCategories().add(new Category(cat.getCode(),cat.getDesc()));

        return  subCategoryGpod;
    }


    public static CategoryGpod buildCategoryGop(String[] row ){
        int id = Integer.parseInt(row[0]); // 0-cid
        String desc = row[1]; //1-title
        String code = row[2]; //2-slug
        String imageName = row[3]; // 3-image
        int prodCatId = Integer.parseInt(row[5]); // 5-p_cid
        boolean isActive = (Integer.parseInt(row[6]) == 1) ? true :  false ; //6 -status
        Date createdTimestamp = DateUtil.getDate(row[7]); // 7-created_at
        Date updatedTimestamp = DateUtil.getDate(row[7]); //8-updated_at

       return new CategoryGpod(id,desc,code,imageName,prodCatId,isActive,createdTimestamp,updatedTimestamp);
    }
}
