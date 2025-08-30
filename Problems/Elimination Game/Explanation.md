# Key Idea of Solution

Instead of simulating the entire process (which would be too slow for large `n`), we track **only the head (first remaining element)** because everything else can be deduced from it.

1. **head** = the first number remaining in the current sequence.
    
    (Initially, head = 1 since the sequence starts at 1).
    
2. **step** = distance (gap) between consecutive numbers that remain after each round.
    
    (Initially, step = 1, because numbers are consecutive: 1, 2, 3...).
    
3. **n** = how many numbers are still in the sequence.
    
    After each elimination, `n` halves: `n /= 2`.
    
4. **left** = boolean to track direction of elimination (left → right or right → left).
    
    (Starts as `true` since the first elimination is from left to right).
    

---

# Step-by-Step Explanation

- **Round 1 (left to right)**:
    - The first number (head) will **always be eliminated or shifted**, so we must move head forward by `step`.
    - Example: `1 2 3 4 5 6` → eliminate evens → `1` moves to `3`.
- **Round 2 (right to left)**:
    - If `n` (current length) is **odd**, the head also changes.
    - If `n` is **even**, the head stays the same.
- **Step doubling**:
    - After each elimination round, the distance between numbers doubles, so `step *= 2`.
- **Alternate direction**:
    - After each round, flip `left`.

---