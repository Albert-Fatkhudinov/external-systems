package edu.javaproject.register.business;

import edu.javaproject.register.dao.MarriageDao;
import edu.javaproject.register.dao.PersonDao;
import edu.javaproject.register.domain.MarriageCertificate;
import edu.javaproject.register.view.MarriageRequest;
import edu.javaproject.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("marriageService")
public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarriageManager");

    private MarriageDao marriageDao;
    private PersonDao personDao;

    @Autowired
    public MarriageManager(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);
        return new MarriageResponse();
    }
}
