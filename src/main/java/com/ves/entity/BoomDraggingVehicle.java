package com.ves.entity;

import javax.persistence.*;

@Entity
@Table(name = "`boom dragging vehicle`", schema = "ves", catalog = "")
public class BoomDraggingVehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "`vehicle type`", nullable = false, length = 20)
    private String vehicleType;
    @Basic
    @Column(name = "`number plate`", nullable = false, length = 20)
    private String numberPlate;
    @Basic
    @Column(name = "latitude", nullable = false, precision = 0)
    private double latitude;
    @Basic
    @Column(name = "longitude", nullable = false, precision = 0)
    private double longitude;
    @Basic
    @Column(name = "`user`", nullable = true)
    private Integer user;

    public BoomDraggingVehicle() {
    }

    public BoomDraggingVehicle(String vehicleType, String numberPlate,
                               double latitude, double longitude,
                               Integer user) {
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoomDraggingVehicle that = (BoomDraggingVehicle) o;

        if (id != that.id) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (vehicleType != null ? !vehicleType.equals(that.vehicleType) : that.vehicleType != null) return false;
        if (numberPlate != null ? !numberPlate.equals(that.numberPlate) : that.numberPlate != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (vehicleType != null ? vehicleType.hashCode() : 0);
        result = 31 * result + (numberPlate != null ? numberPlate.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
