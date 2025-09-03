## Problem Statement

We are given an `n x n` maze represented as a **2D grid** where:

- `1` represents an **open cell** through which the rat can move.
- `0` represents a **blocked cell** that the rat cannot enter.

The rat starts from the **top-left corner** `(0,0)` and has to reach the **bottom-right corner** `(n-1,n-1)`.

The rat can move in **four directions**:

- **Right (East)** → `(i, j+1)`
- **Down (South)** → `(i+1, j)`
- **Left (West)** → `(i, j-1)`
- **Up (North)** → `(i-1, j)`

The task is to **find all possible paths** from start to destination using **backtracking**.
