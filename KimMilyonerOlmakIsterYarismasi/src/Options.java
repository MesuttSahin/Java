public class Options
{
    public String dataOptions(int questionNumber)
    {
        if (questionNumber==1)
        {
            return "A) Elma\n" +
                    "B) Patates\n" +
                    "C) Çilek\n" +
                    "D) Muz";
        }

        else if(questionNumber==2)
        {
            return "A) Mars\n" +
                    "B) Jüpiter\n" +
                    "C) Venüs\n" +
                    "D) Uranüs";
        }

        else if(questionNumber==3)
        {
            return "A) 1919\n" +
                    "B) 1923\n" +
                    "C) 1933\n" +
                    "D) 1945";
        }
        else if(questionNumber==4)
        {
            return "A) Pablo Picasso\n" +
                    "B) Vincent van Gogh\n" +
                    "C) Leonardo da Vinci\n" +
                    "D) Salvador Dalí";
        }
        else if(questionNumber==5)
        {
            return "A) 1950\n" +
                    "B) 1968\n" +
                    "C) 1972\n" +
                    "D) 1985";
        }
        else if(questionNumber==6)
        {
            return "A) Mars\n" +
                    "B) Neptün\n" +
                    "C) Jüpiter\n" +
                    "D) Uranüs";
        }
        else if(questionNumber==7)
        {
            return "A) 1963\n" +
                    "B) 1972\n" +
                    "C) 1984\n" +
                    "D) 2002";
        }
        else if(questionNumber==8)
        {
            return "A) Venüs\n" +
                    "B) Mars\n" +
                    "C) Jüpiter\n" +
                    "D) Satürn";
        }
        else if(questionNumber==9)
        {
            return "A) George Orwell\n" +
                    "B) Aldous Huxley\n" +
                    "C) Ray Bradbury\n" +
                    "D) H.G. Wells";
        }
        else if(questionNumber==10)
        {
            return "A) Türkiye\n" +
                    "B) Pakistan\n" +
                    "C) Cezayir\n" +
                    "D) Tunus";
        }
        else if(questionNumber==11)
        {
            return "A) Isaac Newton\n" +
                    "B) Galileo Galilei\n" +
                    "C) Albert Einstein\n" +
                    "D) Stephen Hawking";
        }

        return "System Error";
    }
}
