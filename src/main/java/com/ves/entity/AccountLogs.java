package com.ves.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "account logs", schema = "ves", catalog = "")
public class AccountLogs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "log id", nullable = false)
    private Integer logId;
    @Basic
    @Column(name = "account id", nullable = false)
    private Integer accountId;
    @Basic
    @Column(name = "login time", nullable = false)
    private Timestamp loginTime;
    @Basic
    @Column(name = "logout time", nullable = false)
    private Timestamp logoutTime;
    @Basic
    @Column(name = "activities id", nullable = false)
    private Integer activitiesId;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Integer getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(Integer activitiesId) {
        this.activitiesId = activitiesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountLogs that = (AccountLogs) o;

        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (logoutTime != null ? !logoutTime.equals(that.logoutTime) : that.logoutTime != null) return false;
        if (activitiesId != null ? !activitiesId.equals(that.activitiesId) : that.activitiesId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (logoutTime != null ? logoutTime.hashCode() : 0);
        result = 31 * result + (activitiesId != null ? activitiesId.hashCode() : 0);
        return result;
    }
}
