package com.gmcc.autotest.util;
/**
 * @author Wayne.Song
 * @version 0.0.1.Alpha
 */
public class Compare {
    private String a;
    private String b;
    private String c;
    private String resultSource;
    private String resultTarget;
    private String process1(){
        int[][] lengths = new int[this.a.length()+1][this.b.length()+1];
        for (int i = 0; i < this.a.length(); i++)
            for (int j = 0; j < this.b.length(); j++)
                if (this.a.charAt(i) == this.b.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                    lengths[i+1][j+1] =
                            Math.max(lengths[i+1][j], lengths[i][j+1]);
        StringBuffer sb = new StringBuffer();
        for (int x = this.a.length(), y = this.b.length();
             x != 0 && y != 0; ) {
            if (lengths[x][y] == lengths[x-1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y-1])
                y--;
            else {
                assert this.a.charAt(x-1) == this.b.charAt(y-1);
                sb.append(this.a.charAt(x-1));
                x--;
                y--;
            }
        }
        return sb.reverse().toString();
    }
    private String process2(String buffer){
        StringBuffer sb = new StringBuffer();
        sb.append("<style>.sMark{color:orange;}</style>");
        int flag = 0, i, j;
        if(buffer.charAt(0) == this.c.charAt(0)){
            sb.append(buffer.charAt(0));
            i = 1; j = 1;
        }else {
            sb.append("<a class=sMark>").append(buffer.charAt(0));
            flag = 1;
            i = 1; j = 0;
        }
        for(; i < buffer.length();){
            if(buffer.charAt(i) == this.c.charAt(j)){
                if(flag == 0){
                    sb.append(buffer.charAt(i));
                }else {
                    sb.append("</a>").append(buffer.charAt(i));
                }
                flag = 0;
                i++; j++;
            }else {
                if(flag == 0){
                    sb.append("<a class=sMark>").append(buffer.charAt(i));
                }else {
                    sb.append(buffer.charAt(i));
                }
                flag = 1;
                i++;
            }
        }
        return sb.toString();
    }
    public Compare(String source, String target){
        this.a = source;
        this.b = target;
        this.c = process1();
        this.resultSource = process2(this.a);
        this.resultTarget = process2(this.b);
    }
    public String getResultSource(){
        return this.resultSource;
    }
    public String getResultTarget(){
        return this.resultTarget;
    }
}
