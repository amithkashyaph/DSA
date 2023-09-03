package problems.trees;

import java.util.*;

public class Tree {

    public static Map<Integer, List<Node>> verticalLevel = new HashMap<>();

    public static List<Integer> path = new ArrayList<>();
    public static List<Node> nodePath = new ArrayList<>();
    public Node root;
    private int diameter = 0;

    class Node {
         int data;
         Node right;
         Node left;

         Node(int data, Node right, Node left) {
             this.data = data;
             this.right = right;
             this.left = left;

         }
         Node(int data) {
             this.data = data;
         }
     }

     class Info {
         public boolean isBalanced;
         public int height;

         public boolean isBST;
         public int min;
         public int max;
         public int ans;
         public int size;

         public Info(boolean isBST, int min, int max, int ans, int size) {
             this.isBST = isBST;
             this.min = min;
             this.max = max;
             this.ans = ans;
             this.size = size;
         }

         Info(boolean isBalanced, int height) {
             this.height = height;
             this.isBalanced = isBalanced;
         }
     }
     Tree(int data) {
         Node node = new Node(data, null, null);
         this.root = node;
     }
    Tree() {
        this.root = null;
    }

     public void insert(int data) {
         Node node = new Node(data, null, null);
         Node curr = this.root;
         Node prev = curr;
         while(curr != null) {
             prev = curr;
             if(data > curr.data ) {
                 curr = curr.right;
             } else {
                 curr = curr.left;
             }
         }
         if(data > prev.data) {
             prev.right = node;
         } else {
             prev.left = node;
         }
     }

     public void preOrderTraversal(Node root) {
         if(root == null) {
             return;
         }
         System.out.print(root.data + "  ");
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
     }

