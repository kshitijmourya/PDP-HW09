import Model.Account;
import View.UserView;

public class Main {

  public static void main(String[] args){

    Account model= new Account();
    UserView view = new UserView();

    //AppController2 controller = new AppController2(model);

    //controller.runApp();
    view.run();
  }
}
