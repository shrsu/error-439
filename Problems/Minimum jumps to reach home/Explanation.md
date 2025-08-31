## Approach

We need the **shortest path** → this hints at **BFS (Breadth-First Search)**.

1. **Forbidden Set**
    
    Store forbidden positions in a `Set` for O(1) lookup.
    
2. **Visited State**
    
    Since "no two consecutive backward jumps" is a rule, we need to track not just the **position**, but also whether the **last move was backward**.
    
    - `visited[pos][0]` → visited when last move was forward.
    - `visited[pos][1]` → visited when last move was backward.
3. **BFS Queue**
    
    Each state: `{pos, backFlag}`
    
    - `backFlag = 0` → last move was forward.
    - `backFlag = 1` → last move was backward.
4. **Transitions**
    - **Forward Jump**: always allowed (if not forbidden, within bounds, not visited).
    - **Backward Jump**: only allowed if last move was **not backward**.
5. **Upper Bound**
    
    To prevent infinite BFS expansion, we set a safe limit → `6000`.
    
    (Reason: `x` and `forbidden` are ≤ 2000, and we might overshoot a bit with forward jumps.)
    
6. **BFS Levels** = Number of steps.