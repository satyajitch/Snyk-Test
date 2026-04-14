import java.io.*;
import java.util.Scanner;

public class CommandInjection {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String userInput = sc.nextLine(); // ✅ USER INPUT

        Runtime.getRuntime().exec("cmd /c " + userInput); // ❌
    }
}
