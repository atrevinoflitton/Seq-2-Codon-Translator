/*
Program author name: Analia Treviño-Flitton


Part 1. Java program to read in a dna seq from a seq file (.seq)
Then print codons from three forward frames. Method will take in parameter (reading frame) & return an array with codons
Only complete codons will be used.

Part 2. Modify part 1 to print the single letter amino acid under each codon. Stop codon represented by (*).

*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Seq2CodonTranslator {


    public static String readFile(String userFile) throws FileNotFoundException, IOException {
        StringBuilder buildString = new StringBuilder();
        String fileLine;

        // Try to read user file by line & pass to string builder till the end of file
        try {
            BufferedReader bufferRead = new BufferedReader(new FileReader(userFile));

            while ((fileLine = bufferRead.readLine()) != null) {
                buildString.append(fileLine);
            }
            bufferRead.close();


        } catch (FileNotFoundException e) {
            System.out.println("Unable to locate file");
        } catch (IOException ioException) {
            System.out.println("Please retry with a readable file-type");
        }

        return buildString.toString();
    }





    public static void main(String[] args) throws IOException {

        // Initialize scanner and processCodon object
        Scanner input = new Scanner(System.in);
        processCodon processC = new processCodon();


        // Ask user for file name & create file object
        System.out.println("Please enter the file path:");
        String userFile = input.nextLine();


        // Call readFile  & set DNA returned to processCodon class
        String DNAseq = readFile(userFile);
        processC.setDnaSeq(DNAseq);
        System.out.println("\nThe DNA sequence:\n" + DNAseq);


        // Call codon converter
        System.out.println("\nThe 1st Reading Frame:");
        processC.codon(1);
        System.out.println("\n\nThe 2nd Reading Frame:");
        processC.codon(2);
        System.out.println("\n\nThe 3rd Reading Frame:");
        processC.codon(3);


        System.out.println("\n\nWritten by: Analia Treviño-Flitton\n");


        // Call codon translator
        System.out.println("\nThe DNA sequence:\n" + DNAseq);
        System.out.println("\nThe 1st Reading Frame codons & amino acids:");
        processC.codon(1);
        processC.codon2aa();
        System.out.println("\n\nThe 2nd Reading Frame codons & amino acids:");
        processC.codon(2);
        processC.codon2aa();
        System.out.println("\n\nThe 3rd Reading Frame codons & amino acids:");
        processC.codon(3);
        processC.codon2aa();


        System.out.println("\n\nWritten by: Analia Trevino-Flitton\n");


    }
}
