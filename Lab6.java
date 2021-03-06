import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.io.IOException;

class Student{
    private String secondName;
    private Date birthDate;
    private String birthPlace;
    public static List<Student> AllStudents = new ArrayList<>();

    public Student(String secondName,Date birthDate,String birthPlace)
    {
        this.secondName =  secondName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        AllStudents.add(this);
    }
    public Student(Student a){
        this.secondName = a.secondName;
        this.birthDate = a.birthDate;
        this.birthPlace = a.birthPlace;
        AllStudents.add(this);
    }
    public Student(){ }
    public static Student AddStudentInfo(){
        Scanner a = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        Student b = new Student();
        try {
            System.out.print("\tВведіть прізвище студента: ");
            b.secondName = a.nextLine();
            System.out.println("\tВведіть дату народження: ");
            int d, m, y;
            System.out.print("\t\tДень: ");
            d = a.nextInt();
            System.out.print("\t\tМісяць: ");
            m = a.nextInt();
            System.out.print("\t\tРік: ");
            y = a.nextInt();
            b.birthDate = new Date(y - 1900, m - 1, d);
            System.out.print("\tВведіть місце народження: ");
            b.birthPlace = f.nextLine();
        }
        catch(Exception ex){
            System.out.println("Введене некоректне значення");
            return AddStudentInfo();
        }
        return b;
    }
    private void OutputInfo(){
        SimpleDateFormat aboba = new SimpleDateFormat("d-MM-y");
        System.out.println(secondName + "\t|\t" + aboba.format(birthDate) + "\t|\t" + birthPlace);
    }
    public static void PrintAllStudentInfo(List<Student> a){
        System.out.println("Кількість студентів: " + a.size());
        for(int i = 0; i < a.size(); i++){
            a.get(i).OutputInfo();
        }
    }
    public static void PrintAllSortedStudentInfo(){
        List<Student> arrayToSort = new ArrayList<>();
        arrayToSort.addAll(AllStudents);
        Date d = new Date();
        List<Student> aa = new ArrayList<>();
        for(int i = 0; i < arrayToSort.size() - 1; i++){
            for(int j = 0; j < arrayToSort.size() - 1; j++){
                d = arrayToSort.get(i).birthDate;
                if(d.compareTo(arrayToSort.get(i+1).birthDate) < 0){
                    Student tmp = arrayToSort.get(i+1);
                    arrayToSort.set(i+1, arrayToSort.get(i));
                    arrayToSort.set(i, tmp);
                }
            }
        }
        PrintAllStudentInfo(arrayToSort);
        System.out.println("Двійнята");
        PrintAllStudentInfo(aa);
    }
    public static int dateValue(Date a){
        int c = 0;
        c += a.getDay();
        c += a.getMonth() * 30;
        c += a.getYear() * 365;
        return c;
    }

}
class TimeTable implements Serializable{
    public int lessonNumber;
    public int dayWeek;
    public String subject;
    public String teacherSecondName;
    public boolean educationType;
    public static List<TimeTable> AllTimeTabled = new ArrayList<TimeTable>();
    public static List<TimeTable> sorted = new ArrayList<TimeTable>();

    public TimeTable(int lessonNumber, int dayWeek, String subject, String teacherSecondName,boolean educationType){
        this.lessonNumber = lessonNumber;
        this.dayWeek = dayWeek;
        this.subject = subject;
        this.teacherSecondName = teacherSecondName;
        this.educationType = educationType;
        AllTimeTabled.add(this);
    }
    public TimeTable(TimeTable a){
        this.lessonNumber = a.lessonNumber;
        this.dayWeek = a.dayWeek;
        this.subject = a.subject;
        this.teacherSecondName = a.teacherSecondName;
        this.educationType = a.educationType;
        AllTimeTabled.add(this);
    }
    public TimeTable(){ }
    public static TimeTable AddTimeTableInfo(){
        Scanner a = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        TimeTable b = new TimeTable();
        try {
            System.out.print("\tВведіть номер пари: ");
            b.lessonNumber = a.nextInt();
            System.out.print("\tВведіть день тижня(номер дня): ");
            b.dayWeek = a.nextInt();
            System.out.print("\tВведіть назву предмета: ");
            b.subject = f.nextLine();
            System.out.print("\tВведіть прізвище викладача: ");
            b.teacherSecondName = f.nextLine();
            System.out.print("\tВведіть форму навчання(якщо очна, то ОЧНА, якщо дистанційна то ДИСТАНЦІЙНА: ");
            String v = f.nextLine();
            if(v.equals("ОЧНА")){
                b.educationType = true;
            }
            else if(v.equals("ДИСТАНЦІЙНА")){
                b.educationType = false;
            }
            else{
                throw new RuntimeException();
            }
        }
        catch(Exception ex){
            System.out.println("Введене некоректне значення");
            return AddTimeTableInfo();
        }
        return b;
    }
    public static void DeleteTimeTableInfo(){
        System.out.println("Введіть номер запису: ");
        int n = new Scanner(System.in).nextInt();
        if(n > AllTimeTabled.size()){
            System.out.println("Номер за межами массиву!");
            DeleteTimeTableInfo();
            return;
        }
        AllTimeTabled.remove(n - 1);
    }
    public static void OutputAllTimeTableInfo(List<TimeTable> array){
        System.out.println("Кількість записів: " + array.size());
        for(int i = 0; i < array.size(); i++){
            array.get(i).OutputTimeTableInfo();
        }
    }
    public void OutputTimeTableInfo(){
        System.out.println("\tНомер пари: " + lessonNumber);
        System.out.println("\tДень тижня: " + dayWeek);
        System.out.println("\tПредмет: " + subject);
        System.out.println("\tПрізвище вчителя: " + teacherSecondName);
        if(educationType) System.out.println("\tФорма навчання: ОЧНА");
        else System.out.println("\tФорма навчання: ДИСТАНЦІЙНА");
        System.out.println();
    }
    public static void SortTabels() {
        sorted.addAll(AllTimeTabled);
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            System.out.println(sorted.size());
            for (int i = 0; i < sorted.size() - 1; i++) {
                if (sorted.get(i).dayWeek > sorted.get(i + 1).dayWeek) {
                    TimeTable tmp = sorted.get(i);
                    sorted.set(i, sorted.get(i + 1));
                    sorted.set(i + 1, tmp);
                    needIteration = true;
                }
            }
        }
        TimeTable.OutputAllTimeTableInfo(sorted);
    }
