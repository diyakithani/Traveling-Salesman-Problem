/* *****************************************************************************
 *  Name: Diya Kithani
 *  NetID: 226007297
 *  Precept:
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 **************************************************************************** */

Which partner is submitting the program files? ME hehe

Programming Assignment 8: Traveling Salesperson Problem

Hours to complete assignment (optional): 5 hours


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/
The implementation compares the distance between the given point and every point already in the tour using distanceTo(Point p).
 It finds the node in the tour that is nearest to the given point and inserts the new node after that nearest node.
 The new point is inserted in a way that minimizes the overall distance of the tour.

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/
So, instead of finding the nearest node, this approach checks every possible position in the tour and picks the one
that results in the smallest tour length after inserting the new node.


/**********************************************************************
 *  Explain why it's better to use a circularly linked list instead   *
 *  of an array.                                                      *
 **********************************************************************/
-Simpler implementation
-easier to insert elements anywhere
-easier to resize
-used circularly linked list because it goes back to the start point.



/**********************************************************************
 *  Fill in the lengths computed by your heuristics.                  *
 **********************************************************************/

data file      nearest neighbor     smallest increase
-----------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt        7389.929676351667     4887.219040311983
tsp1000.txt       27868.710634854797    17265.628155352584
circuit1290.txt  25029.790452731024   14587.212527709591

/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of n, using expressions of the    *
 *  form: a * n^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for n = 1,000,    *
 *  and repeatedly double n until the execution time exceeds 60       *
 *  seconds.                                                          *
 *                                                                    *
 *  You may use TSPTimer to help do this, as per the checklist.       *
 *  If you do so, execute it with the -Xint option. This turns off    *
 *  various compiler optimizations, which helps normalize and         *
 *  stabilize the timing data that you collect.                       *
 *                                                                    *
 *  (If n = 1,000 takes over 60 seconds, your code is too slow.       *
 *  See the checklist for a suggestion on how to fix it.)             *
 **********************************************************************/

n               nearest time           smallest time
------------------------------------------------------------
1000            0.01s                   1.035s
2000            0.015s                  9.178s
3000            0.031s                  32.44s
4000            0.06s                   85.707s
...

My nearest time  algorithm takes about 7.557e-09 * n ^ 1.913 seconds on my machine which is polynomial run time.
My smallest time algorithm takes about 8.848e-11 * n ^ 3.327 seconds on my machine which is polynomial run time.

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?
no :(


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?
no




/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
It was fun to implement tsp, my first encounter with a heuristics problem. :)
