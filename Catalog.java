/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков (ArrayList).
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. 
Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет. Выводить только те ноутбуки, что соответствуют условию
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Catalog {

    public static void main(String[] args) {

        Notebook nb1 = new Notebook(1, "MSI", 15.6, "black", 16, "i7", 73900);
        Notebook nb2 = new Notebook(2, "Huawei", 17.3, "silver", 8, "i5", 93900);
        Notebook nb3 = new Notebook(3, "Gigabyte", 16.0, "red", 4, "i3", 68700);
        Notebook nb4 = new Notebook(4, "MSI", 16.0, "red", 16, "i3", 63900);
        Notebook nb5 = new Notebook(5, "Huawei", 15.6, "black", 16, "i3", 71900);

        // Создаем множество ноутбуков:
        List<Notebook> catalogNotebooks = Arrays.asList(nb1, nb2, nb3, nb4, nb5);

        List<Notebook> filterArray = filterNotebook(catalogNotebooks);
        if (filterArray.isEmpty()) {
            System.out.println();
            System.out.println("По фильтру ничего не найдено.");
        } else {
            System.out.println();
            System.out.println("Ноутбуки, соответствующие фильтру: ");
            for (Notebook item : filterArray) {
                System.out.println(item);
            }
            System.out.println();
        }
    }

    private static List<Notebook> filterNotebook(List<Notebook> AllNotebook) {
        List<Notebook> filterNb = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String enterVendor = "All";
        String enterColor = "All";
        String enterProcessor = "All";
        System.out.println("Выберите параметры ноутбука для фильтрации:");
        System.out.println();
        System.out.println("Укажите производителя:");
        System.out.print("1 - MSI, 2 - Huawey, 3 - Gigabyte, 4 - Все производители: ");
        int enterV = scanner.nextInt();
        switch (enterV) {
            case 1:
                enterVendor = "MSI";
                break;
            case 2:
                enterVendor = "Huawey";
                break;
            case 3:
                enterVendor = "Gigabyte";
                break;
            // любые другие значения - выводим всех производителей
            default:
                break;
        }

        System.out.println("Укажите минимальный размер диагонали:");
        System.out.print("В наличии диагонали: 15.6; 16.0; 17.3: ");
        Double enterDiagonal = scanner.nextDouble();

        System.out.println("Укажите цвет ноутбука:");
        System.out.print("1 - черный, 2 - серебристый, 3 - красный, 4 - Все цвета: ");
        int enterСlr = scanner.nextInt();
        switch (enterСlr) {
            case 1:
                enterColor = "black";
                break;
            case 2:
                enterColor = "silver";
                break;
            case 3:
                enterColor = "red";
                break;
            // любые другие значения - выводим все цвета
            default:
                break;
        }
        System.out.println("Укажите минимальный размер оперативной памяти:");
        System.out.print("В наличии опреативная память: 4 ГБ; 8 Гб; 16 Гб: ");
        int enterRam = scanner.nextInt();

        System.out.println("Укажите тип процессора:");
        System.out.print("1 - i3, 2 - i5, 3 - i7, 4 - Все процессоры: ");
        int enterPrc = scanner.nextInt();
        switch (enterPrc) {
            case 1:
                enterProcessor = "i3";
                break;
            case 2:
                enterProcessor = "i5";
                break;
            case 3:
                enterProcessor = "i7";
                break;
            // любые другие значения - выводим все цвета
            default:
                break;
        }
        System.out.println("Укажите минимальную цену:");
        System.out.print("В наличии ноутбуки с ценами от 63900 до 93900 руб.: ");
        int enterPrice = scanner.nextInt();

        for (Notebook tempNb : AllNotebook) {
            if (enterVendor.equals(tempNb.vendor) | enterVendor == "All") {
                if (enterDiagonal <= tempNb.diagonal) {
                    if (enterColor.equals(tempNb.color) | enterColor == "All") {
                        if (enterRam <= tempNb.ram) {
                            if (enterProcessor.equals(tempNb.processor) | enterProcessor == "All") {
                                if (enterPrice <= tempNb.price) {
                                    filterNb.add(tempNb);
                                }
                            }
                        }
                    }
                }
            }
        }
        return filterNb;
    }
}
