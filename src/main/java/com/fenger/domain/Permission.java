package com.fenger.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class Permission implements Serializable {
    private Integer perid;

    private String pername;

    private String percode;

    private static final long serialVersionUID = 1L;

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getPerid() == null ? other.getPerid() == null : this.getPerid().equals(other.getPerid()))
            && (this.getPername() == null ? other.getPername() == null : this.getPername().equals(other.getPername()))
            && (this.getPercode() == null ? other.getPercode() == null : this.getPercode().equals(other.getPercode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPerid() == null) ? 0 : getPerid().hashCode());
        result = prime * result + ((getPername() == null) ? 0 : getPername().hashCode());
        result = prime * result + ((getPercode() == null) ? 0 : getPercode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", perid=").append(perid);
        sb.append(", pername=").append(pername);
        sb.append(", percode=").append(percode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}