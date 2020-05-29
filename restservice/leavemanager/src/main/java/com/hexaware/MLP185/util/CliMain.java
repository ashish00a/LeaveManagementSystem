package com.hexaware.MLP185.util;
import java.text.ParseException;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;
//import com.google.protobuf.TextFormat.ParseException;
import com.hexaware.MLP185.model.Employee;
import com.hexaware.MLP185.model.Leave;
/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {

  private final Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() throws ParseException {
    System.out.println("LEAVE MANAGEMENT SYSTEM");
    System.out.println("------------------------");
    System.out.println("1. LIST ALL EMPLOYEES INFO");
    System.out.println("2. DISPLAY EMPLOYEE INFO");
    System.out.println("3. APPLY LEAVE");
    System.out.println("4. UPDATE LEAVE");
    System.out.println("5. LEAVE STATUS");
    System.out.println("6. LEAVE HISTORY");
    System.out.println("7. APPROVE AND DENY");
    System.out.println("8. EXIT");
    System.out.println("ENTER YOUR CHOICE: ");
    final int menuOption = option.nextInt();
    mainMenuDetails(menuOption);

  }

  private void mainMenuDetails(final int selectedOption) throws ParseException {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        displayEmployee();
        break;
      case 3:
        try {
          applyLeave();
          break;
        } catch (Exception e) {
          System.out.println("Enter valid Date format." + e);
        }

      case 4:
        updateLeave();
        break;
      case 5:
        leaveStatus1();
        break;
      case 6:
        try {
          leaveHistory();
        } catch (ParseException e) {
          System.out.println(e);
        }
        break;
      case 7:
        approveAndDeny();
        break;
      case 8:
        exitAll();
      default:
        System.out.println("Choose from the above list");
    }
    mainMenu();
  }
  /*
  *CASE 1.
  */
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "\t" + e.getFullName() + "\t"
          + e.getEmailId() + "\t" + e.getMobNo() + "\t" + e.getDoj() + "\t"
          + e.getEmpDpt() + "\t" + e.getLeaveBal() + "\t" + e.getMgrId());
    }
  }

  /**
   * CASE 2.
   */
  private void displayEmployee() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee em = Employee.listById(empId);
    System.out.println(em);
  }

  /**
   * CASE 3.
   * @throws Exception
   */
  private void applyLeave() throws Exception {
    String lvReason = null;
    String managerComment = null;
    System.out.println("Enter your employee Id");
    int empidd = option.nextInt();
    Employee em = Employee.listById(empidd);
    System.out.println(em);
    if (em != null) {
      if (em.getLeaveBal() == 0) {
        System.out.println("NO LEAVES LEFT TO APPLY");
        return;
      }
      System.out.println("YOU ARE LEFT WITH " + em.getLeaveBal() + " LEAVES.");
      System.out.println("Enter start date (YYYY-MM-DD) :");
      String sdate = option.next();
      System.out.println("Enter end date (YYYY-MM-DD) :");
      String edate = option.next();
      System.out.println("Select leave type (EL, ML, SL) :");
      String lvType = option.next();
      if (lvType.equalsIgnoreCase("EL") || lvType.equalsIgnoreCase("ML") || lvType.equalsIgnoreCase("SL")) {
        System.out.println("ENTER LEAVE REASON :");
        lvReason = option.next();
        int mgr = em.getMgrId();
        if (mgr == 0) {
          String s = Leave.applyLeavvalid1(empidd, sdate, edate, lvType, lvReason, managerComment);
          System.out.println(s);
          return;
        }
        String s1 = Leave.applyLeavvalid(empidd, sdate, edate, lvType, lvReason, managerComment);
        System.out.println(s1);
      } else {
        System.out.println("Please enter valid leave type");
      }
    } else {
      System.out.println("Sorry, No such employee");
    }
  }
