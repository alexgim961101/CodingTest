package inflearn.hashing;

/**
 * 4번째 문제 / 음수가 있는 부분수열
 * */
public class Firth {
    public int solution(int[] nums, int m){
        int answer = 0;

        int left = 0;
        int right = 1;

        int sum = nums[left] + nums[right];
        while (right < nums.length-1 && left < nums.length-2) {
            if(sum == m) {
                answer++;
                sum += nums[++right];
            } else if(sum > m) {
                sum -= nums[left++];
            } else {
                sum += nums[++right];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Firth T = new Firth();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
