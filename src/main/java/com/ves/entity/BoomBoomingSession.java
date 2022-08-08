package com.ves.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "`boom booming session`", schema = "ves")
public class BoomBoomingSession {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`session id`", nullable = false)
    private Integer sessionId;
    @Basic
    @Column(name = "customer", nullable = false)
    private Integer customerId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer", nullable = false, insertable = false, updatable = false)
    private Account customer;


    @Basic
    @Column(name = "truck", nullable = false)
    private Integer truckId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "truck", nullable = false, insertable = false, updatable = false)
    private BoomTruck truck;

    @Basic
    @Column(name = "`customer cancelled`", nullable = false)
    private Boolean customerCancelled;
    @Basic
    @Column(name = "`driver accepted`", nullable = false)
    private Boolean driverAccepted;
    @Basic
    @Column(name = "`time requested`", nullable = false)
    private Timestamp timeRequested;
    @Basic
    @Column(name = "`customer vehicle`", nullable = false)
    private Integer customerVehicleId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customer vehicle`", nullable = false, insertable = false, updatable = false)
    private BoomDraggingVehicle customerVehicle;

    @Basic
    @Column(name = "`driver cancelled`", nullable = false)
    private Boolean driverCancelled;
    @Basic
    @Column(name = "completed", nullable = false)
    private Boolean completed = false;


    public BoomBoomingSession() {
    }

    public BoomBoomingSession(Integer customerId, Integer truckId, boolean customerCancelled,
                              boolean driverAccepted,
                              Integer customerVehicleId, boolean driverCancelled) {
        this.customerId = customerId;
        this.truckId = truckId;
        this.customerCancelled = customerCancelled;
        this.driverAccepted = driverAccepted;
        this.timeRequested = Timestamp.from(new Date().toInstant());
        this.customerVehicleId = customerVehicleId;
        this.driverCancelled = driverCancelled;
    }

    public static BoomBoomingSession createNewSession(BoomDraggingVehicle vehicle, BoomTruck truck){
        return new BoomBoomingSession(vehicle.getUser(), truck.getId(),
                false, false,
                vehicle.getId(), false );
    }


    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customer) {
        this.customerId = customer;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truck) {
        this.truckId = truck;
    }

    public Boolean getCustomerCancelled() {
        return customerCancelled;
    }

    public void setCustomerCancelled(Boolean customerCancelled) {
        this.customerCancelled = customerCancelled;
    }

    public Boolean getDriverAccepted() {
        return driverAccepted;
    }

    public void setDriverAccepted(Boolean driverAccepted) {
        this.driverAccepted = driverAccepted;
    }

    public Timestamp getTimeRequested() {
        return timeRequested;
    }

    public void setTimeRequested(Timestamp timeRequested) {
        this.timeRequested = timeRequested;
    }

    public Integer getCustomerVehicleId() {
        return customerVehicleId;
    }

    public void setCustomerVehicleId(Integer customerVehicle) {
        this.customerVehicleId = customerVehicle;
    }

    public Boolean getDriverCancelled() {
        return driverCancelled;
    }

    public void setDriverCancelled(Boolean driverCancelled) {
        this.driverCancelled = driverCancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoomBoomingSession that = (BoomBoomingSession) o;

        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (truckId != null ? !truckId.equals(that.truckId) : that.truckId != null) return false;
        if (customerCancelled != null ? !customerCancelled.equals(that.customerCancelled) : that.customerCancelled != null)
            return false;
        if (driverAccepted != null ? !driverAccepted.equals(that.driverAccepted) : that.driverAccepted != null)
            return false;
        if (timeRequested != null ? !timeRequested.equals(that.timeRequested) : that.timeRequested != null)
            return false;
        if (customerVehicleId != null ? !customerVehicleId.equals(that.customerVehicleId) : that.customerVehicleId != null)
            return false;
        if (driverCancelled != null ? !driverCancelled.equals(that.driverCancelled) : that.driverCancelled != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (truckId != null ? truckId.hashCode() : 0);
        result = 31 * result + (customerCancelled != null ? customerCancelled.hashCode() : 0);
        result = 31 * result + (driverAccepted != null ? driverAccepted.hashCode() : 0);
        result = 31 * result + (timeRequested != null ? timeRequested.hashCode() : 0);
        result = 31 * result + (customerVehicleId != null ? customerVehicleId.hashCode() : 0);
        result = 31 * result + (driverCancelled != null ? driverCancelled.hashCode() : 0);
        return result;
    }

    public BoomTruck getTruck() {
        return truck;
    }

    public void setTruck(BoomTruck truck) {
        this.truck = truck;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public BoomDraggingVehicle getCustomerVehicle() {
        return customerVehicle;
    }

    public void setCustomerVehicle(BoomDraggingVehicle customerVehicle) {
        this.customerVehicle = customerVehicle;
    }

    public String getTime(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm aa").format(new Date(timeRequested.getTime()));
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }


    public boolean isCancelled(){
        return driverCancelled || customerCancelled;
    }
    public boolean isExpired(){
        long t1 = timeRequested.getTime();
        long t2 = new Date().getTime();

        return (t2 - t1) > 3600 * 1000 * 6;
    }
    public boolean isCompleted(){
        if (completed == null ) return false;
        return completed;
    }
    public boolean isAccepted(){
        return driverAccepted;
    }
    public boolean isPending(){
        if (isCancelled() || isExpired() || isCompleted()) return false;
        return !driverAccepted;
    }
    public boolean isOngoing(){
        if (isCancelled()) return false;
        if (isExpired()) return false;
        if (isCompleted()) return false;
        return driverAccepted;
    }

    public String getStatus(){
        if (isCompleted()) return "Completed";
        if (isCancelled()) return "Cancelled";
        if (isExpired()) return "Expired";
        if (driverAccepted) return "Active";
        return "Pending";
    }


}
