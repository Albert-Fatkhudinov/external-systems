package edu.javaproject.register.business;

import edu.javaproject.register.dao.MarriageDao;
import edu.javaproject.register.domain.MarriageCertificate;
import edu.javaproject.register.view.MarriageRequest;
import edu.javaproject.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarriageManager");

    private MarriageDao marriageDao;

    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);
        return new MarriageResponse();
    }
}
