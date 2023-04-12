package com.example.studentdetails.dao;

import com.example.studentdetails.entites.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao{
    public static Logger log = (Logger) LoggerFactory.getLogger(StudentDaoImpl.class);

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    private static String selectStudentQuery =
            " SELECT id, name, email  FROM student  WHERE id =  : studentId";

    @Override
    public Student getStudent(Integer studentId) {
        try {
            RowMapper<Student> rowMapper = new StudentRowMapper();
            return jdbcTemplate.queryForObject(
                    selectStudentQuery, Collections.singletonMap("studentId", studentId), rowMapper);
        } catch (DataAccessException e) {
            log.debug("Error occurred in fetching Student from DB", e);
            return null;
        }
    }

    private static String selectStudentsQuery =
            " SELECT id, name, email FROM student ";

    @Override
    public List<Student> getStudents() {
        try {
            RowMapper<Student> rowMapper = new StudentRowMapper();
            List<Student> students = jdbcTemplate.query(selectStudentsQuery, rowMapper);

            return students;

        } catch (DataAccessException e) {
            log.debug("Error occurred in fetching student from DB", e);
            return null;
        }
    }

    public static String deleteStudentQuery =
            " DELETE FROM student" + " WHERE (id = :studentId)";

    @Override
    public void deleteStudent(Integer studentId) {
        Map<String, Integer> namedParameters = new HashMap<>();
        namedParameters.put("studentId", studentId);
        jdbcTemplate.update(deleteStudentQuery, namedParameters);
    }

    public static String updateStudentQuery =
            " UPDATE student"
                    + " SET name =  :name, email =  :email"
                    + " WHERE (id =  :id)";

    @Override
    public void updateStudent(Student student) {
        Integer studentId = student.getId();
        if(studentId == null) {
            return;
        }
        Student existingCustomer = getStudent(studentId);
        if (existingCustomer == null) {
            throw new RuntimeException(
                    String.format("Student with id {} does not exists", student.getId()));
        }

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("id", student.getId());
        namedParameters.put("name", student.getName());
        namedParameters.put("email", student.getEmail());
        jdbcTemplate.update(updateStudentQuery, namedParameters);
    }

    public static String createStudentQuery =
            " INSERT INTO customer"
                    + "  (name, email)"
                    + " VALUES ( :name,  :email)";

    @Override
    public Integer createStudent(Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", student.getName());
        namedParameters.addValue("email", student.getEmail());

        jdbcTemplate.update(createStudentQuery, namedParameters, keyHolder, new String[] {"id"});
        student.setId(keyHolder.getKey().intValue());

        return student.getId();
    }
}
