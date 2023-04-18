
/* This class represents a Playlist of podcast episodes, where each
/* episode is implemented as an object of type Episode. A user navigating
/* a Playlist should be able to move between songs using next or previous
references.
/*
/* To enable flexible navigation, the Playlist is implemented as
/* a Doubly Linked List where each episode has a link to both
/* the next and the prev episodes in the list.
*/
import java.nio.channels.WritableByteChannel;
import java.util.*;

public class Playlist {
    private Episode head;
    private int size;

    public Playlist() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Ensure that "size" is updated properly in other methods, to always
    // reflect the correct number of episodes in the current Playlist
    public int getSize() {
        return size;
    }

    // Our implementation of toString() displays the Playlist forward,
    // starting at the first episode (i.e. head) and ending at the last episode,
    // while utilizing the "next" reference in each episode
    @Override
    public String toString() {
        String output = "[HEAD] ";
        Episode current = head;
        if (!isEmpty()) {
            while (current.next != null) {
                output += current + " -> ";
                current = current.next;
            }
            output += current + " [END]\n";
        } else {
            output += " [END]\n";
        }
        return output;
    }

    // This method displays the Playlist backward, starting at
    // the last episode and ending at the first episode (i.e. head),
    // while utilizing the "prev" reference in each episode
    public String toReverseString() {
        String output = "[END] ";
        Episode current = head;
        if (!isEmpty()) {
            while (current.next != null)
                current = current.next;
            // current is now pointing to last node
            while (current.prev != null) {
                output += current + " -> ";
                current = current.prev;
            }
            output += current + " [HEAD]\n";
        } else {
            output += " [HEAD]\n";
        }
        return output;
    }

    /**************************************************************/
    // A4 Part 1 Methods (Add/Delete Operations)
    // TODO: Implement the method addFirst
    public void addFirst(String title, double duration) {

        while (head.prev != null)
            head = head.prev;

        Episode newOne = new Episode(title, duration, head, null);

        head = newOne;

        size++;
    }

    // TODO: Implement the method addLast
    public void addLast(String title, double duration) {
        while (head.next != null)
            head = head.next;

        Episode newOne = new Episode(title, duration, null, head);

        head = newOne;

        size++;
    }

    // TODO: Implement the method deleteFirst
    public Episode deleteFirst() {

        if (isEmpty())
            throw new NoSuchElementException();

        while (head.prev != null)
            head = head.prev;

        Episode temp = head;
        head = null;
        size--;

        return temp;
    }

    // TODO: Implement the method deleteLast
    public Episode deleteLast() {

        while (head.next != null)
            head = head.next;
        if (head == null)
            throw new NoSuchElementException();
        Episode temp = head;
        head = null;
        size--;
        return temp;
    }

    // TODO: Implement the method deleteEpisode
    public Episode deleteEpisode(String title) {

        while (head.prev != null)
            head = head.prev;
        if (head == null)
            throw new NoSuchElementException();
        for (int i = 0; i < size; i++) {
            if (head.title.equals(title))
                break;
        }

        Episode temp = null;

        if (head.next != null) {
            temp = head;
            head = head.next;
        }

        size--;
        return temp;
    }

    /***************************************************************/
    // A4 Part 2 Methods (Sorting the Playlist using MergeSort)
    // TODO: Implement the method merge (read description in A4 handout)
    public Episode merge(Episode a, Episode b) {

        Episode updater = new Episode(null, 0, null, null);

        while (true) {

            if (a.next == null) {
                updater.next = b;
                break;
            }
            if (b.next == null) {
                updater.next = b;
                break;
            }

            /*
             * Compare the data of the two
             * lists whichever lists' data is
             * smaller, append it into tail and
             * advance the head to the next Node
             */
            if (a.title.compareTo(b.title) > 0) {
                updater.next = a;
                a = a.next;
            } else {
                updater.next = b;
                b = b.next;
            }

            /* Advance the tail */
            updater = updater.next;
        }
        return updater.next;
    }
    // Finds the middle episode of the list that begins at the passed node reference

    private Episode getMiddleEpisode(Episode node) {
        if (node == null)
            return node;
        Episode slow = node;
        Episode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // MergeSort starting point
    public void mergeSort() {
        if (isEmpty())
            throw new RuntimeException("Cannot sort empty list.");
        head = sort(head);
    }

    // Recursively splits the list starting at a given node reference
    public Episode sort(Episode node) {
        if (node == null || node.next == null)
            return node;
        Episode middle = getMiddleEpisode(node); // get the middle of the list
        Episode left_head = node;
        Episode right_head = middle.next;
        // split the list into two halves:
        if (right_head != null)
            right_head.prev = null;
        middle.next = null;
        Episode left = sort(left_head);
        Episode right = sort(right_head);
        return merge(left, right);
    }
} // End of Playlist class