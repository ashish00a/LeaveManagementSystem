package com.hexaware.MLP185.persistence;

import com.hexaware.MLP185.model.Leave;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;


import java.util.Date;
import java.util.List;

/**
 * The DAO class for employee.
 */
public interface LeaveDAO {

  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM leave_details")
  @Mapper(LeaveMapper.class)
  List<Leave> list();
 /**
  * @param empId for employee.
  * @return for employee.
  */
  @SqlQuery("SELECT * FROM leave_details where EMP_ID = :empId")
  @Mapper(LeaveMapper.class)
  List<Leave> listByDupliEmp(@Bind("empId") int empId);
  /**
   * @param empId for employee.
   * @param sDate for employee.
   * @param eDate for employee.
   * @return for employee.
   */
  @SqlQuery("select * from leave_details where emp_id = :empId having applied_on >= :sDate"
      + " AND applied_on <= :eDate")
  @Mapper(LeaveMapper.class)
  List<Leave> listByLeaveHistory(@Bind("empId") int empId, @Bind("sDate") Date sDate, @Bind("eDate") Date eDate);
  /**
   * return all the details of the selected employee.
   * @param argEmpID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM leave_details WHERE EMP_ID = :empId")
  @Mapper(LeaveMapper.class)
  Leave find(@Bind("empId") int argEmpID);
/**
 * @param argEmpID for employee.
 * @return for employee.
 */
  @SqlQuery("SELECT * FROM leave_details WHERE leave_id= :empId")
  @Mapper(LeaveMapper.class)
  Leave leaveIdd(@Bind("empId") int argEmpID);

    /**
   * return all the details of all the employees.
   * @param leaveid th
   * @param p TH
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM  leave_details l INNER JOIN employee e ON"
      + " e.emp_id = l.emp_id where l.leave_status=:p AND mgr_id = :empid")
  @Mapper(LeaveMapper.class)
  List<Leave> list1(@Bind("empid") int leaveid, @Bind("p") String p);
  /**
   * for update start date.
   * @return the date
   * @param leaveid the id of employee
   */
 // @SqlQuery("SELECT emp_id FROM leave_details WHERE emp_id = :emp_id")
 // @Mapper(LeaveMapper.class)
 // Leave find(@Bind("emp_id") int leaveid);
   /**
   * for update start date.
   * @return the date
   * @param leaveid the id of employee
   */
  @SqlQuery("SELECT  * FROM leave_details WHERE LEAVE_ID= :leaveid ")
  @Mapper(LeaveMapper.class)
  Leave findleaveid(@Bind("leaveid") int leaveid);
  /**
   * @param leaveid of employee.
   * @return of employee.
   */
  @SqlQuery("SELECT NO_OF_DAYS FROM leave_details EMP_ID =:leavid")
  @Mapper(LeaveMapper.class)
  Leave findleaveidforapprove(@Bind("leaveid") int leaveid);

