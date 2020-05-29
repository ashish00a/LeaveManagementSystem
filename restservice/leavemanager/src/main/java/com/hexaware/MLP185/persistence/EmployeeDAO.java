package com.hexaware.MLP185.persistence;

import com.hexaware.MLP185.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM employee")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

    /**
   * return all the details of all the employees.
   *@param argEmpID the id of the employee
   * @return the employee array
  @SqlQuery("SELECT emp_id FROM employee where emp_id =:id")
  @Mapper(EmployeeMapper.class)
  List<Employee> valid(@Bind("id")int argEmpID);
*/

  /**
   * return all the details of the selected employee.
   * @param argEmpID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM employee WHERE emp_id = :empId")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empId")int argEmpID);
  /**
   * return all the details of the selected employee.
   * @param argEmpID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM employee WHERE mgr_id = :empId")
  @Mapper(EmployeeMapper.class)
  Employee find1(@Bind("empId")int argEmpID);
/**
 * @param argEmpID the employee object.
 * @param mgrid the employee object.
 * @param leavid the employee object.
 * @return the employee object.
 */
  @SqlQuery("SELECT * FROM employee e leave_details l "
      + " WHERE e.emp_id = :empId AND e.mgr_id = :mgrid AND l.leave_id = :leavid")
  @Mapper(EmployeeMapper.class)
  Employee findforapprovedeny(@Bind("empId")int argEmpID, @Bind("mgrid")int mgrid, @Bind("leavid")int leavid);
  /**
   * for update start date.leavid.
   * @return the date.
   * @param p yh/.
   * @param leaveid the id of employee.
   */
  @SqlQuery("SELECT * FROM  employee e INNER JOIN leave_details l ON e.emp_id = l.emp_id where l.leave_status=:p")
  @Mapper(EmployeeMapper.class)
  List<Employee> list1(@Bind("empid") int leaveid, @Bind("p") String p);
 // Employee list1(@Bind("empid") int leaveid, @Bind("p") String p);

  /**
  * close with no args is used to close the connection.
  @SqlUpdate("SELECT * FROM employee_details WHERE EMP_ID = :empId")
  void close();*/

  /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE EMPLOYEE e, leave_details l SET avail_leave_bal = :nod"
        +  " where e.emp_id = l.emp_id AND l.leave_id=:p")
  void availBalaprove(@Bind("nod") int nod, @Bind("p") int sid);

  /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE EMPLOYEE e, leave_details l SET avail_leave_bal = :nod"
        + " where e.emp_id = l.emp_id AND l.leave_id=:p")
  void availBalaprove1(@Bind("nod") int nod, @Bind("p") int sid);
   /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE EMPLOYEE  SET avail_leave_bal = :nod  where emp_id = :p ")
  void updateEl(@Bind("nod") int nod, @Bind("p") int sid);
}
