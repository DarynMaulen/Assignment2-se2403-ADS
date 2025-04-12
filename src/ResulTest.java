import interfaces.MyList;

import java.util.Comparator;

public class ResulTest {
    public static void ShowResults(){
        System.out.println("--- TESTING MyArrayList ---");
        MyList<Integer> arrayList = new MyArrayList<>();
        testList(arrayList);

        System.out.println("\n--- TESTING MyLinkedList ---");
        MyList<Integer> linkedList = new MyLinkedList<>();
        testList(linkedList);

        System.out.println("\n--- TESTING MyStack (based on MyArrayList) ---");
        MyStack<Integer> stack = new MyStack<>(new MyArrayList<>());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top (peek): " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack.peek());

        System.out.println("\n--- TESTING MyQueue (based on MyLinkedList) ---");
        MyQueue<Integer> queue = new MyQueue<>(new MyLinkedList<>());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue front (peek): " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue after dequeue: " + queue.peek());

        System.out.println("\n--- TESTING MyMinHeap (based on MyArrayList) ---");
        MyMinHeap<Integer> heap = new MyMinHeap<>(new MyArrayList<Integer>());
        heap.insert(50);
        heap.insert(20);
        heap.insert(40);
        heap.insert(10);
        heap.insert(30);
        System.out.println("Heap size: " + heap.size());
        System.out.println("Min element (getMin): " + heap.getMin());
        System.out.println("Extract min: " + heap.extractMin());
        System.out.println("Min after extract: " + heap.getMin());
    }

    // Helper function to test MyList
    private static void testList(MyList<Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("After add elements: " + arrayToString(list.toArray()));

        list.add(2, 25);
        System.out.println("After add at index 2: " + arrayToString(list.toArray()));

        list.set(3, 35);
        System.out.println("After set at index 3: " + arrayToString(list.toArray()));

        list.addFirst(5);
        System.out.println("After addFirst: " + arrayToString(list.toArray()));

        list.addLast(50);
        System.out.println("After addLast: " + arrayToString(list.toArray()));

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.remove(2);
        System.out.println("After remove at index 2: " + arrayToString(list.toArray()));

        list.removeLast();
        System.out.println("After removeLast: " + arrayToString(list.toArray()));

        list.removeFirst();
        System.out.println("After removeFirst: " + arrayToString(list.toArray()));

        list.add(15);
        list.add(25);
        list.add(10);
        list.sort(Comparator.naturalOrder());
        System.out.println("After sorting: " + arrayToString(list.toArray()));

        System.out.println("Index of 25: " + list.indexOf(25));
        System.out.println("Last index of 10: " + list.lastIndexOf(10));
        System.out.println("Does 20 exist? " + list.exists(20));

        list.clear();
        System.out.println("After clear: " + arrayToString(list.toArray()));
        System.out.println("Size of the list: " + list.size());
    }

    // Converts array to string for printing
    private static String arrayToString(Object[] array) {
        StringBuilder sb = new StringBuilder();
        for (Object element : array) {
            sb.append(element).append(" ");
        }
        return sb.toString().trim();
    }
}
