import java.util.Scanner;

class Film{
    String name, country, genre;
    double year, cost;
}
class InfoAboutFilms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ВВоД ИНФОРМАЦИИ О ФИЛЬМАХ
        System.out.println("Введите количество фильмов");
        int n = sc.nextInt(); //кол-во фильмов
        Film[] films = new Film[n];
        System.out.println("Введите информацию о фильмах: ");
        for (int i = 0; i < films.length; i++) {
            sc.nextLine();
            films[i] = new Film();
            System.out.println("Название " + (i + 1) + "-го фильма ");
            films[i].name = sc.nextLine();
            System.out.println("Жанр " + (i + 1) + "-го фильма ");
            films[i].genre = sc.nextLine();
            System.out.println("Страна " + (i + 1) + "-го фильма ");
            films[i].country = sc.nextLine();
            System.out.println("Стоимость " + (i + 1) + "-го фильма ");
            films[i].cost = sc.nextDouble();
            System.out.println("Год выпуска " + (i + 1) + "-го фильма ");
            films[i].year = sc.nextDouble();

        }
        System.out.println("\nХарактеристика фильмов");
        for (int i = 0; i < films.length; i++) {
            System.out.println("" + films[i].name + "\t" + films[i].cost + " рублей" + "\t" + films[i].year + " -го года выпуска");
        }
        // Фильм с максимальной стоимостью
        int nommax = 0;
        double max = films[nommax].cost;
        for (int i = 0; i < films.length; i++)
            if (films[i].cost > max) {
                max = films[i].cost;
                nommax = i;
            }
        System.out.println("\nФильм стоимость выше всех :");
        System.out.println("" + films[nommax].name + "\t" + films[nommax].cost + "стоимость");

        //сортировка фильмов по стоимости
        for (int i = 0; i < films.length - 1; i++)
            for (int j = 0; j < films.length - 1 - i; j++)
                if (films[j].cost > films[j + 1].cost) {
                    Film rab = films[j]; // rab – рабочая переменная для перестановки
                    films[j] = films[j + 1];
                    films[j + 1] = rab;
                }
        System.out.println("\nОтсортированный список по стоимости");
        for (int i = 0; i < films.length; i++) {
            System.out.println("" + films[i].name + "\t" + films[i].cost + " рублей");
        }
        //стоимость больше средней

        double s = 0;// суммарная стоимость
        for (int i = 0; i < films.length; i++)
            s += films[i].cost;
        double sr = s / films.length; // средняя стоимость
        System.out.println("Средняя стоимость =" + sr);
        System.out.println("\nФильмы, с стоимостью больше средней");
        for (int i = 0; i < films.length; i++) {
            if (films[i].cost > sr)
                System.out.println(films[i].name + "\t" + films[i].cost + " рублей");
        }
        //самый ранний год выпуска
        int nommin = 0;
        double min = films[nommax].year;
        for (int i = 0; i < films.length; i++)
            if (films[i].year < min) {
                min = films[i].year;
                nommin = i;

            }
        System.out.println("\nСамый ранний фильм :");
        System.out.println("" + films[nommin].name + "\t" + films[nommin].year + "-го года выпуска");

        // СОРТИРОВКА ФИЛЬМОВ ПО АЛФАВИТУ

        for (int i = 1; i < films.length; i++)
            for (int j = 1; j < films.length; j++)
                if(films [j].name.compareTo(films[j-1].name)<films.length-j-1){
                    Film rab=films[j]; //rab – рабочая переменная для перестановки
                    films[j]=films[j-1];
                    films[j-1]=rab;
                }
        System.out.println("\nОтсортированный список по алфавиту:");
        for (int i = 0; i < films.length; i++) {
            System.out.println(""+films[i].name);
        }
     // ПОИСК ПО НАЗВАНИЮ
        sc.nextLine(); // очистка буфера
        System.out.println("Введите название искомого фильма=> ");
        String name=sc.nextLine();
        int nom=-1; // 1 – страна с искомым названием отсутствует

        for (int i = 0; i < films.length; i++)
            if (name.equalsIgnoreCase(films[i].name))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такая страна есть в списке. Это "
                    +films[nom].name+" "+films[nom].cost+" стоимость" + "\t" + films[nom].year+ " года выпуска");
        }
        else System.out.println("Такого фильма нет в списке");

    }
}








