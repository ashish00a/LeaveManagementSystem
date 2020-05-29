package com.hexaware.MLP185.integration.test;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class CommonUtil {
  /**
   * host to store host.
   */
  public static final String host;
  /**
   * port to store port.
   */
  public static final String port;
  /**
   * webapp to store webapp.
   */
  public static final String webapp;
  /**
   * uri_prefix to store uri_prefix.
   */
  public static final String uri_prefix;
  static {
    host = System.getProperty("service.host", "localhost");
    port = System.getProperty("service.port", "8080");
    webapp = System.getProperty("service.webapp", "SNAPSHOT");
    uri_prefix = "http://" + host + ":" + port + "/" + webapp;
  }
   /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws URISyntaxException for exception.
   * @param path for path.
   * @return for rest assured.
   */
  public static URI getURI(final String path) throws URISyntaxException {
    return new URI(uri_prefix + path);
  }
}
/**
 * Employee class to store employee personal details.
 * @author hexaware
 */
class Employee {


  /**
   * empId to store employee id.
   */
  private int empId;
  /**
   * fullName to store fullname.
   */
  private String fullName;
  /**
   * emailId to store email id.
   */
  private String emailId;
  /**
   * mobileNumber to store mobile number.
   */
  private String mobNo;
  /**
   * dateOfJoining to store date of joining.
   */
  private Date doj;
  /**
   * department to store department name.
   */
  private String empDpt;
  /**
   * elBal to store available e leave balance.
   */
  private int leaveBal;

  /**
   * mgrId to store manager id.
   */
  private int mgrId;


  /**
   * empty constructor.
   */
  Employee() {
  }

  /**
   * @param argempId to initialize employee id.
   * @param argfullName to fullName.
   * @param argemailId to emailId.
   * @param argmobileNumber to mobno.
   * @param argdateOfJoining to doj.
   * @param argdepartment to dept.
   * @param argelBal to el bal.
   * @param argmlBal to ml bal.
   * @param argslBal to sl bal.
   * @param argmgrId to manager id.
   * @param arggender to gender.
   */
  Employee(final int argempId,
                       final String argfullName,
                        final String argemailId,
                         final String argmobileNumber,
      final Date argdateOfJoining,
       final String argdepartment,
       final int argelBal,
       final int argmlBal,
       final int argslBal,
        final int argmgrId,
         final String arggender) {
    this.empId = argempId;
    this.fullName = argfullName;
    this.emailId = argemailId;
    this.mobNo = argmobileNumber;
    this.doj = argdateOfJoining;
    this.empDpt = argdepartment;
    this.leaveBal = argelBal;
    this.mgrId = argmgrId;
  }
/**
 * v.
 * @return  v.
 */
  public int getEmpId() {
    return empId;
  }
/**
 * c.
 * @param empId c.
 */
  public void setEmpId(int empId) {
    this.empId = empId;
  }
/**
 * c.
 * @return fullname
 */
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
/**
 * c.
 * @return fullname
 */
  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
/**
 * c.
 * @return fullname
 */
  public String getMobNo() {
    return mobNo;
  }

  public void setMobNo(String mobNo) {
    this.mobNo = mobNo;
  }
/**
 * c.
 * @return fullname
 */
  public Date getDoj() {
    return doj;
  }

  public void setDoj(Date doj) {
    this.doj = doj;
  }
/**
 * c.
 * @return fullname
 */
  public String getEmpDpt() {
    return empDpt;
  }

  public void setEmpDpt(String empDpt) {
    this.empDpt = empDpt;
  }
/**
 * c.
 * @return fullname
 */
  public int getLeaveBal() {
    return leaveBal;
  }

  public void setLeaveBal(int leaveBal) {
    this.leaveBal = leaveBal;
  }
/**
 * c.
 * @return fullname
 */
  public int getMgrId() {
    return mgrId;
  }
  /**
   * @param mgrId of.
   */
  public void setMgrId(final int mgrId) {
    this.mgrId = mgrId;
  }
}
/**
 * Leave class to store employee leave details.
 *
 * @author hexaware
 */
class Leave {
  private int leaveId;

  private int empId;

  private int numOfDays;

  private String startDate;

  private String endDate;

  private String leaveType;

  private String leaveStatus;

  private String leaveReason;

  private Date appliedOn;

  private String managerComment;
  /**
   * Empty constructor.
   */
  Leave() {

  }
/**
   * constructer for Leave class.
   * @param argLeaveId to leave id.
   * @param argEmpId to set employee id.
   * @param argNoOfDays to noofdays.
   * @param argStartDate to set start date.
   * @param argEndDate to set end date.
   * @param argLeaveType to set leave type.
   * @param argLeavestatus for leave status.
   * @param argLeaveReason to set leave reason.
   * @param argAppliedOn to set leave reason.
   * @param argManagercomment to mcom.
   */
  Leave(
                final int argLeaveId,
                final int argEmpId,
                final int argNoOfDays,
                final String argStartDate,
                final String argEndDate,
                final String argLeaveType,
                final String argLeavestatus,
                final String argLeaveReason,
                final Date argAppliedOn,
                final String argManagercomment)     {
    this.leaveId = argLeaveId;
    this.empId = argEmpId;
    this.numOfDays = argNoOfDays;
    this.startDate = argStartDate;
    this.endDate = argEndDate;
    this.leaveType = argLeaveType;
    this.leaveStatus = argLeavestatus;
    this.leaveReason = argLeaveReason;
    this.appliedOn = argAppliedOn;
    this.managerComment = argManagercomment;

  }
/**
 * c.
 * @return fullname
 */
  public int getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(int leaveId) {
    this.leaveId = leaveId;
  }
/**
 * c.
 * @return fullname
 */
  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public int getNumOfDays() {
    return numOfDays;
  }

  public void setNumOfDays(int numOfDays) {
    this.numOfDays = numOfDays;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(String leaveType) {
    this.leaveType = leaveType;
  }

  public String getLeaveStatus() {
    return leaveStatus;
  }

  public void setLeaveStatus(String leaveStatus) {
    this.leaveStatus = leaveStatus;
  }

  public String getLeaveReason() {
    return leaveReason;
  }
  /**
   * 
   * @param leaveReason
   */
  public void setLeaveReason(String leaveReason) {
    this.leaveReason = leaveReason;
  }

  public Date getAppliedOn() {
    return appliedOn;
  }

  public void setAppliedOn(Date appliedOn) {
    this.appliedOn = appliedOn;
  }

  public String getManagerComment() {
    return managerComment;
  }
/**
 * @param managerComment of.
 */
  public void setManagerComment(final String managerComment) {
    this.managerComment = managerComment;
  }

}
