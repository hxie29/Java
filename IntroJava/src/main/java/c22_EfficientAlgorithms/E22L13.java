/* Finding a Convex Hull Using Gift Wrapping Algorithm

* Step 1: Given a list of points S, select the rightmost lowest point and
name it

* Step 2: Sort the points in S angularly along the x-axis with p0 as the
center, as shown in Figure 22.10b. If there is a tie and two points have
the same angle, discard the one that is closer to p0. The points in S are
now sorted as p0, p1, p2, . . . , pn−1.

* Step 3: Push p0, p1, and p2 into stack H. (After the algorithm finishes,
H contains all the points in the convex hull.)

* Step 4:
    i = 3;
    while (i < n) {
        Let t1 and t2 be the top first and second element in stack H;
        if (pi is on the left side of the direct line from t2 to t1) {
            Push pi to H;
            i++; // Consider the next point in S.
        }
        else
            Pop the top element off stack H.
    }

* Step 5: The points in H form a convex hull. */

package c22_EfficientAlgorithms;

public class E22L13 {
}
