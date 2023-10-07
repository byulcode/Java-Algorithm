import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] tree;
    static int root, delNode, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n];    // 이진트리가 아니기 때문
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }
        delNode = Integer.parseInt(br.readLine());

        answer = 0;
        dfs(root);

        System.out.println(answer);
    }

    static void dfs(int node) {
        if (node == delNode) {
            return;
        }

        if (tree[node].size() == 0) { // 자식 노드가 없다. => 리프노드!
            answer++;
            return;
        }

        for (int i : tree[node]) { // 자식 노드가 1개인데, 그게 삭제될 노드이다 => 리프 노드!
            if (i == delNode && tree[node].size() == 1) {
                answer++;
                return;
            }
            dfs(i);
        }
    }
}
