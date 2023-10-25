package crack.interview.collections.stacks;

public class ThreeInOne {

//how to use a single array to implement three stacks

    private final String[] array;

    private ThreeInOne(int l) {
        array = new String[l];
    }

    private void push(String data, int which) {
        switch (which) {
            case 1: {
                top1 += 3;
                array[top1] = data;
                break;
            }
            case 2: {
                top2 += 3;
                array[top2] = data;
                break;
            }
            case 3: {
                top3 += 3;
                array[top3] = data;
                break;
            }
        }
    }

    private int top1 = 0;
    private int top2 = 1;
    private int top3 = 2;

    private String pop(int which) {

        String data = null;
        switch (which) {
            case 1: {
                if (top1 != 0) {
                    data = array[top1];
                    array[top1] = null;
                    top1 = top1 - 3;
                }
                break;
            }
            case 2: {
                if (top2 != 1) {
                    data = array[top2];
                    array[top2] = null;
                    top2 = top2 - 3;
                }
                break;
            }
            case 3: {
                if (top3 != 2) {
                    data = array[top3];
                    array[top3] = null;
                    top3 = top3 - 3;
                }
                break;
            }
        }

        return data;
    }

    private boolean isEmpty(int which) {

        switch (which) {
            case 1: {
                if (top1 == 0)
                    return true;
                break;
            }
            case 2: {
                if (top2 == 1)
                    return true;
                break;
            }
            case 3: {
                if (top3 == 2)
                    return true;
                break;
            }
        }

        return false;
    }

    private String peek(int which) {

        switch (which) {
            case 1: {
                if (top1 != 0)
                    return array[top1];
            }
            case 2: {
                if (top2 != 1)
                    return array[top2];
            }
            case 3: {
                if (top3 != 2)
                    return array[top3];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ThreeInOne threeInOne = new ThreeInOne(200);
        threeInOne.push("sd", 1);
        threeInOne.push("s43d", 1);
        threeInOne.push("2sd", 2);
        threeInOne.push("1sfsd", 1);
        threeInOne.push("2rgfdvsd", 2);

        System.out.println(threeInOne.pop(1).equals("1sfsd"));
        System.out.println(threeInOne.pop(2).equals("2rgfdvsd"));
        System.out.println(threeInOne.peek(1).equals("s43d"));
        System.out.println(threeInOne.peek(2).equals("2sd"));
        System.out.println(threeInOne.isEmpty(1));
        System.out.println(threeInOne.isEmpty(3));
        System.out.println(threeInOne.pop(3) == null);
        System.out.println(threeInOne.peek(3) == null);
    }
}
