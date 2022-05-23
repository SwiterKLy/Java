import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static int PZ1_1(int mas[]) {
        int sum = 1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 0) {
                sum *= mas[i];
            }
        }
        return sum;
    }
    public static int PZ1_2(int mas[]) {
        int sum = 0;
        for (int i = 0; i < mas.length && mas[i] < 0; i++) {
                sum += mas[i];
        }
        return sum;
    }
    public static int PZ2(Vector<Integer> vec)
    {
        int lengh = vec.size();
        int sum = 0;
        for (int i = 0; i < vec.size(); i++) {
            if(vec.elementAt(i)%2 == 0) {
                sum += vec.elementAt(i);
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner a = new Scanner(System.in);
        int lengh = 0;
        int type;
        while(true) {
            try {
                System.out.print("Введіть розмір массиву: ");
                lengh = a.nextInt();
            } catch (Exception ex) {
                System.out.println("Невірне значення");
                continue;
            }
        int[] mass = new int[lengh];
        Random r = new Random();
        for (int i = 0; i < lengh; i++) {
            mass[i] = r.nextInt(200) - 100;
        }
        int n = 0;
        boolean input = true;
        while(input) {
            System.out.println("\n");
            System.out.print("Масив: ");
            for (int i = 0; i < lengh; i++)
            {
                System.out.print(mass[i] + " ");
            }
            System.out.println("\nВивести:");
            System.out.println("1.Добуток додатних елементів масиву");
            System.out.println("2.Суму елементів масиву розташованих до останнього додатного елемента");
            System.out.println("3.Суму парних елементів одновимірного масиву (вектора) із n елементів цілого типу");
            try {
                System.out.print("Оберіть опцію: ");
                n = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("Введене некоректне значення");
                continue;
            }
            switch (n) {
                case (1):
                    System.out.println("Добуток додатніх элементів масиву дорівнює:" + PZ1_1(mass));
                    break;
                case (2):
                    System.out.println("Сума елементів масиву розташованих до останнього додатного елемента дорівнює:" + PZ1_2(mass));
                    break;
                case (3):
                    while (n != 1 && n!= 2) {
                        try {
                            System.out.println("1.Перевести в вектор элементи із массиву");
                            System.out.println("2.Ввести вектор вручну:");
                            n = new Scanner(System.in).nextInt();
                            if(n != 1 && n!= 2)
                            {
                                throw new Exception();
                            }
                        }
                        catch (Exception ex) {
                            System.out.println("Введене некоректне значення");
                            continue;
                        }

                    }
                    Vector<Integer> vec = new Vector<>();
                    if(n == 1)
                    {
                        for (int i = 0; i < lengh; i++) {
                            vec.add(mass[i]);
                        }
                    }
                    else
                    {
                        while(n != 0)
                        {
                            try {
                                System.out.print("\tВведіть " + (vec.size() + 1) + " елемент вектору(введіть 0 щоб завершити): ");
                                if(n != 0) {
                                    vec.add(n = new Scanner(System.in).nextInt());
                                }
                            }
                            catch (Exception ex){
                                System.out.print("\tНевірне значення");
                                continue;
                            }
                        }
                    }
                    System.out.println("Суму парних елементів одновимірного масиву (вектора) дорівнює:" + PZ2(vec));
                    break;
            }

        }
    }
    }
}
