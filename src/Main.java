import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] actions = {"+", "-", "/", "*"};       //Задаем массив типа стринг из 4 арифм. действий
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String primer = s.nextLine();                  //Теперь найдем и определим это действие

        int index = -1;
        for (int i = 0; i < actions.length; i++) {
            if (primer.contains(actions[i])) {
                index = i;                             //Выделяем это действие переменной index
            }
        }

        if (index == -1) {
            System.out.println("Некорректное выражение");          // здесь лучше выдать исключение и закончить
            return;
        }
        String[] ekranActions = {"\\+", "-", "/", "\\*"};         //Задаем массив с экранированными арифм. действиями
        String[] chisla = primer.split(ekranActions[index]);      //Получаем массив типа стринг из двух введённых чисел,
        // этот массив в  переменной chisla

        String[] arabian = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanAll = {"niht", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int j = -1;

        int a = 0;
        int b = 0;

        for (String string : arabian) {
            j = j + 1;
            if (arabian[j].contains(chisla[0])) {                // если слева арабское число до 10,
                a = Integer.parseInt(chisla[0]);                 // то мы и делаем из него арабское число a типа int

                int h = -1;

                for (String string1 : arabian) {
                    h = h + 1;
                    if (arabian[h].contains(chisla[1])) {        // если и справа арабское до 10, то мы
                        b = Integer.parseInt(chisla[1]);         // получаем из него арабское число b типа int

                        switch (index) {
                            case 0:
                                System.out.println(a + b);
                                break;
                            case 1:
                                System.out.println(a - b);
                                break;                                      //и выводим результат на экран
                            case 2:
                                System.out.println(a / b);
                                break;
                            case 3:
                                System.out.println(a * b);
                                break;
                        }

                    }

                }
            }
        }


        int t = -1;

        int c = 0;
        int d = 0;

        for (String string : roman) {
            t = t + 1;
            if (chisla[0].contentEquals(roman[t])) {                      // если слева римское число до Х, то мы
                c = Arrays.asList(roman).indexOf(roman[t]);               //  получаем из него арабское число c типа int

                int l = -1;

                for (String string1 : roman) {
                    l = l + 1;
                    if (chisla[1].contentEquals(roman[l])) {               // если и справа римское число до Х,
                        d = Arrays.asList(roman).indexOf(roman[l]);        // получаем из него арабское число d типа int
                        switch (index) {
                            case 0:
                                System.out.println(romanAll[c + d]);
                                break;
                            case 1:
                                if ((d >= c) && index == 1) {
                                    System.out.println("В римской системе нет отрицательных чисел и нуля");
                                } else System.out.println(romanAll[c - d]);
                                break;
                            case 2:                                                       //и выводим результат на экран
                                System.out.println(romanAll[c / d]);
                                break;
                            case 3:
                                System.out.println(romanAll[c * d]);
                                break;
                            default:
                                return;
                        }
                    }
                }


            }

        }

    }
    //если программа дошла до сюда - выдать исключение



}
