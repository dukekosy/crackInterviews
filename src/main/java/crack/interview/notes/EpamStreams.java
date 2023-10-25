package crack.interview.notes;

import java.util.List;
import java.util.stream.Collectors;

public class EpamStreams {
/*
  You have list of String "AD", "AWs", "awe" -> remove strings which contains upper case chars and return the rest using Java 8 streams..
  converting char to number

                         hashmap

for (assuming alpha only)
                                concat |
                                           for (add letter to arra) if capitol got to next |
  or if next | collect the array

 O(NM)
 for list
    for String

  atomic lock
  completable futures
  */
  public List filterUpperCase(List<String> stringList) {
    return stringList.stream().filter(EpamStreams::isLowerCase).collect(Collectors.toList());
  }

  static boolean isLowerCase(String string) {
    for(int i = 0; i < string.length(); i++) {
      if (Character.isUpperCase(string.charAt(i))){
        return false;
      }
    }
    return true;
  }

}
