

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   int opCount0i=0;
   int opCount0s=0;
   public void insert ( dataType d )
   {
      opCount0i=0;
      opCount0i++;
      if (root == null) {
         //opCount0i++;

         root = new BinaryTreeNode<dataType>(d, null, null);
      }
      else {

         insert(d, root);
      }
   }
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      opCount0i++;
      if (d.compareTo (node.data) <= 0)
      {

         if (node.left == null){

            node.left = new BinaryTreeNode<dataType> (d, null, null); }
         else {
            insert (d, node.left); }
      }
      else
      {
         if (node.right == null){

            node.right = new BinaryTreeNode<dataType> (d, null, null); }
         else{
            insert (d, node.right); }
      }
   }
   
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      opCount0s= 0;
      //opCount0s++;
      if (root == null){
         opCount0s++;
         return null; }
      else{
         return find (d, root); }
   }
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      opCount0s++;
      if (d.compareTo (node.data) == 0){
         //opCount0s++;
         return node; }
      else if (d.compareTo (node.data) < 0) {
         //opCount0s++;
         return (node.left == null) ? null : find (d, node.left); }
      else{
         return (node.right == null) ? null : find (d, node.right);}
   }
   
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null){
         return null; }
      if (d.compareTo (node.data) < 0){
         node.left = delete (d, node.left); }
      else if (d.compareTo (node.data) > 0){
         node.right = delete (d, node.right);}

      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null){
            node = node.left; }
         else{
            node = node.right;}
      return node;
   }
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null){
         return null; }
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }

   public int getOpCount0i() {
      return opCount0i;
   }

   public void setOpCount0i(int opCount0i) {
      this.opCount0i = opCount0i;
   }

   public int getOpCount0s() {
      return opCount0s;
   }

   public void setOpCount0s(int opCount0s) {
      this.opCount0s = opCount0s;
   }
}
