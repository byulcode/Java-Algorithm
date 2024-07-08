# 백준 7576 토마토(2차원)
from sys import stdin
from collections import deque

box = []
days = 0
queue = deque()

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

M, N = map(int, stdin.readline().split())
box = [list(map(int, stdin.readline().split())) for _ in range(N)]

for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            queue.append((i, j))

while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and box[nx][ny] == 0:
            queue.append((nx, ny))
            box[nx][ny] = box[x][y] + 1

for a in box:
    for b in a:
        if b == 0:  # 익지 못한 토마토가 있는 경우
            print(-1)
            exit()
    days = max(days, max(a))

print(days - 1)
