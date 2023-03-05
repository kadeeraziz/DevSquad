public class MyArray<T>{
    
    public T[] array;

    @SuppressWarnings("unchecked")
    public MyArray(int size){
        array = (T[]) new Object[size];
    }

    // size of array
    public int size(){
        return array.length;
    }

    // get element at index
    public T get(int index){
        return array[index];
    }

    // set element at index
    public void set(int index, T element){
        array[index] = element;
    }

    // add element at index
    @SuppressWarnings("unchecked")
    public void add(int index, T element){
        T[] newArray = (T[]) new Object[array.length + 1];
        for(int i = 0; i < index; i++){
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for(int i = index + 1; i < newArray.length; i++){
            newArray[i] = array[i - 1];
        }
        array = newArray;
    }

    // remove element at index
    public void remove(int index){
        T[] newArray = (T[]) new Object[array.length - 1];
        for(int i = 0; i < index; i++){
            newArray[i] = array[i];
        }
        for(int i = index; i < newArray.length; i++){
            newArray[i] = array[i + 1];
        }
        array = newArray;
    }

    // clear array
    public void clear(){
        array = (T[]) new Object[0];
    }

    // check if array contains element
    public boolean contains(T element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    // remove an element
    public void removeElement(T element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                remove(i);
                return;
            }
        }
    }

    // print array
    @SuppressWarnings("unchecked")
    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
    
    public static void main(String[] args){
        MyArray<Integer> a = new MyArray<Integer>(10);
        System.out.println(a.size());
        a.add(0, 10);
        a.print();
        
    }
}