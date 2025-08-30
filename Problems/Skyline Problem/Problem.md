# The Skyline Problem

We are asked to compute the **skyline** formed by a collection of rectangular buildings.

* Imagine standing far away and looking at the buildings.
* The skyline is the **outer contour** (top boundary) of all the buildings combined.

---

## Input

* You are given a list of **buildings**, where each building is represented as:

  ```
  [left, right, height]
  ```

  * `left` → x-coordinate of the building’s left edge
  * `right` → x-coordinate of the building’s right edge
  * `height` → height of the building

* Assumptions:

  * Each building is a perfect rectangle.
  * All buildings are based on flat ground (y = 0).
  * `1 <= buildings.length <= 10^4`
  * `0 <= left < right <= 2^31 - 1`
  * `1 <= height <= 2^31 - 1`
  * Input buildings are **sorted by `left`** in non-decreasing order.

---

## Output

Return the skyline as a list of **key points**:

```
[[x1, y1], [x2, y2], ..., [xn, yn]]
```

Where:

* Each `[xi, yi]` represents a **critical point** where the skyline changes.
* The last key point should always end at height 0, marking the end of the skyline.
* The skyline must not contain consecutive points with the same height (merge them).

---

## Example 1

**Input:**

```
buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
```

**Visualization:**

* Building 1: from x=2 to x=9, height=10
* Building 2: from x=3 to x=7, height=15
* Building 3: from x=5 to x=12, height=12
* Building 4: from x=15 to x=20, height=10
* Building 5: from x=19 to x=24, height=8

**Output:**

```
[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
```

---

## Example 2

**Input:**

```
buildings = [[0,2,3],[2,5,3]]
```

**Output:**

```
[[0,3],[5,0]]
```

---

## Task

Find the list of **critical points** that define the skyline formed by all buildings.
