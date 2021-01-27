from sys import stdin
from sys import setrecursionlimit
setrecursionlimit(100000)
edge = {}
visit = None

def dfs(v):
    visit[v] = True

    if v in edge:
        for e in edge[v]:
            if visit[e]:
                continue
            dfs(e)

def main():
    read = stdin.readline
    n, m = map(int, read().split())

    global visit
    visit = [False] * (n+1)

    for _ in range(m):
        v1, v2 = map(int, read().split())
        if v1 not in edge:
            edge[v1] = []
        if v2 not in edge:
            edge[v2] = []
        edge[v1].append(v2)
        edge[v2].append(v1)
    
    count = 0
    for v in range(1,n+1):
        if visit[v]:
            continue
        dfs(v)
        count += 1
    
    print(count)

if __name__ == '__main__':
    exit(main())
