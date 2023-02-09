package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 베스트 앨범 / Lv 3
 * 1. 장르별 재생횟수를 구한다
 * 2. 장르별 2개씩 재생횟수가 많은 순으로 수록
 * 3. 장르 내 재생횟수가 비슷한 경우 고유번호(인덱스가 낮은 순으로 저장)
 * */
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays){
        // 1. 장르별 재생횟수 구하기
        Map<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. List를 이용해 재생횟수 별 장르를 내림차순 정렬
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map1.keySet()){
            genre.add(key);
        }
        Collections.sort(genre, (o1, o2) -> map1.get(o2) - map1.get(o1));

        // 3. 장르별 최대 2개씩 수록하기(재생횟수 많은 순, 같으면 인덱스 작으거)
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++){
            String gen = genre.get(i);

            // 첫 번째 곡 수록
            int max = Integer.MIN_VALUE;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++){
                if(gen.equals(genres[j]) && plays[i] > max){
                    firstIdx = j;
                    max = plays[j];
                }
            }

            // 두 번째 곡 수록
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++){
                if(gen.equals(genres[j]) && plays[j] > max && firstIdx != j){
                    secondIdx = j;
                    max = plays[j];
                }
            }

            ansList.add(firstIdx);
            if(secondIdx != -1) ansList.add(secondIdx);
        }

        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        System.out.println(bestAlbum.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
    }


}
