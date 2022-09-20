package inter;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * column -> column number
 *   A  ->  1
 *   B  ->  2
 *   C  ->  3
 *   ...
 *   Z  ->  26
 *   AA ->  (Diff*26^2+Diff*26^1+Diff*26^0) ->27
 *   AB ->  (26+2) ->28
 *
 *   AZ ->  (26+26) -> 52
 *
 *   BA ->   (2*26)+ 1  -> 53
 *
 *   CA ->   (3*26)+1
 *   ...
 *   ZZ ->  (26*26) +26 -> 702
 *
 *   AAA ->(26*1) +(26*26) +26
 *   CDA -> ?
 *
 *   A-Z = 1-26
 *   A = 26
 *   B =
 */

public class DemoExcel {
    public int calcColumn(String str){
        String[] arr =  str.split("");
        int sum =0;
        int cnt =0;
        for (String str1 : arr){
            double diff = (str1.charAt(0) - 'A')+1;
            sum += diff*Math.pow(26,cnt);
            cnt++;
        }
        return sum;
    }
    public static void main(String[] args) {
        DemoExcel excel = new DemoExcel();
        System.out.println(excel.calcColumn("BA"));
    }
}
