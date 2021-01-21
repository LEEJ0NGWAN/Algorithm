from collections import deque
from sys import stdin

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

R, C = map(int, stdin.readline().split())
MAP = []

que = deque()
app = que.append
pop = que.popleft

J = None

for i in range(R):
    MAP.append([c for c in stdin.readline() if c != '\n'])

    for j in range(C):
        if MAP[i][j] == 'F':
            app((i,j,0,'F'))
        if MAP[i][j] == 'J':
            J = (i,j,0,'J')

app(J)
J = 'IMPOSSIBLE'

while que:
    p = pop()

    if p[3] == 'J'\
    and p[0] < 0 or p[1] < 0\
    or R <= p[0] or C <= p[1]:
        J = p[2]
        break

    for i in range(4):
        y = p[0] + dy[i]
        x = p[1] + dx[i]

        if p[3] == 'J':
            if y < 0 or x < 0 or C <= x or R <= y:
                app((y,x,p[2]+1,'J'))
            elif MAP[y][x] == '.':
                MAP[y][x] = 'J'
                app((y,x,p[2]+1,'J'))
        else:
            if y < 0 or x < 0 or C <= x or R <= y\
            or MAP[y][x] == '#':
                continue
            if MAP[y][x] != 'F':
                MAP[y][x] = 'F'
                app((y,x,p[2]+1,'F'))

print(J)
