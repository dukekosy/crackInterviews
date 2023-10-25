package hackerrank.dictionariesandhashmaps;


import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DictionariesAndHashMaps {
    //https://www.hackerrank.com/challenges/ctci-ransom-note/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */
/*
for     note
list hashmaps(count of letters)
for     magazine
list hashmaps(count of letters)
for note
    for magazine
     finding each note

2
for magazine
hashmap(word, exist)
for note
 pick the word in hashmap -- if no then no
*/
    public static String checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Integer> hashmap = new HashMap<>();
        for (String string : magazine) {
            hashmap.put(string, hashmap.get(string) == null ? 1 : hashmap.get(string) + 1);
        }

        for (String string : note) {
            try {

                if (hashmap.get(string) >= 1) {
                    hashmap.put(string, hashmap.get(string) - 1);

                } else {
                    return "No";
                }
            } catch (NullPointerException ex) {
                return "No";
            }

        }
        return "Yes";
    }


    public static void main(String[] args) throws IOException {

        System.out.println(DictionariesAndHashMaps.checkMagazine(Lists.newArrayList("give", "me", "one", "grand", "today", "night")
                , Lists.newArrayList("give", "one", "grand", "today")).equals("Yes"));
        System.out.println(DictionariesAndHashMaps.checkMagazine(Lists.newArrayList("ive", "got", "a", "lovely", "bunch" + "of" + "coconuts")
                , Lists.newArrayList("ive", "got", "some", "coconuts")).equals("No"));
        System.out.println(DictionariesAndHashMaps.checkMagazine(Lists.newArrayList("two", "times", "three", "is", "not" + "four")
                , Lists.newArrayList("two", "times", "two", "is", "four")).equals("No"));
    }
}
