import java.io.*;
import java.util.*;

public class question2pt2 {
    public static void main(String[] args) {
        String s1 ="GCTACTCTCCTCATAAGCAGTCCGGTGTAT";
        String s2 = " CGAAAGAACAAGACTAGCCTTGCTAGCAACCGCGG";
        int m = s1.length();
        int n = s2.length();
        int[][] lcs = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j<= n; j++){
                if(i== 0 || j == 0)
                lcs[i][j]= 0;
                else if (s1.charAt(i-1)== s2.charAt(j-1))
                lcs[i][j]=lcs[i-1][j-1]+1;
                else
                lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }

        int len = lcs[m][n];
        char[] lcsArr = new char[len];
        int i = m, j = n;
        while(i>0 && j >0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                lcsArr[--len] = s1.charAt(i-1);
                i--;
                j--;
            } else if(lcs[i-1][j]>lcs[i][j-1])
                i--;
                else
                j--;
        }

        System.out.println("LCS of "+s1+" and "+s2+" is "+new String(lcsArr)+"");
       
    }
    
}
