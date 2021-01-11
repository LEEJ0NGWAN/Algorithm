from sys import stdin
from collections import deque

raw = []
edges = {}
N, M, V = map(int, stdin.readline().split())

def dfs(v, pre, stack):
    if len(stack) == N:
        return

    if v in edges:
        for dst in edges[v]:
            if dst not in stack and dst != pre:
                stack[dst] = str(dst)
                dfs(dst, v, stack)

def bfs(v, stack):
    que = deque()
    app = que.append
    pop = que.popleft

    app((v, v))
    while que:
        node, pre = pop()

        if len(stack) == N:
            break

        if node not in stack:
            stack[node] = str(node)

        if node in edges:
            for dst in edges[node]:
                if dst not in stack and dst != pre:
                    app((dst, node))

for _ in range(M):
    src, dst = map(int, stdin.readline().split())
    if src > dst:
        src, dst = dst, src
    raw.append((src, dst))

raw.sort()

for src, dst in raw:
    if src not in edges:
        edges[src] = []
    if dst not in edges:
        edges[dst] = []
    edges[src].append(dst)
    edges[dst].append(src)

stack = {V: str(V)}
dfs(V, None, stack)
print(' '.join(stack.values()))

stack.clear()
bfs(V, stack)
print(' '.join(stack.values()))