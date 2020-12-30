package model.gpod;

import model.*;

import java.util.*;

public class ProductGpod {

    private String id;
    private String code;
    private String desc;
    private String shortName;
    private String sku;
    private List<Category> categories = new ArrayList<Category>();
    private List<SubCategory> subCategories = new ArrayList<SubCategory>();
    private List<Brand> brands = new ArrayList<Brand>();
    private Price price;
    private Type type;
    private Deal deal;
    private String weight;
    private double tax;
    private String spiceLevel;
    private String aiselNo;
    private String store;
    private String weightType;
    private String imageName;
    private String defaultImage;
    private String[] imageUris;
    private Date updatedTimestamp;
    private Date createdTimestamp;
    private boolean isNewlyAdded;
    private boolean isActive;
    private boolean isDealsEnabled=false;

    public ProductGpod() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public String getAiselNo() {
        return aiselNo;
    }

    public void setAiselNo(String aiselNo) {
        this.aiselNo = aiselNo;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String[] getImageUris() {
        return imageUris;
    }

    public void setImageUris(String[] imageUris) {
        this.imageUris = imageUris;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public boolean isDealsEnabled() {
        return isDealsEnabled;
    }

    public void setDealsEnabled(boolean dealsEnabled) {
        isDealsEnabled = dealsEnabled;
    }

    public boolean isNewlyAdded() {
        return isNewlyAdded;
    }

    public void setNewlyAdded(boolean newlyAdded) {
        isNewlyAdded = newlyAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGpod product = (ProductGpod) o;
        return Double.compare(product.tax, tax) == 0 &&
                isActive == product.isActive &&
                isDealsEnabled == product.isDealsEnabled &&
                Objects.equals(id, product.id) &&
                Objects.equals(code, product.code) &&
                Objects.equals(desc, product.desc) &&
                Objects.equals(categories, product.categories) &&
                Objects.equals(subCategories, product.subCategories) &&
                Objects.equals(brands, product.brands) &&
                Objects.equals(price, product.price) &&
                Objects.equals(type, product.type) &&
                Objects.equals(deal, product.deal) &&
                Objects.equals(weight, product.weight) &&
                Objects.equals(spiceLevel, product.spiceLevel) &&
                Objects.equals(aiselNo, product.aiselNo) &&
                Objects.equals(store, product.store) &&
                Objects.equals(weightType, product.weightType) &&
                Objects.equals(imageName, product.imageName) &&
                Objects.equals(defaultImage, product.defaultImage) &&
                Arrays.equals(imageUris, product.imageUris) &&
                Objects.equals(updatedTimestamp, product.updatedTimestamp) &&
                Objects.equals(createdTimestamp, product.createdTimestamp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, code, desc, categories, subCategories, brands, price, type, deal, weight, tax, spiceLevel, aiselNo, store, weightType, imageName, defaultImage, updatedTimestamp, createdTimestamp, isActive, isDealsEnabled);
        result = 31 * result + Arrays.hashCode(imageUris);
        return result;
    }

    @Override
    public String toString() {
        return "ProductGpod{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", shortName='" + shortName + '\'' +
                ", sku='" + sku + '\'' +
                ", categories=" + categories +
                ", subCategories=" + subCategories +
                ", brands=" + brands +
                ", price=" + price +
                ", type=" + type +
                ", deal=" + deal +
                ", weight='" + weight + '\'' +
                ", tax=" + tax +
                ", spiceLevel='" + spiceLevel + '\'' +
                ", aiselNo='" + aiselNo + '\'' +
                ", store='" + store + '\'' +
                ", weightType='" + weightType + '\'' +
                ", imageName='" + imageName + '\'' +
                ", defaultImage='" + defaultImage + '\'' +
                ", imageUris=" + Arrays.toString(imageUris) +
                ", updatedTimestamp=" + updatedTimestamp +
                ", createdTimestamp=" + createdTimestamp +
                ", isNewlyAdded=" + isNewlyAdded +
                ", isActive=" + isActive +
                ", isDealsEnabled=" + isDealsEnabled +
                '}';
    }
}
