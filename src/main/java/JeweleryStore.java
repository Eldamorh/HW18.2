import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JeweleryStore implements Runnable {
    private List<Visitor> visitors;
    public boolean isOpen = false;

    JeweleryStore() {
        visitors = new ArrayList<>();
    }

    void addVisitor(Visitor visitor) {
        System.out.println("Добро пожалевать посетитель номер " + visitor.getId());
        visitors.add(visitor);

    }

    void removeVisitor(Visitor visitor) {
        if (visitors.contains(visitor)) {
            System.out.println("До свидания посетитель номер " + visitor.getId());
            visitors.remove(visitor);
        }

    }




    @Override
    public void run() {
        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 30_000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isOpen = false;
                System.out.println("Магазин закрывается");
                visitors.clear();
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                isOpen = true;
                System.out.println("Магазин открыт");

            }
        }, begin, timeInterval);
    }

    boolean isNotFull() {
        if (visitors.size() >= 5) {
            return false;
        }
        return true;
    }
}
