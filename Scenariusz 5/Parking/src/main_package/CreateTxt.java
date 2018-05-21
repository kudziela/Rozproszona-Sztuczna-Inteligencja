package main_package;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateTxt {

    public void CreateTxt(String workInfo1, String workInfo2) throws FileNotFoundException {
        PrintWriter printFile = new PrintWriter("Zmiana.txt");
        printFile.println("Pracownik - zmiana poranna");
        printFile.print(workInfo1);
        printFile.println();
        System.out.println();
        printFile.print(workInfo2);
        printFile.println();
        System.out.println();
        printFile.close();
    }

}
