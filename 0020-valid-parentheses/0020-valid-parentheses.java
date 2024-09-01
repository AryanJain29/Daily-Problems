
class Solution
{
    //Function to check if brackets are balanced or not.
    public boolean isValid(String x)
    {
        ArrayDeque<Character>s = new ArrayDeque<>();
        
        for(int i=0;i<x.length();i++)
        {
            char ch = x.charAt(i);
            
            if(ch == '{' || ch == '(' || ch == '[')
            s.push(ch);
            
            else
            {
                if(s.size() == 0)
                return false;
                
                else if( (s.peek() == '{' && ch =='}') ||
                (s.peek() == '[' && ch ==']') ||
                (s.peek() == '(' && ch ==')') )
                s.pop();
                
                else
                return false;
            }
        }
        if(s.size() == 0)
        return true;
        
        return false;
    }
}