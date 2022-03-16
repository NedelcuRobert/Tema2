package Tema2.Project;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	FirmaTeleviziune firma = new FirmaTeleviziune();
        firma.functionare(sc);
    }
}