package com.hexaware.MLP185.model;
import java.util.List;
import java.util.Objects;

import com.hexaware.MLP185.persistence.DbConnection;
import com.hexaware.MLP185.persistence.EmployeeDAO;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;
  private String fullName;
  private String emailId;
  private String mobNo;
  private String doj;
  private String empDpt;
  private int leaveBal;
  private int mgrId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
/**
 * Default constructor.
 */
  public Employee() {
  }

/**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    final DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    final List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }
  /**
   * list all employee details.
   * @param lid i.
   * @param p i
   * @return all employees' details
   */
  public static Employee[] listAll1(final int lid, final String p) {
    final List<Employee> es = dao().list1(lid, p);
    return es.toArray(new Employee[es.size()]);
  }
/**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById1(final int empID) {
    return dao().find1(empID);
  }
  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
/**
 * @param empID Employee.
 * @param mgrId Employee.
 * @param leavid Employee.
 * @return Employee.
 */
  public static Employee listByIdforapp(final int empID, final int mgrId, final int leavid) {
    return dao().findforapprovedeny(empID, mgrId, leavid);
  }



  /**
   * @return No of Days.
   */
  public final String getFullName() {
    return fullName;
  }

  /**
   * @param argFullname for employee.
   */
  public final void setFullName(final String argFullname) {
    this.fullName = argFullname;
  }

  /**
   * @return No of Days.
   */
  public final String getEmailId() {
    return emailId;
  }

  /**
   * @param argEmailid for employee.
   */
  public final void setEmailId(final String argEmailid) {
    this.emailId = argEmailid;
  }

  /**
   * @return No of Days.
   */
  public final String getMobNo() {
    return mobNo;
  }

  /**
   * @param argMobno for employee.
   */
  public final void setMobNo(final String argMobno) {
    this.mobNo = argMobno;
  }

  /**
   * @return No of Days.
   */
  public final String getDoj() {
    return doj;
  }

  /**
   * @param argDoj for employee.
   */
  public final void setDoj(final String argDoj) {
    this.doj = argDoj;
  }

  /**
   * @return No of Days.
   */
  public final String getEmpDpt() {
    return empDpt;
  }

  /**
   * @param argEmpdpt for employee.
   */
  public final void setEmpDpt(final String argEmpdpt) {
    this.empDpt = argEmpdpt;
  }

  /**
   * @return No of Days.
   */
  public final int getLeaveBal() {
    return leaveBal;
  }

  /**
   * @param argLeavebal for employee.
   */
  public final void setLeaveBal(final int argLeavebal) {
    this.leaveBal = argLeavebal;
  }

  /**
   * @return No of Days.
   */
  public final int getMgrId() {
    return mgrId;
  }

  /**
   * list employee details by id.
   * @param appid id
   * @param id id
   * @return Employee
   */
  public static String upnodaysafteraprove(final int appid, final int id) {
    dao().availBalaprove(appid, id);
    return "Apply/De Updated!!!";
  }
  /**
   * list employee details by id.
   * @param id id
   * @return Employee
   */
  /*public static String validateEmployee(final int id) {
    Employee employee = Employee.listById(id);
    if (employee == null) {
      return "Sorry, No such employee";

    } else {
      return "The Following are the EMPLOYEE Details " + "\n" +  employee;
    }
    //dao().valid(id);

  }*/
  /**
   * list employee details by id.
   * @param appid id
   * @param id id
   * @return Employee
   */
  public static String upnodaysafteraprove1(final int appid, final int id) {
    dao().availBalaprove1(appid, id);
    return "Apply/De Updated!!!";
  }
/**
   * list employee details by id.
   * @param appid j.
   * @param id id
   * @return Employee
   */
  public static String eltoZero(final int appid, final int id) {
    dao().updateEl(appid, id);
    return "EL Updated!!!";
  }

  /**
   * @param argMgrid for employee.
   */
  public final void setMgrId(final int argMgrid) {
    this.mgrId = argMgrid;
  }
  /**
   *  * list employee details by id.
   * @param leavID id to get employee details.
   * @param p yh/.
   * @return Employee
  public static Employee listByleaveId1(final int leavID, final String p) {
    return dao().findleaveid1(leavID, p);
  }
    */
  /**
   * list all employee details.
   * @return all leave id details
   */
  public static Leave[] listAllpending() {

    final List<Employee> se = dao().list();
    return se.toArray(new Leave[se.size()]);
  }


  /**
   * @return To string.
   */
  public final String toString() {
    return empId + "\t" + fullName + "\t" + emailId + "\t" + mobNo
      + "\t" + doj + "\t" + empDpt + "\t" + leaveBal + "\t" + mgrId;
  }
/**
 * @param argEmpId of employee.
 * @param argEmailId of employee.
 * @param argFullName of employee.
 * @param argMobNo of employee.
 * @param argDoj of employee.
 * @param argEmployeeDept of employee.
 * @param argLeaveBal of employee.
 * @param argManagerId of employee.
 */
  public Employee(final int argEmpId, final String argEmailId, final String argFullName,

      final String argMobNo, final String argDoj, final String argEmployeeDept,

      final int argLeaveBal, final int argManagerId) {

    this.empId = argEmpId;

    this.fullName = argFullName;

    this.emailId = argEmailId;

    this.mobNo = argMobNo;

    this.doj = argDoj;

    this.empDpt = argEmployeeDept;

    this.leaveBal = argLeaveBal;

    this.mgrId = argManagerId;

  }
/**

 * @param mgrid2 c.
 * @return c.
  public static String validateManager(final int mgrid2) {
    Employee employee = Employee.listById1(mgrid2);
    if (employee == null) {
      return  "Sorry, No such Manager";

    }
    return "The Following are the EMPLOYEE Details " + "\n" +  employee;
  }
*/
}