/**
   *updting the leave.
   */
  private void updateLeave() {
    String i = "y";
    while (i.equals("y") || i.equals("Y")) {
      System.out.println("Enter from the following what modification has to be done :");
      System.out.println("1. UPDATE START DATE");
      System.out.println("2. UPDATE END DATE");
      System.out.println("3. UPDATE LEAVE TYPE");
      System.out.println("4. UPDATE LEAVE REASON");
      System.out.println("5. EXIT");
      final String a = option.next();
      final char o = a.charAt(0);
      switch (o) {
        case '1' : updateStartdate();
        break;
        case '2' : updateEnddate();
        break;
        case '3' : updateLeavetype();
        break;
        case '4' : updateLeavereason();
        break;
        case '5' : exit();
        break;
        default : System.out.println("enter the correct value :");
        break;
      }
      i = option.next();
    }
  }
  /**
   * updating the start date.
   */
  final void updateStartdate() {

    System.out.println("Enter Leave Id");
    final int leavId = option.nextInt();
    final Leave leave = Leave.listByLeaveIdd(leavId);
   // System.out.println(leave);
    Leave li = Leave.listByLeaveIdd(leavId);

    if (li != null) {
      if (leave.getLeaveStatus().equals("P")) {
        //final int elid = l.getLeaveId();
        System.out.println("your leave ID : " +  leavId);
        System.out.println("Your Previous data was : ");
        System.out.println(leave);
        //String earlys = leave.getEndDate();
        String endate = leave.getEndDate();
        System.out.println("Enter the new Start Date (yyyy-MM-dd) : ");
        final String newsdate = option.next();
        String result =  Leave.updateStartdatecalc(endate, newsdate, leavId);
        System.out.println(result);
      } else {
        System.out.println("You cant modify the date as it has been updated by your Manager....");
        System.out.println("Press 1 to continue ");
        return;
      }
    } else {
      System.out.println("Press 1 to continue");
    }
  }

  /**
   * updating the end date.
   * */
  final void updateEnddate() {
    System.out.println("Enter Leave Id");
    final int leavId = option.nextInt();
    final Leave leave = Leave.listByLeaveIdd(leavId);
  //  System.out.println(leave);
    Leave l = Leave.listByLeaveIdd(leavId);
    //System.out.println(l);
    if (l != null) {
      if (Leave.listByLeaveIdd(leavId).getLeaveStatus().equals("P")) {
        System.out.println("your leave ID : " + leavId);
        System.out.println("Your Previous data was : ");
        System.out.println(leave);
        String esdate = leave.getStartDate();
        //System.out.println(esdate);
        System.out.println("Enter the new End Date (yyyy-MM-dd) : ");
        final String newedate = option.next();
        String result = Leave.updateEnddatecalc(esdate, newedate, leavId);
        System.out.println(result + "Press 1 to continue.");
        return;
      } else {
        System.out.println("You cant modify the date as it has been updated by your Manager....");
        System.out.println("Press 1 to continue");
        return;
      }
    } else {
      System.out.println("Press 1 to continue");
    }
  }

  /**
   * updating the Leave type.
   * */
  final void updateLeavetype() {
    System.out.println("Enter Leave Id");
    final int leavId = option.nextInt();
    Leave leave = Leave.listByLeaveIdd(leavId);
    if (leave != null) {
      if (leave.getLeaveStatus().equals("P")) {
        System.out.println("your leave ID : " + leavId);
        System.out.println("Your Previous Leave Type was : ");
        System.out.println(leave.getLeaveType());
        System.out.println("Enter the new Leave Type : ");
        final String leavetpe = option.next();
        System.out.println("The new Leave type :- " + leavetpe + " has been updated");
        Leave.modeltype(leavetpe, leavId);
        System.out.println("do you wish to continue (y/n)");
      } else {
        System.out.println("You cant modify the date as it has been updated by your Manager....");
        return;
      }
    } else {
      System.out.println("Press 1 to continue");
    }
  }
  /**
   * updating the start date.
   * */
  final void updateLeavereason() {
    System.out.println("Enter Leave Id");
    final int leavId = option.nextInt();
    Leave leave = Leave.listByLeaveIdd(leavId);
    if (leave != null) {
      if (leave.getLeaveStatus().equals("P")) {
        final int elid = leave.getLeaveId();
        System.out.println("your leave ID : " + elid);
        System.out.println("Your Previous Reason was : ");
        System.out.println(leave.getLeaveReason());
        System.out.println("Enter the new Reason : ");
        final String lreason = option.next();
        System.out.println("The new Leave reason :- " + lreason + " has been updated");
        Leave.modelreason(lreason, leavId);
        System.out.println("do you wish to continue (y/n)");
      } else {
        System.out.println("You cant modify the date as it has been updated by your Manager....");
        return;
      }
    } else {
      System.out.println("Press 1 to continue");
    }
  }
  /**
   * hjshdhfj.
   */
  final void exit() {
    System.out.println("enter N to exit ");
  }
  private void leaveStatus1() {
    System.out.println("Enter your employee Id");
    int empId = option.nextInt();
    Leave empid = Leave.listById(empId);
    if (empid != null) {
      System.out.println("Enter your leave Id");
      int leaveIdd = option.nextInt();
      Leave[] dupliEmpLvIds = Leave.listByDupliEmpDetails(empId);
      for (Leave lh : dupliEmpLvIds) {
        if (leaveIdd == lh.getLeaveId()) {
          System.out.println("YOUR LEAVE STATUS IS " + lh.getLeaveStatus());
        }
      }
    }
  }

  /**
   * APPROVE DENY.
   */
  private void approveAndDeny() {
  //final Leave[] leav = Leave.listAll();
    System.out.println("Enter the Manager ID ");
    int mgrid = option.nextInt();
    Employee employee = Employee.listById1(mgrid);
    System.out.println(employee);
    if (employee != null) {
      System.out.println("THE FOLLOWING ARE THE PENDING LEAVE ID  ");
      String p = "P";
      final Leave[] leave = Leave.listAll1(mgrid, p);
      for (final Leave e : leave) {
        System.out.println(e);
      }
      System.out.println("Enter the LEAVE ID  ");
      int leavid = option.nextInt();
     //String l = Leave.validateLeaveforapprovedeny(leavid);
    //  if (l != "Sorry, No such LEAVE ID") {
      //System.out.println("Enter the EMPLOYEE ID");
      //int empid = option.nextInt();
       // String e1 = Employee.validateEmployeeforapprovedeny(empid, mgrid, leavid);
     //   if (e1 != "Sorry, No such employee") {
      System.out.println("ENTER THE ACTION YOU WANT TO PERFORM  ");
      System.out.println("1.APPROVE");
      System.out.println("2.DENY");
      System.out.println("3.EXIT");
      int optio = option.nextInt();
      String appdenyop = Leave.appdenyfun(leavid, mgrid, optio);
      System.out.println(appdenyop);
    } else {
      System.out.println("enter proper input");
    }

  }
/**
 * LEAVE HISTORY.
 * @throws ParseException
 */
  private void leaveHistory() throws ParseException {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Leave employee = Leave.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee found.");
    } else {
      System.out.println("Enter start date :");
      String startDate = option.next();
      System.out.println("Enter end Date :");
      String endDate = option.next();
      Leave[] lvHistory = Leave.listByLeaveHis(empId, startDate, endDate);
      System.out.println("These are the following leave history.");
      for (Leave lh : lvHistory) {
        System.out.println(lh.getLeaveId() + "\t" + lh.getEmpId()
              + "\t" + lh.getNumOfDays() + "\t" + lh.getStartDate()
              + "\t" + lh.getEndDate() + "\t" + lh.getLeaveType() + "\t"
              + lh.getLeaveStatus() + "\t" + lh.getLeaveReason() + "\t"
              + lh.getAppliedOn() + "\t" + lh.getManagerComment());
      }
    }
  }
/**
 * dsfhsdjkf.
 */
  final void exitAll() {
    System.out.println("Thank You !!");
    System.exit(0);
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */

  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    try {
      mainObj.mainMenu();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
