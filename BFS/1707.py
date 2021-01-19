from collections import deque
from sys import stdin

ans = []

for _ in range(int(stdin.readline())):
    V, E = map(int, stdin.readline().split())
    
    link = [[] for _ in range(V+1)]
    info = [0] * (V+1)

    for _ in range(E):
        v1, v2 = map(int, stdin.readline().split())
        link[v1].append(v2)
        link[v2].append(v1)
    
    que = deque()
    app = que.append
    pop = que.popleft

    flag = False
    
    for v in range(1,V+1):

        if not info[v]:
            app(v)

            while que:
                v = pop()

                if flag: break
                if not info[v]:
                    info[v] = 1

                for nv in link[v]:
                    if info[nv] == info[v]:
                        flag = True
                        break
                    
                    elif not info[nv]:
                        info[nv] = 3 - info[v]
                        app(nv)

            if flag: break

    ans.append("NO" if flag else "YES")

for a in ans: print(a)
