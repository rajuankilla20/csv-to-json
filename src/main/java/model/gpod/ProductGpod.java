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
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGpod that = (ProductGpod) o;
        return Double.compare(that.tax, tax) == 0 &&
                isNewlyAdded == that.isNewlyAdded &&
                isActive == that.isActive &&
                isDealsEnabled == that.isDealsEnabled &&
                quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(categories, that.categories) &&
                Objects.equals(subCategories, that.subCategories) &&
                Objects.equals(brands, that.brands) &&
                Objects.equals(price, that.price) &&
                Objects.equals(type, that.type) &&
                Objects.equals(deal, that.deal) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(spiceLevel, that.spiceLevel) &&
                Objects.equals(aiselNo, that.aiselNo) &&
                Objects.equals(store, that.store) &&
                Objects.equals(weightType, that.weightType) &&
                Objects.equals(imageName, that.imageName) &&
                Objects.equals(defaultImage, that.defaultImage) &&
                Arrays.equals(imageUris, that.imageUris) &&
                Objects.equals(updatedTimestamp, that.updatedTimestamp) &&
                Objects.equals(createdTimestamp, that.createdTimestamp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, code, desc, shortName, sku, categories, subCategories, brands, price, type, deal, weight, tax, spiceLevel, aiselNo, store, weightType, imageName, defaultImage, updatedTimestamp, createdTimestamp, isNewlyAdded, isActive, isDealsEnabled, quantity);
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
                ", quantity=" + quantity +
                '}';
    }
}
