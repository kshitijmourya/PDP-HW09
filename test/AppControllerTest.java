

import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import Controller.AppController;
import Controller.IAppController;
import Model.Account;


public class AppControllerTest {

  /**
   * Initialization.
   */
  @Before
  public void setUp() {
    Account testTrade = new Account();
  }


  @Test(expected = IllegalStateException.class)
  public void test1() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2018-11-13");
    IAppController controller = new AppController(in, out);
    controller.runApp();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test2() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("-1");
    IAppController controller = new AppController(in, out);
    controller.runApp();
  }

}
