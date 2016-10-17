package com.test.testdome.tests;
public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]","").toLowerCase();
        StringBuffer strBuf = new StringBuffer(str);
        String reverseStr = strBuf.reverse().toString();
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != reverseStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome1(String str) {
        str = str.replaceAll("[^a-zA-Z]","").toLowerCase();
        int length = str.length();
        for (int i=0; i < length/2; i++) {
            if (str.charAt(i) != str.charAt(length - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel sees Leon."));
        System.out.println(isPalindrome1("Noel sees Leon."));
    }
}