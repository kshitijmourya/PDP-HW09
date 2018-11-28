package Controller;

import java.util.Arrays;

import Model.Account;
import View.UserView;

public class AppController2 implements IAppController {

  private Account model;
  private UserView view;



  public AppController2(Account model, UserView view) {
    this.model = model;
    this.view = view;
  }

  public AppController2() {

  }


  /**
   * go method for the controller which interacts with the model.
   */
  @Override
  public void runApp() {
    view.run();

  }


  public void createPortfolio(String portfolioName) {
    System.out.println(this.model);
    try {
      model.addPortfolio(portfolioName);
      view.display("Created a portfolio successfully.\n");
    } catch (IllegalArgumentException e) {
      view.display(e.getMessage());
    }
  }

  public void buy(String stockName, int shares, String portfolio) {
    try {
      //model.addPortfolio(portfolio);
      model.buyStock(stockName, "2018-11-27", "open", shares, portfolio);
      view.display("Bought Stock successfully\n");
    } catch (IllegalArgumentException e) {
      view.display(e.getMessage());
    }
  }

  public void buyMultiple(Double commission, String amount, String portfolioName,
                          String date, String weights) {

    Double investment = Double.parseDouble(amount);

    int[] weightArray = Arrays.stream(weights.split(",")).mapToInt(Integer::parseInt).toArray();

    try {
      model.buyMultipleStockInPortfolio(investment, portfolioName, "2018-11-27", weightArray);
      view.display("Bought Stock Succesfuuly\n");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void periodicInvestment(double commission, double investment, String portfolioName,
                                 String sDate, String edate, int intervals, String weights) {
    int[] weightArray = Arrays.stream(weights.split(",")).mapToInt(Integer::parseInt).toArray();

    try {
      model.periodicInvestment(investment, portfolioName, sDate, edate, intervals, weightArray);
      view.display("Investment Strategy succesfully created");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }


  public void examinePortfolio(String portfolioName) {
    view.display(model.viewAccount());
  }

  public String printPF() {
    return model.checkPortfolioNames();
  }


}
