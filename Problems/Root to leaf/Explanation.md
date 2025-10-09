### **Explanation**

1. **DFS Traversal**:
   We recursively traverse the tree starting from the root.

2. **Path Tracking**:
   Maintain a `path` list that stores the nodes along the current path.

3. **Leaf Node Check**:
   When a node is a leaf (`left` and `right` are null), we **add a copy of the path** to the answer.

4. **Backtracking**:
   After visiting a node, remove it from `path` to allow exploring other paths.
