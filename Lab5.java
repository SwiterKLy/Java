import java.io. *;
import java.util.Arrays;
import java.util.Scanner;

class Lab5 {

    public void Z1(){
        Scanner a = new Scanner(System.in);
        String sentence;
        String[] words;
        System.out.print("Введіть речення: ");
        sentence = a.nextLine();
        words = sentence.split(" ");
        if(words.length <= 1){
            System.out.println("Кількість слів має бути не менше 2");
            Z1();
            return;
        }
        System.out.println("Кількість слів: " + words.length);
        for(int i = 0; i < words.length; i++){
            char[] word = words[i].toCharArray();
            int c = 0;
            for(char w : word){
                if(contains(w, new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'})){
                    c++;
                }
            }
            if(c%2 != 0){
                words[i] = null;
            }
        }
        System.out.print("Після видалення слів з непарною кількістю голосних: ");
        for(int i = 0; i < words.length; i++){
            if(words[i] == null){
                continue;
            }
            System.out.print(words[i] + " ");
        }
        System.out.println();

        words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(new StringBuilder(words[i]).reverse().toString())){
                words[i] = null;
            }
        }
        System.out.print("Після видалення слів паліндромів: ");
        for(int i = 0; i < words.length; i++){
            if(words[i] == null){
                continue;
            }
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }
    private boolean contains(char a, char[] word){
        for (char c : word) {
            if (a == c) {
                return true;
            }
        }
        return false;
    }
    public void Z2(){
        Scanner a = new Scanner(System.in);
        String path = "C:/Java/lab5.txt";
        try(FileReader reader = new FileReader(path))
        {
            char[] text = new char[256];
            int c;
            while((c = reader.read(text))>0){

                if(c < 256){
                    text = Arrays.copyOf(text, c);
                }
                System.out.print(text);
            }
            char tmp = 0;
            tmp = text[0];
            text[0] = text[3];
            text[3] = tmp;
            FileWriter writer = new FileWriter("NewFile.txt", false);
            writer.write(text);
            writer.flush();
        }
        catch (Exception ex){
            System.out.println("Файла нема");
            Z2();
            return;
        }
    }

    public static class Main {
        public static void main(String[] args) {
           Lab5 laba = new Lab5();
           System.out.println("1 Завдання:");
           /* 7. а) видаляє всі слова, що містять непарну кількість голосних літер; б) видаляє з тексту всі
            слова-паліндроми*/
           laba.Z1();
           System.out.println("2 Завдання:");
            /*7. Дано файл, елементами якого є окремі символи, що складають слово "олгаритм". Отримати
            новий файл, в якому літери слова "алгоритм" будуть розміщені правильно.*/
           laba.Z2();
            float[] a = new float[6];
            for (int i = 1; i <= 6; i++) {
                System.out.print((float) i / 7 + "\t");
                a[i - 1] = (float) i / 7;
            }
            System.out.println();
            for (int i = 0; i < 6; i++) {
                if (a[i] < 0.5f) {
                    a[i] -= Math.abs((0.5f - a[i]) / 7);
                } else {
                    a[i] += Math.abs((0.5f - a[i]) / 7);
                }
                System.out.print(a[i] + "\t");
            }
        }
    }
}
