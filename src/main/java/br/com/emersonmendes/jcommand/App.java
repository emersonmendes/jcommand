package br.com.emersonmendes.jcommand;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("------------------------------------ JCommand --------------------------------------");
        System.out.println("------------------------------------------------------------------------------------\n");
        
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            try{
                String[] splittedLine = sc.nextLine().split(" ");
				Executor.exec(splittedLine[0], Arrays.copyOfRange(splittedLine, 1, splittedLine.length));
            } catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }

        sc.close(); 

    }

}