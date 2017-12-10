### Architecture Design Record 1: Default Algorithm implementation. ###

### Context ###

XspeedIt problem is described in README.md.
It is a variation of the bin packing problem where objects of different volumes must be packed into a 
finite number of bins or containers each of volume V in a way that minimizes the number of bins used.
The problem is described [here](https://en.wikipedia.org/wiki/Bin_packing_problem) or
[here](https://fr.wikipedia.org/wiki/Probl%C3%A8me_de_bin_packing).

A first solution to the problem is described in README.md. 
The solution is non optimal and requires optimization.

### Decision ###

Implement the non optimal solution (hereafter referred as the default solution)
that will serve as a basis for further optimization.
The initial design should leave rooms for extensibility so that new solutions (algorithms)
can be easily tested.

Algorithms should be evaluated according to the optimization they provide 
(ie the percentage of bin or boxes saved) but also according to their response time
(the time to solve the problem for a given input size), their time complexity (how the algorithm scales when 
the input size grows) and their space complexity (the amount of memory used when the input
size grows). Optimization is necessarily a tradeoff between all theses factors.

### Status ###

Accepted.

### Consequences ###

A specific test class will be built to compare the various algorithm used.
It will track:

* The number of bins used.
* The response time of the algorithm.
* The estimated time complexity of the algorithm.
* The estimated space complexity of the algorithm.