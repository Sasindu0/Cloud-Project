package com.ves.entity;

import javax.persistence.*;

@Entity
@Table(name = "`garage`", schema = "ves")
public class Garage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`garage id`", nullable = false)
    private Integer garageId;

    @Basic
    @Column(name = "`name`", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    private Double latitude;
    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    private Double longitude;
    @Basic
    @Column(name = "`garage email`", nullable = false, length = 50)
    private String garageEmail;
    @Basic
    @Column(name = "`garage phone`", nullable = false, length = 20)
    private String garagePhone;
    @Basic
    @Column(name = "`owner id`", nullable = false)
    private Integer ownerId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`owner id`", nullable = false, insertable = false, updatable = false)
    private Account owner;

    public Garage() {
    }

    public Garage(String name, Double latitude, Double longitude,
                  String garageEmail, String garagePhone,
                  Integer ownerId) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.garageEmail = garageEmail;
        this.garagePhone = garagePhone;
        this.ownerId = ownerId;
    }

    public Integer getGarageId() {
        return garageId;
    }

    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGarageEmail() {
        return garageEmail;
    }

    public void setGarageEmail(String garageEmail) {
        this.garageEmail = garageEmail;
    }

    public String getGaragePhone() {
        return garagePhone;
    }

    public void setGaragePhone(String garagePhone) {
        this.garagePhone = garagePhone;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garage garage = (Garage) o;

        if (garageId != null ? !garageId.equals(garage.garageId) : garage.garageId != null) return false;
        if (name != null ? !name.equals(garage.name) : garage.name != null) return false;
        if (latitude != null ? !latitude.equals(garage.latitude) : garage.latitude != null) return false;
        if (longitude != null ? !longitude.equals(garage.longitude) : garage.longitude != null) return false;
        if (garageEmail != null ? !garageEmail.equals(garage.garageEmail) : garage.garageEmail != null) return false;
        if (garagePhone != null ? !garagePhone.equals(garage.garagePhone) : garage.garagePhone != null) return false;
        if (ownerId != null ? !ownerId.equals(garage.ownerId) : garage.ownerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = garageId != null ? garageId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (garageEmail != null ? garageEmail.hashCode() : 0);
        result = 31 * result + (garagePhone != null ? garagePhone.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        return result;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
