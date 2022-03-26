import java.util.ArrayList;

/**
 * @author 猿小蔡
 * @date 2022/3/27
 */
public class MainClass {
    public static void main(String[] args) {
        ascending();
        descending();
        reverseOrder();
        notSorted();
    }

    /**
     * 升序
     */
    private static void ascending() {
        System.out.println("升序");
        ArrayList<Integer> list = getList();
        list.sort((o1, o2) -> {
            // 升序 返回1的时候进行位置交换
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            } else {
                return 0;
            }
        });
        print(list);
        System.out.println();
    }

    /**
     * 降序
     */
    private static void descending() {
        System.out.println("降序");
        ArrayList<Integer> list = getList();
        list.sort((o1, o2) -> {
            // 降序 返回1的时候进行位置交换
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        });
        print(list);
        System.out.println();
    }

    /**
     * 倒序
     */
    private static void reverseOrder() {
        System.out.println("倒序");
        ArrayList<Integer> list = getList();
        list.sort((o1, o2) -> {
            // 不管大于、小于和等于 都返回 -1
            return -1;
        });
        print(list);
        System.out.println();
    }

    /**
     * 不排序
     */
    private static void notSorted() {
        System.out.println("不排序");
        ArrayList<Integer> list = getList();
        list.sort((o1, o2) -> {
            // 返回0或者1的时候不排序
            return 1;
        });
        print(list);
        System.out.println();
    }

    private static void print(ArrayList<Integer> list) {
        print("排序后", list);
    }

    private static void print(String msg, ArrayList<Integer> list) {
        System.out.print(msg + " = ");
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            System.out.print(integer);
            if (i != list.size() - 1) {
                System.out.print("、");
            }
        }
    }

    private static ArrayList<Integer> getList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(8);
        print("排序前", list);
        System.out.println();
        return list;
    }

}
