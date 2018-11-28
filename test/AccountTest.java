import org.junit.Before;
import org.junit.Test;

import Model.Account;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;


public class AccountTest {
  Account testTrade;

  /**
   * Initialization.
   */
  @Test
  public void setUp() throws InterruptedException {
    testTrade = new Account();
    testTrade.addPortfolio("Technology");

    testTrade.buyStock(20.00,"AMZN", "2018-11-08", "open", 10, "Technology");
    Thread.sleep(25000);

    testTrade.buyStock(20.00,"amd", "2018-11-08", "open", 10, "Technology");
    Thread.sleep(25000);
    testTrade.buyStock(20.00,"apple", "2018-11-13", "open", 20, "Technology");
    Thread.sleep(25000);
    testTrade.buyStock(20.00,"microsoft", "2018-11-08", "open", 10, "Technology");
    Thread.sleep(25000);

    String early_ports = testTrade.viewAccount();
    testTrade.addPortfolio("Retail");

    System.out.println(testTrade.viewAccount() + "\n\n");
    System.out.println(testTrade.viewPortfolio("Technology") + "\n\n");
    System.out.println(testTrade.viewStockLogsInPortfolio("Technology") + "\n\n");
    System.out.println(testTrade.getAccountProfit("2018-11-2", "2018-11-27") + "\n\n");

    String all_ports = testTrade.viewAccount();
    testTrade.removePortfolio("Retail");

    assertNotEquals(early_ports, all_ports);
    assertEquals(early_ports, testTrade.viewAccount());

    testTrade.buyMultipleStockInPortfolio(20.00,2000.00, "Technology", "2018-10-05", 20, 10, 20, 50);
    testTrade.periodicInvestment(20, 2000.00,  "Technology", "2017-10-05","2018-11-27" ,20, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddRemove1() {
    testTrade = new Account();
    testTrade.buyStock(20.00,"", "2018-11-08", "open", 10, "Technology");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddRemove2() {
    testTrade = new Account();
    testTrade.addPortfolio("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddRemove3() {
    testTrade = new Account();
    testTrade.removePortfolio("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddRemove4() {
    testTrade = new Account();
    testTrade.addPortfolio("Farming");
    testTrade.addPortfolio("Farming");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddRemove5() {
    testTrade = new Account();
    testTrade.removePortfolio("Retirement");
  }
}