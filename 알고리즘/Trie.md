# Trie
#알고리즘/Trie

---


```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9202 {
    static int W, B;
    static char[][] board = new char[4][4];
    static boolean[][] visited = new boolean[4][4];
    static StringBuffer sb = new StringBuffer();
    static int max_val = 0;
    static String max_word = "";
    static int find_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        W = Integer.parseInt(br.readLine());
        //트라이 생성
        Node root = new Node();

        for (int i = 0; i < W; i++) {
            String word = br.readLine();

            root.insert(word);
        }

        br.readLine();

        B = Integer.parseInt(br.readLine());
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < 4; j++) {
                String s = br.readLine();
                for (int k = 0; k < 4; k++) {
                    board[j][k] = s.charAt(k);
                }
            }

            for (int j = 0; j < 4; j++) {
                //DFS
                for (int k = 0; k < 4; k++) {
                    if (root.child[board[j][k] - 'A'] != null )
                        dfs(j, k, root.child[board[j][k] - 'A']);
                }
            }

            if (i != B - 1) {
                root.clearHit();
                br.readLine();
            }
            if (max_word.equals(""))
                System.out.println(max_val + " " + find_cnt);
            else
                System.out.println(max_val + " " + max_word + " " + find_cnt);
            max_val = 0;
            max_word = "";
            find_cnt = 0;
        }

    }

    static void dfs(int x, int y, Node node) {
        //체크인
        visited[x][y] = true;
        sb.append(board[x][y]);
        //목적지인가
        if (node.isWord && !node.isHit) {
            String foundWord = sb.toString();
            int length = foundWord.length();
            if (max_word.length() < length)
                max_word = foundWord;
            else if (max_word.length() == length) {
                if (max_word.compareTo(foundWord) > 0) {
                    max_word = foundWord;
                }
            }

            max_val += getScore(length);
            find_cnt += 1;
            node.isHit = true;
        }
        //연결
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //갈수있는가 (맵안, 트라이자식있는지, visited)
            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && !visited[nx][ny] && node.child[board[nx][ny] - 'A'] != null) {
                //간다
                dfs(nx, ny, node.child[board[nx][ny] - 'A']);
            }
        }
        //체크아웃
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private static int getScore(int length) {
        if (length <= 2)
            return 0;
        else if (length <= 4) {
            return 1;
        } else if (length == 5) {
            return 2;
        } else if (length == 6) {
            return 3;
        } else if (length == 7) {
            return 5;
        } else {
            return 11;
        }
    }

}

class Node {
    boolean isWord;
    boolean isHit;
    Node[] child = new Node[26];

    public void insert(String word) {
        Node node = this;
        for (int i = 0; i < word.length(); i++) {
            int next = word.charAt(i) - 'A';

            if (node.child[next] == null) {
                node.child[next] = new Node();
            }

            node = node.child[next];
        }

        node.isWord = true;
    }

    public boolean contains(String word) {
        Node node = this;
        for (int i = 0; i < word.length(); i++) {
            int next = word.charAt(i) - 'A';

            if (node.child[next] == null) {
                return false;
            }

            node = node.child[next];
        }

        return node.isWord;
    }

    void clearHit() {
        isHit = false;
        for (int i = 0; i < child.length; i++) {
            if (child[i] != null) {
                child[i].clearHit();
            }
        }
    }
}
```