  /**
  * close with no args is used to close the connection.
    *@param appdeny the dat
    *@param lid the id
  */
  @SqlUpdate("UPDATE leave_details SET leave_status = :appdeny  where leave_id = :lid ")
  void updateapdeny(@Bind("appdeny") String appdeny, @Bind("lid") int lid);

/**
 * @param argEmpID for employee.
 * @return for employee.
 */
  @SqlQuery("SELECT * FROM leave_details WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveMapper.class)
  Leave leaveIddd(@Bind("leaveId") int argEmpID);
/**
 * @param argEmpID c/.
 * @param mgrid c.
 * @return c.
 */
  @SqlQuery("SELECT * FROM leave_details l , employee e WHERE l.LEAVE_ID = :leaveId AND e.mgr_id = :mgr")
  @Mapper(LeaveMapper.class)
  Leave leaveIddd1(@Bind("leaveId") int argEmpID, @Bind("mgr") int mgrid);


  /**
   * @param argLeaveType Type of leave.
   * @return Type of leave.
   */
  @SqlQuery("SELECT LEAVE_TYPE FROM leave_details WHERE EMP_ID = :empId")
  @Mapper(LeaveMapper.class)
  Leave leaveType(@Bind("leaveType") String argLeaveType);
/**
 * @param argLeaveStatus of employee.
 * @return leave status of employee.
 */
  @SqlQuery("SELECT LEAVE_STATUS FROM leave_details WHERE LEAVE_ID = :leaveId")
  @Mapper(LeaveMapper.class)
  Leave leaveStatus(@Bind("leaveId") String argLeaveStatus);
/**
 * @param empId for getting emp id.
 * @param nod for getting number of days.
 * @param sdate for getting starting date.
 * @param eDate for getting end date.
 * @param lvType for getting leave type.
 * @param lvStatus for getting leave status.
 * @param lReason for getting leave reason.
 * @param aDate for getting applied date.
 * @return for inserting data to leave_details table.
 */

 /**
  /**
  * close with no args is used to close the connection.
    *@param nsdate1 the date
    *@param sid the
  */
  @SqlUpdate("UPDATE leave_details SET START_DATE = :startdate  where leave_id = :sid")
  void updatesdate(@Bind("startdate") Date nsdate1, @Bind("sid") int sid);
   /**
  * close with no args is used to close the connection.
  *@param sid the
    *@param nsdate1 the date
    @return leave.
  */
  @SqlUpdate("UPDATE leave_details SET END_DATE = :enddate  where leave_id = :sid")
  int updateedate(@Bind("enddate") Date nsdate1, @Bind("sid") int sid);
/**
 * @param lType for leave.
 * @param sId for leave.
 */
  @SqlUpdate("UPDATE leave_details SET LEAVE_TYPE = :ltype where leave_id = :sid")
  void updateltype(@Bind("ltype") String lType, @Bind("sid") int sId);

    /**
  * close with no args is used to close the connection.
  *@param sid the
    *@param lreason the date
  */
  @SqlUpdate("UPDATE leave_details SET LEAVE_REASON = :lreason where leave_id = :sid")
  void updatelreason(@Bind("lreason") String lreason, @Bind("sid") int sid);

/**
 * @param empId for employee.
 * @param nod for employee.
 * @param sDate for employee.
 * @param eDate for employee.
 * @param lvType for employee.
 * @param lvStatus for employee.
 * @param lReason for employee.
 * @param aDate for employee.
 * @return for employee.
 */
  @SqlUpdate("insert into leave_details (EMP_ID, NO_OF_DAYS, START_DATE,"
      + "END_DATE, LEAVE_TYPE, LEAVE_STATUS, LEAVE_REASON, APPLIED_ON)"
      + "values(:empId, :nod, :sDate, :eDate, :lvType, :lvStatus, :lReason, :aDate)")
  @GetGeneratedKeys
  int applyLeave(@Bind("empId") int empId,
                        @Bind("nod") int nod,
                        @Bind("sDate") Date sDate,
                        @Bind("eDate") Date eDate,
                        @Bind("lvType") String lvType,
                        @Bind("lvStatus") String lvStatus,
                        @Bind("lReason") String lReason,
                        @Bind("aDate") Date aDate);

    /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE leave_details SET no_of_days = :nod where leave_id = :sid")
  void stnod(@Bind("nod") int nod, @Bind("sid") int sid);

   /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE leave_details SET no_of_days = :nod where leave_id = :sid")
  void stnod1(@Bind("nod") int nod, @Bind("sid") int sid);

   /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE leave_details SET leave_status = :nod where leave_id = :sid AND leave_status = 'P' ")
  void approved(@Bind("nod") String nod, @Bind("sid") int sid);
   /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE leave_details e SET leave_status = :nod where emp_id = :emp AND leave_status = 'P'")
  void approved1(@Bind("emp") int sid, @Bind("nod") String nod);
  /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE leave_details SET leave_status = :nod where leave_id = :sid AND leave_status = 'P' ")
  void denied(@Bind("nod") String nod, @Bind("sid") int sid);

/**
 * @param nod the date.
 * @param sid the date.

 */
  @SqlUpdate("UPDATE leave_details SET applied_on = :date where leave_id = :sid")
 void apply(@Bind("date") Date nod, @Bind("sid") int sid);

    /**
  * close with no args is used to close the connection.
  *@param sid the
  *@param nod the date
  */
  @SqlUpdate("UPDATE leave_details SET applied_on = :date where leave_id = :sid")
  void apply1(@Bind("date") Date nod, @Bind("sid") int sid);
  /** */
  void close();
}
