package com.github.adchilds.pas.algorithm.support;

/**
 * This class was created to support the implementation of the First-In-First-Out and Second-Chance paging allocation
 * algorithms for Operating Systems.
 *
 * @since 1.0
 */
public class Queue {

    private int[] arr;
    private int nElems;
    private int front;
    private int rear;

    public Queue(int sz) {
        arr = new int[sz];
        nElems = 0;
        front = 0;
        rear = -1;
    }

    /**
     * Inserts an element at the end of the {@link Queue}
     *
     * @since 1.0
     */
    public void insert(int i) {
        if (isFull()) {
            System.out.println("1 QUEUE IS FULL");
            return;
        } else if (rear != arr.length-1) {
            arr[rear + 1] = i;
            rear++;
        } else {
            arr[0] = i;
            rear = 0;
        }

        nElems++;
    }

    /**
     * Removes and element from the beginning of the {@link Queue}
     *
     * @since 1.0
     */
    public void remove() {
        if (isEmpty()) {
            System.out.println("1 QUEUE IS EMPTY");
            return;
        } else if (front != arr.length-1) {
            front++;
        } else {
            front = 0;
        }

        nElems--;
    }

    /**
     * Searches for a particular value in the {@link Queue}
     *
     * @since 1.0
     */
    public boolean search (int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return true;
            }
        }

        return false;
    }

    /**
     * returns the location of an element in the {@link Queue}. It is created for searching for values in the Queue,
     * replacement in {@link SC_Allocation}.
     *
     * @param element
     * @return
     * @since 1.0
     */
    public int find (int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Updates the value of a reference's dirty bit.
     *
     * @since 1.0
     */
    public void updateDirty (int location, int value) {
        arr[location] = value;
    }

    /**
     * Returns the element at the given {@code location}.
     *
     * @param location
     * @return
     * @since 1.0
     */
	public int elementAt(int location) {
        return arr[location];
    }

    /**
     * Resets the dirty {@link Queue} to all zeros.
     *
     * @param frames
     * @return
     * @since 1.0
     */
    public Queue makeZero(int frames) {
        Queue temp = new Queue(frames);

        for (int i = 0; i < frames; i++) {
            temp.insert(0);
        }

        return temp;
    }

    /**
     * Finds the location of the first dirty bit with a value of 0, to determine what element should be replaced. Only
     * used for the dirty {@link Queue} in {@link SC_Allocation}.
     *
     * @since 1.0
     */
    public int findReplacement(int frames) {
        int replace = -1;

        for (int i = 0; i < frames; i++) {
            if (arr[i] == 0){
                replace = i;
                break;
            } else if (i == frames - 1 ){
                replace = -1;
            }
        }

        return replace;
    }

    /**
     * Removes an element at a specific location within and returning the updated {@link Queue}.
     *
     * @since 1.0
     */
    public Queue updateQueue(Queue replace, int location, int frames){
        Queue temp = new Queue(frames);

        for (int i = 0; i < frames; i++) {
            if (i == location) {
                replace.remove();
            } else {
                temp.insert(replace.front());
                replace.remove();
            }
        }

        return temp;
    }

    /**
     * Returns the element at the front of the array.
     */
    public int front() {
        return arr[front];
    }

	/**
     * Checks to see if the {@link Queue} is full.
     */
    public boolean isFull() {
        return (nElems == arr.length);
    }

    /**
     * Checks to see if the {@link Queue} is empty.
     */
    public boolean isEmpty() {
        return (nElems == 0);
    }

}