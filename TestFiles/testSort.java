public class testSort {
    public static void main(String[] args) {
        String synList[] = {"merciful | kindly, compassionate, forgiving, charitable",
                        "powerful | mighty, vigorous, forceful, energetic",
                        "beautiful | lovely, pretty, graceful, appealing, charming" ,
                        "glowing | luminous, vibrant, flaming, gleaming"};



        for (int i = 0; i < synList.length; i++) {
            System.err.println(synList[i]);
        }
        System.err.println("\n");

        for (int j = 0; j < synList.length; j++) {
            for (int i = 0; i < synList.length -1 ; i++) {
                if(synList[i].charAt(0) > synList[i+1].charAt(+1)){
                  String tempSyn = synList[i+1];
                    synList[i+1] = synList[i];
                 synList[i] =tempSyn;
             }       
         }
        }

        for (int i = 0; i < synList.length; i++) {
            System.err.println(synList[i]);
        }
        System.err.println("\n");



    }
}
