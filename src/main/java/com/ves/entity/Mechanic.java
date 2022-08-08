package com.ves.entity;

import javax.persistence.*;

@Entity
public class Mechanic {

    @Id
    @Column(name = "mechanic_id", nullable = false)
    private int mechanicId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mechanic_id", nullable = false, insertable = false, updatable = false)
    private Account account;
    @Basic
    @Column(name = "mechanic_name", nullable = false, length = 50)
    private String mechanicName;
    @Basic
    @Column(name = "type", nullable = false, length = 30)
    private String type;
    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    private Double latitude;
    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    private Double longitude;
    @Basic
    @Column(name = "hiring_price", nullable = true, precision = 0)
    private Double hiringPrice;

    public Mechanic(int owner_id, String m_name,String type,Double latitude,Double longitude,Double price){
        this.mechanicId = owner_id;
        this.mechanicName = m_name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hiringPrice = price;
    }

    public Mechanic(){    
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Double getHiringPrice() {
        return hiringPrice;
    }

    public void setHiringPrice(Double hiringPrice) {
        this.hiringPrice = hiringPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mechanic mechanic = (Mechanic) o;

        if (mechanicId != mechanic.mechanicId) return false;
        if (mechanicName != null ? !mechanicName.equals(mechanic.mechanicName) : mechanic.mechanicName != null)
            return false;
        if (type != null ? !type.equals(mechanic.type) : mechanic.type != null) return false;
        if (latitude != null ? !latitude.equals(mechanic.latitude) : mechanic.latitude != null) return false;
        if (longitude != null ? !longitude.equals(mechanic.longitude) : mechanic.longitude != null) return false;
        if (hiringPrice != null ? !hiringPrice.equals(mechanic.hiringPrice) : mechanic.hiringPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mechanicId;
        result = 31 * result + (mechanicName != null ? mechanicName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (hiringPrice != null ? hiringPrice.hashCode() : 0);
        return result;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
