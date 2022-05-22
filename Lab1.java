import java.util.Scanner;
public class Main {
    static double Func1v1()
    {
        int b = 0;
        int c = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("введіть b");
            b = scanner.nextInt();
            System.out.println("введіть c");
            c = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func1v1();
        }
        double a = 0;
        if(b == 1)
        a = 4*b-9*c;
        if(b == 2)
            try {
                if(2 - b * c < 0)
                throw new Exception("Корінь з від'ємного числа не вичисляється,введіть заново");
                a = Math.sqrt(2 - b * c);
            }
            catch (Exception ex)
            {
                System.out.println(ex.toString());
                Func1v1();
            }
        if(b == 3)
            try {
                if(c == 0)
                throw new Exception("Ділення на 0 неможливе,введіть заново");
                a = b / (c * c);
            }
            catch (Exception ex)
            {
                System.out.println(ex.toString());
                Func1v1();
            }
        if(b>3||b<1)
        System.out.println("Nemozhlivo vichisliti rezul'tat,введіть zanowo");
        if(b>3||b<1)
            Func1v1();
        return a;
    }
    static double Func1v2()
    {
        int b = 0;
        int c = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть b");
            b = scanner.nextInt();
            System.out.println("Введіть c");
            c = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func1v2();
        }
        double a = 0;
        if(b == 1) {
            a = 4 * b - 9 * c;
        }
        else if(b == 2) {
            try {
                if(2 - b * c < 0) {
                    throw new Exception("Корінь з від'ємного числа не вичисляється,введіть заново");
                }
                else
                {
                    a = Math.sqrt(2 - b * c);
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
                Func1v2();
            }
        }
        else if (b == 3) {
            try {
                if(c==0) {
                    throw new Exception("Ділення на 0 неможливе,введіть заново");
                }
                else {
                    a = b / (c * c);
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
                Func1v2();
            }
        }
        else {
            System.out.println("Nemozhlivo vichisliti rezul'tat,введіть zanowo");
            Func1v2();
        }
        return a;
    }
    /*Ввести з клавіатури 4 числа d1, d2, d3, d4. Визначити, чи утворюють вони неспадну
    послідовність. Якщо утворюють, то вивести їх середнє арифметичне, в протилежному випадку –
    середнє геометричне.*/
    static void Func2()
    {
        double d1 = 0,d2 = 0,d3 = 0,d4 = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть d1:");
            d1 = scanner.nextDouble();
            System.out.println("Введіть d2:");
            d2 = scanner.nextDouble();
            System.out.println("Введіть d3:");
            d3 = scanner.nextDouble();
            System.out.println("Введіть d4:");
            d4 = scanner.nextDouble();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func2();
        }
        if(d1 < d2 && d2 < d3 && d3 < d4)
        {
            System.out.println((d1+d2+d3+d4)/4);
        }
        else
            try {
                if (d1 * d2 * d3 * d4 > 0)
                    System.out.println(Math.pow(d1 * d2 * d3 * d4, 1.0 / 4));
                else
                    throw new Exception();
            }
            catch (Exception ex)
            {
                System.out.println(ex.toString());
                Func2();
            }
    }
    static void Func3()
    {
        int n = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть номер місяця:");
            n = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func3();
        }
        switch (n) {
            case 1:
            {
            }
            case (2):
            {
                System.out.println("Зима");
                break;
            }
            case (3):
            {

            }
            case (4):
            {
            }
            case (5):
            {
                System.out.println("Весна");
                break;
            }
            case (6):
            {

            }
            case (7):
            {
            }
            case (8):
            {
                System.out.println("Літо");
                break;
            }
            case (9):
            {
            }
            case (10):
            {
            }
            case (11):
            {
                System.out.println("Осінь");
                break;
            }
            case (12):
            {
                System.out.println("Зима");
                break;
            }
        }
    }
    static double Func4()
    {
        int x = 0;
        int y = 0;
        int z = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть x");
            x = scanner.nextInt();
            System.out.println("Введіть y");
            y = scanner.nextInt();
            System.out.println("Введіть z");
            z = scanner.nextInt();
            if(Math.pow(x,2)-x*y+Math.pow(y,2)==0 || 1-Math.pow(y,2)==0 || 1-Math.pow(x,2)==0)
            {
                throw new Exception("Ділення на нуль неможливе,введіть данні заново");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func4();
        }
        double r = 0;
        return (x+y/Math.pow(x,2)-x*y+Math.pow(y,2)) + (Math.sin(x)/1-Math.pow(y,2)) + (Math.cos(y)/1-Math.pow(x,2));
    }
    public static void main(String[] args)
    {
        //System.out.println(Func1v1());
        //System.out.println(Func1v2());
        //Func2();
        //Func3();
        System.out.println(Func4());
    }
}
