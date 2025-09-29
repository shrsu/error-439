## Steps to Implement

### 1. Define a Node structure

Each node represents either:

- A **leaf node** (character + frequency), or
- An **internal node** (sum of two child frequencies).

Fields usually include:

- `char ch` (character, only for leaf nodes)
- `int freq` (frequency of the node)
- `Node left, right` (children of the node)

---

### 2. Build a Priority Queue (Min-Heap)

- Insert all characters and their frequencies as nodes.
- Use a **PriorityQueue** in Java, ordered by frequency.

---

### 3. Construct the Huffman Tree

- While more than one node remains in the queue:
    - Remove the two nodes with the lowest frequencies.
    - Create a new node with frequency = sum of the two.
    - Assign the two nodes as children (left, right).
    - Insert the new node back into the queue.
- The last remaining node is the root of the Huffman Tree.

---

### 4. Generate Huffman Codes

- Traverse the tree:
    - Add `0` when moving left, `1` when moving right.
    - When a leaf node is reached, the path so far is the code for that character.

---

### 5. Encode and Decode

- Encoding: Replace each character in the string with its Huffman code.
- Decoding: Traverse the tree according to bits until reaching a leaf.


---

# How the Code Works Step by Step

1. **Count Frequencies**: For `"huffman coding example"`, it creates a map like `{a=2, f=2, m=2, ...}`.
2. **Build Tree**: Lowest frequency characters are merged first into internal nodes.
3. **Generate Codes**: Traverse from root, appending `0` (left) and `1` (right).
4. **Encoding**: Replace each character in the string with its Huffman code.
5. **Decoding**: Read bits, traverse tree until a leaf is reached, then output that character.

---