import java.io.*;
import java.util.*;

/**
* 문제 해결
*
* 1. 이진 트리 만들기
* 2. 전위 순회
* 3. 후위 순회
*/

class Solution {
    int[][] result;
    int idx = 0;
    
    static class Node {
        int value;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int value, int x, int y, Node left, Node right) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        result = new int[2][nodeinfo.length];
        
        // 1. 노드를 저장할 배열 생성
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }
        
        // 2. 이진 트리를 만들기 위해 노드 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            return o1.y == o2.y ? o1.x - o2.x : o2.y - o1.y;
        });
        
        // 3. 이진 트리 만들기
        Node root = nodes[0];
        for(int i = 1; i < nodes.length; i++) {
            makeTree(root, nodes[i]);
        }
        
        // 4. 전위 순회
        preOrder(root);
        
        // 5. 후위 순회
        idx = 0;
        postOrder(root);
        
        return result;
    }
    
    public void makeTree(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left != null) makeTree(parent.left, child);
            else {
                parent.left = child;
            }
        } else {
            if(parent.right != null) makeTree(parent.right, child);
            else {
                parent.right = child;
            }
        }
    }
    
    public void preOrder(Node root) {
        if(root != null) {
            result[0][idx++] = root.value;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            result[1][idx++] = root.value;
        }
    }
}