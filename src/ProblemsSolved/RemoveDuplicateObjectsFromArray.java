package ProblemsSolved;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateObjectsFromArray {

    public static void main(String[] args) {
        Anim animal = new Anim();
        Baby baby = new Baby();
        Child child = new Child();

        String[] temp = removeDuplicateObjects(animal, baby, child);

        System.out.println(Arrays.toString(temp));
    }

    private static String[] removeDuplicateObjects(Anim animal, Baby baby, Child child) {

        Object[] array = new Object[]{baby, baby, animal, animal, child, animal, animal, child, child, child, animal};

        List<Object> list = Arrays.asList(array);
        List<Object> finalList = new ArrayList<>();
        for (Object m : list) {
            if (!finalList.contains(m)) {
                finalList.add(m);
            }
        }

        Object[] newArray = finalList.toArray();
        String[] filteredArr = filterObjectNames(newArray);

        return filteredArr;
    }

/*    private static String[] removeDuplicateObjects(Anim animal, Baby baby, Child child) {

        Object[] arr = new Object[]{baby, baby, animal, animal, child, animal, animal, child, child, child};
        Object[] list = new Object[arr.length];


        for (int i = 0; i < arr.length; i++) {
            list[i] = arr[i];
            for (int j = 1; j < arr.length; j++) {
                if (arr[i].getClass().getSimpleName().equalsIgnoreCase(arr[j].getClass().getSimpleName()) && i != j) {
                    arr = ArrayUtils.remove(arr, i);

                    i = j;
                }
            }
        }

                String[] filteredArr = filterObjectNames(arr);

        return filteredArr;

        */


    private static String[] filterObjectNames(Object[] arr) {
        String[] filteredArr = new String[arr.length];
        int i = 0;
        for (Object o : arr) {
            filteredArr[i++] = o.getClass().getSimpleName();
        }
        return filteredArr;
    }

    private static class Child {
    }

    private static class Anim {
    }

    private static class Baby {
    }
}
