package com.hexaware.MLP185.model;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.hexaware.MLP185.persistence.DbConnection;
import com.hexaware.MLP185.persistence.LeaveDAO;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

import java.util.concurrent.TimeUnit;



/**

 * Leave class.

 */

public class Leave {

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
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Leave lea = (Leave) obj;
    if (Objects.equals(empId, lea.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }

/**

 * @return Leave Id.

 */

  public final int getLeaveId() {

    return leaveId;

  }

/**

 * @param argLeaveId for setting leaveId.

 */

  public final void setLeaveId(final int argLeaveId) {

    this.leaveId = argLeaveId;

  }

/**

 * @return employee Id.

 */

  public final int getEmpId() {

    return empId;

  }

/**

 * @param argEmpId for employee.

 */

  public final void setEmpId(final int argEmpId) {

    this.empId = argEmpId;

  }

/**

 * @return No of Days.

 */

  public final int getNumOfDays() {

    return numOfDays;

  }

/**

 * @param argNumOfDays of employee.

 */

  public final void setNumOfDays(final int argNumOfDays) {

    this.numOfDays = argNumOfDays;

  }

/**

 * @return start date

 */

  public final String getStartDate() {

    return startDate;

  }

/**

 * @param argStartDate as start date of taking leave.

 */

  public final void setStartDate(final String argStartDate) {

    this.startDate = argStartDate;

  }

/**

 * @return end date.

 */

  public final String getEndDate() {

    return endDate;

  }

/**

 * @param argEndDate for leave.

 */

  public final void setEndDate(final String argEndDate) {

    this.endDate = argEndDate;

  }

 /**

  * @return for leave.

  */

  public final String getLeaveType() {

    return leaveType;

  }

/**

 * @param argLeaveType for employee.

 */
  public final void setLeaveType(final String argLeaveType) {

    this.leaveType = argLeaveType;

  }

/**

 * @return leave status.

 */

  public final String getLeaveStatus() {

    return leaveStatus;

  }

/**

 * @param argLeaveStatus of employee.

 */

  public final void setLeaveStatus(final String argLeaveStatus) {

    this.leaveStatus = argLeaveStatus;

  }

/**

 * @return leave reason.

 */

  public final String getLeaveReason() {

    return leaveReason;

  }

/**

 * @param argLeaveReason for taking leave.

 */

  public final void setLeaveReason(final String argLeaveReason) {

    this.leaveReason = argLeaveReason;

  }

/**

 * @return Leave applied on.

 */

  public final Date getAppliedOn() {

    return appliedOn;

  }

/**

 * @param argAppliedOn leave.

 */

  public final void setAppliedOn(final Date argAppliedOn) {

    this.appliedOn = argAppliedOn;

  }

/**

 * @return manager comment.

 */

  public final  String getManagerComment() {

    return managerComment;

  }

/**

 * @param argManagerComment for leave.

 */

  public final void setManagerComment(final String argManagerComment) {

    this.managerComment = argManagerComment;

  }

/**

 * @param argEmpId for employee.

 * @param argStartDate starting date.

 * @param argEndDate end date.

 * @param argLeaveStatus leave status.

 * @param argLeaveReason leave reason.

 * @param argAppliedOn applied on.

 * @param argManagerComment manager comment.

 */

  public Leave(final int argEmpId,

      final String argStartDate, final String argEndDate, final String argLeaveStatus,

      final String argLeaveReason, final Date argAppliedOn, final String argManagerComment) {

    this.empId = argEmpId;

    this.startDate = argStartDate;

    this.endDate = argEndDate;

    this.leaveStatus = argLeaveStatus;

    this.leaveReason = argLeaveReason;

    this.appliedOn = argAppliedOn;

    this.managerComment = argManagerComment;

  }

/**

 * constructor.

*/



  public Leave() {

  }

  /**

   * The dao for employee.

   */

  private static LeaveDAO dao() {

    final DbConnection db = new DbConnection();

    return db.getConnect().onDemand(LeaveDAO.class);

  }



  /**

   * list all employee details.

   * @return all employees' details

   */

  public static Leave[] listAll() {



    final List<Leave> es = dao().list();

    return es.toArray(new Leave[es.size()]);

  }
    /**
   * @param empId id to get employee leave id.
   * @return Leave ID
   */
  public static Leave listById(final int empId) {

    return dao().find(empId);
  }
     /**
   * @param empId id to get employee leave id.
   * @return Leave ID
   */
  public static Leave listByIdf(final int empId) {

    return dao().findleaveid(empId);
  }
/**
 * @param empIdddd for employee.
 * @return for employee.
 */

  public static Leave[] listByDupliEmpDetails(final int empIdddd) {

    final List<Leave> es1 = dao().listByDupliEmp(empIdddd);

    return es1.toArray(new Leave[es1.size()]);

  }
  /**
   * @param empIddd for employee.
   * @param startDate for employee.
   * @param endDate for employee.
   * @return for employee.
   */
  public static Leave[] listByLeaveHis(final int empIddd, final String startDate, final String endDate) {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    Date sDate = null;
    Date eDate = null;
    try {
      sDate = sdf.parse(startDate);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      eDate = sdf.parse(endDate);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    final List<Leave> es2 = dao().listByLeaveHistory(empIddd, sDate, eDate);

    return es2.toArray(new Leave[es2.size()]);

  }
  /**
   * @param leaveType for taking leave.
   * @return leave type.
   */
  public static Leave listByLeaveType(final String leaveType) {

    return dao().leaveType(leaveType);

  }
/**
 * @param leaveId of employees.
 * @return leave id of employees.
 */
  public static Leave listByLeaveId(final int leaveId) {

    return dao().leaveIdd(leaveId);
  }

  /**
 * @param leaveId of employees.
 * @return leave id of employees.
 */
  public static Leave listByLeaveIdd(final int leaveId) {

    return dao().leaveIddd(leaveId);
  }




/**
 * @param empId for employee.
 * @param nod for employee.
 * @param sDate for employee.
 * @param eDate for employee.
 * @param lvType for employee.
 * @param leaveStatus for employee.
 * @param lvReason for employee.
 * @param aDate for employee.
 * @param mComment for employee.
 * @return for employee.
 */
  public static String insertingNewLeave(final int empId,
      final int nod, final Date sDate,
       final Date eDate, final String lvType, final String leaveStatus,
       final String lvReason, final Date aDate, final String mComment) {
    int id = dao().applyLeave(empId, nod, sDate, eDate, lvType, leaveStatus,
        lvReason, aDate);
    return "You have Applied for " + nod + " leaves and your Leave ID is : " + id;
  }
/**
 * @param leaveStatus for employee.
 * @return for employee.
 */
  public static Leave listByLeaveStatus(final String leaveStatus) {

    return dao().leaveStatus(leaveStatus);
  }
  /**

   * @return To string.

   */
 /**
   * list employee details by id.
   * @param nsdate1 id to get employee details.
   * @param sid id
   * @return Employee
   */
  public static String modstdate(final Date nsdate1, final int sid) {
    Leave l = Leave.listByLeaveId(sid);
    if (l != null) {
      dao().updatesdate(nsdate1, sid);
      return "Start date Updated!!!";
    } else {
      return "Leave id not found...";
    }

  }
  /**
   * list employee details by id.
   * @param nddate1 id to get employee details.
   * @param sid id
   * @return Employee
   */
  public static String modendate(final Date nddate1, final int sid) {
    Leave l = Leave.listByLeaveId(sid);
    if (l != null) {
      int leaveId = dao().updateedate(nddate1, sid);
      return "End date Updated!!!" + leaveId;
    } else {
      return "Leave id not found...";
    }
  }
   /**
   * list employee details by id.
   * @param ltype id to get employee details.
   * @param sid id
   * @return Employee
   */
  public static String modeltype(final String ltype, final int sid) {
    dao().updateltype(ltype, sid);
    return "Leave type Updated!!!";
  }
   /**
   * list employee details by id.
   * @param lreason id to get employee details.
   * @param sid id
   * @return Employee
   */
  public static String modelreason(final String lreason, final int sid) {
    dao().updatelreason(lreason, sid);
    return "Leave reason Updated!!!";
  }
/**
 * @param argLeaveId of employee.
 */
  public Leave(final int argLeaveId) {
    this.empId = argLeaveId;
  }


/**
 * @return to have leave details.
 */

  public final String toString() {
    return leaveId + "\t" + empId + "\t" + numOfDays + "\t"

      + startDate + "\t" + endDate + "\t" + leaveType + "\t" + leaveStatus + "\t"

      + leaveReason + "\t" + appliedOn + "\t" + managerComment;

  }
/**
 * @param startd1 for employee.
 * @param leavId for employee.
 */
  public static void appliedon(final Date startd1, final int leavId) {
    dao().apply(startd1, leavId);
  }
  /**
   * @param nod for employee.
   * @param leavId for employee.
   */
  public static void upnodays(final int nod, final int leavId) {
    dao().stnod1(nod, leavId);
  }
/**
 * @param lid for employee.
 * @param p for employee.
 * @return for employee.
 */
  public static Leave[] listAll1(final int lid, final String p) {
    final List<Leave> es = dao().list1(lid, p);

    return es.toArray(new Leave[es.size()]);

  }
/**
 * @param app for employee.
 * @param apid for employee.
 * @return for employee.
 */
  public static int applyDeny(final String app, final int apid) {

    dao().denied(app, apid);
    return 1;
  }
/**
 * @param app for employee.
 * @param apid for employee.
 * @return for employee.
 */
  public static int applyApprove(final String app, final int apid) {
    dao().approved(app, apid);
    return 1;
  }
  /**
 * @param app for employee.
 * @param apid1 for employee.
 * @return for employee.
 */
  public static int applyApproveformanager(final int apid1, final String app) {
    dao().approved1(apid1, app);
    return 1;
  }
/**
 * @param endd1 for employee.
 * @param elid for employee.
 * @return for employee.
 */
  public static int appliedon1(final Date endd1, final int elid) {
    dao().apply(endd1, elid);
    return 1;
  }
/**
 * @param nod for employee.
 * @param sid for employee.
 * @return for employee.
 */
  public static int upnodays1(final int nod, final int sid) {
    dao().stnod1(nod, sid);
    return 1;
  }

  /**
   *@param endate dc.
   *@param newsdate sx.
   *@param leaveId cs.
   *@return s.
   */
  public static String updateStartdatecalc(final String endate, final String newsdate,  final int leaveId) {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    final Date curdate = new Date();
    Date startd1 = null;
    Date startd2 = null;
    try {
      startd1 = sdf.parse(newsdate);
      startd2 = sdf.parse(endate);
      //System.out.println(startd1);
      //System.out.println(startd2);
      long diffinmillis = Math.abs(startd2.getTime() - startd1.getTime());
      //System.out.println(diffinmillis);
      long diff = TimeUnit.DAYS.convert(diffinmillis, TimeUnit.MILLISECONDS) + 1;
      DateFormat df = DateFormat.getDateInstance();
      Date cd = df.parse(df.format(curdate));
      //System.out.println(diff);
      int nod1 = (int) diff;
      //System.out.println(startd1);
      //System.out.println(startd2);
      //System.out.println(cd.getTime());
      if (startd1.getTime() <= cd.getTime() || startd1.getTime() >= startd2.getTime()) {
        return "wrong date entered";
      } else {
          //final String newstartdate = sdf.format(startd1);
          //System.out.println(newstartdate);
        Leave leave = Leave.listByLeaveId(leaveId);
        if (leave != null) {
          appliedon(curdate, leaveId);
          Leave.modstdate(startd1, leaveId);
          Leave.upnodays(nod1, leaveId);
          return "The date has been modified\n Press 1 to continue.do you wish to continue (y/n)";
        } else {
          return "Invalid Leave Id";
        }
      }
    } catch (final ParseException e) {
      return "Enter valid format";
    }
  }
      //System.out.println(nod1);
      //System.out.println(startd1.getTime());
      //System.out.println(cd.getTime());
      //System.out.println(startd1.getTime() <= cd.getTime());

       // System.out.println("no of days" + nod1);
   //System.out.println("no of days" + nod);
        //System.out.println();

    /**
   *@param esdate1 dc.
   *@param newedate1 sx.
   *@param leavId1 cs.
   *@return s.
   */
  public static String updateEnddatecalc(final String esdate1, final String newedate1,  final int leavId1) {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    final Date curdate = new Date();
    Date startd11 = null;
    Date startd22 = null;
    try {
      startd11 = sdf.parse(newedate1);
      startd22 = sdf.parse(esdate1);
      //System.out.println(startd11);
      //System.out.println(startd22);
      long diffinmillis = Math.abs(startd11.getTime() - startd22.getTime());
      //System.out.println(diffinmillis);
      long diff = TimeUnit.DAYS.convert(diffinmillis, TimeUnit.MILLISECONDS) + 1;
      //DateFormat df = DateFormat.getDateInstance();
      //Date cd = df.parse(df.format(curdate));
      //System.out.println(diff);
      int nod1 = (int) diff;
      //System.out.println(nod1);
    //  System.out.println(startd11.getTime());
     // System.out.println(cd.getTime());
     // System.out.println(startd11.getTime() <= cd.getTime());
      if (startd11.getTime() <= startd22.getTime()) {
        return "Date should not be the same or less than the applied date";
      } else {
        final String newstartdate = sdf.format(startd22);
        System.out.println(newstartdate);
        Leave leave = Leave.listByLeaveId(leavId1);
        if (leave != null) {
          appliedon1(curdate, leavId1);
          Leave.modendate(startd11, leavId1);
          Leave.upnodays1(nod1, leavId1);
          System.out.println("no of days" + nod1);
   //System.out.println("no of days" + nod);
          return "The End date has been modified\ndo you wish to continue (y/n)";
        } else {
          return "Invalid Leave Id";
        }
      }
    } catch (final ParseException e) {
      return "Enter valid format";
    }
  }
   /**
   *@param empid dc.
   *@param sdate dc.
   *@param edate sx.
   *@param ltype cv.
   *@param lresn cv.
   *@param manager es.
   *@throws ParseException for exception.
   *@return s.
   */
  public static String applyLeavvalid(final int empid, final String sdate, final String edate,
       final String ltype, final String lresn, final String manager) throws ParseException {
    int timeDiff = 0;
    Date d1 = null;
    String leaveStatus = "P";
    Date d2 = null;
    String managerComment = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //Date currDate = new Date(); //for current date

    try {
      d1 = sdf.parse(sdate);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      return "Enter valid Start Date";
    }
    Date cd1 = new Date();
    DateFormat df = DateFormat.getDateInstance();
    Date cd = null;
    //System.out.println(d1);
    try {
      d2 = sdf.parse(edate);
      cd = df.parse(df.format(cd1));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      return "Enter valid End Date";
    }
    Leave[] sv = Leave.listByDupliEmpDetails(empid);
    System.out.println(sv);
    for (Leave s :sv) {
      if (d1.getTime() >= sdf.parse(s.getStartDate()).getTime() && d1.getTime() <= sdf.parse(s.getEndDate()).getTime()
          || d2.getTime() >=  sdf.parse(s.getStartDate()).getTime()
          && d2.getTime() <= sdf.parse(s.getEndDate()).getTime()
      ) {
        return "ALREADY APPLIED ON THIS DATE";
      }
    }

    if (d1.getTime() >= cd.getTime() && d2.getTime() >= d1.getTime()) {
      long diffInMillis = Math.abs(d2.getTime() - d1.getTime());
      long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS) + 1;
      timeDiff = (int) diff;
      Employee a = Employee.listById(empid);
      if (a != null) {
        if (a.getLeaveBal() <= timeDiff) {
          return "NO SUFFICIENT BALANCE";
        }
        String result = Leave.insertingNewLeave(empid, timeDiff, d1, d2, ltype, leaveStatus, lresn,
             cd, managerComment);
        System.out.println(result);
        return "*********PLEASE REMEMBER THE LEAVE ID FOR CHECKING FURTHER STATUS***********";
      }
    }
    return "Please Enter valid details.";
  }
   /**
   * list employee details by id.
   * @param id id
   * @return Employee

  public static String validateLeave(final int id) {
    Leave l = new Leave();
    String l1 = Leave.listByLeaveId(id);
    if (l == null) {
      //System.out.println();
      return "Sorry, No such LEAVE ID";
    } else {
      System.out.println(l);
    //dao().valid(id);
      return l;
    }
  }
  */
/**
 * @param empid c.
 * @param sdate c.
 * @param edate c.
 * @param ltype c.
 * @param lresn c.
 * @param manager c.
 * @return c.
 * @throws ParseException  c.
 */
  public static String applyLeavvalid1(final int empid, final String sdate, final String edate,
      final String ltype, final String lresn, final String manager) throws ParseException {
    int timeDiff = 0;
    Date d11 = null;
    String leaveStatus = "A";
    Date d22 = null;
    String managerComment = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date currDate = new Date(); //for current date
    try {
      d11 = sdf.parse(sdate);
    } catch (ParseException e) {
 // TODO Auto-generated catch block
     // e.printStackTrace();
      return "Enter valid Start Date";
    }
    try {
      d22 = sdf.parse(edate);
    } catch (ParseException e) {
 // TODO Auto-generated catch block
     // e.printStackTrace();
      return "Enter valid End Date";
    }
//d1 = null;
//d2 = null;
//Date currDate = new Date(); //for current date

    if (d11.getTime() >= currDate.getTime() && d22.getTime() >= d11.getTime()) {
      long diffInMillis = Math.abs(d22.getTime() - d11.getTime());
      long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS) + 1;
      timeDiff = (int) diff;
      Leave epid = Leave.listById(empid);
      Employee epid1 = Employee.listById(empid);
      if (epid != null) {
        if (epid1.getLeaveBal() <= timeDiff) {
          return "NO SUFFICIENT BALANCE";
        }
        Leave[] sv = Leave.listByDupliEmpDetails(empid);
        System.out.println(sv);
        for (Leave s :sv) {
          if (d11.getTime() >= sdf.parse(s.getStartDate()).getTime()
              && d11.getTime() <= sdf.parse(s.getEndDate()).getTime()
              || d22.getTime() >=  sdf.parse(s.getStartDate()).getTime()
              && d22.getTime() <= sdf.parse(s.getEndDate()).getTime()
          ) {
            return "ALREADY APPLIED ON THIS DATE";
          }
        }

        Leave.insertingNewLeave(empid, timeDiff, d11, d22, ltype, leaveStatus, lresn,
            currDate, managerComment);
            //////////////////////////////////////
       // System.out.println("" + result);
        int nodforapr = epid.getNumOfDays();
        System.out.println(nodforapr);
        int ap = epid1.getLeaveBal();
        System.out.println(ap);
        int newavbal = ap - nodforapr;
        if (newavbal <= 0) {
          return "YOU CANT APPROVE HIM LEAVE  AS HIS LEAVE BALANCE IS INSUFFICIENT";
        } else {
         // Leave e = new Leave();
          int a = epid.getLeaveId();
          //System.out.println(");
          //Leave.applyApprove(app1, apid);
          Employee.upnodaysafteraprove1(newavbal, a);
          return "The total Available leave balance left for the employee having : " + "\n"
              + newavbal + "\n"
              + "*********PLEASE REMEMBER THE LEAVE ID FOR CHECKING FURTHER STATUS***********";
        }
        //System.out.println("Please enter correct date.");
      }
     // return "manager auto updating the available leave balance";
    }
    return "timeDiff";
  }
// /**
//  * @param leavId x.
//  * @return x.
//  */
//   public static String validateLeave(final int leavId) {
//     final Leave leave = Leave.listByLeaveIdd(leavId);
//     if (leave == null) {
//       //System.out.println();
//       return "Sorry, No such LEAVE ID";
//     } else {
//       return "Valid Leave ID";
//     }

//   }
/**
 * @param leavid c.
 * @param optio c.
 * @param mgrid c.
 * @return c.
 */
  public static String appdenyfun(final int leavid, final int mgrid, final int optio) {
    final Leave li = Leave.listByIdf(leavid);
    System.out.println(li);
    if (li != null) {
      int eid = li.getEmpId();
      Employee emp = Employee.listById(eid);
      int mgrID = emp.getMgrId();
      if (mgrID == mgrid) {
        if (optio == 1) {
          String approv = "A";
          int nodforapr = li.getNumOfDays();
          System.out.println(nodforapr);
          Employee employee = Employee.listById1(mgrid);
          int epleavebal = employee.getLeaveBal();
          System.out.println(epleavebal);
          int newavbal = epleavebal - nodforapr;
          if (newavbal <= 0) {
            return "YOU CANT APPROVE HIM LEAVE  AS HIS LEAVE BALANCE IS INSUFFICIENT";
          } else {
            Leave.applyApprove(approv, leavid);
            Employee.upnodaysafteraprove(newavbal, leavid);
            return "The total Available leave balance left for the employee :" + newavbal;
          }
        }
        if (optio == 2) {
          String rej = "R";
          Leave.applyDeny(rej, leavid);
          return "You have succesfully updated the leave status";
        }
        if (optio != 1 && optio != 2) {
          return "enter the correct value : ";
        }
      } else {
        return "you are not authorised to do this";
      }
    }
    return "Please enter valid Leave id";
  }
}
