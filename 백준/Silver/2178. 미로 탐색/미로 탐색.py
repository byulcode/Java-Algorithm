# 백준 2178 미로 탐색 - 다차원 배열의 최단거리
from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().split())
graph = []

for _ in range(N):
    graph.append(list(map(int, stdin.readline().rstrip())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
    return graph[N - 1][M - 1]


print(bfs(0, 0))
