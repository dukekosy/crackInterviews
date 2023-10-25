package hackerrank.strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

  /*
   * Complete the 'fetchItemsToDisplay' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. 2D_STRING_ARRAY items
   *  2. INTEGER sortParameter
   *  3. INTEGER sortOrder
   *  4. INTEGER itemsPerPage
   *  5. INTEGER pageNumber
   */

  public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
    // Write your code here

    // create array with colum. order that 1 3 / 0 2
    String[] column = new String[items.size()];
    Map<String, String> map = new HashMap<>(items.size());
    for (int i = 0; i < items.size(); i++) {

      column[i] = items.get(i).get(sortParameter);
      map.put(column[i], items.get(i).get(0));
    }

    String[] sortedColumns = sort(column, sortOrder);

    List<String> returnString = new ArrayList<>(itemsPerPage);
    int pointer = 0;
    for (int j = 0; j < sortedColumns.length; j += itemsPerPage) {
      if (pageNumber == 0) {
        pointer = j;
      }
      pageNumber--;
    }

    for (int k = pointer; k < itemsPerPage; k++) {
      returnString.add(map.get(sortedColumns[k]));
    }
    return returnString;

  }

  private static String[] sort(String[] strings, int sortOrder) {

    Arrays.sort(strings);
    if (sortOrder == 0) {
      return strings;
    } else {
      String[] inverse = new String[strings.length];
      int counter = 0;
      for (int i = strings.length; i > 0; i--) {
        inverse[counter] = strings[i];
        counter++;
      }
      return inverse;
    }

  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    
    //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
   /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
    int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<String>> items = new ArrayList<>();

    IntStream.range(0, itemsRows).forEach(i -> {
      try {
        items.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                  .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());

    int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());

    int itemsPerPage = Integer.parseInt(bufferedReader.readLine().trim());

    int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());


    bufferedWriter.write(
        result.stream()
              .collect(joining("\n"))
        + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();*/
  }

}
