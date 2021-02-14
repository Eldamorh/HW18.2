public class Main {
    public static void main(String[] args) {
        JeweleryStore store = new JeweleryStore();
        Thread thread1 = new Thread(store);
        Thread thread2 = new Thread(new ThreadClass(store));
        thread1.start();
        thread2.start();
    }
}
