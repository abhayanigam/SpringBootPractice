package com.example.employees.dao;

import com.example.employees.entity.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
public class EmployeesDaoImpl implements EmployeesDao{

    public static Logger log = (Logger) LoggerFactory.getLogger(EmployeesDaoImpl.class);

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    private static String selectEmployeeQuery =
            "SELECT id, name, salary FROM employees WHERE id = :empId";

    private static String selectEmployeesJoinQuery =
//            "SELECT id, name, salary FROM employees";
              "SELECT employees.id, employees.name, employees.salary, food.id, food.Meal FROM employees" +
                      " LEFT OUTER JOIN food ON employees.id = food.id UNION SELECT employees.id, employees.name, employees.salary, food.id, food.Meal" +
                      " FROM employees RIGHT OUTER JOIN food ON employees.id = food.id";

    public static String createEmployeeQuery =
            " INSERT INTO employees"
                    + "  (name, salary)"
                    + " VALUES ( :name,  :salary)";

    public static String updateEmployeeQuery =
            " UPDATE employees"
                    + " SET name =  :name, salary =  :salary"
                    + " WHERE (id =  :empId)";

    public static String deleteEmployeeQuery =
            " DELETE FROM employees" + " WHERE (id = :empId)";

    @Override
    public Employees getEmployee(Integer empId) {
        try{
            RowMapper<Employees> rowMapper = new EmployeeRowMapper();
            return jdbcTemplate.queryForObject(selectEmployeeQuery, Collections.singletonMap("empId",empId),rowMapper);
        }catch (DataAccessException e){
            log.debug("Error occurred in fetching student from DB", e);
            return null;
        }
    }

    @Override
    public List<Employees> getEmployeesFromTwoTables() {
        try {
            RowMapper<Employees> rowMapper = new EmployeeRowMapper();
            List<Employees> employees = jdbcTemplate.query(selectEmployeesJoinQuery, rowMapper);

            return employees;

        } catch (DataAccessException e) {
            log.debug("Error occurred in fetching student from DB", e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer createEmployees(Employees employees) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", employees.getName());
        namedParameters.addValue("salary", employees.getSalary());

        jdbcTemplate.update(createEmployeeQuery, namedParameters, keyHolder, new String[] {"id"});
        employees.setId(keyHolder.getKey().intValue());

        return employees.getId();
    }

    @Override
    public void updateEmployees(Employees employees) {
        Integer employeesId = employees.getId();
        if(employeesId == null) {
            return;
        }
        Employees existingEmployee = getEmployee(employeesId);
        if (existingEmployee == null) {
            throw new RuntimeException(
                    String.format("Employee with id {} does not exists", employees.getId()));
        }

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("salary", employees.getSalary());
        namedParameters.put("empId", employees.getId());
        namedParameters.put("name", employees.getName());

        jdbcTemplate.update(updateEmployeeQuery, namedParameters);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        Map<String, Integer> namedParameters = new HashMap<>();
        namedParameters.put("empId", empId);

        jdbcTemplate.update(deleteEmployeeQuery, namedParameters);
    }
}
