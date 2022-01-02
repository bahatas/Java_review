package com.cybertek.leetcode.codewars.kyu6;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
public class ExtractFileName {

    public static String extractFileName(String dirtyFileName) {

        String res = "";
        int dotCounter=0;
        int underScoreCounter=0;
        for (Character c : dirtyFileName.toCharArray()) {
            if(c=='.') dotCounter++;
            if(c=='_') underScoreCounter++;
            if(underScoreCounter>0){
                res+=c+"";
                if(dotCounter==2) break;
            }
        }
        return res.substring(1,res.length()-1);
    }

    /**
     * Best Solutions
     */
//      return f.substring(f.indexOf('_')+1,f.lastIndexOf('.'));
  //   return s.replaceAll("^\\d+\\_|\\.[^.]+$", "");


    public void testSample() {
        assertEquals(
                "FILE_NAME.EXTENSION",
                ExtractFileName.extractFileName("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION")
        );
        assertEquals(
                "FILE_NAME.EXTENSION",
                ExtractFileName.extractFileName("1_FILE_NAME.EXTENSION.OTHEREXTENSIONadasdassdassds34")
        );
    }

}
