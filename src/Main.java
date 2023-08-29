import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String inputFile = "poem.txt"; // Имя входного файла
        String outputFilePrefix = "part"; // Префикс названия выходных файлов

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int partNumber = 1; // Номер текущего выходного файла

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String outputFileName = outputFilePrefix + partNumber;
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                        writer.write(line);
                        writer.newLine();
                    }
                } else {
                    partNumber++; // Увеличиваем номер выходного файла для следующего абзаца
                }
            }

            System.out.println("Файлы успешно созданы.");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}