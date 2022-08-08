package com.ves.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "account session", schema = "ves", catalog = "")
public class AccountSession {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "session id", nullable = false)
    private Integer sessionId;
    @Basic
    @Column(name = "account id", nullable = false)
    private Integer accountId;
    @Basic
    @Column(name = "start", nullable = false)
    private Timestamp start;
    @Basic
    @Column(name = "end", nullable = true)
    private Timestamp end;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountSession that = (AccountSession) o;

        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
