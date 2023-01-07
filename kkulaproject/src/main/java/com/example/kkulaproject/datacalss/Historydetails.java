package com.example.kkulaproject.datacalss;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Historydetails")
public class Historydetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Historydetailsid;
    private String sendemail;
    private String professor;
    private String fileURL;
    private String phone;
    private String details;

    @OneToOne(mappedBy = "Historydetails")
    private History history;

    public Historydetails() {
    }

    public Historydetails(String sendemail, String fileURL, String phone, String details) {
        this.sendemail = sendemail;
        this.fileURL = fileURL;
        this.phone = phone;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Historydetails [Historydetailsid=" + Historydetailsid + ", sendemail=" + sendemail + ", professor="
                + professor + ", fileURL=" + fileURL + ", phone=" + phone + ", details=" + details + ", history="
                + history + "]";
    }

    public String getSendemail() {
        return sendemail;
    }

    public void setSendemail(String sendemail) {
        this.sendemail = sendemail;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @JsonIgnore
    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Integer getHistorydetailsid() {
        return Historydetailsid;
    }

    public void setHistorydetailsid(Integer historydetailsid) {
        Historydetailsid = historydetailsid;
    }

}
