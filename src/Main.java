public class Main {

    public static void main(String[] args) {
        MyArr i = new MyArr();
        i.fill();
        i.view();
        System.out.println(i.getSIZE());
        i.add(5,1);

        i.remove(1);
        i.view();
        i.remove(1);
        i.view();
    }
}
