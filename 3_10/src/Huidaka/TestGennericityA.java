package Huidaka;
/*
使用泛型A
 */
class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
public class TestGennericityA {
    public static void main(String[] args) {
        A<Integer> a = new A<>(99);
        int n = a.get();
        System.out.println(n);
    }
}
