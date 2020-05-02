package edu.javaproject.register.rest;

import edu.javaproject.register.business.MarriageManager;
import edu.javaproject.register.view.MarriageRequest;
import edu.javaproject.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageController {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarriageController");

    private MarriageManager marriageManager;

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(request);
    }
}
