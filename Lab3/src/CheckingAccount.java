public class CheckingAccount extends AbstractAccount {

  public CheckingAccount(double startAmount) {
    super(startAmount);
  }

  @Override
  public void performMonthlyMaintenance() {
    if (balance < 100) {
      balance -= 5;
    }
  }
}
