# 문제: 숫자의 개수 (https://www.acmicpc.net/problem/2577)
# 난이도: 브론즈 2

import sys

input = sys.stdin.readline
print = sys.stdout.write

arr = [0 for _ in range(10)]
sum = 1

for i in range(3):
    sum *= int(input().rstrip())

for ch in str(sum):
    arr[int(ch)] += 1

for i in arr:
    print(f"{i}\n")