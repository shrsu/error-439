import java.util.*;

// Node class for Huffman tree
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '-'; // Internal node
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

// Comparator for PriorityQueue (min-heap)
class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class HuffmanCodingAlgorithm {

    // Build Huffman Tree
    public static Node buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        // Step 1: Create leaf nodes for all characters
        for (var entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Step 2: Build the tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.freq + right.freq, left, right);
            pq.add(parent);
        }

        return pq.poll(); // Root
    }

    // Generate Huffman codes
    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCode) {
        if (root == null) return;

        // Leaf node
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, code);
            return;
        }

        generateCodes(root.left, code + "0", huffmanCode);
        generateCodes(root.right, code + "1", huffmanCode);
    }

    // Decode encoded string using Huffman Tree
    public static String decode(String encoded, Node root) {
        StringBuilder result = new StringBuilder();
        Node current = root;
        for (char bit : encoded.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;

            // Reached leaf
            if (current.left == null && current.right == null) {
                result.append(current.ch);
                current = root;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "huffman coding example";

        // Step 1: Count frequency of characters
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build Huffman Tree
        Node root = buildHuffmanTree(freqMap);

        // Step 3: Generate codes
        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);

        // Step 4: Print codes
        System.out.println("Huffman Codes:");
        for (var entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Step 5: Encode text
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(huffmanCode.get(c));
        }
        System.out.println("\nEncoded text: " + encoded);

        // Decoding (optional)
        String decoded = decode(encoded.toString(), root);
        System.out.println("\nDecoded text: " + decoded);
    }

}
