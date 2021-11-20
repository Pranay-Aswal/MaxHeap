import java.util.*;

public class MaxHeap<Node extends Comparable<Node>>{
    private ArrayList<Node> list;
    private Comparator<? super Node> comparator;

    public MaxHeap(Comparator<? super Node> comparator) {       //Constructor for MaxHeap
        list = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(Node element) {                         //Function that sorts the heap
        list.add(element);
        int currentIndex = list.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if(comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
                Node temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break;
            currentIndex = parentIndex;
        }
    }

    public void remove() {                                  //Function that removes the root node of the heap and rearranges heap
        list.set(0, list.get(list.size() - 1));
        int currentIndex = 0;
        list.remove(list.size() - 1);
        while (currentIndex < list.size()) {
            int leftSubtreeIndex = currentIndex * 2 + 1;
            int rightSubtreeIndex = currentIndex * 2 + 2;
            int maxIndex = leftSubtreeIndex;
            if(maxIndex >= list.size())
                break;
            if(rightSubtreeIndex < list.size()) {
                if(comparator.compare(list.get(maxIndex), list.get(rightSubtreeIndex)) < 0) {
                    maxIndex = rightSubtreeIndex;
                }
            }

            if(comparator.compare(list.get(maxIndex), list.get(currentIndex)) > 0) {
                Node temp = list.get(currentIndex);
                list.set(currentIndex, list.get(maxIndex));
                list.set(maxIndex, temp);
                currentIndex = maxIndex;
            } else
                break;
        }
    }

    public List<Node> getList() {
        return new ArrayList<>(list);
    }       //Returns a list of Node elements from Heap

}

