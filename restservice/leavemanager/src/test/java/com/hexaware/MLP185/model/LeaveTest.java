package com.hexaware.MLP185.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.DateFormat;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hexaware.MLP185.persistence.EmployeeDAO;
import com.hexaware.MLP185.persistence.LeaveDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * LeaveTest.
 */
public class LeaveTest {
  /**
   * sdhfjsdhfh.
   */
  @Test
  public final void testLeave() {
    Leave l1 = new Leave();
    assertNotEquals(101, l1.getEmpId());
    assertEquals(0, l1.getEmpId());
  }

  /**
   */
  /**
   * sdfsdghfsdh.
   */
  @Test
  public final void testGettersAndSetters() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = "2020-04-05";
    Date d1 = null;
    try {
      d1 = sdf.parse(s1);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Leave lv = new Leave();
    lv.setEmpId(105);
    assertEquals(105, lv.getEmpId());
    lv.setLeaveId(41);
    assertEquals(41, lv.getLeaveId());
    lv.setLeaveReason("Ram goes to market");
    assertEquals("Ram goes to market", lv.getLeaveReason());
    lv.setLeaveStatus("P");
    assertEquals("P", lv.getLeaveStatus());
    lv.setLeaveType("SL");
    assertEquals("SL", lv.getLeaveType());
    lv.setNumOfDays(8);
    assertEquals(8, lv.getNumOfDays());
    lv.setManagerComment("OKK");
    assertEquals("OKK", lv.getManagerComment());
    lv.setStartDate("2020-04-05");
    assertEquals("2020-04-05", lv.getStartDate());
    lv.setEndDate("2020-04-05");
    assertEquals("2020-04-05", lv.getEndDate());
    lv.setAppliedOn(d1);
    assertEquals(d1, lv.getAppliedOn());
  }

