# TEAM kabbage
### John Liu, Larry Wong, Derek Song

_From Wikipedia.com_
> In computer science, a double-ended queue (dequeue, often abbreviated to deque) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

# To-Do List
1) Create and maintain a working repo
2) Research what a deque is and pick out essential methods that define it
3) Create interface with the following methods (not in order)
- isEmpty()
- enqueueFirst(T)
- enqueueLast(T)
- toString()
- peekFirst()
- peekLast()
- dequeFirst()
- dequeLast()
4) Implement each method (incrementally)
5) Create or borrow a driver to test functionality

* Our Deque is double-linked node based because it allowed the coder more freedom to control how each implemented method would work, instead of borrowing the built-in methods in the java API. In addition, it allowed for O(1) runtime for most methods, since working with the front and the end nodes are independent of the other nodes in between. 

## Methods to implement (in ascending order):
- isEmpty()
- addFirst(T)
- addLast(T)
- toString()
- peekFirst()
- peekLast()
- removeFirst()
- removeLast()

- We decided to choose the above methods because they are what define a deque. These methods above are, in the simplest terms, the foundations of a deque and without anyone of them, the data structure will not be a deque. In addition, other methods are not nessessary in order to make a deque work. The other methods, such as offerFirst() and pollFirst(), appear to be some variant of the methods stated above. Therefore, they are not essential for what we are doing here. What we are aiming for is the functionality of the deque while maintaining conciseness and simplicity. In addition, we decided to choose methods with names that are easily understood by the reader. For example, pollFirst() might be confusing to some people, so we decided to use removeFirst(), which is a similar method to pollFirst(). The above methods also throw exceptions, which will help users debug.

## Developmental Plan:
- We plan to keep our deque as simple as possible so that anyone can pick it up and use/modify it easily. We do this by first limiting the methods that are considered "essential" to the deque data structure by eliminating methods that seem redundant (as explained above). Selected methods are stated above. 
- We first implement the easier methods that do not require in-depth analysis. For example, isEmpty() relies solely on the instance variable size. Next, in order for any other deque methods to work, it requires the add methods. Next, we decided to implement the methods that provide visibility within the deque in order to test the functionality. Finally, we decided to implement the remove methods as the last ones because they depend on the functionality of the deque.

## Changes (so far):
- README is made clearer and explains our intentions more in detail
- Exceptions are added to the methods
- Comments are easier to read
