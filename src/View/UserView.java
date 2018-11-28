package View;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Controller.AppController2;
import Model.Account;

public class UserView {
  private Account model = new Account();
  private AppController2 controllerObj = new AppController2(model, this);

  public UserView() {
  }

  public void display(String st) {
    System.out.println(st);
  }

  private String input(Scanner scan) throws IllegalStateException {
    String string = "";
    try {
      string = scan.next();
    } catch (NoSuchElementException e) {
      throw new IllegalStateException();
    }
    return string;
  }


  public void run() {
    display("Welcome User to the Application\nHow to Invest for Dummies\n");
    String menu = "Please Enter the Following Options\n" +
            "Enter 1 to create a portfolio\n" +
            "Enter 2 to Buy Stocks\n" +
            "Enter 3 to Examine a portfolio\n" +
            "Enter Q to quit\n";

    while (true) {
      display(menu);
      Scanner sc = new Scanner(System.in);
      String command = input(sc);

      switch (command) {
        case "1":
          System.out.println("Enter Portfolio name");
          String s = input(sc);
          controllerObj.createPortfolio(s);
          break;

        case "2":
          //buyStockOptions();

          //Scanner sc1 = new Scanner(System.in);
          display("Please Enter Commission amount");
          String com = input(sc);
          double commission = Double.parseDouble(com);

          System.out.println("There are sub options in this menu");
          String subMenu1 = "Enter 1 to buy single stocks\n" +
                  "Enter 2 to buy multiple stocks\n" +
                  "Enter 3 to buy stocks in periodic investment\n";
          display(subMenu1);

          String cmd = input(sc);

          switch (cmd) {
            case "1":
              System.out.println("Enter Stock's name");
              String stockName = input(sc);
              System.out.println("Enter number of shares");
              String s1 = input(sc);
              int shares = Integer.parseInt(s1);
              System.out.println("Enter Portfolio's name");
              String portfolioName = input(sc);
              controllerObj.buy(stockName, shares, portfolioName);
              break;

            case "2":
              display("Displaying all portfolios to choose from:");
              display(controllerObj.printPF());
              display("Enter Portfolio name");
              String portfolio = input(sc);
              display("Enter Amount to invest");
              String amount = input(sc);
              display("Enter the Date");
              String date = input(sc);
              display("Enter the weights [separated by spaces]");
              String weights = input(sc);
              controllerObj.buyMultiple(commission, amount, portfolio, date, weights);
              break;

            //Need to add method to enter more periodic investments
            case "3":
              periodicInvestment();
              break;
          }
          break;


        case "3":
          System.out.println("Enter Portfolio name");
          String st = input(sc);
          controllerObj.examinePortfolio(st);
          break;


        case "q":
        case "Q":
          display("Exiting the program");
          System.exit(0);
          break;

        default:
          display("Please Enter valid response\n\n");
          break;
      }
    }
  }

  private void buyStockOptions() {
/*
    display("Please Enter Commission amount");
    Scanner sc = new Scanner(System.in);
    String com = input(sc);
    double commission = Double.parseDouble(com);

    System.out.println("There are sub options in this menu");
    String subMenu1 = "Enter 1 to buy single stocks\n" +
            "Enter 2 to buy multiple stocks\n" +
            "Enter 3 to buy stocks in periodic investment\n";
    display(subMenu1);

    String command = input(sc);

    switch (command) {
      case "1":
        System.out.println("Enter Stock's name");
        String stockName = input(sc);
        System.out.println("Enter number of shares");
        String s1 = input(sc);
        int shares = Integer.parseInt(s1);
        System.out.println("Enter Portfolio's name");
        String portfolioName = input(sc);
        controllerObj.buy(stockName, shares, portfolioName);
        break;

      case "2":
        display("Displaying all portfolios to choose from:");
        display(controllerObj.printPF());
        display("Enter Portfolio name");
        String portfolio = input(sc);
        display("Enter Amount to invest");
        String amount = input(sc);
        display("Enter the Date");
        String date = input(sc);
        display("Enter the weights [separated by spaces]");
        String weights = input(sc);
        controllerObj.buyMultiple(commission, amount, portfolio, date, weights);
        break;

      //Need to add method to enter more periodic investments
      case "3":
        periodicInvestment();
        break;
    }
    */
  }

  private void periodicInvestment() {
    display("Select your periodic Investment Strategy:\n");
    display("Enter 1 for Dollar Cost Averaging");
    Scanner sc = new Scanner(System.in);
    String command = input(sc);
    switch (command) {
      default:
        display("Displaying all portfolios to choose from:");
        display(controllerObj.printPF());
        display("Enter Portfolio name");
        String portfolio = input(sc);

        display("Enter Commission");
        String com = input(sc);
        double commission = Double.parseDouble(com);

        display("Enter Investment Amount");
        String amount = input(sc);
        double investment = Double.parseDouble(amount);

        display("Enter Start Date");
        String sDate = input(sc);
        display("Enter End Date (Optional)");
        String eDate = input(sc);
        display("Enter interval in days");
        String interval = input(sc);
        int intervals = Integer.parseInt(interval);
        display("Enter weights");
        String weights = input(sc);

        controllerObj.periodicInvestment(commission, investment, portfolio, sDate, eDate, intervals, weights);

    }
  }


}
