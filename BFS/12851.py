from sys import stdin

def main():

    n, k = map(int, stdin.readline().split())
    visit = [False] * 100001

    sec = 0
    que = [n]

    while que:
        tmp = []
        app = tmp.append
        for p in que:

            if p == k:
                print(sec, que.count(k), sep="\n")
                return
            
            visit[p] = True
            for x in (p-1,p+1,p*2):
                if 0 <= x < 100001 and not visit[x]: app(x)
        
        sec += 1
        que = tmp

if __name__ == "__main__":
    exit(main())
