package util;

import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.opencsv.CSVReader;
import converters.ConvertJavaToJsonShatanu;
import model.*;
import model.gpod.BrandGpod;
import model.gpod.ProductGpod;
import model.gpod.SubCategoryGpod;
import model.json.BrandsJson;
import model.json.CategoryJson;
import model.json.SubCategoryJson;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WeeklyProdUploadUtil {

    public static final String BRANDS_JSON = "D:\\projects\\csv-json-proj\\csv-to-json\\src\\main\\resources\\weekly-uploaded-products-input\\production-brands.json";
    public static final String CATEGORIES_JSON = "D:\\projects\\csv-json-proj\\csv-to-json\\src\\main\\resources\\weekly-uploaded-products-input\\production-categories.json";
    public static final String SUB_CATEGORIES_JSON = "D:\\projects\\csv-json-proj\\csv-to-json\\src\\main\\resources\\weekly-uploaded-products-input\\production-sub-categories.json";

    public static Set<String> prodCatList = new HashSet<>();
    public static Set<String> prodBrandsList = new HashSet<>();
    public static Set<SubCategory> prodSubCatList = new HashSet<>();

    public static Set<BrandsJson> brandsSet = new HashSet<>();
    public static Set<CategoryJson> categoriesSet = new HashSet<>();
    public static Set<SubCategoryJson> subCategoriesSet = new HashSet<>();

    public static Set<CategoryJson> newCategoriesSet = new HashSet<>();
    public static Set<SubCategoryGpod> newSubCategoriesSet = new HashSet<>();
    public static Set<BrandGpod> newBrandsSet = new HashSet<>();

    public static int categorySeqId = 13;
    public static int subCategorySeqId = 72;
    public static int brandsSeqId = 3848;


    //    public static Set<String> categoriesMasterList = new HashSet<>(Arrays.asList("Chips, Cookies & Snacks","Beverages & Juices","Pasta & Sauces","Condiments & Dressings","Cooking Needs","Frozen Food","Fresh Produce","Breakfast & Dairy","Laundry & Paper Goods","Kitchen & Cleaning","Meat & Seafood","Personal Care","Richardson's Farm Ice Cream"));
//    public static Set<String> subCategoriesMasterList = new HashSet<>(Arrays.asList("Chips & Fruit Snacks","Cookies & Crackers","Candy & Chocolates","Jerkies","Nuts, Seeds & Dried Fruit","Cocoa & Drink Mixes","Tea, Coffee, Milk & Coconut Water","Water","Energy & Sports Drinks","Ginger Ale & Ginger Beer","Juices & Refrigerated Drinks","Soft Drinks & Seltzers","Ice Pops","Raw Pasta","Instant Pasta","Pasta Sauce","Gluten Free Pasta","Marinades, Ketchup & Sauces","Salad Dressings & Toppings","Honey, Syrup & Nectars","Pickled Goods & Olives","Preserved Dips & Spreads","Fresh Dips & Tapenades","Baking & Cooking","Canned Food","Rice & Grains","Spices & Seasonings","Oils & Vinegars","Frozen Dinners & Entrees","Frozen Pasta","Frozen Pizza","Frozen Produce","Ice Cream & Ice","Frozen Breakfast","Frozen Fruit & Juice","Frozen Dessert","Fresh Vegetables","Fresh Herbs","Fresh Fruits","Fresh Organic Vegetables","Fresh Organic Herbs","Fresh Organic Fruits","Breads & Rolls","Cereal","Dairy & Eggs","Tea & Coffee","Granola & Oats","Bars & Pastries","Pancake & Waffle Mix","Paper Goods","Laundry","Air Fresheners & Candles","Cleaning Products","Dish Detergents","Food Storage & Kitchen Supplies","Trash Bags & Liners","Meat & Seafood Counter","Packaged Meat & Seafood","Hot Dogs, Bacon & Sausage","Lunch Meat","Canned Meat & Seafood","Frozen Meat & Seafood","Body Wash, Soap & Hair Care","Feminine Care","Vitamins & Proteins","First Aid & Healthcare","Personal Needs","Ice Cream Toppings","Cups, Cones & Bowls","Ice Cream","Frozen Yogurt","Sherbet & Sorbet"));
//    public static Set<String> favProductList = new HashSet<>(Arrays.asList("4971","8096","10657","13926","10658","3872","3873","6900","3633","3634","3876","3877","3635","3636","3650","3893","3651","10426","5829","3641","4973","4731","3643","4734","5824","4736","3647","5825","3661","4992","6927","12812","12816","4742","3656","3657","12811","4747","3658","6925","15095","6939","3665","4513","3439","5619","6949","6707","3435","3434","5611","6946","5614","6706","15076","6960","5630","3453","3451","10625","3444","4532","5624","6714","7803","608","4552","6731","4309","6729","3456","612","5632","5633","3697","6965","617","618","6727","6741","15291","620","621","4312","6733","4317","10251","3484","12674","10253","4566","6503","4569","13767","10257","14856","10256","6508","12676","6507","10016","10258","5430","6522","13539","400","402","3487","6997","4577","5425","5667","6758","5429","5681","4110","7864","10239","10238","13747","13748","14837","411","3499","6766","4587","5435","4107","8707","10476","4109","4120","4363","4121","6542","8964","7630","9811","7633","10240","6543","14607","10008","422","7865","5204","6779","4116","9802","9807","5207","5208","4119","9806","10247","6790","6551","6793","6552","8973","5466","12878","12872","10451","6788","5698","12873","6787","5216","4127","12870","9813","6305","13960","12876","10455","10212","10457","10214","4381","7897","8983","4388","7896","10220","4379","207","10464","10466","5229","10468","8751","5483","5002","5486","7421","6576","5480","13705","213","8989","7898","5237","219","7658","8988","5239","8509","6581","7433","5496","7432","6103","13714","13715","13957","223","7425","12860","13713","7429","13952","13953","13481","8776","4176","6113","13485","8777","13240","13482","6598","235","236","238","13004","13005","13489","8767","13003","6349","13008","13006","5030","4183","9631","13253","6366","5035","5277","8301","5037","4180","4182","13499","8779","6118","14109","9641","9887","13462","9646","5289","14550","491","496","5038","13466","9638","13467","13222","13464","14317","13468","14558","7472","5054","5056","9891","5291","5049","9408","9889","13476","9422","7486","9420","13683","13684","7010","8102","7013","7255","6168","13452","8106","8346","282","284","285","286","7249","13453","8112","9202","8110","7023","13660","10150","8114","8115","7269","7262","7020","7261","13428","10156","13420","8108","13424","14997","13425","7274","8121","9211","5099","8364","6187","9699","9215","14520","13432","13679","13435","13678","15021","7285","13085","15025","13089","15266","15023","8378","15022","9460","3911","15273","9232","7294","15038","3921","8396","15480","8394","8395","15249","15005","3931","15252","15014","7074","15258","3701","3945","15461","15221","15463","9269","13043","8170","7081","9022","8172","3715","3719","3710","3714","13293","9034","9035","13056","9038","9032","9031","5904","3960","4810","13058","3722","3724","13265","3980","14110","8194","13026","3731","3975","13029","14360","9299","15210","4833","15218","15217","3747","3506","9067","9068","9061","9065","12958","10535","4608","12956","13803","4840","3995","3996","13801","12954","4845","4846","3530","9074","12967","10548","3521","13818","12960","4610","4853","4854","12964","4613","13811","5704","4857","12963","10544","4872","5718","10516","5719","3535","3534","10518","10517","3533","9080","3531","10510","5714","5715","4868","12930","9096","7909","3546","12949","4873","5966","6813","5726","15185","3560","15180","5739","4402","4644","15197","15198","5994","3573","7929","10503","5508","10507","3566","10509","10508","7924","5761","15166","15165","3581","5519","5995","5512","7934","15169","6844","7933","6605","6847","5516","6849","5759","6848","6863","3590","12902","3588","3586","5523","507","6870","5781","6872","4210","5784","7721","4454","13406","13648","13407","3599","4202","5775","5776","10376","5778","10375","4206","6869","6868","13647","13402","13645","5791","6882","5794","13650","4465","13659","5786","4213","9902","10143","13653","10142","13654","4457","7725","10144","9906","7729","14502","13413","7728","6890","6892","4230","6652","5563","6893","5321","6896","6654","4234","12773","14952","7733","6889","7977","6888","10358","14954","5570","6421","12780","6420","6423","10361","6422","10128","13638","304","10121","5566","13874","10362","6657","5569","6418","12786","6419","10126","5580","5100","9943","4012","5102","4014","4498","9941","550","10339","8604","6667","9935","8605","12750","10331","9939","10576","12753","8606","9937","5594","5110","4021","5353","9951","5114","9952","10349","10348","10106","321","13619","12762","9946","4015","5346","9702","9944","329","9945","10100","10584","10587","10103","5109","9948","9949","12765","4032","5122","6453","8631","5125","7544","8632","12738","14916","574","13824","575","14914","576","6449","6207","12976","14912","13820","4284","6462","4044","9733","8403","4280","581","582","100","343","586","10328","588","5126","107","12741","6459","10564","7308","6219","10322","10567","10325","12984","10566","8651","6232","10095","4056","14695","10096","4290","350","351","13125","7318","14697","9752","7334","6487","9754","7577","4069","9990","365","125","13136","5149","9989","8416","6251","10072","13100","7346","6490","370","4070","374","139","9759","14675","14678","6021","9771","5177","7355","6266","7358","5179","380","9770","10089","13597","14689","14205","45","9782","47","8455","10295","10294","5180","5183","396","154","10297","6028","9779","9538","14899","56","13572","6049","7379","14660","6283","13575","62","63","9322","6295","68","6058","7389","8237","6057","13540","14871","13782","7148","10030","6292","6291","7383","6294","6293","13308","10035","14630","13300","13546","78","13792","10041","9330","10285","13795","10287","83","14295","15146","9106","15145","9104","9105","98","9114","9354","15150","9115","7187","9366","7188","9368","13186","9127","7183","8271","4908","15125","7199","14282","14288","14286","9130","14492","14493","13162","14012","13165","13166","14010","8292","8295","14014","15346","4920","15345","14015","4922","14018","8066","13171","14022","9390","3603","4938","4930","4931","14268","13141","13142","4941","15328","14002","14486","14241","13394","15330","13153","4958","4959","14006","4710","14004","14488","4953","4954","4714","15339","15338"));
//    public static Set<String> brandsMasterList = new HashSet<>(Arrays.asList("Charleston","Gordon's","Oscar Mayer","Vermont Bread","Authenic","Success","A1","Mounds","Mrs.Paul's","Fiber One","Barbaras","Boston Market","Lundberg Family Farms","Jose Ole","Musselman's","Dubble Bubbles","Karma","Ball Park","kitchen of love Cucina & Amore","Wiley Wallaby","Seapoint Farms","Mama Marys","Dannon","Hershey's","Pede Brothers","Bridgford","Barber Foods","Briannas","Hollywood","Manischewitz","Betty Crocker","Fairlife","Welch's","Hero","Explore Cusine","Caramel Creams","Cholula","Walden farms","P.F.Chang's","Vlasic","Wrigley's","Kid Cuisine","Dai Day","G Hughes","Tiger","Conte's","Crosse & BlackWell","Digiorno","Gunters","J.J. Nissen","Pompeian","Straight Up Tea","Home Style","Saffron Road","Amy's","Marconi","Against The Grain Gourmet","Braswell's","Yasou","Trimino","Tropical","Quest","Don Pepimo","Celeste","La Valle","Sable and Rosenfeld","Sunbelt Bakery","Cento","Loacker","Sugardale","John McCann's","Endangered Species","Kodaik Cakes","Pam","Heath","Mrs. Richardson's","Mt. Olive","PB2","Caprisun","Langers","Casa Visco","Southern Comfort","Blake's","Skinny girl","Viet Huong","Ferrero Rocher","Jenni-O","Unreal","Banza","Nature's Own","Colman's","Benissima","Daiya","Smart Ones","Dragonfly","Jet puffed","Raisinets","B&G","Toffifay","Orbit","Annie Chuns","Almond joy","B&M","Bar S","Deutschamcher","CoraBella","Near East","Kitchen & Love","Victorina","De Wafelbakkers","Goodbelly","Green Valley","Grey Poupon","Lean Cuisine","Sandwich Bros","Cool Whip","Pirro's","The Ginger People","Wow Butter","Stuffed Foods","Celentano","Capatriti","Wood Stocks","Half Baked","Furlani","Minute maid","California Olive Ranch","French's","Stouffer's","Kitchens Of India","Bonne Maman","L & A","Think!","Vermont Maid","Really Raw","Cary's","Sky Lark","Amore","Grando's","Sweet Earth","Stove Top","Organic Supwefoods","Pop Secret","Mee Tu","Southwestern Veggie","Giuliano","Lilly B's","Lympiana","CALIFIA","Eckrich","Annie's","Blue Ribbon","Post","Hormel","Tresca","Crisco","Stonyfield","Apple & Eve","AriZona","Freschetta","Chef Gusto","Minute Maid","Tony's","Gillian's","Life Cuisine","Guzzler","Bove's","Juicy Juice","Kikkoman","Tic Tac","Albanese","Swanson","International Collection","Noosa","Kabuto","HP","Country Kitchen","Don Lee Farms","Chalk Market & Label Set","Hatfield","Waterhill","Olive Garden","Smithfield","De Cecco","Jones Dairy Farm","Turkey Hill","Kahiki","Jelly Knife","Joyva","Frank's","Gulf Pacific","Poppy's","Hood","Hebrew National","Mister Mustard","So Be Water","GrapeOla","Joyce Chen","Pasta Roni","Goobers","Pampeano","Bubba Burger","Mother's","Victoria","Pepperidge Farm","Bar Harbor","Organic Ville","Pennsylvania Dutch","Monari Federzoni","Panda","Bookbinder's","Gulden's","Italica","Campbells","Nips","Lily's","Virginia Brand","Lactaid","Sunsweet","LouAna","Gummi Factory","Rhodes","Peppermint Cobalt","Sara Lee","Jimmy Dean","Bragg","Denture ice","Pastabilities","San Remo","Grandma's","Uncle Matt's","Thai Kitchen","Blue Diamond","R.W. Knudsen","StarBucks","Mrs Fanning's","Felix","Beyond Meat","River","Kite hill","La Tourangelle","JimmyDean","TAI & PEI","Fun Delina","Kellogg's","Totino's","Biotta","La Spagnola","Banquet","Chung's","GoGo Squeez","St. Dalfour","Tessera","Cains","YoCrunch","Canyon Bakehouse","KC Masterpiece","Drew's","Teas Tea Organic","Truwhip","Pacific","Smash","Morning Stars Farms","Tropicana","Soup Singles","Home Run Inn","Maille","Virtuoso","Ancient Harvest","Good Food Made","Darrell Sea","Lucini","Nutiva","Eden","Cape Code Cafe","Kool-Aid","Rubinstein's","Danimals","Mrs. Butter Worth's","Uncle Sam","Emperor","Ronzoni","Sun Luck","ALEIAs","Giosanmi Rama","Screamin' Sicilian","Incogmeato","Rao's","Heinz","Perdue","Alfresco","Organic Baby Food","Sparta","Dicrinson's","Krinos","Mrs Cubbison's","Carolina","Lipton","Vitatops","Applegate","Reese's","Botticelli","Forager","Northland","Mayer Bros","Cavendish Farms","Feel Good Foods","Tinkyada","Green valley","Levant","Santa Cruz","Jiffy","Destination","DeIORIO'S","Gaspars","Log Cabin","Thai Kictchen","Modenaceti","Familia","Gefen","Chobani","Paesana","Levant ","Breakstone's","Premier Protien","Buitoni","Holland House","Chosen Foods","Evergreen Leaves Brand","Dynasty","LLL S No Style","Cream of Wheat","Supper Pretzel","Dromedary","Mancini","Mott's","Outsiders Pizza Company","Sweet Baby Ray's","Kayem","Gold Seasons","Honeycup","Weetabix","Pierre Drive Thru","Red's","Yo Crunch","Wisconsin's Finest","inglehoffer","Carnation","Quattro Formaggio","Sure Jell","Del monte","Ken's Steak House","Made Good","Air Heads","Francesco Rinaldi","Leidys","Krusteaz","ReaLemon","Robert  Rothschid","Ah-So","McCann's","Friends","International Delight","Ray's","Orville Redenbacher's","Emeril's","Uncle Ben's","Karo","Mystic Pizza","Van De Kamp's","Wickles","Siggi's","Mariokart","Market Basket","Martin's","Bacardi Mixers","A Taste Of Thai","Cap'n Crunch's","Richard's","Alssi","Handover","Birch Benders","Miracle Whip","Crazy Richardy's","Wee Bee Honey","Tyling","Gold Peak Tea","Werther's","Bell & Evans","Barer's Joy","Forno De Minas","Goya","Once Up on Farm","Pop Tarts","Aunt Jemima","Claeys","Icelandic","James Killer & Son","Contadina","Green Leaf Brand","Tofutti","Assi","Hot Tamales","Nature Valley","Prego","Mama Rosie's","Tamari","McCormick","Pine Cone","Fisherboy","Sticky","Farm Valley","Angy's","Jordans","Filippo Berio","Silver Floss","RX","Fontanini","Quaker","Evol","Ocean Spray","Cole's","Silk","Taza","Biazoo","Dave's Killer Bread","Benihana","Buddy Fruits","Snapple","Kraft","Golden","Katz","Lea & Perrins","Thomas","Cascadian Farm","El Monterey","World Harbors","Hillshire Farm","Two Good","Wild Mike's","Zeppy","Maypo","North Country","TGI Fridays","Bush's","Cherribundi","Rustic Crust","Michelina's","Malt O Meal","Simply","Carmela","Nellie's","Deming's","Crofter's","Quality Farms","Hint","Body Armor","Inglehoffer","Quorn","Dreamfields","Neuro Sonic","Woodstock","Kitkat","Crosby's","Lawry's","Udi's","Powerade","Richarson's Farm","Koffee Kup Bakery","Boboli","Chocolove","MilDer","Lindt","Bombay Market","V8","Thin 'n Trim","Keebler","Manzola","Ellio's","Mon Ami","Smucker's","Green Giant","Hawaiian Punch","Hi-C","Mappleglazed","Ratio Kito","SeaPak","Stubb's","Rips","Russell Stover","Red Baron","Marukan","Bibigo","Michael Angelo's","Kadoya","JHL","Honest","Vigo","Fage","Knorr","Hot Pockets","Golden Curry","Fantini","Homestyle","Billybee","Maple Grove Farms","John Morrell","Barney","Colonna","Madhava","Nature's Path","Lucio","White Castle","Woeber's","Devour","Grandmother's","Bulletproof","Dutch Colony","Pure Protein","Field Roast ","Spearmint Rain","Campbell's","Trimona","Mezzetta","Wicked Toisted","Armour","Hoilday","Reese","Jolly Rancher","Sambal Oelex","Pagoda","Super Food","Yummy","Laforestiere","Plant Made","Purity Organic","Vitamin 1","Black Lable","Hodgson Mill","Coconut Secret","Riesa","Atkins","Rothbury Farms","Johnsonville","Rice Roni","Romanoff","Hunts","La Fe","Barilla","Columela","Gulf Wax","Natalie's","Enjoy Life","Carando","La Choy","Floridas Natural","Hidden Valley","Classico","Ghirardelli","Kosciusko","Newman's Own","Fanny ","Newmen's Own","Nellie & Joe's","Birds Eye","Underwood","Mike and ike","Alpen","Pillars","Cracker Barrel","Pulmuone","Kashi","Body Fortress","House of Pasta","Saucy Susar","Premium Gold","Lindsay","Justin's","Lender's","Teras","Gerardo's Trattoria Amalfi","Murry's","Pickapeppa","Butterball","Hungry-Man","Pure Farmland","Wild Friends","Alessi","Dole","London Pub","Zatarains","Clif","La Yogurt","Geisha","Nakano","Howard's","Pearls","Clio","Hellmann's","Spectrum","Nature Nates","Cabot","Lee Kum Kee","Santorina","Colman","Bark Thins","Breath Savers","DAVIO'S","Dum.Dums","Ragu","Fast Bites","Happy Kid","Tina's","Healthy Ones","Muir Glen","Chef Boyardee","Dr.Praeger's","Pastene","NewYork Bakery","Cream of Rice","Jolly Time","Sun Butter","Three Bakers","When Pig's Fly","Louisiana","Olivari","Coconut Aminos","Colavita","Sell's","Bertolli","Vitamin Water","Yoohoo","Allegro","Cardini's","Cow Tales","Panera Bread","Sushi Chef","20 Quarter Pound","Hi-CHew","Andrew & Everett","Good Food Made Simple","Van's","Asian Fusion","The Alpha","Yoplait","Butcher Block Sauces","Brown Cow","Rosetto","Activia","Bear Naked","Nathan's","Prince","Godshalls","Trinidad Country Style","Pure Leaf","Gatorade","Kind","Seeds of Change","3 Musketeers","Chelsea","Peloponnese","Wei Chuan","American Flatbread","Sander's","Bumble Bee","Black Forest","Hi-Chew","Bubs Naturals","Bob's Red Mill","Wholesome","Caulipower","Healthy Choice","Walden Farms","Buddig","Arnold","Bull's-Eye","Carrington Frams","Joy","Minute Rice","RedHot","Tabasco","Pillsbury","Kinnikinnick","Bubble gum","Old Neighborhood","Organic Valley","Divine","Marie Callender's","Gardein","Nantucket Nectars","Friendship","Mrs.T's","Del Monte","STOK","Pomi","House Of Tsang","Oikos","Brekki","Mc Cocktail","NewBridge","Fruits of the Nile","Soy Yay","Papa Gino's Pizzeria","Bai","Mazola","Vermont Village","Bell's","Nature's Earthly Choice","Nut Butter Rx","Wonder Bread","Gorton's","Roland","Christe's","Maranatha","Coleman","Wish Bone","Cucina and Amore","Huy Fong","Manwich","Rice Select","Mama Mancini's","Peanut Butter & co","Purely Elizabeth","Farm Rich","General Mills","Sonoma Flatbreads","Tripple Leaf Brand"));


    public static int productCounter = 20000;

    public static void buildProducts(String fileName, Set<ProductGpod> productsSet, boolean sizeMixed, int productIdSeq, boolean productIdExist) throws IOException {

       // setWeeklyProductInventory(weeklyProductInventory1);


        loadMasterData(brandsSet, categoriesSet, subCategoriesSet);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.ISO_8859_1);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            Set<String> existingImages = null;//getExistingImages();

            // Reading Records One by One in a String array
            // to avoid header
            csvReader.readNext();
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                productsSet.add(prepareProduct(row, sizeMixed, productIdSeq++, productIdExist));
            }
        }

        // check if any new cat, sub-cat & brands found

        printNewCatSubCatAndBrands();

        /* NOTE enable if you want to print the data in excel format by writing again same data into
            comma seperated csv and save the file as csv
        */
