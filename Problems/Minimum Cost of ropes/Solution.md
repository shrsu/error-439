## Intuition

- Every time we connect two ropes, the cost is their **sum**.
- That new rope length will again be added to the pool.
- If we connect large ropes early, their cost will repeatedly get added in future operations → **higher total cost**.
- Therefore, the best strategy is always to connect the **two smallest ropes first**.

This is a **greedy approach**.

---

## Steps

1. Put all rope lengths into a **min-heap** (PriorityQueue in Java).
2. While more than one rope remains in the heap:
    - Extract the two smallest lengths.
    - Add their sum to the total cost.
    - Insert the new combined rope back into the heap.
3. The accumulated cost is the **minimum total cost**.

---

## Dry Run (Example 1: [4, 3, 2, 6])

- Heap = [2, 3, 4, 6]
- Pick 2 + 3 = 5 → cost = 5, heap = [4, 5, 6]
- Pick 4 + 5 = 9 → cost = 5 + 9 = 14, heap = [6, 9]
- Pick 6 + 9 = 15 → cost = 14 + 15 = 29, heap = [15]
- Final Answer = **29**

---

## Complexity Analysis

- Building heap: **O(N log N)**
- Each combine step: remove 2 and insert 1 → **O(log N)**
- Number of steps: N - 1
- **Overall: O(N log N)**

---