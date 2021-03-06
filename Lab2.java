import java.util.Scanner;
public class Main {
    static void Func1() {
        int x = 0;
        int y = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введіть x");
                x = scanner.nextInt();
                System.out.println("Введіть y");
                y = scanner.nextInt();
                if (x - y == 0) {
                    throw new Exception("Ділення на нуль неможливе,введіть данні заново");
                }
                if (x - y < 0) {
                    throw new Exception("Корінь з від'ємного числа не вичисляється");
                }
                System.out.println((Math.pow(x, 2) + Math.pow(y, 2)) / Math.sqrt(x - y));
                return;
            } catch (Exception ex) {
                System.out.println(ex.toString());
                continue;
            }
        }
    }

    static double Func2() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        Math.pow(sum, 2);
        return sum;
    }
    static double Func4() {
        double a = -Math.PI;
        double b = Math.PI;
        double dx = Math.PI/10;
        double x = a;
        while(x <= b)
        {
            double y = Math.cos(x) * Math.sin(x);
            System.out.printf("\t|x|");
            System.out.printf("\t%.2f",x);
            System.out.printf("\t|y|");
            System.out.printf("\t%.2f",y);
            x = x + dx;
            System.out.println();
        }
        return x;
    }
    static void Func3() {
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
            System.out.print("Результат функції:");
            System.out.printf("%.2f",sum);
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Func3();
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                int input = 0;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введіть номер завдання 1-4");
                input = scanner.nextInt();
                {
                    switch (input) {
                        case (1): {
                            System.out.println("1 завдання:");
                            Func1();
                            break;
                        }
                        case (2): {
                            System.out.println("2 завдання:");
                            System.out.println(Func2());
                            break;
                        }
                        case (3): {
                            System.out.println("3 завдання:");
                            Func3();
                            break;
                        }
                        case (4): {
                            System.out.println("4 завдання:");
                            Func4();
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println("Неправильне значення");
                continue;
            }

        }
    }
}
