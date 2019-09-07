import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArr {
    private int SIZE = 10_000;
    private int[] arr;

    MyArr(){
        arr = new int[SIZE];
    }

    void view(){
        System.out.println(Arrays.toString(Arrays.copyOfRange(this.arr,0,SIZE)));
    }

    private int getSIZE(){
        return this.SIZE;
    }

    public void add(int i){ // используется для вставки в конец массива
        try{
            this.arr[SIZE] = i;
        } catch (ArrayIndexOutOfBoundsException e){
            this.arr  = Arrays.copyOf(arr, (int) (arr.length * 1.4)); // увеличиваем размер с запасом
            this.arr[SIZE] = i;
        }
        finally {
            SIZE++;
            System.out.println("Добавлено число "+i);
        }
    }

    public void add(int pos, int i){ // используется для вставки по индексу
        int[] tempArr = Arrays.copyOf(this.arr, this.SIZE++);
        this.arr = (int[]) Array.newInstance(this.arr.getClass().getComponentType(), SIZE);
        System.arraycopy(tempArr,0,this.arr,0,pos);
        this.arr[pos]=i;
        System.arraycopy(tempArr,pos,this.arr,pos+1,tempArr.length-pos);
        System.out.printf("Добавлено число %d на позицию %d\n",i,pos);

    }

     int findInChaos(int dest){ // поиск со скоростью O(n)
        for(int i = 0; i < this.getSIZE(); i++){
            if (this.arr[i]== dest){
                System.out.println("Мы нашли число по Вашему запросу. Оно расположено на позиции "+ i);
                return i;
            }
        }
        System.out.println("Похоже, такого числа в нашем списке нет, попробуйте ввести другое.");
        return -1;
    }

    public void remove(int dest){ // удаление элемента, скорость О(n); удаляет 1й встреченный элемент, если их несколько
        int temp = findInChaos(dest);
        if(temp == -1){
            System.out.println("Такого элемента не существует, поэтому его невозможно удалить.");
        }
        else {
            int[] tempArr = Arrays.copyOf(this.arr,this.SIZE--);
            this.arr = (int[]) Array.newInstance(this.arr.getClass().getComponentType(),this.arr.length-1);
            System.arraycopy(tempArr,0,this.arr,0,temp);
            System.arraycopy(tempArr,temp+1,this.arr,temp,tempArr.length-temp-1);
            System.out.printf("Удалено число %d с позиции %d\n",dest,temp);

        }
    }

    void fillRandom(){ // заполняет массив случайными числами
        for (int i = 0; i < this.SIZE; i++) {
            this.arr[i] = (int) (Math.random()*1000);
        }

    }

    void sortBubble() { // смещает самое большое число в конец за 1 итерацию
        long time = System.currentTimeMillis();
        int outer,inner;
        for(outer = this.SIZE-1; outer>= 1 ; outer--){
            for (inner = 0; inner < outer; inner++){
                if (this.arr[inner] > this.arr[inner+1]){
                    change(inner, inner+1);
                }
            }
        }
        System.out.println(System.currentTimeMillis()-time + " — время пузырьковой сортировки.");
    }


    public void sortSelect() { // смещает самое маленькое число в начало за 1 итерацию
        long time = System.currentTimeMillis();
        int outer, inner, mark;
        for(outer = 0; outer< this.SIZE; outer++){
            mark = outer;
            for (inner = outer + 1; inner<this.SIZE; inner++){
                if (this.arr[inner] < this.arr[mark]){
                    mark = inner;
                }
            }
            change(outer, mark);
        }
        System.out.println(System.currentTimeMillis() - time + " — время сортировки методом выбора.");
    }

    void sortInsert(){ // сортирует всё, что слева от текущего положения в цикле
        long time = System.currentTimeMillis();
        int inner, outer;
        for (outer = 1; outer<this.SIZE; outer++){
            int temp = this.arr[outer];
            inner = outer;
            while (inner > 0 && this.arr[inner - 1] >= temp) {
                this.arr[inner] = this.arr[inner-1];
                --inner;
            }
            this.arr[inner] = temp;
        }
        System.out.println(System.currentTimeMillis() - time + " — время сортировки методом вставки.");
    }

    private void change(int a, int b) {
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }



}
