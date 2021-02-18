public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(4);
//    root.left.right = new TreeNode(5);
//
//    root.right.left = new TreeNode(6);



    public static int countCompleteNodes(TreeNode root){
          if(root == null){
              return 0;
          }

          TreeNode left = root;
          int leftLevel = 1;

          while (left.left != null ){
              left = left.left;
              leftLevel += 1;
          }

        TreeNode right = root;
        int rightLevel = 1;

        while (right.right != null ){
            right = right.right;
            rightLevel += 1;
        }

          if(leftLevel == rightLevel){
              return (int) (Math.pow(2, leftLevel)-1);
          } else {
              return 1 + countCompleteNodes(root.left) + countCompleteNodes(root.right);
          }

      }
}
