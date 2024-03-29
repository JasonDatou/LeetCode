package ssicf.leetcode2022;

public class WildcardMatching {
  public static void main(String[] args) {
    WildcardMatchingSolution s = new WildcardMatchingSolution();
    boolean result = s.isMatch("aab", "c*");
    System.out.println(result);
  }
}

class WildcardMatchingSolution {
  public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] f = new boolean[m + 1][n + 1];

    f[0][0] = true;
    for(int i = 1; i <= n; i++){
      f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
    }

    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
          f[i][j] = f[i - 1][j - 1];
        }
        if(p.charAt(j - 1) == '*'){
          f[i][j] = f[i][j - 1] || f[i - 1][j];
        }
      }
    }
    return f[m][n];
  }
}
