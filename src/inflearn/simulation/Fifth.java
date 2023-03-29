package inflearn.simulation;

/**
 * 최대길이 바이토닉 수열
 * 이중 for문과 플레그 두개를 이용하여 문제풀이
 * O(n^2) => 100,000,000 예상
 **/
public class Fifth {
    public int solution(int[] nums){
        int answer = 0;

        for(int i = 0; i < nums.length - 1; i++){
            int count = 1;
            boolean[] flag = new boolean[2];
            for(int j = i; j < nums.length-1; j++){
                if(!flag[1] && (nums[j] < nums[j+1])) {
                    flag[0] = true;
                    count++;
                    continue;
                } else if(flag[0] && (nums[j] > nums[j+1])) {
                    flag[1] = true;
                    count++;
                } else {
                    break;
                }
            }
            if(flag[0] && flag[1]) {
                answer = Math.max(answer, count);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Fifth T = new Fifth();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
