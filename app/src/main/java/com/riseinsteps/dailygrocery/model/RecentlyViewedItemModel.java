package com.riseinsteps.dailygrocery.model;

public class RecentlyViewedItemModel {
    private int id;
    private int image;

    private int BIGImage;
    private String recentlyItemName;
    private String recentlyItemDesc;
    private String recentlyItemPrice;
    private String recentlyItemQuantity;

    public RecentlyViewedItemModel(int id, int image, int BIGImage, String recentlyItemName, String recentlyItemDesc, String recentlyItemPrice, String recentlyItemQuantity) {
        this.id = id;
        this.image = image;
        this.BIGImage = BIGImage;
        this.recentlyItemName = recentlyItemName;
        this.recentlyItemDesc = recentlyItemDesc;
        this.recentlyItemPrice = recentlyItemPrice;
        this.recentlyItemQuantity = recentlyItemQuantity;
    }

    public int getBIGImage() {
        return BIGImage;
    }

    public void setBIGImage(int BIGImage) {
        this.BIGImage = BIGImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRecentlyItemName() {
        return recentlyItemName;
    }

    public void setRecentlyItemName(String recentlyItemName) {
        this.recentlyItemName = recentlyItemName;
    }

    public String getRecentlyItemDesc() {
        return recentlyItemDesc;
    }

    public void setRecentlyItemDesc(String recentlyItemDesc) {
        this.recentlyItemDesc = recentlyItemDesc;
    }

    public String getRecentlyItemPrice() {
        return recentlyItemPrice;
    }

    public void setRecentlyItemPrice(String recentlyItemPrice) {
        this.recentlyItemPrice = recentlyItemPrice;
    }

    public String getRecentlyItemQuantity() {
        return recentlyItemQuantity;
    }

    public void setRecentlyItemQuantity(String recentlyItemQuantity) {
        this.recentlyItemQuantity = recentlyItemQuantity;
    }
}
