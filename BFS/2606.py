from sys import stdin
from collections import deque
read = stdin.readline

V = int(read())
E = int(read())
edges = {}

def bfs(seed=1):
    visit = {seed:True}

    que = deque()
    app = que.append
    pop = que.popleft

    app(seed)

    while que:
        node = pop()
        
        if node in edges:
            for v in edges[node]:
                if v not in visit:
                    visit[v] = True
                    app(v)
    
    return len(visit)-1

for _ in range(E):
    v1, v2 = map(int, read().split())
    if v1 not in edges:
        edges[v1] = []
    if v2 not in edges:
        edges[v2] = []
    
    edges[v1].append(v2)
    edges[v2].append(v1)

print(bfs())
