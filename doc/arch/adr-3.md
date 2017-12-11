### Architecture Design Record 3: Best Fit Bin Packing Algorithm. ###

### Context ###

adr-2 proposed a first fit packing algorithm. Performance measurements states:

* Number of box used: 511 for 1000 items, roughly 20 % less box used than the default algorithm.
* Response time: 568693 ns for 1000 items, x 20 degradation in response time compared to the default algorithm.
* Time complexity: around O(3n).
* Space complexity: 87 boxes opened at max for 1000 items.


### Decision ###

We change the robot decision when it comes to box selection.
Instead of selecting the first box in which the element can fit, the robot will
select the box having the minimum space left (ideally 0 when item is packed).

We don't set any limitations in the number of opened boxes (bins) the robot has to manage.
In a real life scenario, this number would be surely constrained.

### Status ###

Accepted.

### Consequences ###

None.