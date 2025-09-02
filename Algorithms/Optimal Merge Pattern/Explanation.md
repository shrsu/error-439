# Optimal Merge Pattern (OMP)

## Background (what/why)

* **Problem**: You’re given `n` already-sorted lists with known sizes `s1, s2, …, sn`.
  Merge them (two at a time) into one sorted list with **minimum total cost**.
* **Cost model**: Merging two lists of sizes `x` and `y` costs `x + y` (you touch every element once).
* **Key insight**: Different merge **patterns** yield different total costs.
  The **optimal** pattern is to **always merge the two smallest lists first** (greedy).
* **Why it works**: This is the same optimal substructure/greedy-choice property behind **Huffman coding**: putting big costs late makes them counted fewer times.
* **Data structure**: Use a **min-heap / priority queue** to repeatedly pick the two smallest sizes.
* **Complexity**: Building heap `O(n)`, then `n-1` merges each doing two pops + one push → **O(n log n)** time, **O(n)** space.
* **Outputs you might want**:

  * **Minimum total cost**.
  * (Optional) The **merge sequence** to show the pattern/tree.

## Greedy steps (numbered)

1. Put all list sizes into a **min-heap**.
2. While the heap has more than one item:

   * Pop the **two smallest** sizes `a` and `b`.
   * Merge cost = `a + b`; add to `totalCost`.
   * Push `a + b` back (that’s the new merged list size).
   * (Optional) Record the pair `(a, b)` for the pattern.
3. When one item remains, you’re done. `totalCost` is the **optimal** cost.

---
