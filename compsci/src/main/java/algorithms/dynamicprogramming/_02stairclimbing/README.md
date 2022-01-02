Number of ways of climbing stairs using up to 3 jumps

n is number of steps in stairs

n=0 (go from 0 to 0 step) ,{1} ways = 1 (already on step) - basecase
n=1 (go from 0 to 1 step), {1} ways = 1  - basecase
n=2, {1,1} {2} ways = 2 - bascase
n=3, {1,1,1}, {1,2}, {2,1}, {3} ways = 4


We know the number of ways to get from 0 step below to the top, 1 step below to the top, 2 steps below to get to the 
top etc

T(n) = T(n-1) + T(n-2) + T(n-3) (thus need only 3 base cases)

DP as T(n) is split into subproblems, and each subproblem can be solved from a previous subproblem

E.G. 

T(4) = T(3) + T(2) + T(1)
and T(3) can be broken down again
T(3) = T(2) + T(1) + T(0)
and T(2) can be broken down again
T(2) = T(1) + T(0) 
which is now solvable
T(2) = 2, T(3) = 4, T(4) = 7

3 -> 1
2 -> 2, 11
1 -> 111, 21, 12
0 -> 4 