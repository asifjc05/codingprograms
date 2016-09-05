public class LinkedListPalindrome {

    Node head;
    Node slow_ptr, fast_ptr, second_half;

    // creating list node
    class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }

    // pushing the data to the list
    public void push(char new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        // System.out.println("added element " + new_data);
        head = new_node;
        System.out.println("head data is " + head.data);
    }

    // printing the list
    void printList(Node ptr) {
        while (ptr != null) {
            System.out.print(ptr.data + "->");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    // first find middle element and then reverse the half of the list
    // have pointer in middle and then compare first half and second half
    boolean isPalindrome(Node head) {
        slow_ptr = head;
        fast_ptr = head;
        Node prev_of_slow_ptr = head;
        Node midNode = null;
        boolean result = true;

        // finding middle element in list
        if (head != null && head.next != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            if (fast_ptr != null) {
                midNode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            second_half = slow_ptr;
            prev_of_slow_ptr.next = null;
            reverse();
            result = compareLists(head, second_half);
            reverse();

            if (midNode != null) {
                prev_of_slow_ptr = midNode;
                midNode.next = second_half;
            } else {
                prev_of_slow_ptr = second_half;
            }
        }
        return result;

    }

    // method to reverse the list
    void reverse() {
        Node prev = null;
        Node current = second_half;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }

    // comparing both lists same or not
    boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                return false;
            }
        }

        if (temp1 == null && temp2 == null) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListPalindrome list = new LinkedListPalindrome();
        list.head = list.new Node('r');
        list.head.next = list.new Node('a');
        list.head.next.next = list.new Node('d');
        list.head.next.next.next = list.new Node('a');
        list.head.next.next.next.next = list.new Node('r');
        list.printList(list.head);
        if (list.isPalindrome(list.head)) {
            System.out.println("is palindrome");
            System.out.println("");
        } else {
            System.out.println("Not palindrome");
            System.out.println("");
        }
    }

}
