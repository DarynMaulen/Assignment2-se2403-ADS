📌This project contains custom implementations of common data structures in Java. It was created as part of Assignment 2 for the Algorithms and Data Structures course.

🔹IMPLEMENTED DATA STRUCTURES:

MyArrayList<T> — Custom implementation of a dynamic array.

MyLinkedList<T> — Custom implementation of a doubly linked list.

MyStack<T> — Stack implementation using a list.

MyQueue<T> — Queue implementation using a list.

MyMinHeap<T extends Comparable<T>> — Min-heap implementation using a list.

🔹KEY FEATURES:

Each data structure supports standard operations (add, remove, get, set, etc.).

The min-heap supports insert, getMin, and extractMin methods with proper heap properties.

All generic classes use type parameters for flexibility.

Code is separated into interfaces and implementation classes for better modularity.

🔹TESTING:

All data structures are tested in the ResulTest.java class.

Example inputs and expected outputs are printed to the console.

You can run ResulTest.java to verify the functionality of all components.

🔹FOLDER STRUCTURE:

interfaces/ — contains interfaces like IMyStack, IMyQueue, IMyMinHeap, MyList, etc.

Implementation classes: MyArrayList.java, MyLinkedList.java, MyStack.java, MyQueue.java, MyMinHeap.java.

Main.java — optional main entry (if needed).

ResulTest.java — contains all test cases for each structure.
