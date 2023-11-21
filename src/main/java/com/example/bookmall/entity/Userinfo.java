package com.example.bookmall.entity;

import java.io.Serializable;

public class Userinfo implements Serializable {
    private Integer iid;

    private String iusername;

    private String isex;

    private Integer iage;

    private Integer iphone;

    private String irealname;

    private String iaddress;

    private static final long serialVersionUID = 1L;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getIusername() {
        return iusername;
    }

    public void setIusername(String iusername) {
        this.iusername = iusername == null ? null : iusername.trim();
    }

    public String getIsex() {
        return isex;
    }

    public void setIsex(String isex) {
        this.isex = isex == null ? null : isex.trim();
    }

    public Integer getIage() {
        return iage;
    }

    public void setIage(Integer iage) {
        this.iage = iage;
    }

    public Integer getIphone() {
        return iphone;
    }

    public void setIphone(Integer iphone) {
        this.iphone = iphone;
    }

    public String getIrealname() {
        return irealname;
    }

    public void setIrealname(String irealname) {
        this.irealname = irealname == null ? null : irealname.trim();
    }

    public String getIaddress() {
        return iaddress;
    }

    public void setIaddress(String iaddress) {
        this.iaddress = iaddress == null ? null : iaddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iid=").append(iid);
        sb.append(", iusername=").append(iusername);
        sb.append(", isex=").append(isex);
        sb.append(", iage=").append(iage);
        sb.append(", iphone=").append(iphone);
        sb.append(", irealname=").append(irealname);
        sb.append(", iaddress=").append(iaddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}