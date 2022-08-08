package com.ves.entity;

import javax.persistence.*;

@Entity
@Table(name = "`shop spare part`", schema = "ves")
public class ShopSparePart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sp_id", nullable = false)
    private Integer spId;
    @Basic
    @Column(name = "shop_id", nullable = false)
    private Integer shopId;
    @Basic
    @Column(name = "vehicle_model", nullable = false, length = 30)
    private String vehicleModel;
    @Basic
    @Column(name = "sp_name", nullable = false, length = 30)
    private String spName;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Basic
    @Column(name = "price_per_unit", nullable = false, precision = 0)
    private Double pricePerUnit;


    public ShopSparePart() {
    }

    public ShopSparePart(int shop_id, String vehicle_model, String sp_name, int quantity, Double price_per_unit){
        this.shopId = shop_id;
        this.vehicleModel = vehicle_model;
        this.spName = sp_name;
        this.quantity = quantity;
        this.pricePerUnit = price_per_unit;
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleMode) {
        this.vehicleModel = vehicleMode;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopSparePart that = (ShopSparePart) o;

        if (spId != null ? !spId.equals(that.spId) : that.spId != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (vehicleModel != null ? !vehicleModel.equals(that.vehicleModel) : that.vehicleModel != null) return false;
        if (spName != null ? !spName.equals(that.spName) : that.spName != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (pricePerUnit != null ? !pricePerUnit.equals(that.pricePerUnit) : that.pricePerUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spId != null ? spId.hashCode() : 0;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (vehicleModel != null ? vehicleModel.hashCode() : 0);
        result = 31 * result + (spName != null ? spName.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (pricePerUnit != null ? pricePerUnit.hashCode() : 0);
        return result;
    }
}
