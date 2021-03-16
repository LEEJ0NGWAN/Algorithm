string = ''
for tc in range(1,11):

    adj = {}
    visit = [False] * 101
    length, start = map(int, input().split())
    raw = input().split()
    for i in range(0, length, 2):
        f = int(raw[i])
        t = int(raw[i+1])

        if f not in adj:
            adj[f] = set()
        
        adj[f].add(t)
    
    visit [start] = True
    que = [start]
    ans = start
    while que:
        tmp = []
        app = tmp.append
        tmp_ans = 0
        for p in que:
            if tmp_ans < p:
                tmp_ans = p
            if p in adj:
                for next_ in adj[p]:
                    if not visit[next_]:
                        visit[next_] = True
                        app(next_)
        que = tmp
        ans = tmp_ans

    string += '#'+str(tc)+' '+str(ans)+'\n'
print(string)