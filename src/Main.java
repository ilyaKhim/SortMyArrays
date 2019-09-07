public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyArr i = new MyArr();


        i.fillRandom();
        i.view();
        i.sortBubble();
        i.view();
        i.findInChaos(123);
        i.remove(123);
        i.findInChaos(123);
        i.add(123);

        Thread.sleep(5000);


        i.fillRandom();
        i.view();
        i.sortSelect();
        i.view();
        i.findInChaos(234);
        i.remove(234);
        i.findInChaos(234);
        i.add(234);

        Thread.sleep(5000);

        i.fillRandom();
        i.view();
        i.sortInsert();
        i.view();
        i.findInChaos(456);
        i.remove(456);
        i.findInChaos(456);
        i.add(456);

        System.out.println("\nEnd.");

    }
}
