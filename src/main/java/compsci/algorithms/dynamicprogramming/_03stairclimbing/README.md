Minimum jumps to reach nth Stair using 1, 2 or 3 steps

min no of jumps = 1 + MIN (T(n-1), T(n-2), T(n-3))
Basecond
T(3) = T(2) = T(1) = 1
T(0) = 0


Example n =5 
T(5) = 2
T(5) = 1 + MIN(T(4), T(3), T(2)) =  1 + MIN(2,1,1) = 1 + 1 = 2
T(4) = 1 + MIN(T(3), T(2), T(1)) = 1 + MIN(1,1,1) = 1 + 1 = 2