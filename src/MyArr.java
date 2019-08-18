import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArr {
    private int SIZE = 10;
    private int[] arr;

    public MyArr(){
        arr = new int[(int)(SIZE)];
    }

    public void view(){
        System.out.println(Arrays.toString(this.arr));
    }

    public void fill(){
        for (int j = 1; j<= this.arr.length; j++){
            this.arr[j-1] = j;
        }
    }

    public int getSIZE(){
        return this.SIZE;
    }

    public void add(int i){
        try{
            this.arr[SIZE] = i;
        } catch (ArrayIndexOutOfBoundsException e){
            this.arr  = Arrays.copyOf(arr, (int) (arr.length * 1.3)); // увеличиваем размер с запасом
            this.arr[SIZE] = i;
        }
        finally {
            SIZE++;
        }
    }

    public void add(int pos, int i){
        int[] tempArr = Arrays.copyOf(this.arr, this.SIZE++);
        this.arr = (int[]) Array.newInstance(this.arr.getClass().getComponentType(), SIZE);
        System.arraycopy(tempArr,0,this.arr,0,pos);
        this.arr[pos]=i;
        System.arraycopy(tempArr,pos,this.arr,pos+1,tempArr.length-pos);
    }

    public int findInChaos(int dest){
        for(int i = 0; i < this.getSIZE(); i++){
            if (this.arr[i]== dest){
                System.out.println("Мы нашли число по Вашему запросу. Оно расположено на позиции "+ i);
                return i;
            }
        }
        System.out.println("Похоже, такого числа в нашем списке нет, попробуйте ввести другое.");
        return -1;
    }

    public void remove(int dest){
        int temp = findInChaos(dest);
        if(temp == -1){
            System.out.println("Такого элемента не существует, поэтому его невозможно удалить.");
        }
        else {
            int[] tempArr = Arrays.copyOf(this.arr,this.SIZE--);
            this.arr = (int[]) Array.newInstance(this.arr.getClass().getComponentType(),this.arr.length-1);
            System.arraycopy(tempArr,0,this.arr,0,temp);
            System.arraycopy(tempArr,temp+1,this.arr,temp,tempArr.length-temp-1);

        }
    }




}
