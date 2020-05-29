package com.hexaware.MLP185.integration.test;
//import java.util.Arrays;
import java.util.Date;
//import java.util.List;
//import java.util.Set;
//import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EmployeeRestTest {
/**
   * Tests the equals/hashcode methods of the employee class.
   * @throws AssertionError for assertion.
   * @throws URISyntaxException for uri syntax.
   * @throws ParseException for date parse.
   */
  @Test
    public void testEmployeesList() throws AssertionError, URISyntaxException, ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1000 = sdf.parse("2020-01-10");
    Employee[] res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees")).getBody()
                 .as(Employee[].class);
    assertEquals(res.length, 7);
    assertEquals(res[0].getEmpId(), 1000);
    assertEquals(res[0].getFullName(), "SIVAKUMAR");
    assertEquals(res[0].getEmailId(), "sivakumar1@gmail.com");
    assertEquals(res[0].getMobileNumber(), "8907685678");
    DateFormat df = DateFormat.getDateInstance();
    Date doj = df.parse(df.format(res[0].getDateOfJoining()));
    assertEquals(doj, d1000);
    assertEquals(res[0].getDepartment(), "CEO");
    assertEquals(res[0].getElBal(), 27);
    assertEquals(res[0].getMlBal(), 29);
    assertEquals(res[0].getSlBal(), 29);
    assertEquals(res[0].getMgrId(), 0);
    assertEquals(res[0].getGender(), "Male");
  }
/**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 * @throws ParseException for date parse.
 */
  @Test
    public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees/1000"))
        .then().assertThat().statusCode(200);
    Employee res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees/1000")).getBody()
             .as(Employee.class);
    assertEquals(res.getEmpId(), 1000);
  }
/**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 */
  @Test
    public void testEmployeeById404() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees/9999")).then().assertThat()
       .statusCode(404);
  }
  /**
 * Test class for Employee.
 * @throws AssertionError for assertion.
 * @throws URISyntaxException for uri syntax.
 */
  @Test
public void testValidateIdyes() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees/validateeid/1000"))
            .then().assertThat()
               .statusCode(200);
  }
}
