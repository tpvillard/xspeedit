### Architecture Design Record 2: First Fit Bin Packing Algorithm. ###

### Context ###

Performance measurements for the default algorithm are:

* Number of box used: 640 for 1000 items to pack.
* Response time: 27058 nanoseconds for 1000 items to pack.
* Time complexity: around O(n). (Measured with a variation of the data set from 1000 to 10 0000 entries)
* Space complexity: 1 box opened at max.

The default solution described uses a non optimal solution
in which a box (or bin) is closed as soon as the current element to treat can't fit in. 
At any given point in time, there is only one box (or bin) opened.

### Decision ###

Implement a variation in which boxes remain opened as long as they have not reached
their capacity. The robot holds a list of opened box. For each new item to pack, the
robot will use the first box in which the item can fit.

This algorithm is known as the first fit bin packing algorithm. We'll assume that in the
context of this problem, objects of different volume are supposed to arrive sequentially
and must be treated in real time by the robot (online bin packing). It is hence
not possible to sort the items before hand, which may result in better performance.

We don't set any limitations in the number of opened boxes (bins) the robot has to manage.
This number would surely be constrained in a real life scenario.

### Status ###

Accepted.

### Consequences ###

None.