package edu.javaproject.register.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {

    @OneToMany(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "wife")
    private List<MarriageCertificate> marriageCertificates;

    @OneToMany(cascade = {CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "mother")
    private List<BirthCertificate> birthCertificates;

    public List<MarriageCertificate> getMarriageCertificates() {
        return marriageCertificates;
    }

    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }
}
