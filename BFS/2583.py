from sys import stdin
read = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(i, j):
    count = 0

    que = set()
    app = que.add
    pop = que.pop
    app((i,j))

    while que:
        p = pop()
        count += 1
        MAP[p[0]][p[1]] = True

        for k in range(4):
            nx = p[1] + dx[k]
            ny = p[0] + dy[k]

            if 0<=nx<N and 0<=ny<M and not MAP[ny][nx]:
                app((ny,nx))
    
    return count

def main():
    global M, N, MAP

    M, N, K = map(int, read().split())
    MAP = [[False]*N for _ in range(M)]

    for _ in range(K):
        x1, y1, x2, y2 = map(int, read().split())
        for i in range(y1,y2):
            for j in range(x1,x2):
                MAP[i][j] = True
    
    arr = list()
    app = arr.append
    for i in range(M):
        for j in range(N):
            if not MAP[i][j]:
                app(bfs(i,j))
    arr.sort()
    print(len(arr))
    print(' '.join([str(x) for x in arr]))

if __name__ == '__main__':
    exit(main())
