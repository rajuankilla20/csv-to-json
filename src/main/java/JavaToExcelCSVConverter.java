import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;
import model.CategoryModel;
import model.Product;
import model.SubCategoryModel;
import model.gpod.FinalUserOrders;
import model.gpod.ProductGpod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaToExcelCSVConverter {

    public static void writeAllProducts(Map<Integer, ProductGpod> productMap, String filePath)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "Product ID","Category","Sub Category","Type","Brand","Product Name","Product Description","Price","Tax","Store","Size","UOM","Image","Spice Level","Aisle No." };
            writer.writeNext(header);

            productMap.values().forEach(p -> {
                String[] row = new String[15];
                buildCSVRow(p, row);
                System.out.println("---");
                writer.writeNext(row);
            });



            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeAllOrderedProducts(List<FinalUserOrders>  finalUserOrders,Map<Integer, ProductGpod> productMap, String filePath)
    {
        // first create file object for file placed at location
        // specified by filepath

        Map<Integer, ProductGpod> orderedProducts = new HashMap<>();

        finalUserOrders.forEach(finalUserOrders1 -> {
            finalUserOrders1.getUserOrders().forEach(userOrders -> {

                userOrders.getItems().forEach(item -> {
                    if(!orderedProducts.containsKey(item.getId())){
                        orderedProducts.put(item.getId(), productMap.get(item.getId()));
                    }
                });
            });
        });


        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "Product ID","Category","Sub Category","Type","Brand","Product Name","Product Description","Price","Tax","Store","Size","UOM","Image","Spice Level","Aisle No." };
            writer.writeNext(header);

            orderedProducts.values().forEach(p -> {
                String[] row = new String[15];
                buildCSVRow(p, row);
                System.out.println("---");
                writer.writeNext(row);
            });



            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void buildCSVRow(ProductGpod p, String[] row) {
        row[0]= p.getId()+"";
        row[1]= p.getCategories().get(0).getDesc();
        row[2]= p.getSubCategories().get(0).getDesc();
        row[3]= p.getType().getDesc();
        row[4]= p.getBrands().get(0).getDesc();
        row[5]= p.getDesc();
        row[6]= p.getDesc();
        row[7]= p.getPrice().getBasePrice()+"";
        row[8]= p.getTax()+"";
        row[9]= "";
        row[10]= p.getWeight();
        row[11]= p.getWeight();
        row[12]= p.getDefaultImage();
        row[13]= p.getSpiceLevel();
        row[14]= p.getAiselNo();
    }


}
/*
per - middle
lb at - middle

boxes
box
ct
count
fl oz
oz container
pint container
pint
kg
container
oz bunch
oz bag
oz
lb bag
lb bunch
bunch
bag(s)
lb
per lb
sq ft
gal
L
pack
g
packs
pacs
ml
lbs
each
unit
basket
head
pound
quart
 */