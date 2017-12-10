### Architecture Design Record 2: First Fit Bin Packing Algorithm. ###

### Context ###

The default solution described in the XspeedIt problem statement use a non optimal solution
in which a box (or bin) is closed as soon as the current element to treat can't fit in. 
At any given point of time, there is only one box (or bin) opened.

### Decision ###

Implement a variation in which box remains opened as long as they have not reached
their capacity. The robot holds list of opened box. For each new item to pack, the
robot will use the first box in which the item can fit.

This algorithm is known as the first fit bin packing strategy. We'll assume that in the
context of this problem, objects of different volume are supposed to arrive sequentially
and must be treated in real time by the robot (online bin packing). It is hence
not possible to sort the items before hand, which may result in better performance.

We don't set any limitations in the number of opened boxes (bins) the robot has to manage.
This number would surely be constrained in a real life scenario.

### Status ###

Accepted.

### Consequences ###

None.