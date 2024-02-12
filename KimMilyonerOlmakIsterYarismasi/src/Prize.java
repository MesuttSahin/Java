public class Prize
{
    public void prize(int correct)
    {
        switch (correct)
        {
            case 0:
                System.out.println("Ödül: 0");
                break;
            case 1:
                System.out.println("Ödül: 5,000");
                break;
            case 2:
                System.out.println("Ödül: 10,000");
                break;
            case 3:
                System.out.println("Ödül: 15,000");
                break;
            case 4:
                System.out.println("Ödül: 30,000");
                break;
            case 5:
                System.out.println("Ödül: 50,000");
                break;
            case 6:
                System.out.println("Ödül: 100,000");
                break;
            case 7:
                System.out.println("Ödül: 300,000");
                break;
            case 8:
                System.out.println("Ödül: 500,000");
                break;
            case 9:
                System.out.println("Ödül: 800,000");
                break;
            case 10:
                System.out.println("Ödül: 1,000,000");
                System.out.println("Tebrikler.... Büyük ödülü kazandınız....");
                break;
            default:
                System.out.println("System error");
                break;
        }
    }
}
