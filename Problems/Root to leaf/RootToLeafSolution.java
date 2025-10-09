import java.util.*;

// Definition for Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class RootToLeafSolution {

    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, path, ans);
        return ans;
    }

    private void dfs(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        if (node == null)
            return;

        // Add current node to path
        path.add(node.data);

        // If leaf node, add path to answer
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path)); // Make a copy of current path
        } else {
            // Recurse left and right
            dfs(node.left, path, ans);
            dfs(node.right, path, ans);
        }

        // Backtrack: remove the current node before returning
        path.remove(path.size() - 1);
    }

    public static Node buildTree(ArrayList<Integer> nodes) {
        if (nodes.size() == 0 || nodes.get(0) == -1)
            return null;
        Node root = new Node(nodes.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < nodes.size()) {
            Node curr = q.poll();
            int val = nodes.get(i);
            if (val != -1) {
                curr.left = new Node(val);
                q.add(curr.left);
            }
            i++;
            if (i >= nodes.size())
                break;
            val = nodes.get(i);
            if (val != -1) {
                curr.right = new Node(val);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nodes = new ArrayList<>();
        while (sc.hasNextInt()) {
            nodes.add(sc.nextInt());
        }
        Node root = buildTree(nodes);
        RootToLeafSolution sol = new RootToLeafSolution();
        ArrayList<ArrayList<Integer>> paths = sol.Paths(root);

        for (ArrayList<Integer> path : paths) {
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
