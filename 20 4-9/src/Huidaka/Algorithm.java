package Huidaka;

/**
 * 写一个泛型类，计算数组的最大值
 * @param <T>
 */
public class  Algorithm<T extends Comparable<T>> {
    public T findMaxNum(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Algorithm<Integer> a = new Algorithm<>();
        Integer[] array = {5,6,8,7,2};
        System.out.println(a.findMaxNum(array));
    }
}
