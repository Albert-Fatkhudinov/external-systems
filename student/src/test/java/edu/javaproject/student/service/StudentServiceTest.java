package edu.javaproject.student.service;


import edu.javaproject.student.rest.StudentController;
import edu.javaproject.student.view.StudentRequest;
import edu.javaproject.student.view.StudentResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class StudentServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTest.class);

    @Autowired
    private StudentController controller;

    @Test
    public void studentInfo() {
        StudentRequest request = new StudentRequest();
        request.setLastName("Last");
        request.setFirstName("First");
        request.setMiddleName("Middle");
        request.setDateOfBirth(LocalDate.of(2000, 4, 12));
        request.setPassportSerial("1111");
        request.setPassportNumber("123456");
        request.setPassportDate(LocalDate.of(2016, 4, 30));
        List<StudentResponse> studentInfo = controller.getStudentInfo(request);
        Assert.assertTrue(studentInfo.size() > 0);
    }
}