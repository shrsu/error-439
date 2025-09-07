# Matrix Chain Multiplication

## Problem Type

- **Optimization Problem**
- **Minimization Problem** → Minimize the total number of scalar multiplications when multiplying a chain of matrices.

---

## Why is it Needed?

- Multiplying matrices isn’t just a simple step – it requires **multiple scalar multiplications**.
- The **order of multiplication** (parenthesization) affects the total cost.
- Although matrix multiplication is **associative** (result is same), the **cost differs**.

---

## Key Matrix Multiplication Facts

1. Two matrices **A (p × q)** and **B (q × r)** can be multiplied if:
    - Columns of **A** = Rows of **B**.
2. Resultant matrix dimension: **(p × r)**.
3. Cost (# of scalar multiplications): **p × q × r**.

---

## Example (Two Matrices)

- **A (2 × 3)** × **B (3 × 2)** → Result: (2 × 2).
- Multiplications = 2 × 3 × 2 = **12**.

---

## Example (Three Matrices)

Matrices:

- A (3 × 2), B (2 × 4), C (4 × 2).

Two ways:

1. **(A × B) × C**
    - Cost(A×B) = 3 × 2 × 4 = 24
    - Cost(Result × C) = 3 × 4 × 2 = 24
    - **Total = 48**
2. **A × (B × C)**
    - Cost(B×C) = 2 × 4 × 2 = 16
    - Cost(A × Result) = 3 × 2 × 2 = 12
    - **Total = 28** (Better choice)

---

## General Problem Statement

- Given a **chain of n matrices**: A₁ × A₂ × … × Aₙ.
- Find the **optimal way to parenthesize** the product such that the total scalar multiplications are **minimized**.
- Don’t actually multiply → Fust find **order** of multiplication.

---

## Growth of Possibilities

- Number of ways to parenthesize grows rapidly.
- For **n matrices**, possible parenthesizations = **Catalan number**.
    - n=3 → 2 ways
    - n=4 → 5 ways
    - n=5 → 14 ways
    - n=10 → 16796 ways

---

## Why Dynamic Programming?

- Brute force → Exponential time (too many ways).
- DP helps by:
    - Breaking into subproblems.
    - Storing overlapping results (memoization).
    - Using bottom-up tabulation for efficiency.