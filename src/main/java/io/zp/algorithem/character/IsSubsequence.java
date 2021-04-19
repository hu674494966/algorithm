package io.zp.algorithem.character;

/**
 * 判断是否为子序列
 * 本题解题关键是需要掌握这个indexof()函数
 */
public class IsSubsequence {
    public static  boolean isSubsequence(String s, String t){
        int index = -1;
        for (char c : s.toCharArray()) {
            //indexOf(char c,int m)意思是从第m位置开始寻找该索引(位置)，找到则返回该索引，否则返回-1
            index = t.indexOf(c, index + 1);
            if (index == -1){
                return false;
            }
        }

        
        return true;
                
    }

    public static void main(String[] args) {
        String  s = "abd", t = "ahbgdc";
        boolean result = isSubsequence(s,t);
        System.out.println("是否为子序列：" + result);
    }
}
