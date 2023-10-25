package crack.interview.arrays;

/* https://www.youtube.com/watch?v=GDFVTZ-kKl0&list=PL5tcWHG-UPH03aqnBTkBuH5qIbhshbg_K&index=2 */

final class SpreadSheet {

    public static void main(String[] args) {
        System.out.println(calcColumnIndex("AA"));
        System.out.println(calcColumnIndex("AZ"));
        System.out.println(calcColumnIndex("BA"));
        System.out.println(calcColumnIndex("BZ"));
        System.out.println(calcColumnIndex("ZZ"));
        System.out.println(calcColumnIndex("ZZZ"));
    }

    private static double calcColumnIndex(String column) {
        double currentIndex = 0;
        int size = column.length();
        for (int i = 0; i < size; i++) {
            int currentChar = Character.getNumericValue(column.charAt(i)) - Character.getNumericValue('a') + 1;
            currentIndex += Math.pow(26, size - i - 1) * currentChar;
        }
        return currentIndex;
    }

}