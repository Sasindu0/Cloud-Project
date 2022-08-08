package com.ves.entity;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.*;
import java.io.File;
import java.util.Base64;
import java.util.Locale;

@Entity
@Table(name = "account", schema = "ves")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`register id`", nullable = false)
    private Integer registerId;
    @Basic
    @Column(name = "`name`", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "age", nullable = false)
    private Integer age;
    @Basic
    @Column(name = "address", nullable = false, length = 300)
    private String address;
    @Basic
    @Column(name = "`mobile number`", nullable = false, length = 15)
    private String mobileNumber;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 100)
    private String password;
    @Basic
    @Column(name = "icon", nullable = true)
    private byte[] icon;
    @Basic
    @Column(name = "`account type`", nullable = false, length = 15)
    private String accountType;

    public Account() {
    }

    public Account(
            String name, Integer age, String address, String mobileNumber,
            String email, String username, String password, String accountType) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public void setData(
            String name, Integer age, String address, String mobileNumber,
            String email, String username, String password, String accountType) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public Account(String name, String mobileNumber, String username) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.username = username;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isDriver(){
        return  (accountType.toLowerCase(Locale.ROOT).equals("driver"));
    }
    public boolean isGarageOwner(){
        return  (accountType.toLowerCase(Locale.ROOT).equals("garage"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (registerId != null ? !registerId.equals(account.registerId) : account.registerId != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (age != null ? !age.equals(account.age) : account.age != null) return false;
        if (address != null ? !address.equals(account.address) : account.address != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(account.mobileNumber) : account.mobileNumber != null)
            return false;
        if (email != null ? !email.equals(account.email) : account.email != null) return false;
        if (username != null ? !username.equals(account.username) : account.username != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = registerId != null ? registerId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        return result;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getBase64Img(){
        String img = null;

        try{
            byte[] encoded = Base64.getEncoder().encode(icon);
            img = new String(encoded);
            img = "data:image/png;base64,"+ img;
        }
        catch (Exception e) {
            try {
                ClassPathResource classPathResource =
                        new ClassPathResource("empty_profile.png",
                                this.getClass().getClassLoader());
                File file = classPathResource.getFile();
                byte[] encoded = Base64.getEncoder().encode(FileUtils.readFileToByteArray(file));
                img = new String(encoded);
                img = "data:image/png;base64,"+ img;
            }
            catch (Exception ignored){}
        }
        return img;
    }
}
