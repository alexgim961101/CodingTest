package techit.set;

// Iter -> Iterative
// 반복문으로 부분집합 구하기
public class PowerSet {
    public static void main(String[] args) {
        int[] set = new int[]{2, 3, 5};
        // 선택 여부를 저장하는 배열
        int[] select = new int[3];

        // set의 각 원소를 선택할까 말까?
        // i == 0 이면 첫번째 원소 선택 X
        // i == 1 이면 첫번째 원소 선택 O
        for(int i = 0; i < 2; i++){
            select[0] = i;
            // j == 0 이면 두번째 원소 선택 X
            // j == 1 이면 두번째 원소 선택 O
            for(int j = 0; j < 2; j++){
                select[1] = j;
                // k == 0 이면 세번째 원소 선택 X
                // k == 1 이면 세번째 원소 선택 O
                for(int k = 0; k < 2; k++){
                    select[2] = k;
                    for(int n = 0; n < 3; n++){
                        if(select[n] == 1) System.out.print(set[n] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
