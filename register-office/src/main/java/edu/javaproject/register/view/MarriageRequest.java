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
    private String wifeSurname;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateBirth;
    private String wifePassportSerial;
    private String wifePassportNumber;
    private String wifePassportIssueDate;

    //Certificate
    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;
}
