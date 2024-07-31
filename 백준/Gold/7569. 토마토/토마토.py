# 백준 7569 토마토
from sys import stdin
from collections import deque

m, n, h = map(int, stdin.readline().split())
queue = deque()
box = []
day = 0

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

for i in range(h):
    tmp = []
    for j in range(n):
        tmp.append(list(map(int, stdin.readline().rstrip().split())))
        for k in range(m):
            if tmp[j][k] == 1:
                queue.append([i, j, k])
    box.append(tmp)  # 2차원 배열을 append 해 3차원 배열 만들기

while queue:
    x, y, z = queue.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m and box[nx][ny][nz] == 0:
            box[nx][ny][nz] = box[x][y][z] + 1
            queue.append([nx, ny, nz])

for i in box:
    for j in i:
        for k in j:
            if k == 0:  # 익지 않은 토마토가 있을 경우
                print(-1)
                exit()
        day = max(day, max(j))
print(day - 1)
