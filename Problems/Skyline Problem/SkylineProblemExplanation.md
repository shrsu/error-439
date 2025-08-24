# Skyline Problem Algorithm (Sweep Line + Max Heap / TreeMap)

We need the **outer contour** of all buildings. The solution uses a **sweep line algorithm** with a data structure (`max-heap` or `TreeMap`) to track active heights.

---

## Step 1: Convert Buildings into Events

* For each building `[left, right, height]`:

  * Create **entering event** `(x = left, height = -h)`
    (negative ensures entering events sort before leaving events).
  * Create **leaving event** `(x = right, height = h)`.

These events mark **critical points** where the skyline may change.

---

## Step 2: Sort Events

* Sort primarily by x-coordinate (from left to right).
* If multiple events share the same x:

  * Process **entering events before leaving events**.
  * Among entering events, process taller buildings first.
  * Among leaving events, process shorter buildings first.

This guarantees skyline changes are detected in the correct order.

---

## Step 3: Maintain Active Heights

* Use a **max-heap** (priority queue) or **TreeMap** to keep track of active building heights.
* At each event:

  * If entering, add height to data structure.
  * If leaving, remove height from data structure.
* The current **maximum height** is always the data structure’s top (heap) or lastKey (TreeMap).

---

## Step 4: Record Skyline Key Points

* Keep track of the **previous maximum height** (`prevMax`).
* After processing each event:

  * Let `currMax` = current highest building.
  * If `currMax != prevMax`, the skyline has changed → record key point `[x, currMax]`.
  * Update `prevMax`.

This ensures only **critical height changes** are added.

---

# Edge Cases Handled by Algorithm

1. **Overlapping buildings of different heights** → tallest dominates, skyline drops when it ends.
2. **Adjacent buildings with same height** → consecutive flat segments are merged (no duplicate heights).
3. **Nested buildings (shorter inside taller)** → shorter ones are ignored since taller covers them.
4. **Touching buildings with different heights** → correct transition captured at the shared boundary.
5. **Multiple buildings starting/ending at same x** → sorting rules ensure taller starts are processed first, shorter ends last.
6. **Disjoint buildings** → skyline correctly drops to ground (`height=0`) before rising again.
---

## Time Complexity

* Event generation: **O(n)**
* Sorting events: **O(n log n)**
* Processing events with heap/TreeMap: **O(n log n)**
  ➡️ **Overall: O(n log n)**
