package edu.javaproject.city.dao;

import edu.javaproject.city.domain.PersonRequest;
import edu.javaproject.city.domain.PersonResponse;
import edu.javaproject.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonCheckDaoTest {

//    @Test
//    public void checkPerson() throws PersonCheckException {
//        PersonRequest personRequest = new PersonRequest();
//        personRequest.setSurName("Васильев");
//        personRequest.setGivenName("Павел");
//        personRequest.setPatronymic("Николаевич");
//        personRequest.setDateOfBirth(LocalDate.of(1995, 3, 18));
//        personRequest.setStreetCode(1);
//        personRequest.setBuilding("10");
//        personRequest.setExtension("2");
//        personRequest.setApartment("121");
//
//        PersonCheckDao personCheckDao = new PersonCheckDao();
//        PersonResponse response = personCheckDao.checkPerson(personRequest);
//        Assert.assertTrue(response.isRegistered());
//        Assert.assertFalse(response.isTemporal());
//    }

    @Test
    public void checkPerson2() throws PersonCheckException {
        PersonRequest personRequest = new PersonRequest();
        personRequest.setSurName("Васильева");
        personRequest.setGivenName("Ирина");
        personRequest.setPatronymic("Петровна");
        personRequest.setDateOfBirth(LocalDate.of(1997, 3, 18));
        personRequest.setStreetCode(1);
        personRequest.setBuilding("271");

        PersonCheckDao personCheckDao = new PersonCheckDao();
        PersonResponse response = personCheckDao.checkPerson(personRequest);
        Assert.assertTrue(response.isRegistered());
        Assert.assertFalse(response.isTemporal());
    }
}