//        sorted.addAll(AllTimeTabled);
//        for(int i = 0; i < sorted.size()-1; i++){
//            for(int j = 0; j < sorted.size()-1; j++){
//                if(sorted.get(i).dayWeek < sorted.get(i+1).dayWeek){
//                    TimeTable tmp = sorted.get(i);
//                    sorted.set(i, sorted.get(i+1));
//                    sorted.set(i+1, tmp);
//                }
//            }
//        }
//
//    }
    public static void SearchTabels(){
        String name;
        System.out.print("Введіть прізвище викладача: ");
        name = new Scanner(System.in).nextLine();
        for(int i = 0; i < AllTimeTabled.size(); i++){
            if(AllTimeTabled.get(i).teacherSecondName.equals(name)){
                AllTimeTabled.get(i).OutputTimeTableInfo();
            }
        }
    }
}
class File_manager{
    public static String path;
    public static void SetPath(){
        path = "C:/Java";
    }
    public static <T>void WriteList(List<T> Tlist) throws IOException {
        FileOutputStream writeData = new FileOutputStream(path + "/laba6-2.txt");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(Tlist);
        writeStream.flush();
        writeStream.close();
    }
    public static <T>List<T> ReadList() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path + "/laba6-2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<T> Tlist = (List<T>) ois.readObject();
        ois.close();
        return Tlist;
    }
}
class File_manager1{
    public static String path;
    public static void SetPath(){
        path = "C:/Java";
    }
    public static <T>void WriteList1(List<T> Tlist) throws IOException {
        FileOutputStream writeData = new FileOutputStream(path + "/laba6-1.dat");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(Tlist);
        writeStream.flush();
        writeStream.close();
    }
    public static <T>List<T> ReadList1() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path + "/laba6-1.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<T> Tlist = (List<T>) ois.readObject();
        ois.close();
        return Tlist;
    }
}
public class Lab6 {

