# 백준 11729 하노이 탑 이동 순서

n = int(input())


def func(a, b, n):
    if n == 1:
        print(a, b)
        return

    func(a, 6 - a - b, n - 1)
    print(a, b)
    func(6 - a - b, b, n - 1)


cnt = 2 ** n - 1
print(cnt)
func(1, 3, n)
