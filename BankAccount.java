//*****************************************
//   Name: Declan Hays
//   CTP 150 – Section# 002
//   Lab: 09
//*****************************************

import java.text.DecimalFormat;

/**
The BankAcccount class allows the user to create a fully functioning bank account
*/
public abstract class BankAccount
{
   private double balance;
   private double numDeposits;
   private double numWithdrawals;
   private double annIntRate;
   private double monthlyServiceCharges;
   
   /**
   default constructor
   */
   public BankAccount()
   {
      balance = 0;
      numDeposits = 0;
      numWithdrawals = 0;
      annIntRate = 0;
      monthlyServiceCharges = 0;
   }
   
   /**
   constructor taking parameters for balance and annual interest
   @param bal Balance
   @param annInt annual interest
   */
   public BankAccount(double bal, double annInt)
   {
      balance = bal;
      annIntRate = annInt;
   }
   
   /**
   constructor taking parameters for balance, annual interest, and monthly service charges
   @param bal Balance
   @param annInt annual interest
   @param servChar service charges
   */
   public BankAccount(double bal, double annInt, double servChar)
   {
      balance = bal;
      annIntRate = annInt;
      monthlyServiceCharges = servChar;
   }
   
   /**
   allows user to add money to bank account
   @param amount Money to be added to account
   */
   protected void deposit(double amount)
   {
      balance += amount;
      numDeposits++;
   }
   
   /**
   allows user to take money out of account
   @param amount Money to be taken from account
   */
   protected void withdraw(double amount)
   {
      balance -= amount;
      numWithdrawals++;
   }
   
   /**
   calculates the annual interest on an account
   @return interest Monthly interest on an account
   */
   protected double calcInterest()
   {
      double monthlyIntRate = annIntRate/12;
      double interest = balance*monthlyIntRate;
      balance = balance + interest;
      return interest;
   }
   
   /**
   performs monthly functions on an account
   */
   protected void monthlyProcess()
   {
      balance -= monthlyServiceCharges;
      calcInterest();
      numDeposits = 0;
      numWithdrawals = 0;
   }
   
   /**
   gets balance
   @return balance
   */
   public double getBalance()
   {
      return balance;
   }
   
   /**
   gets the number of deposits made for the month
   @return numDeposits
   */
   public double getNumDeposits()
   {
      return numDeposits;
   }
   
   /**
   gets the number of withdrawals made that month
   @return numWithdrawals
   */
   public double getNumWithdrawals()
   {
      return numWithdrawals;
   }
   
   /**
   gets the annual interest rate
   @return annIntRate
   */
   public double getAnnIntRate()
   {
      return annIntRate;
   }
   
   /**
   gets the monthly service charges
   @return monthlyServiceCharge
   */
   public double getMonthlyServiceCharges()
   {
      return monthlyServiceCharges;
   }
   
   /**
   sets the balance of the account
   @param bal Balance
   */
   public void setBalance(double bal)
   {
      balance = bal;
   }
   
   /**
   sets the annual interest rate
   @param intRate interest rate
   */
   public void setIntRate(double intRate)
   {
      annIntRate = intRate;
   }
   
   /**
   sets the monthly service charges
   @param amount money to be charges per month
   */
   public void setMonthlyServiceCharges(double amount)
   {
      monthlyServiceCharges = amount;
   }
   
   /**
   displays balance, number of deposits and withdrawals
   @return s
   */
   public String toString()
   {
      DecimalFormat format = new DecimalFormat("#0.00");
      String s = "";
      s += "Balance: $" + format.format(balance);
      s += "\nNumber of deposits: " + numDeposits;
      s += "\nNumber of withdrawals: " + numWithdrawals;
      return s;
   }
}