from sys import stdin
read = stdin.readline

def main():

    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    R, C = map(int, read().split())
    MAP = [read().strip() for _ in range(R)]
    MAX = 1
    
    que = set()
    app = que.add
    pop = que.pop
    app((0,0,MAP[0][0],1))

    while que:
        p = pop()

        for i in range(4):
            nx = p[0] + dx[i]
            ny = p[1] + dy[i]

            if 0<=nx<C and 0<=ny<R and MAP[ny][nx] not in p[2]:
                MAX = max(MAX, p[3]+1)
                app((nx,ny,p[2]+MAP[ny][nx],p[3]+1))

    print(MAX)

if __name__ == '__main__':
    exit(main())
