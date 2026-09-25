package samplearrays;

public class BankAccount {

    private String name;
    private double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    private double[] transactions=new double[1000];
    private int tansactionCounter=0;
    public BankAccount(String name, int startingBalance){
        this.name=name;
        this.currentBalance=startingBalance;
    }

    public void deposit(double amount){
        if(amount>0){
            transactions[tansactionCounter]=amount;
            tansactionCounter++;
            currentBalance+=amount;
            System.out.println("The depositor : "+name+" ,has deposed an amount of : "+amount+" MAD"+" ,the current balance is : "+currentBalance);
        }else{
            System.out.println("Error : negative deposed amount");
        }
    }

    public void withdraw(double amount){
        if((0<amount)&&(amount<=currentBalance)){
            transactions[tansactionCounter]=0-amount;
            tansactionCounter++;
            currentBalance-=amount;
            System.out.println("The withdrawer : "+name+" ,has withdraw an amount of : "+amount+" MAD"+" ,the current balance is : "+currentBalance);
        }else{
            System.out.println("Error : invalid withdraw amount");
        }
    }

    public void displayTransactions(){
        for(int i=0;i<tansactionCounter;i++){
            System.out.println("Transaction "+i+" : "+transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println("The current balance is : "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
