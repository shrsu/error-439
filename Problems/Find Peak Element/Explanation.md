# Step-by-Step Breakdown

## **Step 1: Input Handling**

```java
int n = sc.nextInt();
int[] arr = new int[n];
for (int i = 0; i < n; i++) {
    arr[i] = sc.nextInt();
}

```

### Rationale:

- Reads the size of the array and its elements.
- Stores them in `arr[]` for processing.
- Nothing special here — just standard input.

---

## **Step 2: Initialize Search Boundaries**

```java
int lo = 0, hi = n - 1;

```

### Rationale:

- Since the problem requires **O(log n)**, we must use **binary search** instead of linear scanning.
- `lo` starts at the beginning (0), `hi` starts at the end (`n-1`).
- We’ll shrink this search window until `lo == hi`, which gives the **index of a peak**.

---

## **Step 3: Binary Search Loop**

```java
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;

```

### Rationale:

- Loop runs until the search space shrinks to a single element.
- `mid` is chosen carefully to avoid integer overflow (`lo + (hi - lo)/2` instead of `(lo+hi)/2`).

---

## **Step 4: Compare `arr[mid]` with `arr[mid + 1]`**

```java
if (arr[mid] > arr[mid + 1]) {
    hi = mid;
} else {
    lo = mid + 1;
}

```

### Rationale:

- This is the **key logic** that uses the "slope climbing" property:
    - If `arr[mid] > arr[mid+1]`:
        - Peak **must be on the left half** (including `mid`).
        - Because if mid is already higher than its right neighbor, then there’s a descent — so peak lies at `mid` or left side.
    - Else (`arr[mid] < arr[mid+1]`):
        - Peak **must be on the right half**.
        - Because we are climbing upward; the peak lies further to the right.
- This guarantees we never discard the side containing the peak.

---

## **Step 5: Termination**

```java
System.out.println(lo);

```

### Rationale:

- Loop exits when `lo == hi`.
- At this point, both `lo` and `hi` point to a **peak element index**.
- Prints the peak index.

---

# Why This Works (Intuition)

- The array can be thought of as **ups and downs (mountains)**.
- At every step, we "follow the slope":
    - If slope goes **down**, peak is **left**.
    - If slope goes **up**, peak is **right**.
- Eventually, we converge on a peak in **O(log n)**.

---