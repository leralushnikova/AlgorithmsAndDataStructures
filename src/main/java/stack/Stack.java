package stack;

class Stack {
    int size;
    String [] stackArray;
    int top;
    Stack(int size) {
        stackArray = new String[size];
        top = -1;
    }
    // Добавление элемента
    void push(String elem) {
        stackArray[++top] = elem;
    }
    // Извлечение элемента
    String pop() {
        return stackArray[top--];
    }
    // Чтение элемента
    String peek() {
        return stackArray[top];
    }
    // Проверка на пустоту
    boolean isEmpty() {
        return top == -1;
    }
    // Проверка на заполнение
    boolean isFull() {
        return (top == size - 1);
    }
}