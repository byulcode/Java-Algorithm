# 백준 1629 곱셈 - 재귀
def rec(a, b, c):
    if b == 1:
        return a % c
    val = rec(a, b // 2, c)
    val = val * val % c
    if b % 2 != 0:
        return a * val % c
    return val


A, B, C = map(int, input().split())
print(rec(A, B, C))
