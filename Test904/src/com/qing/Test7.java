package com.qing;

public class Test7 {

    public class Solution {
        public String replaceSpace(StringBuffer str) {
            String s = str.toString();
            char[] ch = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(ch[i]);
                }
            }
            return sb.toString();
        }

    }
}
