package hackerrank.sorting.countingsort;

import com.google.common.collect.Lists;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class FraudlentActivityNotifications {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    //do a counting sort
//https://www.youtube.com/watch?v=46V6tnxy_Vs
//https://www.youtube.com/watch?v=mLpZunu4coA
    //the answer here is wrong
    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        if(expenditure.size()+1<d)
            return 0;

        List<Integer> list = new ArrayList<>();
        int notice = 0;
        int med_pos = d / 2;
        for(int i=0; i<expenditure.size()-1; i++) {
            list.add(expenditure.get(i));

            if(list.size()<d)
                continue;

            if (list.size()!=d)
                list.remove(0);

            Collections.sort(list);
            //System.out.println("c "+list);
            int median2 = 0;
            int size = list.size();
            //System.out.println("size " + size);
            if(size%2==0) { //even
                //System.out.println("list "+list.get(size%2)+ "d " + d);
                median2 = (list.get(med_pos)+list.get((med_pos)-1));
            } else { //odd
                median2 = list.get((med_pos))*2;
            }
            //System.out.println("median "+ median2 + " ex " + expenditure.get(i));
            if(expenditure.get(i+1)>=median2)
                notice++;
        }

        return notice;
    }


    public static void main(String[] args) throws IOException {

        int d = 10000;
        StringBuilder stringExpend = new StringBuilder("0 82 180 55 168");

        ArrayList<Integer> numberList = new ArrayList<>();
        int currentNumber = 0;
        boolean isNegative = false;

        for (int i = 0; i < stringExpend.length(); i++) {
            char c = stringExpend.charAt(i);

            if (c == '-') {
                isNegative = true;
            } else if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == ' ' && i > 0) {
                numberList.add(isNegative ? -currentNumber : currentNumber);
                isNegative = false;
                currentNumber = 0;
            }
        }

        // Add the last number (if there is no space at the end)
        numberList.add(isNegative ? -currentNumber : currentNumber);

        System.out.println(activityNotifications(numberList, d)==633);


    }
}
