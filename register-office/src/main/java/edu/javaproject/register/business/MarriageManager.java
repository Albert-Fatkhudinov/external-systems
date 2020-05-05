package edu.javaproject.register.business;

import edu.javaproject.register.dao.MarriageDao;
import edu.javaproject.register.dao.PersonDao;
import edu.javaproject.register.domain.MarriageCertificate;
import edu.javaproject.register.domain.Person;
import edu.javaproject.register.domain.PersonFemale;
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
import java.util.List;

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

        personDao.addPerson(getPerson(1));
        personDao.addPerson(getPerson(2));

        MarriageCertificate marriageCertificate = getMarriageCertificate();
       marriageDao.saveAndFlush(marriageCertificate);

        List<MarriageCertificate> list = marriageDao.findByNumber("12345");
        list.forEach(m -> LOGGER.info("MC: {}", m.getMarriageCertificateId()));

        LOGGER.info("--------->>>>>");

        List<MarriageCertificate> list2 = marriageDao.findByNum("345");
        list2.forEach(m -> LOGGER.info("MC: {}", m.getMarriageCertificateId()));

        LOGGER.info("--------->>>>>");


        return new MarriageResponse();
    }

    private MarriageCertificate getMarriageCertificate() {

        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setIssueDate(LocalDate.now());
        marriageCertificate.setNumber("12345");
        marriageCertificate.setActive(true);

        List<Person> persons = personDao.findPersons();

        for (Person person: persons) {
            if (person instanceof PersonMale) {
                marriageCertificate.setHusband((PersonMale) person);
            } else {
                marriageCertificate.setWife((PersonFemale) person);
            }
        }

        return marriageCertificate;
    }

    private Person getPerson(int sex) {
        Person male = sex == 1 ? new PersonMale() : new PersonFemale();
        male.setFirstName("1" + sex);
        male.setLastName("2" + sex);
        male.setPatronymic("3" + sex);
        male.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return male;
    }
}
