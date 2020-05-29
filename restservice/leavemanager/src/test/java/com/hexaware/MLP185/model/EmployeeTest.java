package com.hexaware.MLP185.model;

import com.hexaware.MLP185.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
//import java.util.List;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
  }
/**
 * Testing setters and getters of employee.
 */
  @Test
  public final void testGettersAndSetters() {
    Employee e = new Employee();
    e.setEmpId(101);
    assertEquals(101, e.getEmpId());
    assertNotEquals(45, e.getEmpId());
    e.setFullName("Ashish");
    assertEquals("Ashish", e.getFullName());
    assertNotEquals("Danial", e.getFullName());
    e.setEmailId("ashish@gmail.com");
    assertEquals("ashish@gmail.com", e.getEmailId());
    assertNotEquals("ashish11@gmail.com", e.getEmailId());
    e.setDoj("2020-01-01");
    assertEquals("2020-01-01", e.getDoj());
    assertNotEquals("2020-05-01", e.getDoj());
    e.setEmpDpt("Testing");
    assertEquals("Testing", e.getEmpDpt());
    e.setLeaveBal(45);
    assertEquals(45, e.getLeaveBal());
    e.setMobNo("9128385640");
    assertEquals("9128385640", e.getMobNo());
    e.setMgrId(103);
    assertEquals(103, e.getMgrId());
    e.setEmpDpt("Developer");
    assertNotEquals("Testing", e.getEmpDpt());
    e.setLeaveBal(55);
    assertNotEquals(11, e.getLeaveBal());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }
    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
/**
 * Testing employee constructor.
 */
  @Test
  public final void testConstructor() {
    Employee employ = new Employee(103, "ashish@gmail.com", "Ashish",
        "8360753452", "2019-11-10", "Developer", 12, 102);
    assertEquals(103, employ.getEmpId());
    assertEquals("ashish@gmail.com", employ.getEmailId());
    assertEquals("Ashish", employ.getFullName());
    assertEquals("8360753452", employ.getMobNo());
    assertEquals("2019-11-10", employ.getDoj());
    assertEquals("Developer", employ.getEmpDpt());
    assertEquals(12, employ.getLeaveBal());
    assertEquals(102, employ.getMgrId());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAll1(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list1(3, "P"); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll1(3, "P");
    assertEquals(0, es.length);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void test1ToZero(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.updateEl(5, 15); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String es = Employee.eltoZero(5, 15);
    assertEquals("EL Updated!!!", es);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testUpdateNoOfDaysAfterApproval(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.availBalaprove1(2, 12); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String es = Employee.upnodaysafteraprove1(2, 12);
    assertEquals("Apply/De Updated!!!", es);
  }
}
