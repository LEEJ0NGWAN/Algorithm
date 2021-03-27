[돌아가기](https://github.com/LEEJ0NGWAN/algorithm)

[목록](./list.md)

### Dijkstra

음의 가중치 허용하지 않음

시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식

MST의 프림 알고리즘과 유사한 방식

```java
// s: 시작 정점, adj: 인접 행렬, dist: 시작정점과 특정 정점 사이의 거리 배열
// V: 모든 정점 집합, U: 선택된 정점 집합

Dijkstra (s, adj, dist)

	U = {s};

	// dist 초기화
	FOR 모든 정점 v
		dist[v] = adj[s][v]

	WHILE U != V
		dist[w]가 최소가 되는 정점 w in V-U 선택
		U += {w}

		// 경로 업데이트
		FOR w와 인접한 모든 미방문 정점 v
			dist[v] = min(dist[v], dist[w]+adj[w][v])
```

