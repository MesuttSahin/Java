import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your password: ");
        int pw=scanner.nextInt();
        Atm atm=new Atm();
        while (true)
        {
            if (pw == atm.password)
            {
                atm.displayMenu();
                System.out.println("Please enter the action you want to make...");
                int choice = scanner.nextInt();
                switch (choice)
                {
                    case 1:
                        atm.balanceInquiry();
                        break;
                    case 2:
                        System.out.print("Please enter the amount you want to withdraw : ");
                        int amount = scanner.nextInt();
                        atm.withdraw(amount);
                        break;
                    case 3:
                        System.out.print("Please enter the amount you want to deposit :  ");
                        amount=scanner.nextInt();
                        atm.deposit(amount);
                        break;
                    case 4:
                        System.out.println("Exiting Atm, We wish you a nice day...");
                        return;
                    default:
                        System.out.println("Invalid choice, Please enter a number between 1 and 4 ");
                        break;

                }


            }
            else
            {
                System.out.println("Invalid password, Please try again");

                return;
            }

        }
    }
}
