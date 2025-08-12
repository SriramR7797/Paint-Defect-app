import java.io.*;
import java.util.*;

public class PaintDefectApp {
    static String filePath = "defects.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Paint Defect Management ---");
            System.out.println("1. Add Defect");
            System.out.println("2. View Defects");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addDefect(sc);
                    break;
                case 2:
                    viewDefects();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addDefect(Scanner sc) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Model: ");
            String model = sc.nextLine();
            System.out.print("Enter Location: ");
            String location = sc.nextLine();
            System.out.print("Enter Defect Type: ");
            String type = sc.nextLine();
            System.out.print("Enter Severity (1-10): ");
            String severity = sc.nextLine();

            bw.write(id + "," + model + "," + location + "," + type + "," + severity);
            bw.newLine();

            System.out.println("Defect added successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static void viewDefects() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\n--- Defect Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
