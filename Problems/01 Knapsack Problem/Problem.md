# Problem Statement: 0/1 Knapsack Problem

You are given **n objects**. Each object has:

* a **profit** (value) `p[i]`
* a **weight** `w[i]`

You also have a **knapsack (bag)** with a maximum weight capacity `W`.

The task is to **select a subset of these objects** to put into the knapsack such that:

* The **total profit** is **maximized**.
* The **total weight** of selected objects does not exceed the knapsack’s capacity `W`.
* Each object can either be:

  * **included fully** in the knapsack (`x[i] = 1`), or
  * **not included at all** (`x[i] = 0`).
* **Objects cannot be divided** into fractions (unlike in the fractional knapsack problem).

Formally:

* **Objective Function:**
  Maximize

  $$
  \text{Profit} = \sum_{i=1}^{n} p[i] \cdot x[i]
  $$

* **Constraint:**

  $$
  \sum_{i=1}^{n} w[i] \cdot x[i] \leq W
  $$

* **Decision Variable:**

  $$
  x[i] \in \{0, 1\}, \quad \forall i = 1, 2, …, n
  $$

---

In simple words: *Choose items such that the total weight is within the bag’s capacity, and the total profit is as large as possible. You cannot break items into pieces—you either take the whole item or leave it.*

---
