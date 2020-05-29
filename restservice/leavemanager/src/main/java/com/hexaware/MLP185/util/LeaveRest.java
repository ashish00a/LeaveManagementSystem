package com.hexaware.MLP185.util;

import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP185.model.Leave;

/**
 * This class provides a REST interface for the leave entity.
 */
@Path("/leaves")
public class LeaveRest {
  /**
   * @return leave details.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Leave[] leaveList() {
    final Leave[] leave = Leave.listAll();
    return leave;
  }
    /**
     * @param endate   the string result.
     * @param newsdate the string result.
     * @param leaveId  the string result.
     * @return the string result.
     */
  @GET
    @Path("updateStartDate/{endDate}/{newSDate}/{leaveId}")
    public final String checkUpdateStartDate(@PathParam("endDate") final String endate,
      @PathParam("newSDate") final String newsdate, @PathParam("leaveId") final int leaveId) {
    final String result = Leave.updateStartdatecalc(endate, newsdate, leaveId);
    return result;
  }
    /**
     * @param endate   the string result.
     * @param newsdate the string result.
     * @param leaveId  the string result.
     * @return the string result.
     */
  @GET
    @Path("updateEnddatecalc/{endDate}/{newEDate}/{leaveId}")
    public final String checkUpdateEndDate(@PathParam("endDate") final String endate,
            @PathParam("newEDate") final String newsdate, @PathParam("leaveId") final int leaveId) {
    final String result = Leave.updateEnddatecalc(endate, newsdate, leaveId);
    return result;
  }

    /**
     * @param empIddd   the string result.
     * @param startdate the string result.
     * @param enddate   the string result.
     * @return the string result.
     */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("leaveHistory/{empId}/{startDate}/{endDate}")
    public final Leave[] listByLeaveHis(@PathParam("empId") final int empIddd,
            @PathParam("startDate") final String startdate, @PathParam("endDate") final String enddate) {
    final Leave[] leave = Leave.listByLeaveHis(empIddd, startdate, enddate);
    return leave;
  }

    /**
     * @param empid   the string result.
     * @param sdate   the string result.
     * @param edate   the string result.
     * @param ltype   the string result.
     * @param lresn   the string result.
     * @param manager the string result.
     * @return the string result.
     * @throws ParseException the.
     */
  @POST
    @Path("applyLeaveForManager/{empId}/{sDate}/{eDate}/{lType}/{lResn}/{mngr}")
    public final String applyLeavvalid1(@PathParam("empId") final int empid, @PathParam("sDate") final String sdate,
            @PathParam("eDate") final String edate, @PathParam("lType") final String ltype,
            @PathParam("lResn") final String lresn, @PathParam("mngr") final String manager) throws ParseException {
    final String result = Leave.applyLeavvalid1(empid, sdate, edate, ltype, lresn, manager);
    return result;
  }
/**
 * @param empid for employee.
 * @param sdate for employee.
 * @param edate for employee.
 * @param ltype for employee.
 * @param lresn for employee.
 * @param manager for employee.
 * @return for employee.
 * @throws ParseException for employee.
 */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
    @Path("applyLeaveForEmployee/{empId}/{sDate}/{eDate}/{lType}/{lResn}/{mngr}")
    public final String applyLeavvalid(@PathParam("empId") final int empid, @PathParam("sDate") final String sdate,
            @PathParam("eDate") final String edate, @PathParam("lType") final String ltype,
            @PathParam("lResn") final String lresn, @PathParam("mngr") final String manager) throws ParseException {
    final String result = Leave.applyLeavvalid(empid, sdate, edate, ltype, lresn, manager);
    return result;
  }
  /**
   * @param ltype of employee.
   * @param leaveid of employee.
   * @return of employee.
   */
  @POST
  @Path("updateLeaveType/{lType}/{leaveId}")
  public final String modeltype(@PathParam("lType") final String ltype,
      @PathParam("leaveId") final int leaveid) {
    final String result = Leave.modeltype(ltype, leaveid);
    return result;

  }
/**
 * @param empid for.
 * @param lstatus for.
 * @return for.
 */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pendingLeaves/{empId}/{lStatus}")
    public final Leave[] pendingLeaves(@PathParam("empId") final int empid,
            @PathParam("lStatus") final String lstatus) {
    final Leave[] leave = Leave.listAll1(empid, lstatus);
    return leave;
  }
  /**
 * @param leaveId for.
 * @param managerId for.
 * @param option for.
 * @return for.
 */
  @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("approveDeny/{leaveId}/{managerId}/{option}")
    public final String appdenyfun(@PathParam("leaveId") final int leaveId,
            @PathParam("managerId") final int managerId, @PathParam("option") final int option) {
    final String li = Leave.appdenyfun(leaveId, managerId, option);
    return li;
  }
  /**
 * @param lid for.
 * @return for.
 */
  @GET
  @Path("/leaveId/{lid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Leave listByLeaveIdd(@PathParam("lid") final int lid) {
    Leave leave = Leave.listByLeaveIdd(lid);
    return leave;
  }

}
