# 문제: 스택 (https://www.acmicpc.net/problem/10808)
# 난이도: 브론즈 4

import sys

# 빠른 입출력
input = sys.stdin.readline
print = sys.stdout.write

# 필요한 변수
arr = [0 for _ in range(26)]
word = input().rstrip()


for ch in word:
    idx = ord(ch) - 97
    arr[idx] += 1


for i in arr:
    print(f'{i} ')