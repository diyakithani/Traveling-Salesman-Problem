/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Partner Name:    Ada Lovelace
 *  Partner NetID:   alovelace
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

public class CircularQuote {
    // the first card in a circular linked list



    private Node start; //node is an instance-global variable of circularquote

    // helper linked-list data type
    class Node {
        private String word;
        private Node next;

        private Node(String word) {
            this.word = word;
            this.next = null;
        }
    }

    // create an empty quote
    public CircularQuote() {
        this.start=null;
    }

    // add the word w to the end of the quote
    public void addWord(String w) {
        Node newNode =   new Node(w);

        // special case for 0 nodes
        if ( start==null   ) {
            // save the card with the new word
            start=newNode;
            start.next = start; // make it circular
        }

        // otherwise, traverse list until card points to last word
        else {
            // find the current last word
            Node card = start;
            do {
                card = card.next;
            } while ( card.next!=start   );

            // insert new word
            card.next = newNode;
            newNode.next = start;
        }
    }

    // string representation of the entire quote
    public String toString(){
        StringBuilder result = new StringBuilder();
        if (start == null) // special case
            return result.toString();

        Node card = start;
        do {
            result.append(card.word+" ");
            card=card.next;
        } while (  card.next!=start );

        return   result.toString() ;
    }

    // number of words in the quote
    public int count() {
        int c=0;
        if(start==null)
            return c;

        Node pointer=start;
        do{
            c=c+1;
            pointer=pointer.next;
        }
        while(pointer.next!=start);
        return c;
    }

    // the kth word in the quote (where k = 1 is the first word)
    public String circularGetKth(int k) {
        Node card = start;
        for (int j = 1; j < k; j++) {
            card = card.next;
        }
        return card.word;
    }

    // test client
    public static void main(String[] args) {
        CircularQuote q = new CircularQuote();
        StdOut.println(q.count() + ": " + q);

        q.addWord("A");
        StdOut.println(q.count() + ": " + q);

        q.addWord("rose");
        StdOut.println(q.count() + ": " + q);
        StdOut.println("Second word: " + q.circularGetKth(2)); // rose

        q.addWord("is");
        StdOut.println(q.count() + ": " + q);
        StdOut.println("Tenth word: " + q.circularGetKth(10)); // A

        q.addWord("a");
        StdOut.println(q.count() + ": " + q);
        StdOut.println("Seventh word: " + q.circularGetKth(7)); // is

        q.addWord("rose.");
        StdOut.println(q.count() + ": " + q);
        StdOut.println("First word: " + q.circularGetKth(1)); // A
    }
}
