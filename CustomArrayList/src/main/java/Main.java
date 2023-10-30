import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        CustomArrayList<Integer> sortable = new CustomArrayList<>();

         List<Integer> newArr ;
         newArr = randomList(0, 10000, 1000);

        sortable.addAll(newArr);

        System.out.println(sortable);
        System.out.println(sortable.size());

        sortable.sort(Comparator.comparingInt(o -> o));
        System.out.println(sortable);
        System.out.println(sortable.size());


        CustomArrayList<String> list = getStringCustomArrayList();

        System.out.println(list);
        System.out.println(list.size());

        list.remove("Eleven");
        System.out.println(list.size());

        List<String> additionalList = new ArrayList<>();
        additionalList.add("MmmmDaaa");
        additionalList.add("NuuUjNeet");
        list.addAll(additionalList);
        System.out.println(list);
        System.out.println(list.size());


    }

    private static CustomArrayList<String> getStringCustomArrayList() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        list.add("Eleven");
        list.add("Twelve");
        list.add("Thirteen");
        list.add("Fourteen");
        list.add("Fifteen");
        list.add("Sixteen");
        list.add("Seventeen");
        list.add("Eighteen");
        list.add("Nineteen");
        list.add("Twenty");
        return list;
    }

    public static List<Integer> randomList(int min, int maxIncl, int count) {
        return new Random()
                .ints(min, maxIncl + 1)
                .distinct()
                .limit(count)
                .boxed()
                .collect(Collectors.toList());

    }

}
