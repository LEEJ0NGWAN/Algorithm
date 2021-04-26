from sys import stdin
read = stdin.readline

MAP = []
useByRow = [[False]*10 for _ in range(9)]
useByCol = [[False]*10 for _ in range(9)]
useBySql = [[False]*10 for _ in range(9)]

def dfs(y, x):

    for i in range(y,9):
        for j in range(9):
            if i==y and j<=x: continue
            if MAP[i][j]: continue

            for k in range(1,10):
                if useByRow[i][k]\
                or useByCol[j][k]\
                or useBySql[(i//3)*3+j//3][k]: continue

                useByRow[i][k] =\
                useByCol[j][k] =\
                useBySql[(i//3)*3+j//3][k] = True

                if dfs(i,j):
                    useByRow[i][k] =\
                    useByCol[j][k] =\
                    useBySql[(i//3)*3+j//3][k] = False
                
                else:
                    MAP[i][j] = k
                    return False

            return MAP[i][j]==0

    return False


def main():

    global MAP
    MAP = [list(map(int,read().split(' '))) for _ in range(9)]

    for i in range(9):
        for j in range(9):
            useByRow[i][MAP[i][j]] = True
            useByCol[j][MAP[i][j]] = True
            useBySql[(i//3)*3+j//3][MAP[i][j]] = True
    
    dfs(0,-1)

    ans = ''
    for i in range(9):
        ans += ' '.join(map(str,MAP[i])) + '\n'

    print(ans,end='')

    return

if __name__=='__main__':
    exit(main())
