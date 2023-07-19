package com.fawry.pack.refund.entity;

public enum RefundState {
    ACCEPTED, REJECTED, WAITING;

    public String toString() {
        if (this.equals(ACCEPTED)) {
            return this.accepted();
        }
        else if(this.equals(REJECTED))
            return this.rejected();
        else
            return this.waiting();
    }

    private String accepted() {
        return "accepted";
    }

    private String rejected() {
        return "rejected";
    }
    private String waiting() {
        return "waiting";
    }
}
