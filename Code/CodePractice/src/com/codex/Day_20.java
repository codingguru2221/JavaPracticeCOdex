package com.codex;

// TreeNode class
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int value) {
        data = value;
        left = right = null;
    }
}

// Binary Search Tree class
class BinarySearchTree {
    TreeNode root;

    // Insert a node
    TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            // duplicate values not allowed in BST
            System.out.println("Duplicate value " + data + " ignored.");
        }
        return root;
    }

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search an element in BST
    boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return key < root.data ? search(root.left, key) : search(root.right, key);
    }

    // Find minimum node
    int findMin(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Find maximum node
    int findMax(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // Delete a node from BST
    TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children:
            // Get the inorder successor (smallest in the right subtree)
            root.data = findMin(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }
        return root;
    }
}

// Main class
public class Day_20 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into BST
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.root = bst.insert(bst.root, val);
        }

        System.out.println("=== Tree Traversals ===");
        System.out.print("Inorder   : ");
        bst.inorder(bst.root);
        System.out.print("\nPreorder  : ");
        bst.preorder(bst.root);
        System.out.print("\nPostorder : ");
        bst.postorder(bst.root);

        // Searching
        System.out.println("\n\n=== Searching ===");
        int key1 = 40, key2 = 90;
        System.out.println("Search " + key1 + ": " + bst.search(bst.root, key1));
        System.out.println("Search " + key2 + ": " + bst.search(bst.root, key2));

        // Min & Max
        System.out.println("\n=== Min & Max ===");
        System.out.println("Minimum: " + bst.findMin(bst.root));
        System.out.println("Maximum: " + bst.findMax(bst.root));

        // Deletion
        System.out.println("\n=== Deletion ===");
        System.out.println("Deleting 20...");
        bst.root = bst.delete(bst.root, 20);
        bst.inorder(bst.root);

        System.out.println("\nDeleting 30...");
        bst.root = bst.delete(bst.root, 30);
        bst.inorder(bst.root);

        System.out.println("\nDeleting 50 (root)...");
        bst.root = bst.delete(bst.root, 50);
        bst.inorder(bst.root);
    }
}
