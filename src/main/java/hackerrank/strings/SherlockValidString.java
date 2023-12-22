package hackerrank.strings;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class SherlockValidString {
// come back and fix this.
    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        //abcc  remove one
        //abc   all equal
        //abccc can't remove one
        //aaabbbc
// two conditions
        //count[next] > size
        //count[next] < size
        //count[next] == 0, count[next] = 1 or more then No

        // diff can be 1 2
        //count[next] == size / no need to do anything diff is always 0
        // next > size by 1 once is ok

        // x > size by more than one not ok
        // max and diff is > 1

        // x = size is ok

        // x < size by 1 is ok once

        // x < size by more than one is not ok

        int[] counter = new int[26];
        IntStream.range(0, s.length()).forEach(x -> {
            counter[Character.getNumericValue(s.charAt(x)) - Character.getNumericValue('a')]++;
        });
        IntStream.range(0, counter.length).forEach(x -> {
            System.out.print(counter[x]+ ", ");
        });
        System.out.println("");

        AtomicInteger max = new AtomicInteger(counter[0]);
        AtomicInteger once = new AtomicInteger(0);

       IntStream.range(1, counter.length).forEach(next -> {
           if(counter[next] != 0) {
               //System.out.println(" next " + counter[next] + " max " + max + " once " + once.get());
               if (Math.abs(counter[next] - max.get()) >= 1) {
                   once.getAndIncrement();
               }
           }
        });
/*        List<Integer> Ones = IntStream.range(1, counter.length).filter(x -> counter[x] == 1).boxed().collect(toList());
        if(Ones.size() == 1)
            return "YES";
        else*/
        return once.get()>=2? "NO" : "YES";
    }


    public static void main(String[] args) throws IOException {


        System.out.println(isValid("aabbccddeefghi").equals("NO"));
        System.out.println(isValid("abcdefghhgfedecba").equals("YES"));
        System.out.println(isValid("xxxaabbccrry").equals("NO"));
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd").equals("YES"));

    }
}
