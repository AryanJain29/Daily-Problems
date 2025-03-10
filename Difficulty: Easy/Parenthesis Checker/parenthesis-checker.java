//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        //Defining a stack to store the elements of string x
        Stack<Character> a=new Stack<>();
        for(int i=0;i<x.length();i++){
            char ch=x.charAt(i);
            if(ch=='{' || ch=='[' || ch=='('){
                a.push(ch);
            }else if(ch=='}' || ch==']' || ch==')'){
                //Base condition 
                if(a.isEmpty()){
                    return false;
                }
                char top=a.pop();
                //check if the top element matches the current closing bracket
                if( ((ch==')') && top!='(') || ((ch=='}') && top!='{') || ((ch==']') && top!='[') ) {
                    return false;
                } 
            }
        }
        //stack is empty ie all bracket are matched 
        return a.isEmpty();
    }
}

