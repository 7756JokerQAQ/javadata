package text;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        LinkedList<String> result = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();
        String intNumber = "";
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");

            String[] dotWord = s[1].split("\\.");

            String intWord = "";

            for (int j = dotWord.length - 1; j >= 0; j--) {
                intWord = dotWord[j] + intWord;
                if (map.containsKey(intWord)) {
                    map.put(intWord, String.valueOf((Integer.parseInt(map.get(intWord)) + Integer.parseInt(s[0]))));
                } else {
                    map.put(intWord, s[0]);
                }
                intWord = "." + intWord;
            }
        }
        for (String key :
                map.keySet()) {
            result.add(map.get(key) + " " + key);
        }
        return result;
    }

    public static void main(String[] args) {
        String s[] = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        Solution solution = new Solution();
        solution.subdomainVisits(s);
    }

}
