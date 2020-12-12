class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    int[] q;
    int front;
    int rear;
    int size;
    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        this.q[++rear % this.q.length] = value;
        rear = rear%this.q.length;
        this.size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front+1) % this.q.length;
        this.size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return this.q[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return this.q[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.size == 0) return true;
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(this.size == this.q.length) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */