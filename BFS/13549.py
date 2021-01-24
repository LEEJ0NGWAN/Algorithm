from sys import stdin

def main():

    n, k = map(int, stdin.readline().split())
    visit = [False]*100001

    que = [n]
    sec = 0

    while que:
        tmp = []
        app = tmp.append

        for p in que:
            if p == k:
                print(sec)
                return

            visit[p] = True
            if 0 < 2*p < 100001: que.append(2*p)
        
        for p in que:
            for x in (p-1,p+1):
                if 0 <= x < 100001 and not visit[x]: app(x)

        que = tmp
        sec += 1

if __name__ == '__main__':
    exit(main())
