import java.io.*;
import java.util.*;

/**
* 문제 해결
*
* 1). DFS 이용
* 2). 벤 아이디별로 가능한 아이디 찾기
* 3). 찾은 후 그 다음 벤 아이디의 가능한 아이디 찾기
* 4). 쭉 반복
* 5). 마지막에 벤 아이디를 다 탐색했을 때, 해당 조합을 result에 저장
* 6). 이것을 백 트래킹을 이용해서 조합 찾기
*/

class Solution {
    String[] userIds;
    String[] bannedIds;
    HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        
        dfs(new HashSet<>(), 0);
        
        return result.size();
    }
    
    public void dfs(HashSet<String> set, int depth) {
        if(depth == bannedIds.length) {
            result.add(set);
            return;
        }
        
        for(int i = 0; i < userIds.length; i++) {
            if(set.contains(userIds[i])) continue;
            
            if(check(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }
    
    public boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) return false;
        
        boolean result = true;
        for(int i = 0; i < userId.length(); i++) {
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}