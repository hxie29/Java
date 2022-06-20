/*Algorithm for finding the closest pair:
* Step 1: Sort the points in increasing order of x-coordinates. For the
points with the same x-coordinates, sort on y-coordinates. This results
in a sorted list S of points.
Step 2: Divide S into two subsets, S1 and S2, of equal size using the
midpoint in the sorted list. Let the midpoint be in S1. Recursively find
the closest pair in S1 and S2. Let d1 and d2 denote the distance of the
closest pairs in the two subsets, respectively.
Step 3: Find the closest pair between a point in S1 and a point in S2
and denote their distance as d3. The closest pair is the one with the
distance min(d1, d2, d3). */
package c22_EfficientAlgorithms;

public class E22L08 {

}
