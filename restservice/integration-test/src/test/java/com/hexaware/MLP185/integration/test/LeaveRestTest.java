package com.hexaware.MLP185.integration.test;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.ParseException;
import org.junit.Test;
//import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
//import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
/**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for date
   */
public class LeaveRestTest {
/**
   * Tests the equals/hashcode methods of the employee class.
   * @throws AssertionError for assertion.
   * @throws URISyntaxException for uri syntax.
   * @throws ParseException for date parse.
   */
  @Test
    public void testLeaveList() throws AssertionError, URISyntaxException, ParseException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave"))
        .then().assertThat().statusCode(200);
    Leave[] res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave")).getBody()
                 .as(Leave[].class);
    assertEquals(res.length, 5);
    assertEquals(res[0].getEmpId(), 3002);
    assertEquals(res[0].getLeaveId(), 1);
  }
/**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
    public void testLeaveBylId() throws AssertionError, URISyntaxException, ParseException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/1"))
        .then().assertThat().statusCode(200);
    Leave res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/1")).getBody()
             .as(Leave.class);
    assertEquals(res.getEmpId(), 3002);
    assertEquals(res.getLeaveId(), 1);
  }
/**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 */
  @Test
    public void testLeaveBylId404() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/9999")).then().assertThat()
       .statusCode(404);
  }

/**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testLeaveById() throws AssertionError, URISyntaxException, ParseException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/listbyeid/3002"))
    .then().assertThat().statusCode(200);
    Leave[] res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/listbyeid/3002")).getBody()
         .as(Leave[].class);
    assertEquals(res[0].getEmpId(), 3002);
    assertEquals(res[0].getLeaveId(), 1);
  }
  /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testLeaveHistory() throws AssertionError, URISyntaxException, ParseException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/leavehistory/3002/2020-01-01/2021-01-01"))
    .then().assertThat().statusCode(200);
    Leave[] res = given().accept(ContentType.JSON).when().get(CommonUtil
    .getURI("/api/leave/leavehistory/3002/2020-01-01/2021-01-01")).getBody().as(Leave[].class);
    assertEquals(res[0].getEmpId(), 3002);
    assertEquals(res[0].getLeaveId(), 1);
  }
/**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 */
  @Test
public void testLeaveHistory404() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil
    .getURI("/api/leave/leavehistory/300/2020-01-01/2021-01-01")).then().assertThat()
     .statusCode(404);
  }
  /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testLeavePending() throws AssertionError, URISyntaxException, ParseException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/leave/pendingleaves/2001/PENDING"))
    .then().assertThat().statusCode(200);
    Leave[] res = given().accept(ContentType.JSON).when().get(CommonUtil
    .getURI("/api/leave/pendingleaves/2001/PENDING")).getBody().as(Leave[].class);
    assertEquals(res[0].getEmpId(), 3000);
    assertEquals(res[0].getLeaveId(), 5);
  }
  /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 */
  @Test
public void testLeavePending404() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil
    .getURI("/api/leave/pendingleaves/200/PENDING")).then().assertThat()
     .statusCode(404);
  }
  /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApplyLeave() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/applyingleave/3000/2026-03-02/2026-03-02/EL/vacation")).asString();
    assertEquals(res, "leave appliedleave Id is43");
  }
  /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApplyLeaveDuration() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/applyingleave/3000/2026-03-02/2026-03-02/EL/vacation")).asString();
    assertEquals(res, "you already applied on this duration.");
  }
   /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApplyLeaveValidDate() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/applyingleave/3000/2026-03-05/2026-03-04/EL/vacation")).asString();
    assertEquals(res, "enter valid Date");
  }
   /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApplyLeaveLeaveType() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/applyingleave/3000/2026-03-08/2026-03-08/AL/vacation")).asString();
    assertEquals(res, "check leave type");
  }
   /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApplyLeaveLeaveBalance() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/applyingleave/3000/2026-03-08/2027-03-08/ML/vacation")).asString();
    assertEquals(res, "check ML balance");
  }
   /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testModifyLeave() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/modifyingleave/3000/43/2020-03-22/2020-03-23/ML/caring")).asString();
    assertEquals(res, "leave modified");
  }
   /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApproveLeave() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/approveleave/2001/43/APPROVED/enjoy")).asString();
    assertEquals(res, "leave is   APPROVED");
  }
 /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
public void testApproveLeaveManager() throws AssertionError, URISyntaxException, ParseException {
    String res = given().accept(ContentType.JSON).contentType("application/json").body("").when().
           post(CommonUtil.getURI("/api/leave/approveleave/2000/43/APPROVED/enjoy")).asString();
    assertEquals(res, "leave is   APPROVED");
  }
}
