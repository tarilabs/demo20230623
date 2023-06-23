package org.drools.demo;

public class Request {
    private String type;
    private Boolean approved;
    private String comment;

    public Request() {
        // empty constructor
    }

    public Request(String type, Boolean approved, String comment) {
        this.type = type;
        this.approved = approved;
        this.comment = comment;
    }

    public Request(String type) {
        this(type, null, null);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((approved == null) ? 0 : approved.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Request other = (Request) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (approved == null) {
            if (other.approved != null)
                return false;
        } else if (!approved.equals(other.approved))
            return false;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Request [type=" + type + ", approved=" + approved + ", comment=" + comment + "]";
    }
}
