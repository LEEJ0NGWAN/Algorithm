[돌아가기](https://github.com/LEEJ0NGWAN/algorithm)

[목록](./list.md)

# 라빈-카프

해시 함수를 이용하는 알고리즘

문자열을 brute-force로 비교하는 대신 패턴의 해시값과 본문의 부분 문자열의 해시값 비교

최악의 시간 복잡도는 브루트 포스와 동일한 O(MN) 이지만, 평균적으로 선형에 가까운 빠른 속도

# 보이어 무어

패턴 문자의 오른쪽에서 왼쪽으로 비교하는 알고리즘

패턴의 오른쪽 끝 문자가 불일치하고, 해당 문자가 패턴 내 존재하지 않는 경우 패턴 길이 만큼 점프

최악의 시간 복잡도는 O(MN)이지만, 최선의 시간 복잡도는 O(N/M)으로 평균적으로 가장 빠른 속도를 가짐

# KMP 알고리즘

불일치가 발생한 텍스트 문자열의 앞 부분에 어떤 문자가 있는지 미리 알고 있기 때문에,

불일치가 발생한 앞 부분에 대해 다시 비교하지 않고 매칭 수행하는 알고리즘

→ 패턴 전처리를 통해 fail[k]를 구해서 잘못된 시작을 최소화 시킴

- 패턴을 이용한 실패 함수

    매칭 실패 시 패턴 포인터가 돌아갈 곳을 계산

- 패턴의 0번 인덱스를 제외하고,

    각 인덱스마다 맨 앞부터 해당 인덱스까지의 부분 문자열 중 접두사==접미사가 되는 최대 문자열 길이 계산

→ 실패 함수를 통해서, 접두사==접미사 최대 길이를 이용한 점프를 통해 불필요한 검색 생략
