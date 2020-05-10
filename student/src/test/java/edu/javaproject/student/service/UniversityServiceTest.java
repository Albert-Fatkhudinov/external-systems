package edu.javaproject.student.service;

import edu.javaproject.student.domain.Faculty;
import edu.javaproject.student.domain.University;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class UniversityServiceTest {

    @Autowired
    private UniversityService service;

    @Test
    public void findUniversities() {
        List<University> list = service.findUniversities();
        System.out.println("OK");
        list.forEach(u -> System.out.println(u.getUniversityId() + ": " +
                u.getUniversityName() + " " + u.getFaculties().size()));
    }

    @Test
    public void findFullUniversities() {
        List<University> list = service.findFullUniversities();
        System.out.println("OK");
        list.forEach(u -> System.out.println(u.getUniversityId() + ": " +
                u.getUniversityName() + " " + u.getFaculties().size()));
    }

    @Test
    public void getUniversity() {
        University university = service.getUniversity(1L);
        System.out.println(university.getUniversityName() + ": "
                + university.getFaculties().size());
    }


    @Test
    public void findFaculties() {
        List<Faculty> list = service.findFaculties();
        System.out.println("OK");
        list.forEach(f -> System.out.println(f.getUniversity().getUniversityName()));
    }

    @Test
    public void getFaculty() {
        Faculty faculty = service.getFaculty(1L);
        System.out.println(faculty.getUniversity().getUniversityName());
    }
}