// SynonymHandler

/****************************************************************

SynonymHandler handles information about synonyms for various
words.

The synonym data can be read from a file and handled in various
ways. These data consists of several lines, where each line begins
with a word, and this word is followed with a number of synonyms.

The synonym line for a given word can be obtained. It is possible
to add a synonym line, and to remove the synonym line for a given
word. Also a synonym for a particular word can be added, or
removed. The synonym data can be sorted. Lastly, the data can be
written to a given file.

Author: Fadil Galjic

****************************************************************/

import java.io.*;    // FileReader, BufferedReader, PrintWriter,
                     // IOException

class SynonymHandler
{
	// readSynonymData reads the synonym data from a given file
	// and returns the data as an array
    public static String[] readSynonymData (String synonymFile)
                                         throws IOException
    {
        BufferedReader reader = new BufferedReader(
	        new FileReader(synonymFile));
        int numberOfLines = 0;
        String synonymLine = reader.readLine();
        while (synonymLine != null)
        {
			numberOfLines++;
			synonymLine = reader.readLine();
		}
		reader.close();

		String[] synonymData = new String[numberOfLines];
        reader = new BufferedReader(new FileReader(synonymFile));
		for (int i = 0; i < numberOfLines; i++)
		    synonymData[i] = reader.readLine();
		reader.close();

		return synonymData;
    }

    // writeSynonymData writes a given synonym data to a given
    // file
    public static void writeSynonymData (String[] synonymData,
        String synonymFile) throws IOException
    {
        PrintWriter writer = new PrintWriter(synonymFile);
        for (String synonymLine : synonymData)
            writer.println(synonymLine);
        writer.close();

    }

    // synonymLineIndex accepts synonym data, and returns the
    // index of the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	private static int synonymLineIndex (String[] synonymData,
        String word) throws IllegalArgumentException
    {
		int delimiterIndex = 0;
		String w = "";
		int i = 0;
		boolean wordFound = false;
		while (!wordFound  &&  i < synonymData.length)
		{
		    delimiterIndex = synonymData[i].indexOf('|');
		    w = synonymData[i].substring(0, delimiterIndex).trim();
		    if (w.equalsIgnoreCase(word))
				wordFound = true;
			else
				i++;
	    }

	    if (!wordFound)
	        throw new IllegalArgumentException(
		        word + " not present");

	    return i;
	}

    // getSynonymLine accepts synonym data, and returns
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String getSynonymLine (String[] synonymData,
        String word) throws IllegalArgumentException
    {
		int index = synonymLineIndex(synonymData, word);

	    return synonymData[index];
	}

    // addSynonymLine accepts synonym data, and adds a given
    // synonym line to the data.
	public static String[] addSynonymLine (String[] synonymData,
	    String synonymLine)
	{
		String[] synData = new String[synonymData.length + 1];
		for (int i = 0; i < synonymData.length; i++)
		    synData[i] = synonymData[i];
		synData[synData.length - 1] = synonymLine;

	    return synData;
	}

    // removeSynonymLine accepts synonym data, and removes
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	public static String[] removeSynonymLine (String[] synonymData,
	    String word) throws IllegalArgumentException
	{
        String synonymData2[] = new String[synonymData.length-1];
        try {
            int foundString = 0;
            for (int i = 0; i < synonymData2.length; i++) {
                if(synonymData[i] == getSynonymLine(synonymData, word)){
                    foundString=i;
                }
            }
            int j = 0;
            for (int i = 0; i < synonymData.length; i++) {
                if(foundString!=i){
                    synonymData2[j] = synonymData[i];
                    j++;
                }
            }
        } catch (Exception e) {
            System.err.println("word not found");
        }
        return synonymData2;
	}

    // getSynonyms returns synonyms in a given synonym line.
	private static String[] getSynonyms (String synonymLine)
	{
        synonymLine = synonymLine.substring(synonymLine.indexOf('|')+2);
        String synonymData2[] = synonymLine.split(", ");

        for (int i = 0; i < synonymData2.length; i++) {
            synonymData2[i] = synonymData2[i].trim();
        }


        return synonymData2;
	}

    // addSynonym accepts synonym data, and adds a given
    // synonym for a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
	public static void addSynonym (String[] synonymData,
	    String word, String synonym) throws IllegalArgumentException
	{
        synonymData[synonymLineIndex(synonymData, word)] = getSynonymLine(synonymData, word) + ", " +synonym;
    }

    // removeSynonym accepts synonym data, and removes a given
    // synonym for a given word.
    // If the given word or the given synonym is not present, an
    // exception of the type IllegalArgumentException is thrown.
    // If there is only one synonym for the given word, an
    // exception of the type IllegalStateException is thrown.
	public static void removeSynonym (String[] synonymData,
	    String word, String synonym)
	    throws IllegalArgumentException, IllegalStateException
	{
        if(synonymLineIndex(synonymData, word) == -1) {
            throw new IllegalStateException("word not present");
        }
        String synonymData2[] = getSynonyms(synonymData[synonymLineIndex(synonymData, word)]);
        String returnData[] = new String[synonymData2.length -1];

        if(synonymData2.length <= 1){
            throw new IllegalArgumentException("Word only has one synonym");
        }

        int synCounter = 0;
        for (int i = 0; i < synonymData2.length; i++) {
            if(!synonymData2[i].equals(synonym)){
                returnData[synCounter] = synonymData2[i];
                synCounter++;
            }
        }        
        
        synonymData[synonymLineIndex(synonymData, word)] = word + " | " + String.join(", ",returnData);

    }

    // sortIgnoreCase sorts an array of strings, using
    // the selection sort algorithm
    private static void sortIgnoreCase (String[] strings)
    {
        for (int j = 0; j < strings.length; j++) {
            for (int i = 0; i < strings.length -1 ; i++) {
                if(strings[i].charAt(0) > strings[i+1].charAt(0)){
                  String tempSyn = strings[i+1];
                    strings[i+1] = strings[i];
                 strings[i] =tempSyn;
             }       
         }
        } 
    }

    // sortSynonymLine accepts a synonym line, and sorts
    // the synonyms in this line
    private static String sortSynonymLine (String synonymLine)
    {
        String synonyms[] = synonymLine.substring(synonymLine.indexOf('|')+1).split(",");
        for (int i = 0; i < synonyms.length; i++) {
            synonyms[i] = synonyms[i].trim();
        }

        sortIgnoreCase(synonyms);

        String finishSynLine = synonymLine.substring(0, synonymLine.indexOf("| ")+2);
        for (int i = 0; i < synonyms.length; i++) {
            finishSynLine += synonyms[i] + ", ";
        }
        finishSynLine = finishSynLine.substring(0,finishSynLine.length()-2);
        return finishSynLine;
    }

    // sortSynonymData accepts synonym data, and sorts its
    // synonym lines and the synonyms in these lines
	public static void sortSynonymData (String[] synonymData)
	{
        for (int i = 0; i < synonymData.length; i++) {
            synonymData[i] = sortSynonymLine(synonymData[i]);
        }
    
        sortIgnoreCase(synonymData);
    	}
}