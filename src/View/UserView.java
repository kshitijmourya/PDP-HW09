package View;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Controller.AppController2;

public class UserView {
  private AppController2 controllerObj;

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
    controllerObj = new AppController2();
    display("Welcome User to the Application\nHow to Invest for Dummies\n");
    String menu = "Please Enter the " +
            "Following Options\nEnter 1 to create a portfolio\nEnter 2 to Buy Stocks\nEnter 3 to " +
            "Examine a portfolio\nEnter 4 to Explore Stock Market\nEnter Q to quit\n";

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
          System.out.println("Enter Stock's name");
          String s3 = input(sc);
          System.out.println("Enter number of shares");
          String s1 = input(sc);
          int shares = Integer.parseInt(s1);
          System.out.println("Enter Portfolio's name");
          String s2 = input(sc);
          controllerObj.buy(s3, shares, s2);
          break;


        case "3":
          System.out.println("Enter Portfolio name");
          String st = input(sc);
          controllerObj.examinePortfolio(st);
          break;


        case "4":
          System.out.println("Enter Stock's name");
          String st1 = input(sc);
          controllerObj.examineStock(st1);
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
    System.out.println("There are sub options in this menu");
    String subMenu1 = "Enter 1 to buy single stocks\nEnter 2 to buy multiple " +
            "stocks\nEnter 3 to buy stocks in periodic investment";


  }


}
