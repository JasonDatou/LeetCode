package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.TreeNode;

public class FlattenBinaryTreetoLinkedList {
  public static void main(String[] args) {
    FlattenBinaryTreetoLinkedListSolution s = new FlattenBinaryTreetoLinkedListSolution();
    TreeNode root = new TreeNode("1,2,5,3,4,null,6");
//    TreeNode root = new TreeNode("1");
    s.flatten(root);
    System.out.println(root);
  }
}

class FlattenBinaryTreetoLinkedListSolution {
  public void flatten(TreeNode root) {
    while (root != null) {
      //左子树为 null，直接考虑下一个节点
      if (root.left == null) {
        root = root.right;
      } else {
        // 找左子树最右边的节点
        TreeNode pre = root.left;
        while (pre.right != null) {
          pre = pre.right;
        }
        //将原来的右子树接到左子树的最右边节点
        pre.right = root.right;
        // 将左子树插入到右子树的地方
        root.right = root.left;
        root.left = null;
        // 考虑下一个节点
        root = root.right;
      }
    }
  }
}