    public static void main(String[] args) throws IOException, InterruptedException, ParserConfigurationException, TransformerException, SAXException, IllegalAccessException, ClassNotFoundException {
        int i = 2;
       /*1. Описати клас для бази зданих з інформацією про студентів з полями: прізвище, дата
        народження, місце народження. Дата народження задається у вигляді ДД:ММ:РР. Відсортувати записи за
        зростанням дат народження та вивести його на екран у формі таблиці. Якщо є студенти з однаковою датою
        народження (співпадають день та місяць), то вивести записи про них окремо в таблиці «двійнята».*/
        {
            Student e = new Student("Лучанко", new Date(2004 - 1900, 7 - 1, 5), "Звенигородка");
            Student f = new Student("Яблонський", new Date(2004 - 1900, 6 - 1, 6), "Новоукраїнка");
            Student j = new Student("Бабак", new Date(2004 - 1900, 5, 7 - 1), "Шпола");
            Student k = new Student("Головінський", new Date(2004 - 1900, 4 - 1, 8), "Ватутіне");
            Student a = new Student("Ластовецький", new Date(2003 - 1900, 4 - 1, 1), "Ізяслав");
            Student b = new Student("Чехівська", new Date(2003 - 1900, 11 - 1, 1), "Свалява");
            Student c = new Student("Воронько", new Date(2003 - 1900, 9 - 1, 3), "Городок");
            Student d = new Student("Зварич", new Date(2003 - 1900, 8 - 1, 4), "Березань");
            Student m = new Student("Многогрішна", new Date(2003 - 1900, 3 - 1, 9), "Городок");
            Student l = new Student("Борушенко", new Date(2003 - 1900, 2 - 1, 10), "Новоукраїнка");
        }
        while(i == 1) {
            File_manager1.SetPath();
            System.out.println("1.Ввести нового студента");
            System.out.println("2.Вивести всіх студентів");
            System.out.println("3.Вивести всіх студентів(відсортовано за датою)");
            System.out.println("4.Вийти");
            System.out.print("Оберіть опцію: ");
            int n = 6;
            while(true) {
                try {
                    n = new Scanner(System.in).nextInt();
                    break;
                }
                catch (Exception ex){
                    System.out.println("Введене некоректне значення");
                    System.out.print("Оберіть опцію: ");
                    continue;
                }
            }
            switch (n) {
                case (1):{
                    Student _student = new Student(Student.AddStudentInfo());
                    break;}
                case (2):
                    Student.PrintAllStudentInfo(Student.AllStudents);
                    break;
                case (3):
                    Student.PrintAllSortedStudentInfo();
                    break;
                case (4):
                    return;

            }
        } // 1 завдання
        File_manager.SetPath();
        while(i == 2){
/*            2. Розробити консольний застосунок для роботи з базою даних, що зберігається у
            текстовому файлі (початковий масив не менше 10 записів). Структура бази даних
            описується класом згідно вашого варіанта. Передбачити роботу з довільною кількістю
            записів. Для ідентифікації спроби введення з клавіатури некоректних даних описати
            10
            виключення. Всі поля класу зробити закритими, а доступ до них реалізувати через get i set.
            Реалізувати конструктори з параметрами та без параметрів, а ініціалізацію полів виконати
            через властивості. Реалізувати методи для:
            – додавання записів;
            – редагування записів;
            – знищення записів;
            – виведення інформації з файла на екран;
            – пошук потрібної інформації за конкретною ознакою (поле Параметр пошуку);
            – сортування за різними полями (поле Параметр сортування).
            Меню програми реалізувати по натисненню на певні клавіші: наприклад, Enter – вихід,
            п - пошук, р – редагування тощо*/
          /*  {
                TimeTable e1 = new TimeTable(1, 3, "Математика", "Петро Сарматович", true);
                TimeTable f1 = new TimeTable(2, 2, "Фізика", "Устим Любомирович", false);
                TimeTable j1 = new TimeTable(3, 1, "Хімія", "Нестор Іванович", true);
                TimeTable k1 = new TimeTable(4, 7, "Трудове", "Гордята Драганович", false);
                TimeTable a1 = new TimeTable(5, 6, "Англійська", "Адам Леонідович", true);
                TimeTable b1 = new TimeTable(6, 5, "Укр.Мова", "Домна Полянівна", false);
                TimeTable c1 = new TimeTable(7, 4, "Укр.Література", "Федосія Арсенівна", false);
                TimeTable d1 = new TimeTable(8, 3, "Зарубіжна", "Шанетта Макарівна", false);
                TimeTable m1 = new TimeTable(9, 2, "Хімія", "Юхимія Жданівна", true);
                TimeTable l1 = new TimeTable(10, 1, "Трудове", "Чеслава Максимівна", false);
            }*/
            System.out.println("1.Ввести запис у розклад");
            System.out.println("2.Вивести всі данні про розклад");
            System.out.println("3.Вивести відсортований массив записів");
            System.out.println("4.Пошук по прізвищу");
            System.out.println("5.Видалити запис");
            System.out.println("6.Записати у файл");
            System.out.println("7.Зчитати з файлу");
            System.out.print("Оберіть опцію: ");
            int n = 4;
            while(true) {
                try {
                    n = new Scanner(System.in).nextInt();
                    break;
                }
                catch (Exception ex){
                    System.out.println("Введене некоректне значення");
                    System.out.print("Оберіть опцію: ");
                }
            }
            switch (n) {
                case (1):
                    TimeTable _timeTable = new TimeTable(TimeTable.AddTimeTableInfo());
                    break;
                case (2):
                    TimeTable.OutputAllTimeTableInfo(TimeTable.AllTimeTabled);
                    break;
                case (3):
                    TimeTable.SortTabels();
                    break;
                case (4):
                    TimeTable.SearchTabels();
                    break;
                case (5):
                    TimeTable.DeleteTimeTableInfo();
                    break;
                case (6):
                    File_manager.WriteList(TimeTable.AllTimeTabled);
                    System.out.println("Файл записано");
                    break;
                case (7):
                    TimeTable.AllTimeTabled = File_manager.<TimeTable>ReadList();
                    System.out.println("Файл зчитано");
                    break;
            }
        }// 2 завдання
    }
}
