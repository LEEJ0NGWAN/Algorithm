from sys import stdin, setrecursionlimit
setrecursionlimit(100000)
read = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
N = 0
MAP = []
visit = []

def dfs(i, j, level):
    visit[i][j] = True

    for k in range(4):
        nx = j + dx[k]
        ny = i + dy[k]
        if 0 <= nx < N\
        and 0 <= ny < N\
        and level < MAP[ny][nx]\
        and not visit[ny][nx]:
            dfs(ny,nx,level)

def initMap():
    global visit
    for i in range(N):
        visit[i] = [False]*N

def main():
    global N, MAP, visit
    N = int(read())
    maxLevel = 0
    maxCount = 0

    for i in range(N):
        MAP.append(list(map(int,read().split())))
        visit.append([False]*N)
        if maxLevel < max(MAP[i]):
            maxLevel = max(MAP[i])

    for level in range(maxLevel-1,-1,-1):
        count = 0
        for i in range(N):
            for j in range(N):
                if not visit[i][j]\
                and level < MAP[i][j]:
                    dfs(i,j,level)
                    count+=1
        if maxCount <= count:
            maxCount = count

        initMap()
    
    print(maxCount)

if __name__ == '__main__':
    exit(main())
