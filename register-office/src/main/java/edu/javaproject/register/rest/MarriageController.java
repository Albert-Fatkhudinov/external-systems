package edu.javaproject.register.rest;

import edu.javaproject.register.business.MarriageManager;
import edu.javaproject.register.view.MarriageRequest;
import edu.javaproject.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("controller")
public class MarriageController {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarriageController");

    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(request);
    }
}
