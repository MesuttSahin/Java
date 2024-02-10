public class Transaction
{
    public double Transactions(char op,double num1,double num2)
    {
        switch (op) {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;
            default:
                System.out.println("!!Wrong Operator Usage!!");
        }

        return 0;
    }
}
