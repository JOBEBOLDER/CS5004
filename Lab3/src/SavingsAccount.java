public class SavingsAccount extends AbstractAccount {

    private int withdrawCount;

  public SavingsAccount(double starterAmount) {
      super(starterAmount); // 父类初始化
    this.withdrawCount = 0;
  }

  @Override
  public boolean withdraw(double amount) {
    if (super.withdraw(amount)) {
      withdrawCount++;
      return true;
    }
    return false;
  }

  @Override
  public void  performMonthlyMaintenance() {
    if (withdrawCount > 6) {
      balance -= 14;
    }
    withdrawCount = 0;
  }

}
