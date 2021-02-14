import java.util.Random;

public class ThreadClass implements Runnable {

    JeweleryStore store;

    ThreadClass(JeweleryStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3_001) + 2_000);
                if (store.isNotFull() && store.isOpen) {
                    store.addVisitor(new Visitor(store));

                } else {
                    System.out.println("Магазин заполнен или закрыт");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
