package modules;


import java.util.HashMap;
import java.util.Map;

import static modules.WebPage.transList;

public class HeaderAnalysis {

    public static void Header() {

//        Analysing the headers of each article
//        The translated headers are converted into string array
        String[] stringArray = transList.toArray(new String[0]);
        for (String str : stringArray) {
            System.out.println(str);
        }
        Map<String, Integer> charMap = new HashMap<String, Integer>();

        // Adding number of occurrences of each word in a map
        for (String title : stringArray) {
            String[] words = title.toLowerCase().split("\\W+");
            for (String word : words) {
                Integer count = charMap.get(word);
                if (count == null) {
                    charMap.put(word, 1);
                } else {
                    charMap.put(word, count + 1);
                }

            }
        }
        System.out.println(charMap);

//        Printing words that are repeated more than twice
        System.out.println("Words which are repeated more than twice are as below : ");
        for (Map.Entry<String, Integer> entry : charMap.entrySet()) {
                if (entry.getValue() > 2) {
                System.out.println(entry.getKey());
            }
        }

    }
}


