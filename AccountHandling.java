import java.util.*;

interface Operation{
  float deposit(int pin, float Amt);
  float withdraw(int pin, float Amt);
  void Transaction(int pin, int n);
  void showBalance(int Ac_no, int pin);
}


class BankOperations implements Operation {
  final int AccountNumber;
  String name;
  float Balance;
  int pin;
  ArrayList<String> Transaction = new ArrayList<>();
  
  BankOperations(String name, float OpeningBalance)
 {
    this.name=name;
    this.Balance=OpeningBalance;
    int Ac=((int)(Math.random()*8999999))+1000000;
    this.AccountNumber=Math.round(Ac);
    System.out.println("Your Name is "+name+" your assigned Acount number is : "+AccountNumber);
 }



  public float deposit(int pin, float Amt){
   if(this.pin==pin){
    Balance+=Amt;
    System.out.println("₹"+Amt+" deposited successfuly in A/c no. "+AccountNumber);
    Transaction.add("Deposited :₹"+Amt);
   } 
   else{
    System.out.println("PIN not matched ");
   }   
    
    return Balance;
  }


  public float withdraw(int pin, float Amt){
    if(this.pin==pin){
     
      if(this.Balance>=Amt){
          System.out.println("₹"+Amt+" deducted successfuly from A/c no. "+AccountNumber);
          Balance -=Amt;
          Transaction.add("Withdrawed :₹"+Amt);
      }
      else{
          System.out.println("Sufficient amount not available in A/c "+AccountNumber);
      }
  
     } 
     else{
      System.out.println("PIN not matched ");
     }      
    return Balance;
  }



  public void Transaction(int pin, int n){
    if(this.pin==pin){

     if(Transaction.size()>=n){
     for (int index = 0; index < n; index++) {
      System.out.println(Transaction.get(index));
     }
    }
     else{
      
      System.out.println("You have only "+Transaction.size()+" transactions");
      for (int index = 0; index < Transaction.size(); index++) {
        System.out.println(Transaction.get(index));
       }
     }
     
     } 
    
     else{
      System.out.println("PIN not matched ");
     }      
  }

  public void showBalance(int Acc_no, int pin){
  if(AccountNumber==Acc_no && this.pin==pin){
    System.out.println("Available balance in you account is :"+Balance);
  }
  else{
    System.out.println("PIN or Account number not matched");
  }
  }

}

class AccountHandling {
  public static void main(String [] arg){
  
    System.out.println("Welcome to NewBank ");
    System.out.println("To open your a new account we need some of your informations ");
    System.out.println("Enter Your name ");
    
    Scanner read=new Scanner(System.in);
    String name=read.next();

    System.out.println("Enter the amout with which you want to open the Account ");
    int OpeningBalance=read.nextInt();

    BankOperations User1= new BankOperations(name, OpeningBalance);
    System.out.println("Set your Account PIN "); 
    User1.pin=read.nextInt();

    System.out.println("Your Account has been successfuly stablished remember the Account number and the pin you set"); 
    System.out.println("What task you want to perform : "); 

    System.out.println("Enter 1,2,3,4,5 (to Deposit, WIthdraw, Show Transactions, Show balance, and Quit respectiverl) :");
    int opr=0;
 

    while(true){
      System.out.println("What next?");
      opr=read.nextInt();
     
      switch (opr) {
        case 1:
        {
        System.out.println("Enter the pin and Amount");
        int p=read.nextInt();
        float amt=read.nextInt();
        User1.deposit(p,amt);
        break;
      }

        case 2:
      {
        System.out.println("Enter the pin and Amount");
        int p=read.nextInt();
        float amt=read.nextInt();
        User1.withdraw(p, amt);
        break;
      }

      case 3:
      {  System.out.println("Enter the pin and number of transaction you want to check");
       int p=read.nextInt();
       int n=read.nextInt();
       User1.Transaction(p, n);
       break;
      }

        case 4:
      {  System.out.println("Enter the Account number and pin");
       int a=read.nextInt();
       int p=read.nextInt();
       User1.showBalance(a, p);
       break;
      }

      
        case 5:
      {
        System.out.println("Exiting");
        break;
      }

    
      default:
      System.out.println("Enter valid entry");
      break;
    }

    if(opr==5){
      break;
    }

  }
  }  
}
