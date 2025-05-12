//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minVal(a, b));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        // code here
        int temp=b;
        int count_b=0;
        while(temp>0)
        {
            if((temp&1)==1)
            count_b++;
            temp=temp>>1;
        }
        HashSet<Integer>set=new HashSet<>();
        int temp1=a;
        int index=0;
        while(temp1>0)
        {
            if((temp1&1)==1)
            set.add(index);
            index++;
            temp1=temp1>>1;
        }
        int res=0;
        
        for(int i=31;i>=0;i--)
        {
            if(set.contains(i) && count_b>0)
            {
                            res+=(int)Math.pow(2,i);
                            count_b--;
            }
        }
        while(count_b>0)
        {
            for(int i=0;i<=31;i++)
           {
            if(!set.contains(i) && count_b>0)
            {
                            res+=(int)Math.pow(2,i);
                            count_b--;
            }
            }
            break;
        }
        return res;
    }
}