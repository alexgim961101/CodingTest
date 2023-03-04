package DoItCodingTest.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 수열 / 실버 2 / 시간 제한 2초 / 메모리 제한 128MB
 * 해결 과정
 * 1). push 단계와 pop단계로 나눔
 * 2). push 단계 : 특정 수만큼 push한 후, 마지막에 pop(같은 수를 출력해야 하기 때문에)
 * 3). pop 단계 : 스텍의 맨 윗 값을 pop한 후, 조건과 맞는지 검사
 * -> 어차피 스텍의 모든 수를 리턴해야 하는데 제일 위의 수가 아닌 그 아래의 수를 원하면 결국 꼬여서 NO를 출력할 수 밖에 없음
 * */
public class B_1874 {
    static int n;
    static int[] arr;
    static Stack<Integer> stk;
    static StringBuilder sb;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        stk = new Stack<>();
        sb = new StringBuilder();
        flag = true;
    }

    public static void output() {
        String answer = flag ? sb.toString() : "NO";
        System.out.print(answer);
    }

    public static void process() {
        int num = 1;
        for(int i = 0; i < n; i++){
            int target = arr[i];

            if(num <= target){
                while (num <= target) {
                    stk.push(num);
                    num++;
                    sb.append("+\n");
                }
                stk.pop();
                sb.append("-\n");
            } else {
                int tmp = stk.pop();
                if(target != tmp) {
                    flag = false;
                    return;
                } else {
                    sb.append("-\n");
                }
            }
        }
    }
}