package edu.javaproject.student.dao;

import edu.javaproject.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    @Query("SELECT st FROM Student st WHERE st.lastName = :lastName AND " +
            "st.firstName = :firstName AND st.middleName = :middleName AND " +
            "st.dateOfBirth = :dateOfBirth AND st.passportSerial = :passportSerial AND " +
            "st.passportNumber = :passportNumber AND st.passportDate = :passportDate")
    List<Student> findStudent(@Param("lastName")String lastName,
                              @Param("firstName")String firstName,
                              @Param("middleName")String middleName,
                              @Param("dateOfBirth") LocalDate dateOfBirth,
                              @Param("passportSerial")String passportSerial,
                              @Param("passportNumber")String passportNumber,
                              @Param("passportDate") LocalDate passportDate
    );
}