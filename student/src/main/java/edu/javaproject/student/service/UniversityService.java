package edu.javaproject.student.service;

import edu.javaproject.student.dao.FacultyRepository;
import edu.javaproject.student.dao.UniversityRepository;
import edu.javaproject.student.domain.Faculty;
import edu.javaproject.student.domain.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Transactional(readOnly = true)
    public List<University> findUniversities() {
        return universityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Faculty> findFaculties() {
        return facultyRepository.findAll();
    }
}
