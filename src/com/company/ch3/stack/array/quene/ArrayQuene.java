package com.company.ch3.stack.array.quene;

public class ArrayQuene<E> implements Quene<E> {

    private Array<E> array;

    public ArrayQuene(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQuene(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getLength();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Quene: ");
        res.append("front [");

        for(int i=0 ; i < array.getLength(); i ++){
            res.append(array.get(i));
            if (i != array.getLength()-1)
                res.append(", ");
        }

        res.append("] tail");
        return res.toString();

    }


    public static void main(String[] args) {

        ArrayQuene<Integer> quene = new ArrayQuene<>();
        for (int i = 0; i < 10; i++) {

            quene.enqueue(i);
            System.out.println(quene);
            if (i % 3 == 2){
                quene.dequeue();
                System.out.println(quene);
            }

        }
    }


}
