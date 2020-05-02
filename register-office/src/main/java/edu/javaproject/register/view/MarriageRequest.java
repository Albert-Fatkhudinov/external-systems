package edu.javaproject.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {

    //husband
    private String husbandSurname;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateBirth;
    private String husbandPassportSerial;
    private String husbandPassportNumber;
    private String husbandPassportIssueDate;

    //wife
    private String wifeSurName;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateBirth;
    private String wifePassportSerial;
    private String wifePassportNumber;
    private String wifePassportIssueDate;

    //Certificate
    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;

    public String getHusbandSurname() {
        return husbandSurname;
    }

    public void setHusbandSurname(String husbandSurname) {
        this.husbandSurname = husbandSurname;
    }

    public String getHusbandGivenName() {
        return husbandGivenName;
    }

    public void setHusbandGivenName(String husbandGivenName) {
        this.husbandGivenName = husbandGivenName;
    }

    public String getHusbandPatronymic() {
        return husbandPatronymic;
    }

    public void setHusbandPatronymic(String husbandPatronymic) {
        this.husbandPatronymic = husbandPatronymic;
    }

    public LocalDate getHusbandDateBirth() {
        return husbandDateBirth;
    }

    public void setHusbandDateBirth(LocalDate husbandDateBirth) {
        this.husbandDateBirth = husbandDateBirth;
    }

    public String getHusbandPassportSerial() {
        return husbandPassportSerial;
    }

    public void setHusbandPassportSerial(String husbandPassportSerial) {
        this.husbandPassportSerial = husbandPassportSerial;
    }

    public String getHusbandPassportNumber() {
        return husbandPassportNumber;
    }

    public void setHusbandPassportNumber(String husbandPassportNumber) {
        this.husbandPassportNumber = husbandPassportNumber;
    }

    public String getHusbandPassportIssueDate() {
        return husbandPassportIssueDate;
    }

    public void setHusbandPassportIssueDate(String husbandPassportIssueDate) {
        this.husbandPassportIssueDate = husbandPassportIssueDate;
    }

    public String getWifeSurName() {
        return wifeSurName;
    }

    public void setWifeSurName(String wifeSurName) {
        this.wifeSurName = wifeSurName;
    }

    public String getWifeGivenName() {
        return wifeGivenName;
    }

    public void setWifeGivenName(String wifeGivenName) {
        this.wifeGivenName = wifeGivenName;
    }

    public String getWifePatronymic() {
        return wifePatronymic;
    }

    public void setWifePatronymic(String wifePatronymic) {
        this.wifePatronymic = wifePatronymic;
    }

    public LocalDate getWifeDateBirth() {
        return wifeDateBirth;
    }

    public void setWifeDateBirth(LocalDate wifeDateBirth) {
        this.wifeDateBirth = wifeDateBirth;
    }

    public String getWifePassportSerial() {
        return wifePassportSerial;
    }

    public void setWifePassportSerial(String wifePassportSerial) {
        this.wifePassportSerial = wifePassportSerial;
    }

    public String getWifePassportNumber() {
        return wifePassportNumber;
    }

    public void setWifePassportNumber(String wifePassportNumber) {
        this.wifePassportNumber = wifePassportNumber;
    }

    public String getWifePassportIssueDate() {
        return wifePassportIssueDate;
    }

    public void setWifePassportIssueDate(String wifePassportIssueDate) {
        this.wifePassportIssueDate = wifePassportIssueDate;
    }

    public String getMarriageCertificateNumber() {
        return marriageCertificateNumber;
    }

    public void setMarriageCertificateNumber(String marriageCertificateNumber) {
        this.marriageCertificateNumber = marriageCertificateNumber;
    }

    public LocalDate getMarriageCertificateDate() {
        return marriageCertificateDate;
    }

    public void setMarriageCertificateDate(LocalDate marriageCertificateDate) {
        this.marriageCertificateDate = marriageCertificateDate;
    }
}
