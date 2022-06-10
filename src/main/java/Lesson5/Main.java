package Lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

/*
1. Реализовать сохранение данных в csv файл;
2. Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура csv файла:
| Строка заголовок с набором столбцов |
| Набор строк с целочисленными значениями |
| * Разделитель между столбцами - символ точка с запятой (;) |
Пример:
Value 1;Value 2;Value 3
100;200;123
300,400,500
Для хранения данных использовать класс вида:
public class AppData {
  private String[] header;
  private int[][] data; // ...
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
*/

    public static void main(String[] args) throws IOException {
        int a = 3;
        int b = 3;
        String[] headMassive = new String[b];
        for (int i = 0; i < headMassive.length; i++) {
            headMassive[i] = "Value " + (1+i);
        }
        int[][] dataMassive = new int[a][b];
        for (int i = 0; i < dataMassive.length; i++) {
            for (int j = 0; j < dataMassive[i].length; j++) {
                dataMassive[i][j] = (int) (Math.random() * 1000);
            }
        }

        AppData value = new AppData(headMassive, dataMassive);
        value.getHeader();
        try (PrintWriter DataValue = new PrintWriter("Geek.csv")) {
            for (int i = 0; i < value.getHeader().length - 1; i++) {
                DataValue.print(value.getHeader()[i] + "; ");
            }
            DataValue.println(value.getHeader()[value.getHeader().length - 1]);

            for (int i = 0; i < value.getData().length - 1; i++) {
                for (int j = 0; j < value.getData()[i].length - 1; j++) {
                    DataValue.print(value.getData()[i][j] + "; ");
                }
                DataValue.println(value.getData()[i][value.getData()[i].length - 1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader ValueData = new BufferedReader(new FileReader("Geek.csv"))) {
            String str = null;
            while ((str = ValueData.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
