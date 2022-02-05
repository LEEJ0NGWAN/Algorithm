# 이진 탐색

Sorted Array 자료구조에서 O(logn)의 시간복잡도로 원하는 값을 찾아내는 탐색 알고리즘

## 방법
1. 정렬 배열의 탐색 구간에서 중앙값과 목표값을 비교한다.
2-1. 중앙값과 목표값이 같다면 값을 찾은 것이다.
2-2. 중앙값 < 목표값: 배열의 탐색 구간을 우측으로 절반 좁힌다
2-3. 중앙값 > 목표값: 배열의 탐색 구간을 좌측으로 절반 좁힌다


```
// left: 현재 배열의 탐색구간의 제일 왼쪽 원소(오름차순 기준 가장 작은 값)
// right: 현재 배열의 탐색구간의 제일 오른쪽 원소(오름차순 기준 가장 큰 값)
// 중앙값: 현재 배열의 탐색구간의 중간 값

while left <= right
	
    if 중앙값 is 목표값 then
  		return 중앙값
  	endif
  
  	if 중앙값 < 목표값 then
  		left = 중앙값 + 1 // 
  	else
  		right = 중앙값 - 1 // 배열의 탐색 구간을 좌측으로 절반 좁힌다
  	endif

endwhile

```

## 구현(java)
```
    public int search(int[] nums, int target) {

        int ans = -1;
        
        int left = 0;
        int right = nums.length-1;
        int pivot = (left + right) / 2;
        
        if (target < nums[left] || nums[right] < target) return ans;
        
        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        
        while (left <= right) {
            
            if (nums[pivot] == target) {
                
                ans = pivot;
                break;
            }
            
            pivot = nums[pivot] < target?
                ((left = pivot + 1) + right) / 2:
                (left + (right = pivot - 1)) / 2;
        }
        
        return ans;
    }
```
