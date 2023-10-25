package crack.interview.notes.lambda;

import com.sun.javafx.image.IntPixelGetter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalInterfaces {

  int sum;

  public static void main(String[] args) {

  }

  public void test() {


    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
    List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
    String s = "Abracadabra";
    String t = "sdfa";

    supplyDate(LocalDate::now);

    values.forEach(this::updateSum);

    //predicate
    strings.removeIf(String::isEmpty);

    //bi predicate
    BiPredicate<String, Integer> condition = (string, limit) -> string.length() < limit;
    condition.test("Hello World", 3);

    //Function
    Function<String, Integer> calculateLength = String::length;
    int length = calculateLength.apply(s);

    //Bi Function
    BiFunction<String, Integer, Boolean> isSmallerThanLimit = (string, limit) -> string.length() < limit;
    boolean isSmaller = isSmallerThanLimit.apply(s, 20);

    UnaryOperator<String> operator = String::toUpperCase;
    String result = operator.apply(s);

    BinaryOperator<String>  concat = String::concat;
    String result2 = concat.apply(s, t);

  }

  //supplier
  public static LocalDate supplyDate(Supplier<LocalDate> supplier) {
    return supplier.get();
  }

  //consumer
  public void updateSum(Integer value) {
    this.sum += value;
  }

  public void filterLists() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    list.stream().filter(x -> x > 2).collect(Collectors.toList());

    double sum = list.stream().mapToDouble(Math::floor).sum();

    list.stream().findFirst().ifPresent(d -> save(d));

    List<List<String>> listfmap = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));

    System.out.println(listfmap
                           .stream()
                           .flatMap(Collection::stream)
                           .collect(Collectors.toList()));

    /*assertEquals(Optional.of("STRING"), Optional
                                            .of("string")
                                            .flatMap(s -> Optional.of("STRING")));*/

  Optional.ofNullable(System.getProperty("port"))
                     .filter(f -> !f.isEmpty())
                     .map(Integer::parseInt)
                     .orElseThrow(() -> new IllegalStateException("'port' environment variable not set"));


  }

  /*private Map<String, List<Payment>> deserializePayments(final Result<PaymentsRecord> result) {
    return result
               .stream()
               .filter(record -> Optional.ofNullable(record.getId()).isPresent())
               .collect(Collectors.groupingBy(
                   PaymentsRecord::getOrderId,
                   Collectors.mapping(
                       paymentRecord -> Payment.create(paymentRecord.getId()),
                       Collectors.toList())
               ));
  }*/


  public void save(int i) {

  }

}
