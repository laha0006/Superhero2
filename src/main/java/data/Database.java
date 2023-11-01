package data;

import domain.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    private final String CSV_FILE_NAME = "superheroes.csv";

    private final List<String[]> dataLines;

    public Database() {
        dataLines = new ArrayList<>();
        dataLines.add(new String[]
                {"John", "Doe", "38", "Comment Data\nAnother line of comment data"});
        dataLines.add(new String[]
                {"Jane", "Doe, Jr.", "19", "She said \"I'm being quoted\""});
    }

    public void save() {

    }

    public String convertToCSV(Superhero superhero) {
        String[] data = superhero.getStringArray();
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        System.out.println("escaped!");
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void writeToCsv(ArrayList<Superhero> dataLines) {
        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<String[]> loadData() {
        ArrayList<String[]> rows = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(CSV_FILE_NAME))) {
            while (scanner.hasNextLine()) {
                rows.add(getRowFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    private String[] getRowFromLine(String line) {
        String[] values = new String[6];
        try (Scanner rowScanner = new Scanner(line)) {
        rowScanner.useDelimiter(",");
        for(int i = 0; i < 6; i++) {
            values[i] = rowScanner.next();
        }

    }
        return values;
    }
}