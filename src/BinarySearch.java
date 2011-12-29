import java.io.*;
import java.util.*;

class TreeNode
{
  public TreeNode left;
  public TreeNode right;
 
 //data
  public int key;
 
  TreeNode(int mkey)
 {
  key = mkey;
  left = null;
  right = null;
 }
}

class BinaryST
{
	 public TreeNode root = null;
	 
	 BinaryST(ArrayList<Integer> arrays)
	 {
		 System.out.println("Create Binary Search Tree");
		 
		 //create build search tree
		 System.out.println("root Node key: " + arrays.get(0));

		 root = new TreeNode(arrays.get(0));
		 //create tree node
		 for (int i=1; i<arrays.size(); i++)
		 {
		   System.out.println("=============session " + Integer.toString(i-1) + "=============");
		   int this_key = arrays.get(i);
		   System.out.println("this key: " + this_key);
		   
		   TreeNode p = null;
		   TreeNode nowNode = root;
		   //tree node: root start
		   while(nowNode!=null)
		   {
		    p = nowNode;
		    nowNode = this_key<nowNode.key? nowNode.left:nowNode.right;
		   }
		   
		   //找到最後一點：比較，將結果放置左邊小, 右邊大
		   System.out.println("find near key " + p.key + " and this key " + this_key + " compare");

		   if(this_key<p.key)
		   {
			System.out.println("compare result: small, put this key " + this_key + " left");
		    p.left = new TreeNode(this_key);
		   }
		   else
		   {
				System.out.println("compare result: , put this key " +  this_key + " right" );
		    p.right = new TreeNode(this_key);
		   }
		   System.out.println("=============end=============");
		   System.out.println("");
		  }
	 }
	 
	 public void traverse_binary_tree(TreeNode tnode)
	 {
		  if(tnode==null)  return;
		  //往左邊子樹找
		  traverse_binary_tree(tnode.left);
		  	System.out.print(tnode.key + " ");
		  //往右邊子樹找
		  	traverse_binary_tree(tnode.right);
	 }
	 
	}



public class BinarySearch
{
	  public static void main(String[] alio)throws FileNotFoundException
	  {
		  Scanner input = new Scanner(System.in);
		  ArrayList<Integer> list = new ArrayList<Integer>();
		  int count=1, value = 0;
		  
		  //if value == -1, input end 
		  while (value != -1)
		  {
			  System.out.print("input " + count + " times, data: ");
			  value = input.nextInt();
			  if (value == -1) break;
			  list.add(value);
			  count++;
		  }
		  
		  System.out.println("");

		  BinaryST bst = new BinaryST(list);
		  System.out.println("");
		  
		  //先找左邊在找右邊, 剛好是由小到大的排序
		  System.out.println("result, using traverse_binary_tree:");
		  bst.traverse_binary_tree(bst.root);
		  System.out.println("");
		 }
	 }