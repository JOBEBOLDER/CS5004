public abstract class AbstractAccount implements IAccount {
  protected double balance;

  public AbstractAccount(double startAmount) {
    if (startAmount < 0 || startAmount < 0.01) {
      throw new IllegalArgumentException(
              "Your starter amount money can not be negative and less than 0.01!"
      );
    }
    this.balance = startAmount;
  }

  @Override
  public void deposit(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException(
              "Your deposited Money can not be negative!! "
      );
    }
    balance += amount;
  }

  @Override
  public boolean withdraw(double amount) {
    if (amount < 0 || amount > balance) {
      return false;
    }
    balance -= amount;
    return true;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public abstract void  performMonthlyMaintenance();

  @Override
  public String toString() {
    return String.format("$%.2f", balance);
  }


















  }















}
