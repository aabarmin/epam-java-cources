package com.epam.university.java.core.task042;

/**
 * Class describes that Alexander is busy now and is going to get back to the
 * office at proposed time.
 */
public class TimeProposalResponse implements BookingResponse {
    private String proposedTime;

    public String getProposedTime() {
        return proposedTime;
    }

    public void setProposedTime(String proposedTime) {
        this.proposedTime = proposedTime;
    }
}
