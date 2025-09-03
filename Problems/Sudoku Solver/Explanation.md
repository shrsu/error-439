## Backtracking Strategy for Sudoku

1. Start from `(row=1, col=1)`.
2. If cell is **pre-filled (≠0)** → move to next cell.
3. If cell is **empty (0)** → try all values `1–9`.
    - Check validity (row, column, block).
    - If valid → place number and recurse to next cell.
    - If invalid → try next number.
    - If none works → backtrack to previous cell and change it.
4. Stop when we pass `(row=9, col=9)` successfully.

---

## Base Case (Termination Condition)

- When recursion moves **beyond the grid** (`row=10, col=1`), it means all cells are filled.
- At that point → **print the completed Sudoku**.

---

## Algorithm (Recursive)

```
Algorithm SudokuSolver(S, row, col):

1. If row == 10 and col == 1:
       Print grid S  (solution found)
       return

2. If S[row][col] ≠ 0:
       Move to next cell:
          if col == 9 → SudokuSolver(S, row+1, 1)
          else        → SudokuSolver(S, row, col+1)

3. Else (cell is empty, i.e. S[row][col] == 0):
       For value = 1 to 9:
           If IsValid(S, row, col, value):
                S[row][col] = value
                Move to next cell (same logic as step 2)
                Reset cell (S[row][col] = 0) ← backtrack

End Algorithm

```

---

## Validity Check Function (Bounding Function)

```
Algorithm IsValid(S, row, col, value):

1. Check entire row:
      For j = 1 to 9:
          If S[row][j] == value → return false

2. Check entire column:
      For i = 1 to 9:
          If S[i][col] == value → return false

3. Check 3×3 block:
      blockRow = row - ((row-1) mod 3)
      blockCol = col - ((col-1) mod 3)
      For i = 0 to 2:
          For j = 0 to 2:
              If S[blockRow+i][blockCol+j] == value → return false

4. If all checks pass → return true

```

## Complexity Discussion

- Maximum possibilities: `9^(81)` (huge).
- But pruning with **validity checks** reduces the search drastically.
- Backtracking ensures we don’t explore impossible paths too long.

---