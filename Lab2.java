import java.util.Scanner;
public class Main {
    static void Func1()
    {
        int x = 0;
        int y = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть x");
            x = scanner.nextInt();
            System.out.println("Введіть y");
            y = scanner.nextInt();
            if(x-y==0)
            {
                throw new Exception("Ділення на нуль неможливе,введіть данні заново");
            }
            if(x-y<0)
            {
                throw new Exception("Корінь з від'ємного числа не вичисляється");
            }
            System.out.println((Math.pow(x,2) + Math.pow(y,2))/Math.sqrt(x-y));
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func1();
        }
    }
    static double Func2()
    {
        int sum = 0;
        for(int i=1;i<10;i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        Math.pow(sum,2);
        return sum;
    }
    static void Func3()
    {
        int x = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть x");
            x = scanner.nextInt();
            double sum = 1;
            for (double i = 1; i <= 5; i++) {
                for (double j = 1; j <= i; j++) {
                    sum = sum * (i + Math.pow(x, j));
                }
            }
            System.out.println("Результат функції:" + sum);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            Func3();
        }
    }

    public static void main(String[] args)
    {
       Func3();
    }
} 
