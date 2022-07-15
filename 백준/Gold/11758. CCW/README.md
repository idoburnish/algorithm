# [Gold V] CCW - 11758 

[문제 링크](https://www.acmicpc.net/problem/11758) 

### 성능 요약

메모리: 14240 KB, 시간: 128 ms

### 분류

기하학(geometry)

### 문제 설명

<p>2차원 좌표 평면 위에 있는 점 3개 P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>가 주어진다. P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>를 순서대로 이은 선분이 어떤 방향을 이루고 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 P<sub>1</sub>의 (x<sub>1</sub>, y<sub>1</sub>), 둘째 줄에 P<sub>2</sub>의 (x<sub>2</sub>, y<sub>2</sub>), 셋째 줄에 P<sub>3</sub>의 (x<sub>3</sub>, y<sub>3</sub>)가 주어진다. (-10,000 ≤ x<sub>1</sub>, y<sub>1</sub>, x<sub>2</sub>, y<sub>2</sub>, x<sub>3</sub>, y<sub>3</sub> ≤ 10,000) 모든 좌표는 정수이다. P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>의 좌표는 서로 다르다.</p>

### 출력 

 <p>P<sub>1</sub>, P<sub>2</sub>, P<sub>3</sub>를 순서대로 이은 선분이 반시계 방향을 나타내면 1, 시계 방향이면 -1, 일직선이면 0을 출력한다.</p>

### 리뷰
CCW(Counter Clock Wise) 알고리즘을 이용하는 문제로, CCW 알고리즘은 3개의 점 A, B, C가 있을 때 이 점 3개를 이은 직선의 방향을 알고자 할 때 유용한 기하 알고리즘이다. 경우의 수는 시계방향, 반시계방향, 직선으로 총 3가지가 있으며 이는 벡터의 외적으로 구할 수 있다. 외적의 결과가 음수이면 시계방향, 양수이면 반시계방향, 0이면 직선이다.
