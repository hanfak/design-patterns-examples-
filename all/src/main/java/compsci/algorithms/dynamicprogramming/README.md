# Dynamic Programming (DP)


DP solves problems by breaking it down into simpler subproblems and utilizing the fact that the optimal solution to the
overall problem depends upon the optimal solution to its subproblems.

Always start with brute force problem, then apply DP

A problem can be solved by DP if it has the following traits: 

- Overlapping subproblems

Subproblems are smaller versions of the original problem. Any problem has overlapping sub-problems
if finding its solution involves solving the same subproblem multiple times

E.G. if solving the same subproblem twice, is an overlapping subproblem

Fibonacci -> f(n) = f(n-1) + f(n-2) recursive solution
So for f(4) we have to solve f(2) twice, and f(1) three times

- It has an optimal substructure

its overall optimal solution can be constructed from the optimal solutions of its subproblems

E.G.  f(n) = f(n-1) + f(n-2), shows that f(n) is broken down into subproblems

Dynamic programming is mostly just a matter of taking a recursive algorithm and finding the overlapping
subproblems (that is, the repeated calls).You then cache those results for future recursive calls.

## Issues with recursion

Recursive algorithms can be very space inefficient. Each recursive call adds a new layer to the stack, which
means that if your algorithm recurses to a depth of n, it uses at least 0 (n) memory.