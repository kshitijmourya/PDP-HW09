

import org.junit.Before;
import org.junit.Test;

import Controller.AppController2;
import Controller.IAppController;
import Model.Account;
import Model.UserAccount;
import View.IUserView;
import View.UserView;

import static org.junit.Assert.assertEquals;


public class AppControllerTest {

  /**
   * Initialization.
   */
  @Before
  public void setUp() {

    UserAccount testModel = new Account();
    IUserView testView = new UserView();
    IAppController testController = new AppController2();
  }


  @Test(expected = NullPointerException.class)
  public void test1() {
    IAppController testController = new AppController2();
    testController.createPortfolio("");
  }


}