// JavaToExcelCSVConverter.writeAllNoImageProducts(directProducts,"D:\\projects\\csv-json-proj\\csv-to-json\\src\\main\\resources\\shantanu-output\\AllPoducts_shantanu.csv");

    }

    private static void printNewCatSubCatAndBrands() {
        if(newCategoriesSet.size()>0){
            System.out.println("---found new categorires");
        }

        if(newSubCategoriesSet.size()>0){
            System.out.println("---found new sub categories");
        }

        if(newBrandsSet.size()>0){
            System.out.println("---found new brands");
        }

        ConvertJavaToJsonShatanu.createJsonFile(newCategoriesSet,"new-categories"); // Done
        ConvertJavaToJsonShatanu.createJsonFile(newSubCategoriesSet,"new-sub-categories"); // Done
        ConvertJavaToJsonShatanu.createJsonFile(newBrandsSet,"new-brands"); // Done
    }


    private static void loadMasterData(Set<BrandsJson> brandsSet, Set<CategoryJson> categoriesSet, Set<SubCategoryJson> subCategoriesSet) {


        //     load brands
        ConvertJsonToJavaUtil.convertJsonBrandsToJava(BRANDS_JSON, brandsSet);
        ConvertJsonToJavaUtil.convertJsonCategoriesToJava(CATEGORIES_JSON, categoriesSet);
        ConvertJsonToJavaUtil.convertJsonSubCategoriesToJava(SUB_CATEGORIES_JSON, subCategoriesSet);

        // prepare categories list
        categoriesSet.forEach(categoryJson -> prodCatList.add(categoryJson.getDesc()));
        // SubCategory(subCategory, category)

        subCategoriesSet.forEach(subCategoryJson -> prodSubCatList.add(new SubCategory(subCategoryJson.getDesc(), subCategoryJson.getCategories().get(0).getDesc())));
        brandsSet.forEach(brandsJson -> prodBrandsList.add(brandsJson.getDesc()));

        System.out.println("------");
    }


    public static ProductGpod prepareProduct(String[] row,  boolean sizeMixed, int productIdSeq, boolean productIdExist) {
        //        0-Product ID
        //        1-Category
        //        2-Sub Category
        //        3-Type
        //        4-Brand
        //        5-Product Name
        //        6-UPC Code
        //        7-Product Description
        //        8-Price
        //        9-Tax
        //        10-Store
        //        11-Size
        //        12-UOM
        //        13-Image
        //        14-Spice Level
        //        15-Aisle No.

        ProductGpod p = new ProductGpod();
//        System.out.println("--prodId "+ row[0]);

        if (productIdExist) {
            p.setId(Integer.parseInt(row[0])); // 0- productId
        } else {
            p.setId(productIdSeq);
        }

        if (!prodCatList.contains(row[1])) {
            if(!isCategoryFound(row[1]))
                   newCategoriesSet.add(buildCategoryGop(row[1]));
        }
        p.getCategories().add(new Category(row[1], row[1])); // 1- category


        SubCategory subCategory = new SubCategory(row[1],row[2]);

        if (!prodSubCatList.contains(subCategory)) {
            if(!isSubCategoryFound(row[1],row[2]))
                    newSubCategoriesSet.add(buildSubCategory(row[1], row[2]));
        }

        p.getSubCategories().add(new SubCategory(row[2], row[2])); // 2- sub-category

        p.setType(new Type(row[3], row[3])); // 3-type

        // used for algolia search in future we can add more search key words for that product
        p.getTags().add(row[3]); // 3-type
         String brand = row[4].trim();
        if(!prodBrandsList.contains(brand)) {
            if(!isBrandsFound(brand)){
                int brandId = brandsSeqId + 1;
                //weeklyProductInventory.setBrandsSeqId(brandId);
               newBrandsSet.add(new BrandGpod(brandId,brand,brand,"NULL",true,new Date(),new Date()));
            }
        }

        p.getBrands().add(new Brand(row[4], row[4])); //4-brand

        p.setDesc(row[5]);  //5-Product
        p.setCode(row[5]);  //5-Product
        p.setUpcCode(row[6]); //6-UPC Code
        p.setShortDesc(row[7]); // 7-Product Description
        p.setPrice(new Price(Double.parseDouble(row[8]), Double.parseDouble(row[8]))); // 8-price
        p.setTax(Double.parseDouble(row[9])); // 9-Tax
        p.setStore(row[10]); // 10-store

        if (sizeMixed) {
            p.setWeight(row[11]); // 11-size
            p.setWeightType(row[11]); //12-uom
        } else {
            p.setWeight(row[11] + " " + row[12]); // 11-size
            p.setWeightType(row[11] + " " + row[12]); //12-uom
        }

        p.setDefaultImage(row[13]); // 13-Image
        p.setImageName(row[13]); // 13-Image

        p.setSpiceLevel(row[14]);  // 14-Spice Level
        p.setAiselNo(row[15]); // 15-aisel No

        p.setQuantity(0);
        p.setNewlyAdded(false); // default to all products
        p.setDealsEnabled(false); // default to all products
        p.setActive(true);
        p.setCreatedTimestamp(new Date());
        p.setUpdatedTimestamp(new Date());
        return p;
    }

    public static CategoryJson buildCategoryGop(String categoryName) {
        int categoryId = categorySeqId + 1;
//        categorySeqId(categoryId);
        //int id, String desc, String code, String imageName, String createdTimestamp, String updatedTimestamp, boolean isActive

        return new CategoryJson(categoryId, categoryName, categoryName, "",  new Date()+"", new Date()+"", true);
    }

    private static SubCategoryGpod buildSubCategory(String category, String subCategory) {
        ;

        SubCategoryGpod subCategoryGpod = new SubCategoryGpod();

        int subCategoryId = subCategorySeqId + 1;
//        subCategorySeqId(subCategoryId);

        subCategoryGpod.setId(subCategoryId);
        subCategoryGpod.setActive(true);
        subCategoryGpod.setUpdatedTimestamp(new Date());
        subCategoryGpod.setCreatedTimestamp(new Date());
        subCategoryGpod.setImageName("");
        subCategoryGpod.setDesc(subCategory);
        subCategoryGpod.setCode(subCategory);
        subCategoryGpod.getCategories().add(new Category(category, category));

        return subCategoryGpod;
    }

    public static boolean isSubCategoryFound(String category,String subCategory){
        boolean found=false;
        for(SubCategoryGpod subCategoryGpod  : newSubCategoriesSet) {
            if(subCategoryGpod.getCode().equalsIgnoreCase(category) && subCategoryGpod.getDesc().equalsIgnoreCase(subCategory)){
                found=true;
                break;
            }
        }
        return found;
    }

    public static boolean isCategoryFound(String category){
        boolean found=false;
        for(CategoryJson categoryJson  : newCategoriesSet) {
            if(categoryJson.getCode().equalsIgnoreCase(category)){
                found=true;
                break;
            }
        }
        return found;
    }

    public static boolean isBrandsFound(String brand){
        boolean found=false;
        for(BrandGpod brandGpod  : newBrandsSet) {
            if(brandGpod.getCode().equalsIgnoreCase(brand) && brandGpod.getDesc().equalsIgnoreCase(brand)){
                found=true;
                break;
            }
        }
        return found;
    }
}