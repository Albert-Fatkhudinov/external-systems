package edu.javaproject.register.business;

import edu.javaproject.register.dao.MarriageDao;
import edu.javaproject.register.dao.PersonDao;
import edu.javaproject.register.domain.MarriageCertificate;
import edu.javaproject.register.domain.Person;
import edu.javaproject.register.domain.PersonMale;
import edu.javaproject.register.view.MarriageRequest;
import edu.javaproject.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarriageManager");

    @Autowired
    private MarriageDao marriageDao;

    @Autowired
    private PersonDao personDao;

    @Transactional
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDao.findMarriageCertificate(request);

        personDao.findPersons();


        personDao.addPerson(getPerson());
        personDao.addPerson(getPerson());
        personDao.addPerson(getPerson());

        return new MarriageResponse();
    }

    private Person getPerson() {
        Person male = new PersonMale();
        male.setFirstName("1");
        male.setLastName("2");
        male.setPatronymic("3");
        male.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return male;
    }
}
