package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "time_slots")

public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "time_slot_id")
    private Long slotId;

    @Column(name = "time_slot_date")
    private Date slotDate;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "is_keynote_time_slot")
    private boolean isKeynote;

    public TimeSlot() { }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isKeynote() {
        return isKeynote;
    }

    public void setKeynote(boolean keynote) {
        isKeynote = keynote;
    }
}
