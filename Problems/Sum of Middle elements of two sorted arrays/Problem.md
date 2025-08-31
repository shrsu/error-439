# **Sum of Middle elements of two sorted arrays**

Given 2 sorted integer arrays arr1 and arr2 of the same size. Find the sum of the middle elements of two sorted arrays arr1 and arr2.

**Input format:**

The input will consist of two lines.

- The first line contains space-separated integers for arr1.
- The second line contains space-separated integers for arr2.

**Output Format:**

The output will be a single integer representing the sum of the two middle elements of the conceptually merged array.

**Examples 1:**

```
Input:
1 2 3 4 5
6 7 8 9 10

Output:
11

```

**Explanation:**

The merged array looks like [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]. Sum of middle elements is 11 (5 + 6).

**Example 2:**

```
Input: arr1 =
1 12 15 26 38
2 13 17 30 45

Output:
32

```

**Explanation:**

The merged array looks like [1, 2, 12, 13, 15, 17, 26, 30, 38, 45]. Sum of middle elements is 32 (15 + 17).

Expected Time Complexity: O(log n) Expected Auxiliary Space: O(1)

Constraints:

- `1 <= arr1.size() == arr2.size() <= 103`
- `1 <= arr1[i] <= 106`
- `1 <= arr2[i] <= 106`

**Note:** You can assume that the total number of elements across both arrays will always be even. There is no need to handle cases where the combined array has an odd number of elements.