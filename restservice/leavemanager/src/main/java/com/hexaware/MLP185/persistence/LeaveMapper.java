package com.hexaware.MLP185.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.MLP185.model.Leave;
/**
 * Mapper class to map from result set to employee object.
 */
public class LeaveMapper implements ResultSetMapper<Leave> {
  /**
   * @param idx     the index
   * @param rs      the resultset
   * @param ctx     the context
   * @param leaveId
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Leave map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    Leave lv = new Leave();
    lv.setLeaveId(rs.getInt("LEAVE_ID"));
    lv.setEmpId(rs.getInt("EMP_ID"));
    lv.setNumOfDays(rs.getInt("NO_OF_DAYS"));
    lv.setStartDate(rs.getString("START_DATE"));
    lv.setEndDate(rs.getString("END_DATE"));
    lv.setLeaveType(rs.getString("LEAVE_TYPE"));
    lv.setLeaveStatus(rs.getString("LEAVE_STATUS"));
    lv.setLeaveReason(rs.getString("LEAVE_REASON"));
    lv.setAppliedOn(rs.getDate("APPLIED_ON"));
    lv.setManagerComment(rs.getString("MANAGE_COMMENT"));
    return lv;
  }
}
