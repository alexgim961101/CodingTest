package codePlus.basic.DynamicProgramming;

/**
 * DP : Dynamic Programming
 * 정의 : 큰 문제를 작은 문제로 나눠 푸는 알고리즘 (Dynamic이라는 단어는 딱히 큰 의미는 없다)
 *
 * 조건
 * 1). 겹치는 작은 문제 (Overlapping Subproblem) : ex). 피보나치 수열
 * 2). 최적 부분 구조 (Optimal Substructure) : 문제의 정잡을 작은 문제의 정답에서 구할 수 있다 ex). 피보나치 수열, 서울에서 부산
 * => 작은 문제들이 겹치고, 최적 부분 구조이기 때문에 이 겹치는 문제들의 답이 어디선가 또 쓰임 -> 기록해 둘 필요가 있음 -> Memoization
 *
 * 시간복잡도
 * 1). 모든 문제를 풀어야 함
 * 2). 모든 문제는 1번만 풀어야됨 -> DP의 작은 문제들의 답은 항상 일정하기 때문
 * ==> 문제의 개수 * 문제 1개를 푸는 시간   ex). 피보나치 => 개수 n * (n-1)과 (n-2)의 합연산의 시간 복잡도(1) => O(n)
 *
 * 해결 방봅
 * 1). Top-down (재귀 이용) : 큰 문제를 나눌 수 없는 가장 작은 문제로 나눔
 * 2). Bottom-up (반복문 이용)
 *
 * 문제풀이 전략
 * 1). 점화식의 정의를 세운다. (먼저 글로 정의해볼 것)
 * 2). 문제를 작게 만들 수 있는 방법을 찾을 것
 * 3). 점화식을 완성할 것
 * */
public class Main {
    public static void main(String[] args) {

    }
}