    public void inOrderTraversal(Node root) {
         if(root == null) {
             return;
         }
        inOrderTraversal(root.left);
        System.out.print(root.data + "  ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + "  ");
    }

    public void verticalTraversal(Node root, int distance) {
         if(root == null) {
             return;
         }
         if(!verticalLevel.containsKey(distance)) {
             verticalLevel.put(distance, new ArrayList<>());
         }
         verticalLevel.get(distance).add(root);
         verticalTraversal(root.left, distance - 1);
         verticalTraversal(root.right, distance + 1);
    }

    public void printVerticalOrderTraveral() {
         for(Map.Entry<Integer, List<Node>> m : verticalLevel.entrySet()) {
             System.out.print(m.getKey()  + "  --->   ");
             for(Node n : m.getValue()) {
                 System.out.print(n.data + "  ");
             }
             System.out.println();
         }
    }

    public void printTopView() {
        for(Map.Entry<Integer, List<Node>> m : verticalLevel.entrySet()) {
            System.out.print(m.getKey()  + "  --->   ");
            for(Node n : m.getValue()) {
                System.out.print(n.data + "  ");
                break;
            }
            System.out.println();
        }
    }

    public void levelOrderTraversal() {
        Queue<Object> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            if(queue.peek() == null) {
                queue.poll();
                queue.add(null);
                System.out.println();
            } else {
                Node node = (Node) queue.poll();
                System.out.print(node.data + "   ");
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void levelOrderTraversal2() {
         List<List<Integer>> levelElements = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        queue.add(this.root);
        queue.add(null);

        List<Integer> tempLevelElements = new ArrayList<>();
        while(!queue.isEmpty() && queue.size() > 1) {
            Node n = queue.remove(0);
            if(n == null) {
                levelElements.add(tempLevelElements);
                tempLevelElements = new ArrayList<>();
                queue.add(null);
            } else {
                tempLevelElements.add(n.data);
                if(n.left != null) {
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }
                if(queue.size() == 1) {
                    levelElements.add(tempLevelElements);
                }
            }
        }
        for(List<Integer> i : levelElements) {
            System.out.println(i);
        }
    }

    public Info isTreeBalanced(Node root) {
         if(root == null) {
             return new Info(true, 0);
         }
         Info leftInfo= isTreeBalanced(root.left);
         Info rightInfo = isTreeBalanced(root.right);

         if(leftInfo.isBalanced && rightInfo.isBalanced && (Math.abs(leftInfo.height - rightInfo.height) <= 1)) {
             return new Info(true, Math.max(leftInfo.height, rightInfo.height) + 1);
         }
         return new Info(false, 0);

    }

    public Info maxBSTinBT(Node root) {
         if(root.right == null && root.left == null) {
             return new Info(true, root.data, root.data, 1, 1);
         }
         Info leftBSTinBT = maxBSTinBT(root.left);
         Info rightBSTinBT = maxBSTinBT(root.right);

        int max = Math.max(leftBSTinBT.max, rightBSTinBT.max);
        max = Math.max(max, root.data);
        int min = Math.min(leftBSTinBT.min, rightBSTinBT.min);
        min = Math.min(min, root.data);
        int size = leftBSTinBT.size + rightBSTinBT.size + 1;


        if(leftBSTinBT.isBST && rightBSTinBT.isBST && (root.data >= leftBSTinBT.max && root.data <= rightBSTinBT.min)) {
             int ans =  size;
             return new Info(true, min, max, ans, size);
         }
         return new Info(false, min, max, Math.max(leftBSTinBT.ans, rightBSTinBT.ans), size);
    }
    public int heightOfBST(Node root) {
         if(root == null) {
             return -1;
         }
         int leftHeightBST = heightOfBST(root.left);
         int rightHeightBST = heightOfBST(root.right);

         return Math.max(leftHeightBST, rightHeightBST) + 1;
    }

    public Node constructTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {
         if(inOrderEnd < inOrderStart) {
             return null;
         }
         Node temp = new Node(preOrder[preOrderStart]);
        if (inOrderStart == inOrderEnd)
            return temp;
         int index = -1;
         for(int i = inOrderStart; i <= inOrderEnd; i++) {
             if(inOrder[i] == preOrder[preOrderStart]) {
                 index = i;
                 break;
             }
         }
         temp.left = constructTree(preOrder, preOrderStart + 1, preOrderStart + index, inOrder, inOrderStart, index - 1);
         temp.right = constructTree(preOrder, preOrderStart + index + 1, preOrderEnd, inOrder, index  + 1, inOrderEnd);

         return temp;
    }

    public boolean isValidBST(Node root, int min, int max) {
         if(root == null) {
             return true;
         }
         if(root.data >= min && root.data <= max) {
             boolean isLeftValid = isValidBST(root.left, min, root.data - 1);
             boolean isRightValid = isValidBST(root.right, root.data + 1, max);
             return isLeftValid && isRightValid;
         }

         return false;
    }

    public boolean hasPath(Node root, int k) {
         if(root == null) {
             return false;
         }
         path.add(root.data);
        nodePath.add(root);


        if(root.data == k) {
             return true;
         }
         if(hasPath(root.left, k) || hasPath(root.right, k)) {

             return true;
         }
         path.remove(path.size()  - 1);
        nodePath.remove(nodePath.size() - 1);
         return false;
    }

    public int nodesAtLevelK(Node root, int k) {
        if(root == null) {
            return 0;
        }
        if(k == 0) {
            return 1;
        }
        int leftNodes = nodesAtLevelK(root.left, k - 1);
        int rightNodes = nodesAtLevelK(root.right, k - 1);

        return leftNodes + rightNodes;
//        return nodesAtLevelK(root.left, k - 1) + nodesAtLevelK(root.right, k - 1);

    }

    public int nodesAtDistanceK(Node root, int k, int distance) {
         boolean path = hasPath(root, k);
         int ans = 0;
         if(!path) {
             return 0;
         }
         ans = nodesAtLevelK(nodePath.get(nodePath.size() - 1), distance);
         distance -= 1;
         for(int i = nodePath.size() - 2; i >= 0; i--) {
             if(distance == 0) {
                 ans++;
                 break;
             }
             if(nodePath.get(i).right == nodePath.get(i + 1)) {
                 ans += nodesAtLevelK(nodePath.get(i).left, distance - 1);
             } else {
                 ans += nodesAtLevelK(nodePath.get(i).right, distance - 1);
             }
             distance -= 1;
         }
         return ans;
    }

    public int maxDistanceBetweenTwoNodesThroughRoot(Node root) {
         if(root == null) {
             return -1;
         }
         int leftMaxDistance = heightOfBST(root.left);
         int rightMaxDistance = heightOfBST(root.right);

         return leftMaxDistance + rightMaxDistance + 2;
    }

    public int diameterOfBST(Node root) {
        if(root == null) {
            return -1;
        }
        int leftHeight = diameterOfBST(root.left);
        int rightHeight = diameterOfBST(root.right);
        this.diameter = Math.max(this.diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

         Tree tree = new Tree(50);
         tree.insert(40);
         tree.insert(45);
         tree.insert(30);
         tree.insert(60);
         tree.insert(55);
         tree.insert(65);
         tree.insert(70);
         tree.insert(80);
        tree.insert(54);
        tree.insert(56);
        tree.insert(53);
        tree.insert(52);
        tree.insert(51);

        System.out.println(tree.isValidBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println();

//        System.out.println(tree.hasPath(tree.root, 80));
//        System.out.println();
//        System.out.println();
//        for(Integer i : path) {
//            System.out.print(i + " --> ");
//        }


//        System.out.println();
//        System.out.println(tree.nodesAtLevelK(tree.root, 0));

//        System.out.println();
//        System.out.println(tree.nodesAtDistanceK(tree.root, 65, 2));
//
//        System.out.println();
//        System.out.println(tree.maxDistanceBetweenTwoNodesThroughRoot(tree.root));

        System.out.println();
        System.out.println(tree.diameterOfBST(tree.root));
        System.out.println(tree.diameter);


////
////         tree.inOrderTraversal(tree.root);
////         System.out.println();
////         tree.preOrderTraversal(tree.root);
////         System.out.println();
////         tree.postOrderTraversal(tree.root);
////
////        System.out.println();
////         tree.verticalTraversal(tree.root, 0);
////         tree.printVerticalOrderTraveral();
////
////        System.out.println();
////        System.out.println();
////        System.out.println();
////         tree.printTopView();
////
////        System.out.println();
////        System.out.println();
////        System.out.println();
//        tree.levelOrderTraversal2();
////
////        System.out.println();
////        System.out.println();
////        System.out.println();
////        Info i = tree.isTreeBalanced(tree.root);
////        System.out.println(i.isBalanced);
////        System.out.println(i.height);

//        Tree tree = new Tree();
//
//        int[] preOrder = {8, 6, 5, 15, 19, 9, 18, 25, 4, 7, 41, 30, 39, 48};
//        int[] inOrder =  {15, 5, 19, 6, 18, 9, 25, 8, 7, 41, 4, 39, 30, 48};
//
//        tree.root = tree.constructTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
//
//        tree.levelOrderTraversal();
    }


}
