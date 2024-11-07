public class testSortSynLine {
    public static void main(String[] args) {
        String synonymLine = "glowing | luminous, vibrant, flaming, gleaming";
        String synonyms[] = synonymLine.substring(synonymLine.indexOf('|')+1).split(",");
        for (int i = 0; i < synonyms.length; i++) {
            synonyms[i] = synonyms[i].trim();
        }

        synonyms = sortList(synonyms);

        String finishSynLine = synonymLine.substring(0, synonymLine.indexOf("| ")+2);
        for (int i = 0; i < synonyms.length; i++) {
            finishSynLine += synonyms[i] + ", ";
        }
        finishSynLine = finishSynLine.substring(0,finishSynLine.length()-2);
        System.err.println(finishSynLine);


    }
        private static String[] sortList (String[] synList){
            for (int j = 0; j < synList.length ; j++) {
                for (int i = 0; i < synList.length -1 ; i++) {
                    if(synList[i].charAt(0) > synList[i+1].charAt(0)){
                      String tempSyn = synList[i+1];
                        synList[i+1] = synList[i];
                     synList[i] =tempSyn;
                 }       
             }
            }
            return synList;
        }
    }

    

