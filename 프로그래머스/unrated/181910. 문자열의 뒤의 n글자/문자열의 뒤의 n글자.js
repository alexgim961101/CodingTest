function solution(my_string, n) {
    var answer = '';
    
    answer = my_string.slice(-n, my_string.length)
    
    return answer;
}