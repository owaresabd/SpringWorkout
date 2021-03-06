package com.springWorkout.responseObject;


public class ConcurrencyResponseObject extends ResponseObject {

    private String personName;
    private String personSurname;
    private String tckNo;
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public String getTckNo() {
        return tckNo;
    }

    public void setTckNo(String tckNo) {
        this.tckNo = tckNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((personName == null) ? 0 : personName.hashCode());
        result = prime * result + ((personSurname == null) ? 0 : personSurname.hashCode());
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((tckNo == null) ? 0 : tckNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!super.equals(obj)) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        ConcurrencyResponseObject other = (ConcurrencyResponseObject) obj;
        if (personName == null) {
            if (other.personName != null) { return false; }
        } else if (!personName.equals(other.personName)) { return false; }
        if (personSurname == null) {
            if (other.personSurname != null) { return false; }
        } else if (!personSurname.equals(other.personSurname)) { return false; }
        if (requestId == null) {
            if (other.requestId != null) { return false; }
        } else if (!requestId.equals(other.requestId)) { return false; }
        if (tckNo == null) {
            if (other.tckNo != null) { return false; }
        } else if (!tckNo.equals(other.tckNo)) { return false; }
        return true;
    }

    @Override
    public String toString() {
        return "ConcurrencyResponseObject [personName=" + personName + ", personSurname=" + personSurname + ", tckNo="
            + tckNo + ", requestId=" + requestId + "]";
    }

}
