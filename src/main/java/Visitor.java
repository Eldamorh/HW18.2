import java.util.Random;

public class Visitor implements Runnable {
    static int numberOfVisitors = 0;
    JeweleryStore store;
    int id;

    Visitor(JeweleryStore store) {
        this.store = store;
        id = numberOfVisitors++;
        Thread thread = new Thread(this);
        thread.start();
    }

    int getId() {
        return id;
    }


    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(7_001) + 1_000);
            store.removeVisitor(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
