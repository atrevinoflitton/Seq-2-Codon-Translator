/*
File name: processCodon.java- class file to be used with main (Seq2CodonTranslator.java)
Program author name: Analia Treviño-Flitton
*/


import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.HashMap;



public class processCodon {


    // Initialize class variables
    private String DNAseq;
    ArrayList<String> frameList = new ArrayList<String>();
    String DNA;


    //Set DNA seq from main for local access
    public void setDnaSeq(String dnaSeq) {
        DNAseq = dnaSeq;
    }




    public void codon(int frame) {

        // Setting start position of codon reader depending on reading frame & clearing list from previous iterations
        switch (frame) {
            case 1:
                DNA = (DNAseq);
                frameList.clear();
                break;
            case 2:
                DNA = (DNAseq.substring(1));
                frameList.clear();
                break;

            case 3:
                DNA = (DNAseq.substring(2));
                frameList.clear();
                break;
        }


        // Regex Pattern to sort codons
        Pattern pattern = Pattern.compile("([ATGC]){3}");
        Matcher match = pattern.matcher(DNA);


        // While matcher returns a positive match, the match is getting added to ArrayList
        while (match.find()) {
            frameList.add(match.group());
        }

        // Print each codon in the array
        for (String codon : frameList) {
            System.out.print(codon + " ");
        }

    }





    public void codon2aa() {

        // HashMap Dictionary of codon-2-amino acid seqs
        HashMap <String, String> codonAA = new HashMap();
        codonAA.put("ATA", "I");codonAA.put("ATC", "I");codonAA.put("ATT","I");codonAA.put("ATG","M");
        codonAA.put("ACA","T"); codonAA.put("ACC","T");codonAA.put("ACG","T");codonAA.put("ACT","T");
        codonAA.put("AAC","N");codonAA.put("AAT","N");codonAA.put("AAA","K");codonAA.put("AAG","K");
        codonAA.put("AGC","S");codonAA.put("AGT","S");codonAA.put("AGA","R");codonAA.put("AGG","R");
        codonAA.put("CTA","L");codonAA.put("CTC","L");codonAA.put("CTG","L");codonAA.put("CTT","L");
        codonAA.put("CCA","P");codonAA.put("CCC","P");codonAA.put("CCG","P");codonAA.put("CCT","P");
        codonAA.put("CAT","H");codonAA.put("CAA","Q");codonAA.put("CAG","Q");codonAA.put("CGA","R");
        codonAA.put("CGC","R");codonAA.put("CGG","R");codonAA.put("CGT","R");codonAA.put("GTA","V");
        codonAA.put("GTC","V");codonAA.put("GTG","V");codonAA.put("GTT","V");codonAA.put("GCA","A");
        codonAA.put("GCC","A");codonAA.put("GCG","A");codonAA.put("GCT","A");codonAA.put("GAC","D");
        codonAA.put("GAT","D");codonAA.put("GAA","E");codonAA.put("GAG","E");codonAA.put("GGA","G");
        codonAA.put("GGC","G");codonAA.put("GGG","G");codonAA.put("GGT","G");codonAA.put("TCA","S");
        codonAA.put("TCC","S");codonAA.put("TCG","S");codonAA.put("TCT","S");codonAA.put("TTC","F");
        codonAA.put("TTT","F");codonAA.put("TTA","L");codonAA.put("TTG","L");codonAA.put("TAC","Y");
        codonAA.put("TAT","Y");codonAA.put("TAA","*");codonAA.put("TAG"," *");codonAA.put("TGC","C");
        codonAA.put("TGT","C");codonAA.put("TGA","*");codonAA.put("TGG","W");codonAA.put("CAC","H");

        System.out.print("\n");

        // For each codon in the array, get the amino acid
        for (String codon : frameList) {
            System.out.print( codonAA.get(codon) + "\t");

        }


    }
}