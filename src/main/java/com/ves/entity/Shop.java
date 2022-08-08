package com.ves.entity;

import javax.persistence.*;

@Entity
public class Shop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "shop_id", nullable = false)
    private Integer shopId;
    @Basic
    @Column(name = "owner_id", nullable = false)
    private Integer ownerId;
    @Basic
    @Column(name = "shop_name", nullable = false, length = 30)
    private String shopName;
    @Basic
    @Column(name = "latitude", nullable = false, precision = 0)
    private Double latitude;
    @Basic
    @Column(name = "longitude", nullable = false, precision = 0)
    private Double longitude;
    @Basic
    @Column(name = "shop_email", nullable = false, length = 30)
    private String shopEmail;

    public Shop(int owner_id, String shop_name, Double latitude, Double longitude, String email){
        this.ownerId = owner_id;
        this.shopName = shop_name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.shopEmail = email;
    }

    public Shop(){    
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shopId != null ? !shopId.equals(shop.shopId) : shop.shopId != null) return false;
        if (ownerId != null ? !ownerId.equals(shop.ownerId) : shop.ownerId != null) return false;
        if (shopName != null ? !shopName.equals(shop.shopName) : shop.shopName != null) return false;
        if (latitude != null ? !latitude.equals(shop.latitude) : shop.latitude != null) return false;
        if (longitude != null ? !longitude.equals(shop.longitude) : shop.longitude != null) return false;
        if (shopEmail != null ? !shopEmail.equals(shop.shopEmail) : shop.shopEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopId != null ? shopId.hashCode() : 0;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (shopEmail != null ? shopEmail.hashCode() : 0);
        return result;
    }
}
