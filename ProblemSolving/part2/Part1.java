import edu.duke.*;

public class Part1 {
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int index = dna.indexOf(stopCodon, startIndex);
        if(index == -1 || (index - startIndex)%3 != 0){
            return -1;
        }
        return index;
    }
    
  
	public String findGene(String dna,int x) {
		int startIndex = dna.indexOf("ATG",x);
		if(startIndex == -1) {
			return "";
		}

		int taaIndex = findStopCodon(dna, startIndex, "TAA");
		int tagIndex = findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex, "TGA");

		int minIndex = 0;
		if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) {
			minIndex = tagIndex;
		} else {
			minIndex = taaIndex;
		}

		if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
			minIndex = tgaIndex;
		}

		if(minIndex == -1) {
			return "";
		}

		return dna.substring(startIndex, minIndex + 3);
	}

    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String gene = findGene(dna, startIndex);
            if(gene.isEmpty()){
                break;
            }
            System.out.println(gene);
            startIndex = dna.indexOf("ATG", startIndex)+gene.length();
        }
    }
   	
	public StorageResource getAllGenes(String dna){
		int startIndex = 0;
		StorageResource genes = new StorageResource();
		while(true){
			String gene = findGene(dna, startIndex);
			if(gene.isEmpty()){
				break;
			}
			genes.add(gene);
			startIndex = dna.indexOf("ATG", startIndex)+gene.length();
		}
		return genes;
	}
	
    
    public void testFindStopCodon(){
        String[] testCases = {
                "GAATGCTATAATCACA",
                "TCAATGCTATATTTACA",
                "ATGTAATTA"
                };
        System.out.println("Testing TAA");
        for(String dna : testCases){
            int start = dna.indexOf("ATG");
            System.out.println("TAA index: "+ findStopCodon(dna, start, "TAA"));
        }
        System.out.println("Testing TTA");
        for(String dna : testCases){
            int start = dna.indexOf("ATG");
            System.out.println("TTA index: "+ findStopCodon(dna, start, "TTA"));
        }
    }
    
    public void testFindGenes(){
        String[] testCases = {
                "GAATGCTATACTCACAGTAGTTAGGGTAA",
                "TCAATGCCATATTGACAATAGGG",
                "ATGTAATTATAG",
                "AATATTGTTAATAGATGAATATA",
                "AGATGAAATAATAGATGGTTATTTAAGCTACACCATGAGGTTAAGGATGA",
                "GCTACACCATGAGGTTAAGGTGA"
                };
        for(String dna : testCases){
             for(String gene:getAllGenes(dna).data()){
               
                System.out.println(gene);
                }
        }
    }
    
    public void testPrintAllGenes(){
            URLResource ab = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
            for(String gene:getAllGenes(ab.asString().toUpperCase()).data()){
                System.out.println(gene);
                }
       
    }
    double findCg (String dna){
        int cCount = 0;
        int gCount = 0;
        int i = 0;
        while(i < dna.length()){
            char protein = dna.charAt(i);
            if(protein == 'C'){
                cCount++;
            }
            if(protein == 'G'){
                gCount++;
            }
            i++;
        }
        if(gCount == 0){
            return (double)cCount;
        }
        return ((double)cCount)/gCount;
    }
}