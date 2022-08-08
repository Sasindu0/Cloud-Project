package com.ves.entity;

import javax.persistence.*;

@Entity
@Table(name = "`boom truck`", schema = "ves")
public class BoomTruck {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "driver", nullable = false)
    private int driverId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver", nullable = false, insertable = false, updatable = false)
    private Account driver;

    @Basic
    @Column(name = "`vehicle number`", nullable = false, length = 100)
    private String vehicleNumber;
    @Basic
    @Column(name = "available", nullable = false)
    private boolean available;
    @Basic
    @Column(name = "`price per km`", nullable = false, precision = 0)
    private double pricePerKm;
    @Basic
    @Column(name = "licence", nullable = false, length = 50)
    private String licence;
    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    private Double latitude;
    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    private Double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driver) {
        this.driverId = driver;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }
    public String getPricePerKmTxt() {
        return String.format("%.2f",pricePerKm);
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoomTruck boomTruck = (BoomTruck) o;

        if (id != boomTruck.id) return false;
        if (driverId != boomTruck.driverId) return false;
        if (available != boomTruck.available) return false;
        if (Double.compare(boomTruck.pricePerKm, pricePerKm) != 0) return false;
        if (vehicleNumber != null ? !vehicleNumber.equals(boomTruck.vehicleNumber) : boomTruck.vehicleNumber != null)
            return false;
        if (licence != null ? !licence.equals(boomTruck.licence) : boomTruck.licence != null) return false;
        if (latitude != null ? !latitude.equals(boomTruck.latitude) : boomTruck.latitude != null) return false;
        if (longitude != null ? !longitude.equals(boomTruck.longitude) : boomTruck.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + driverId;
        result = 31 * result + (vehicleNumber != null ? vehicleNumber.hashCode() : 0);
        result = 31 * result +  (available ? 1:0);
        temp = Double.doubleToLongBits(pricePerKm);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (licence != null ? licence.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    public Account getDriver() {
        return driver;
    }

    public void setDriver(Account driver) {
        this.driver = driver;
    }

    public boolean isAvailable() {
        return available;
    }
}
