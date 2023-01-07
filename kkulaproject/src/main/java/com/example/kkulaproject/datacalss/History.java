
package com.example.kkulaproject.datacalss;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historyid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "startdate")
    private Date startdate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "enddate")
    private Date enddate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Historydetails_id")
    private Historydetails Historydetails;

    public History() {
    }

    public History(Date startdate, Date enddate, Historydetails Historydetails) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.Historydetails = Historydetails;
    }

    @Override
    public String toString() {
        return "History [historyid=" + historyid + ", startdate=" + startdate + ", enddate=" + enddate
                + ", Historydetails=" + Historydetails + "]";
    }

    public Integer getHistoryid() {
        return historyid;
    }

    public void setHistoryid(Integer historyid) {
        this.historyid = historyid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Historydetails getHistorydetails() {
        return Historydetails;
    }

    public void setHistorydetails(Historydetails Historydetails) {
        this.Historydetails = Historydetails;
    }

}