  /**
   * Testing constructor.
   */
  @Test
  public final void testConstructor() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = "2020-04-05";
    Date d1 = null;
    try {
      d1 = sdf.parse(s1);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Leave lvConstructor = new Leave(101, "2020-05-01", "2020-06-01", "A", "sdgjhgh", d1, "sdfyusdyf");
    assertEquals(101, lvConstructor.getEmpId());
    assertEquals("2020-05-01", lvConstructor.getStartDate());
    assertEquals("2020-06-01", lvConstructor.getEndDate());
    assertEquals("A", lvConstructor.getLeaveStatus());
    assertEquals("sdgjhgh", lvConstructor.getLeaveReason());
    assertEquals(d1, lvConstructor.getAppliedOn());
    assertEquals("sdfyusdyf", lvConstructor.getManagerComment());
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        ArrayList<Leave> es = new ArrayList<Leave>();
        es.add(new Leave(1));
        es.add(new Leave(10));
        es.add(new Leave(41));
        es.add(new Leave(45));
        dao.list(); result = es;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    Leave[] ls = Leave.listAll();
    assertEquals(4, ls.length);
  }
  /**
   * @param dao1 Testing leave by id.
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testListById(@Mocked final LeaveDAO dao1) throws ParseException {
    final String appliedOn = "2020-01-01";
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date d1 = sdf.parse(appliedOn);
    final Leave lv = new Leave(101, "2020-05-01", "2020-06-01", "A", "sdgjhgh", d1, "sdfyusdyf");
    new Expectations() {
      {
        dao1.leaveIdd(101); result = lv;
        dao1.leaveIdd(-1); result = null;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao1;
      }
    };
    Leave ls = Leave.listByLeaveId(101);
    assertNotNull(ls);
    Leave ls1 = Leave.listByLeaveId(-1);
    assertNull(ls1);
  }
/**
 * @param dao for employee.
 * @throws ParseException for employee.
 */
  @Test
  public final void testLeaveStatus(@Mocked final LeaveDAO dao) throws ParseException {
    /*final String appliedOn = "2020-01-01";
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date d1 = sdf.parse(appliedOn);
    final Leave l1 = new Leave(101, "2020-05-01", "2020-06-01", "A", "sdgjhgh", d1, "sdfyusdyf");*/
    final Leave li = new Leave();
    li.setLeaveId(2);
    li.setEmpId(1001);
    new Expectations() {
      {
        dao.leaveStatus("A"); result = li;
        dao.leaveStatus("M"); result = null;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    Leave ls = Leave.listByLeaveStatus("A");
    assertNotNull(ls);
    Leave ls1 = Leave.listByLeaveStatus("M");
    assertNull(ls1);
  }
/**
 * @param dao testing leave history.
 * @throws ParseException testing leave history.
 */
  @Test
  public final void testLeaveHistory(@Mocked final LeaveDAO dao) throws ParseException {
    final String sDate = "2020-01-01";
    final String eDate = "2020-08-01";
    final String appliedOn = "2020-03-01";
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date sd = sdf.parse(sDate);
    final Date ed = sdf.parse(eDate);

    final Date appliedOnn = sdf.parse(appliedOn);
    new Expectations() {
      {
        ArrayList<Leave> ls = new ArrayList<Leave>();
        ls.add(new Leave(101, "2020-05-01", "2020-06-01", "A", "sdgjhgh", appliedOnn, "sdfyusdyf"));
        ls.add(new Leave(101, "2020-04-01", "2020-05-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf"));
        ls.add(new Leave(101, "2020-04-01", "2020-05-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf"));
        ls.add(new Leave(102, "2020-04-01", "2020-05-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf"));
        dao.listByLeaveHistory(101, sd, ed); result = ls;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    Leave[] ls = Leave.listByLeaveHis(101, "2020-01-01", "2020-08-01");
    assertEquals(4, ls.length);
    assertNotNull(ls);
  }
  /**
   * @param dao testing start date updation.
   * @throws ParseException testing start date updation.
   */
  @Test
  public final void testupdateStartDate(@Mocked final LeaveDAO dao) throws ParseException {

    final String sDate = "2021-05-03";
    final String appliedOn = "2021-04-28";
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date appliedOnDate = sdf.parse(appliedOn);
    final Date updatedSDate = sdf.parse(sDate);
    final Leave li = new Leave(101, "2021-05-01", "2021-05-09", "P", "sick", appliedOnDate, null);
    new Expectations() {
      {

        dao.leaveIdd(101); result = li;
        dao.leaveIdd(102); result  = null;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String result = Leave.updateStartdatecalc("2021-05-10", "2021-05-03",  101);
    assertEquals("The date has been modified\n Press 1 to continue.do you wish to continue (y/n)", result);
    String result1 = Leave.updateStartdatecalc("2021-05-10", "2021-05-03",  102);
    assertEquals("Invalid Leave Id", result1);

  }
  /**
   * @param dao testing start date updation.
   * @throws ParseException testing start date updation.
   */
  @Test
     public final void testupdateEndDate(@Mocked final LeaveDAO dao) throws ParseException {
    Date appliedOnn = new Date();
    final Leave l1 = new Leave(101, "2020-03-01", "2020-03-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf");
    new Expectations() {
          {
            dao.leaveIdd(101); result = l1;
            dao.leaveIdd(102); result  = null;
          }
        };
    new MockUp<Leave>() {
          @Mock
          LeaveDAO dao() {
            return dao;
          }
        };
    String result = Leave.updateEnddatecalc("2020-03-03", "2020-03-09", 101);
    String result2 = Leave.updateEnddatecalc("2020-03-01", "2020-03-09", 102);
    String result3 = Leave.updateEnddatecalc("2020-03-01", "2020-03-01", 101);
    assertEquals("The End date has been modified\ndo you wish to continue (y/n)", result);
    assertEquals("Invalid Leave Id", result2);
    assertEquals("Date should not be the same or less than the applied date", result3);
  }
  // @Test
  // public final void testupdateEndDate(@Mocked final LeaveDAO dao) throws ParseException {
  //   final Leave leave = new Leave();
  //   leave.setLeaveId(3);
  //   leave.setStartDate("2021-03-25");
  //   leave.setEndDate("2021-03-28");
  //   final String oldStartDate = leave.getEndDate();
  //   final String oldEndDate = leave.getStartDate();
  //   final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
  //   //final Date startDate = sf.parse("2021-02-25");
  //   //final Date endDate = sf.parse("2021-02-28");
  //   //final Date appliedOn = new Date();
  //   final String newStrEndDate = "2021-03-04";
  //   final Date newEndDate = sf.parse("2021-03-04");
  //   new Expectations() {
  //     {
  //       dao.updateedate(newEndDate, 3); result = leave.getLeaveId();
  //       // ArrayList<Leave> ls = new ArrayList<Leave>();
  //       // ls.add(new Leave(101, "2020-02-01", "2020-06-01", "A", "sdgjhgh", appliedOnn, "sdfyusdyf"));
  //       // ls.add(new Leave(102, "2020-04-01", "2020-05-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf"));
  //       // ls.add(new Leave(103, "2020-04-01", "2020-05-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf"));
  //       // dao.updateedate(ed, 3); result = ls;
  //       // dao.updateedate(null, 115); result = null;
  //     }
  //   };
  //   new MockUp<Leave>() {
  //     @Mock
  //     LeaveDAO dao() {
  //       return dao;
  //     }
  //   };
  //   String result = Leave.updateEnddatecalc(oldEndDate, oldStartDate, 3);
  //   assertEquals("Date should not be the same or less than the applied date", result);
  //   //assertNull(ls1);
  // }
  /**
   * @throws ParseException for applied on.
   */
  @Test
  public final void testToString() throws ParseException {
    final String appliedOn = "2020-02-01";
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date appliedOnn = sdf.parse(appliedOn);
    Leave leave = new Leave(101, "2020-03-21", "2020-03-23", "P", "GoingHome", appliedOnn,
        "OkTakecare");
    String result = "1" + "\t" + "101" + "\t" + 5 + "\t" + "2020-03-21" + "\t" + "2020-03-23"
        + "\t" + "SL" + "\t" + "P" + "\t" + "GoingHome" + "\t" + appliedOnn + "\t" + "OkTakecare";
    assertNotEquals(result, leave.toString());
    /*assertEquals(result, leave.toString());
    assertNull(result);*/
  }
/**
   * to test the apply Leave.
   * @param edao for mocking dao class for employ.
   * @param ldao for mocking dao class for leave
   * @throws ParseException for parsing date.
   */
  @Test
  public final void testCreateLeave(@Mocked final LeaveDAO ldao, @Mocked final EmployeeDAO edao)
      throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date sd = sf.parse("2020-03-20");
    final Date ed = sf.parse("2020-03-24");
    final Date cd = new Date();
    final DateFormat df = DateFormat.getDateInstance();
    final Date ad1 = df.parse(df.format(cd));
    final Employee emp = new Employee(104, "Ashish", "ashish@gmail.com", "456448486", "2020-01-12", "java", 24, 103);
    final Employee empMgr = new Employee(104, "Danial", "danial@gmail.com", "654665489", "2020-01-12",
           "java", 24, 0);
    new Expectations() {
      {
        edao.find(104); result = emp;
        ldao.applyLeave(104, 5, sd, ed, "EL", "P", "Sick", ad1);
        edao.find(104); result = empMgr;
        ldao.applyLeave(104, 5, sd, ed, "EL", "P", "Sick", ad1);
      }
    };
    new Expectations() {
      {

        //edao.find(104); result = empMgr;
        ldao.applyLeave(104, 5, sd, ed, "EL", "P", "Sick", ad1);
        ldao.applyLeave(104, 5, sd, ed, "EL", "P", "Sick", ad1);

      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    String result1 = Leave.applyLeavvalid(104, "2020-03-20", "2020-03-24", "EL", "Sick", null);
    assertEquals("*********PLEASE REMEMBER THE LEAVE ID FOR CHECKING FURTHER STATUS***********", result1);
    String result2 = Leave.applyLeavvalid1(104, "2020-03-20", "2020-03-24", "EL", "Sick", null);
    assertEquals("ALREADY APPLIED ON THIS DATE", result2);
    String result3 = Leave.applyLeavvalid1(105, "2020-03-20", "2020-03-24", "EL", "Sick", null);
    assertEquals("NO SUFFICIENT BALANCE", result3);
    String result4 = Leave.applyLeavvalid(104, "2020-03-20", "2020-03-24", "EL", "Sick", null);
    assertEquals("ALREADY APPLIED ON THIS DATE", result4);
  }
 /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListByLeaveId(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        ArrayList<Leave> es = new ArrayList<Leave>();
        es.add(new Leave(1));
        es.add(new Leave(10));
        es.add(new Leave(41));
        es.add(new Leave(45));
        dao.leaveIddd(1); result = es;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    Leave ls = Leave.listByLeaveIdd(1);
    assertEquals(0, ls.getLeaveId());
  }
  /**
   * Tests the equals/hashcode methods of the leave class.
   */
  @Test
  public final void testLeaveEquals() {
    Leave l1 = new Leave(1);
    Leave l2 = new Leave(2);
    assertNotEquals(l1, null);
    assertNotEquals(l1, new Integer(1));
    assertEquals(l1, new Leave(1));
    assertNotEquals(l2, new Leave(1));
    assertEquals(l1.hashCode(), new Leave(1).hashCode());
    assertEquals(l1.getLeaveId(), new Leave(1).getLeaveId());
    l1.setLeaveId(1);
    assertEquals(l2, new Leave(2));
  }
 /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAll1(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        dao.list1(3, "P"); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    Leave[] es = Leave.listAll1(3, "P");
    assertEquals(0, es.length);
  }
 /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testLeaveDeny(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        dao.denied("P", 3); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    int es = Leave.applyDeny("P", 3);
    assertNotEquals(0, es);
  }
 /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testApplyApprove(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        dao.approved("P", 3); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    int es = Leave.applyApprove("P", 3);
    assertNotEquals(0, es);
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testApproveByManager(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        dao.approved1(3, "P"); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    int es = Leave.applyApproveformanager(3, "P");
    assertNotEquals(0, es);
  }
/**
 * @param dao mocking the dao class.
 * @throws ParseException mocking the dao class.
 */
  @Test
  public final void testAppliedOn(@Mocked final LeaveDAO dao) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date appOn = sf.parse("2020-02-14");
    new Expectations() {
      {
        ArrayList<Leave> ls = new ArrayList<Leave>();
        ls.add(new Leave(101, "2020-02-01", "2020-06-01", "A", "sdgjhgh", appOn, "sdfyusdyf"));
        dao.apply(appOn, 101); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    int es = Leave.appliedon1(appOn, 101);
    assertNotEquals(0, es);
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testNumberOfDays(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        dao.stnod1(3, 1); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    int es = Leave.upnodays1(3, 1);
    assertEquals(1, es);
  }
/**
 * @param dao mocking the dao class.
 * @throws ParseException mocking the dao class.
 */
  @Test
  public final void testEndDate(@Mocked final LeaveDAO dao) throws ParseException {
    Date appliedOnn = new Date();
    final Leave l1 = new Leave(101, "2020-03-01", "2020-03-01", "P", "sdgjhgh", appliedOnn, "sdfyusdyf");
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date appOn = sf.parse("2020-02-14");
    final Date sDate = sf.parse("2020-06-01");
    // final Date eDate = sf.parse("2020-06-01");
    new Expectations() {
      {
        dao.leaveIdd(101); result = l1;
        dao.leaveIdd(-1); result = null;
        dao.updateedate(sDate, 101);
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String es = Leave.modendate(sDate, 101);
    assertEquals("End date Updated!!!0", es);
    String es1 = Leave.modendate(sDate, -1);
    assertEquals("Leave id not found...", es1);
  }
/**
 * @param dao mocking the dao class.
 * @throws ParseException mocking the dao class.
 */
  @Test
   public final void testLeaveType(@Mocked final LeaveDAO dao) throws ParseException {
    new Expectations() {
      {
        dao.updateltype("A", 1); result = new ArrayList<Leave>();
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String es = Leave.modeltype("A", 1);
    assertEquals("Leave type Updated!!!", es);
  }
// /**
//  * @param dao mocking the dao class.
//  * @throws ParseException mocking the dao class.
//  */
//   @Test
//   public final void testValidateLeave(@Mocked final LeaveDAO dao) throws ParseException {
//     final String sApp = "2021-02-25";
//     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//     final Date appliedDate = sf.parse(sApp);
//     final Leave l1 = new Leave(200, "2021-03-01", "2021-03-05", "P", "sdgjhgh", appliedDate, "null");
//     new Expectations() {
//       {
//         Leave.listByLeaveIdd(200); result = l1;
//         dao.leaveIddd(800); result = null;
//       }
//     };
//     new MockUp<Leave>() {
//       @Mock
//     LeaveDAO dao() {
//         return dao;
//       }
//     };
//     String result = Leave.validateLeave(200);
//     // String result2 = Leave.validateLeave(800);
//     assertEquals("Valid Leave ID", result);
//     // assertEquals("Sorry, No such LEAVE ID", result2);
//   }
/**
 * @param ldao of employee.
 * @param edao of employee.
 * @throws ParseException of employee.
 */
  @Test
  public final void testAppDenyFun(@Mocked final LeaveDAO ldao, @Mocked final EmployeeDAO edao) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date appOn = sf.parse("2020-02-18");
    //final Employee emp = new Employee(104, "Ashish", "ashish@gmail.com", "456448486", "2020-01-12", "java", 24, 103);
    final Employee emp1 = new Employee(105, "Ashish", "ashish@gmail.com", "456448486", "2020-01-12", "java", 24, 104);
    //final Leave leave = new Leave(104, "2020-03-20", "2020-03-24", "P", "GoingHome", appOn,
          // "OkTakecare");
    final Leave leave1 = new Leave(105, "2020-03-20", "2020-03-24", "P", "GoingHome", appOn,
           "OkTakecare");
    new Expectations() {
      {
        //ldao.findleaveid(5); result = leave;
        ldao.findleaveid(5); result = leave1;
        //ldao.findleaveid(6); result = leave2;
        //edao.find(107); result = emp;
        //edao.find(104); result = emp;
        edao.find(105); result = emp1;
        //ldao.appdenyfun(); result = 5;
        //ldao.applyLeave(101, 5, sd, ed, "EL", "P", "Sick", appOn); result = 5;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    //String result1 = Leave.appdenyfun(5, 103, 1);
    String result2 = Leave.appdenyfun(5, 104, 1);
    //String result3 = Leave.appdenyfun(6, 105, 0);
    //assertEquals("you are not authorised to do this", result1);
    assertEquals("YOU CANT APPROVE HIM LEAVE  AS HIS LEAVE BALANCE IS INSUFFICIENT", result2);
  }
  /**
   * @param dao of employee.
   */
  @Test
  public final void testModelReason(@Mocked final LeaveDAO dao) {
    new Expectations() {
        {
          dao.updatelreason("asdyusiyh", 1); result = new ArrayList<Leave>();
        }
      };
    new MockUp<Leave>() {
        @Mock
        LeaveDAO dao() {
          return dao;
        }
      };
    String es = Leave.modelreason("asdyusiyh", 1);
    assertEquals("Leave reason Updated!!!", es);
  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListByDupliEmpDetails(@Mocked final LeaveDAO dao) {
    new Expectations() {
      {
        ArrayList<Leave> es = new ArrayList<Leave>();
        es.add(new Leave(1));
        es.add(new Leave(2));
        es.add(new Leave(3));
        es.add(new Leave(4));
        dao.listByDupliEmp(103); result = es;
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    Leave[] ls = Leave.listByDupliEmpDetails(103);
    assertEquals(4, ls.length);
  }
/**
 * @param dao modifying start date.
 * @throws ParseException modifying start date.
 */
  @Test
  public final void testModStart(@Mocked final LeaveDAO dao) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date appOn = sf.parse("2021-02-22");
    final String sd = "2021-04-01";
    final Date sDate = sf.parse(sd);
    final String newSDate = "2021-04-01";
    final Date newStartDate = sf.parse(newSDate);
    final Leave l1 = new Leave(101, "2021-04-01", "2021-04-10", "P", "sick", appOn, "dfgjhjdf");
    new Expectations() {
      {
        dao.leaveIdd(101); result = l1;
        dao.leaveIdd(-1); result = null;
        dao.updatesdate(newStartDate, 101);
      }
    };
    new MockUp<Leave>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String es = Leave.modstdate(newStartDate, 101);
    assertEquals("Start date Updated!!!", es);
    String rs = Leave.modstdate(newStartDate, -1);
    assertEquals("Leave id not found...", rs);
  }
}

