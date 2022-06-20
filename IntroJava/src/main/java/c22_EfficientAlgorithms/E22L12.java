/*

Step 1: Given a list of points S, let the points in S be labeled
s0, s1, . . . , sk. Select the rightmost lowest point S. As shown in
Figure 22.9a, h0 is such a point. Add h0 to list H. (H is initially
empty. H will hold all points in the convex hull after the algorithm is
finished.) Let t0 be h0.

Step 2: Let t1 be s0.
For every point p in S,
       if p is on the right side of the direct line from t0 to t1, then let t1 be p.
(After Step 2, no points lie on the right side of the direct line from t0 to t1, as shown in Figure 22.9b.)

Step 3: If t1 is h0 (see Figure 22.9d), the points in H form a convex
hull for S. Otherwise, add t1 to H, let t0 be t1, and go back to Step 2 (see Figure 22.9c).

*/

package c22_EfficientAlgorithms;

public class E22L12 {
}
