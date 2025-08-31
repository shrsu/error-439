# Closest Pair of Points in 2D Plane

You are given a set of N points in a 2D Cartesian plane. Your task is to find the minimum distance between any two distinct points in this set.

To solve this, you must implement a **Divide and Conquer** algorithm. The core idea is to recursively split the problem into smaller pieces and combine the results. For this specific problem, to keep the "Combine" step simple, you will use a brute-force check for pairs that cross the dividing line.

**Input Format:**

- The first line contains an integer `N`, the number of points.
- The next `N` lines each contain two space-separated integers, `x` and `y`, representing the coordinates of a point.

**Output Format:**

- A single floating-point number representing the minimum distance between any two points, printed with a precision of up to 6 decimal places.

**Example 1:**

```
Input:
4
0 0
7 6
2 2
10 0

Output:
2.828427

```

**Explanation:** The four points are (0,0), (7,6), (2,2), and (10,0). Let's trace the Divide and Conquer approach:

1. Sort by x-coordinate: P = [(0,0), (2,2), (7,6), (10,0)].
2. Divide:
    - Left half: [(0,0), (2,2)]
    - Right half: [(7,6), (10,0)]
3. Conquer:
    - d_left = distance((0,0), (2,2)) = sqrt((2-0)^2 + (2-0)^2) = sqrt(8) ≈ 2.828427.
    - d_right = distance((7,6), (10,0)) = sqrt((10-7)^2 + (0-6)^2) = sqrt(9 + 36) = sqrt(45) ≈ 6.708204.
4. Combine:
    - The minimum distance from the recursive calls is d = min(d_left, d_right) = 2.828427.
    - The dividing line is at x= (2+7)/2 = 4.5.
    - The strip contains points within 2.828427 of x=4.5. This includes (2,2) and (7,6).
    - The distance between (2,2) and (7,6) is sqrt((7-2)^2 + (6-2)^2) = sqrt(25+16) = sqrt(41) ≈ 6.403. This is not smaller than d.
    - The final minimum distance is 2.828427.

**Example 2:**

```
Input:
5
0 0
1 10
2 0
10 10
12 0

Output:
2.000000

```

**Explanation** The points are (0,0), (1,10), (2,0), (10,10), (12,0). The closest pair is (0,0) and (2,0), with a distance of 2. The Divide and Conquer algorithm will find this by comparing the results from the left half, the right half, and the "strip" in the middle.

**Constraints**

- `2 <= N <= 500`
- `10000 <= x, y <= 10000`
- All points are distinct.