# Instructions:
A squad of robotic rovers are to be landed by NASA on a plateau on Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.

Your task is to develop an API that moves the rovers around on the plateau.

In this API, the plateau is represented as a 10x10 grid, and a rover has state consisting of two parts:

* its position on the grid (represented by an X,Y coordinate pair)
* the compass direction it's facing (represented by a letter, one of N, S, E, W)
# Rules:
1. You are given the initial starting point (0,0,N) of a rover.
2. 0,0 are X,Y co-ordinates on a grid of (10,10).
3. N is the direction it is facing (i.e. N,S,E,W).
4. L and R allow the rover to rotate left and right.
5. M allows the rover to move one point in the current direction.
6. The rover receives a char array of commands e.g. RMMLM and returns the finishing point after the moves e.g. 2:1:N
7. The rover wraps around if it reaches the end of the grid.
8. The grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle e.g. O:2:2:N