# MultiThreadGame
WIF3003 Group Assignment

## Game Description
You are required to build a simple game using multithreading. The game (your program) accepts three arguments, **n**, **t** and **m**, where **_n >> t_**. After receiving the arguments, the program will sequentially **_create n random points_**. The points are **_floating point_** (floats or doubles) coordinates in a **_1000 x 1000 region_**. **NO** two points should overlap. Each point is represented as an object containing the coordinates.

After that, your program will launch **_t threads_**. Each thread will randomly pick a pair of points to **_add an edge between_** them. Use an appropriate data structure to store the pair of connected points. However, **NO** point should be connected with more than one other point, i.e. each point could be used to form at most one edge (locking needed when forming an edge).
The program will run for **_m seconds_**, or when any one thread has failed to form a single edge **_after 20 attempts_**. Display the number of edges each thread was successfully created.
