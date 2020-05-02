package edu.javaproject.register.dao;

import edu.javaproject.register.domain.MarriageCertificate;
import edu.javaproject.register.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class MarriageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarriageController");

    private EntityManager entityManager;
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called: {}", test);
        return null;
    }
}
