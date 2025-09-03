## What is Sudoku?

- Sudoku is a **9×9 grid-based puzzle**.
- The grid has **81 cells** (9 rows × 9 columns).
- It is divided into **9 smaller 3×3 blocks**.
- Some cells are pre-filled, while the remaining are **empty** (we treat them as `0` in programming).

### Rules of Sudoku

1. Each row must contain numbers **1–9 without repetition**.
2. Each column must contain numbers **1–9 without repetition**.
3. Each 3×3 block must also contain numbers **1–9 without repetition**.

So, for any empty cell, a number can be placed only if:

- It is **not present in the same row**.
- It is **not present in the same column**.
- It is **not present in the same 3×3 block**.

---