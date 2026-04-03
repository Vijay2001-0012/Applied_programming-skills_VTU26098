class MyCircularDeque {

    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int k;
    public MyCircularDeque(int k) {
        this.k = k;
        this.arr = new int[this.k];
        this.front = this.rear = this.size = 0;
    }
    
    public boolean insertFront(int value) {
        if (this.isFull()) return false;
        if (this.front == 0) this.front = this.k - 1;
        else this.front -= 1;
        this.arr[this.front] = value;
        this.size += 1;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (this.isFull()) return false;
        this.arr[this.rear] = value;
        this.rear = (this.rear + 1) % this.k;
        this.size += 1;
        return true;
    }
    
    public boolean deleteFront() {
        if (this.isEmpty()) return false;
        this.front = (this.front + 1) % this.k;
        this.size -= 1;
        return true;
    }
    
    public boolean deleteLast() {
        if (this.isEmpty()) return false;
        if (this.rear == 0) this.rear = this.k - 1;
        else this.rear -= 1;
        this.size -= 1;
        return true;
    }
    
    public int getFront() {
        if (this.isEmpty()) return -1;
        return this.arr[this.front];
    }
    
    public int getRear() {
        if (this.isEmpty()) return - 1;
        if (this.rear == 0) return this.arr[this.k - 1];
        return this.arr[this.rear - 1];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */