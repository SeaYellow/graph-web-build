package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by Administrator on 2017/6/14.
 */
@Entity
@Table(name = "PF_USER_INFO")
public class ExampleUser implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private long status;

    @Column(name = "PASS_CHANGED")
    private Date passChanged;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "MAC_ADDRESS")
    private String macAddress;

    @Column(name = "ERR_TIMES")
    private long errTimes;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS_LOCKED")
    private Date passLocked;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "SYNCSTATUS")
    private long syncstatus;

    @Column(name = "CREDENTIALS_SALT")
    private String credentialsSalt;

    public long getSyncstatus() {
        return syncstatus;
    }

    public void setSyncstatus(long syncstatus) {
        this.syncstatus = syncstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Date getPassChanged() {
        return passChanged;
    }

    public void setPassChanged(Date passChanged) {
        this.passChanged = passChanged;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public long getErrTimes() {
        return errTimes;
    }

    public void setErrTimes(long errTimes) {
        this.errTimes = errTimes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getPassLocked() {
        return passLocked;
    }

    public void setPassLocked(Date passLocked) {
        this.passLocked = passLocked;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCredentialsSalt() {
        return credentialsSalt;
    }

    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = credentialsSalt;
    }
}
