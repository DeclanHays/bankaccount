//*****************************************
//   Name: Declan Hays
//   CTP 150 – Section# 002
//   Lab: 09
//*****************************************
/**

*/
public class SavingsAccount extends BankAccount
{
   private boolean isActive = true;
   public static final double SUFFICIENT_FUNDS = 25;
   
   /**
   default constructor
   */
   public SavingsAccount()
   {
      super();
   }
   
   /**
   constructor that sets values for balance, annInt, and serChar
   @param bal Balance
   @param annInt annual interest 
   @param serChar monthly service charges
   */
   public SavingsAccount(double bal, double annInt, double serChar)
   {
      super(bal, annInt, serChar);
   }
   
   /**
   checks if the account has more than $25, if yes then deposits, if not then denied
   @param amount Money to be taken from account
   */
   public void withdraw(double amount)
   {
      if(isActive)
      {
         super.withdraw(amount);
      }
      else
         System.out.println("This account is not active. Withdrawal denied.");
         
      updateStatus();
   }
   
   /**
   puts money into account, if account now has more than $25 then status is changes to active
   @param amount Money to be added to account
   */
   public void deposit(double amount)
   {
      if(isActive)
      {
         super.deposit(amount);
      }
      else
      {
         super.deposit(amount);
      }
      
      updateStatus();
   }
   
   /**
   checks if the monthly withdrawals for the account is over 4, every one over 4 is $1 added to monthly fees
   */
   public void monthlyProcess()
   {
      if(getNumWithdrawals() > 4)
      {
         setMonthlyServiceCharges(getMonthlyServiceCharges() + (getNumWithdrawals() - 4));
      }
      super.monthlyProcess();
      
      updateStatus();
   }
   
   /**
   gets the status
   @return isActive
   */
   public boolean getStatus()
   {
      return isActive;
   }
   
   /**
   if the account is inactive then the user is informed. Otherwise, account specifications displayed as usual
   @return s
   */
   public String toString()
   {
      String s = "";      
      if(!isActive)
      {
         s += "Balance is less than $25. The account is inactive.\n";
      }
      s += super.toString();
      return s;
   }
   
   /**
   updates the status of the account, if more than $25 then it is active, inactive otherwise
   */
   private void updateStatus()
   {
      if(getBalance() > 25)
      {
         isActive = true;
      }
      else
         isActive = false;
   }
   
}