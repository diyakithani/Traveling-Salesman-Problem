/* *****************************************************************************
 *  Name:    Diya Kithani
 *  NetID:   226007297
 *  Description:  TSP tour program using nearest and smallest heuristics algorithm
 *
 **************************************************************************** */

public class Tour {
    private Node start; // node is an instance-global variable of Tour
    // helper linked-list data type

    private class Node {
        private Point p;
        private Node next;

        private Node(Point p) {
            this.p = p;
            this.next = null;
        }
    }

    private void insert(Point p) { //inserts the point at the end of the tour
        Node stop = new Node(p);
        if (start == null) {
            start = stop;
            stop.next = start;
        } else {
            Node pointer = start;
            do {
                pointer = pointer.next;
            } while (pointer.next != start);
            pointer.next = stop;
            stop.next = start;
        }
    }

    // creates an empty tour
    public Tour() {
        this.start = null;
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        insert(a);
        insert(b);
        insert(c);
        insert(d);
        Node pointer = start;
        do {
            System.out.println(pointer.p);
            pointer = pointer.next;
        } while (pointer != start);

    }

    // returns the number of points in this tour
    public int size() {
        int count = 0;
        Node pointer = start;
        if (start == null) {
            return count;
        }
        do {
            count++;
            pointer = pointer.next;
        } while (pointer != start);
        return count;
    }

    // returns the length of this tour
    public double length() {
        Node pointer = start;
        double length = 0;
        if (start == null) {
            return length;
        }

        do {
            length = length + pointer.p.distanceTo(pointer.next.p);

            pointer = pointer.next;
        } while (pointer != start);
        return length;
    }

    // returns a string representation of this tour
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        Node pointer = start;

        if (start == null) {
            s.append("");
            return s.toString();
        }

        do {
            s.append(pointer.p + "\n"); // kya
            pointer = pointer.next;
        } while (pointer != start);

        return s.toString();
    }

    // draws this tour to standard drawing
    public void draw() {
        Node pointer = start;
        if (start == null) {
            return;
        }

        do {
            pointer.p.drawTo(pointer.next.p);

            pointer = pointer.next;
        } while (pointer != start);

    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        // Empty edge case
        if(start==null){
            insert(p);
            return;
        }

        Node newnode= new Node(p);

        // Keep track of nearest neighbour
        double minimum= Double.MAX_VALUE;
        Node m=null;

        // Traverse tour and find out the nearest neighbour
        Node pointer=start;
        do{
            double d=pointer.p.distanceTo(p);
            if(d<minimum){
                minimum=d;
                m=pointer;

            }
            pointer=pointer.next;
        }
        while(pointer!=start);

        // Insert the new node after the nearest node
        newnode.next=m.next;
        m.next=newnode;

    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        // Empty Edge Case
        if(start==null){
            insert(p);
            return;
        }


        Node newnode=new Node(p);

        // Keep track of the node due to which the tour has the smallest length
        Node fin=null;
        double len=Double.MAX_VALUE;

        // Traverse the tour and find that node
        Node pointer=start;
        do{
           newnode.next=pointer.next;
           pointer.next=newnode;
           if(this.length()<len){
               len=this.length();
               fin=pointer;
           }
           pointer.next=newnode.next;
           pointer=pointer.next;
        }
        while(pointer!=start);

        // Insert the new node
        newnode.next=fin.next;
        fin.next=newnode;
    }


    // tests this class by directly calling all constructors and instance methods
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(1, 1);
        Point d = new Point(1, 0);

        Tour t = new Tour(a, b, c, d);

        int size = t.size();
        StdOut.println("Number of points = " + size);

        double length = t.length();
        StdOut.println("Tour length = " + length);

        System.out.println(t.toString());

        StdDraw.setXscale(-2, 2);
        StdDraw.setYscale(-2, 2);
        t.draw();

        Tour t1=new Tour();
        t1.insertNearest(new Point(0,0));
        t1.insertNearest(new Point(0,10));
        t1.insertNearest(new Point(0,9));
        System.out.println(t1.length());


        Tour t2=new Tour();
        t2.insertSmallest(new Point(0,0));
        t2.insertSmallest(new Point(0,10));
        t2.insertSmallest(new Point(0,9));
        System.out.println(t2.length());



    }
}