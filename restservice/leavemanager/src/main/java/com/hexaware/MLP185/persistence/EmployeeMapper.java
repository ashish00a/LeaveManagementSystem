package com.hexaware.MLP185.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.MLP185.model.Employee;

/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
  /**
   * @param idx     the index
   * @param rs      the resultset
   * @param ctx     the context
   * @param emailId
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    Employee emp = new Employee();
    emp.setEmpId(rs.getInt("EMP_ID"));
    emp.setFullName(rs.getString("FULLNAME"));
    emp.setEmailId(rs.getString("EMAIL_ID"));
    emp.setMobNo(rs.getString("MOB_NUMBER"));
    emp.setDoj(rs.getString("DOJ"));
    emp.setEmpDpt(rs.getString("DEPARTMENT"));
    emp.setLeaveBal(rs.getInt("AVAIL_LEAVE_BAL"));
    emp.setMgrId(rs.getInt("MGR_ID"));
    return emp;
  }
}

