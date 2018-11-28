package Controller;

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

  }


  public void createPortfolio(String portfolioName) {
    view = new UserView();
    model = new Account();
    try {
      model.addPortfolio(portfolioName);
      view.display("Created a portfolio successfully.\n");
    } catch (IllegalArgumentException e) {
      view.display(e.getMessage());
    }
  }

  public void buy(String stockName, int shares, String portfolio) {
    view = new UserView();
    model = new Account();
    try {
      model.addPortfolio(portfolio);
      model.buyStock(stockName, "2018-11-27", "open", shares, portfolio);
      view.display("Bought Stock successfully\n");
    } catch (IllegalArgumentException e) {
      view.display(e.getMessage());
    }
  }


  public void examinePortfolio(String portfolioName) {

  }

  public void examineStock(String stockName) {

  }

}
