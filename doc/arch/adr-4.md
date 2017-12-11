### Architecture Design Record 3: Best Fit Bin Packing Algorithm. ###

### Context ###

adr-3 proposed a best fit packing algorithm. Performance measurements states:

* Number of box used: 511.
* Response time: roughly the same as first fit.
* Time complexity: roughly the same as first fit.
* Space complexity: 74.

The main improvement is in the number of opened boxes.

### Decision ###

To enhance search response time for best fit algorithm, boxes will be stored in a tree map.

``` java

TreeMap<key, List<Box>> openedBoxes = new TreeMap<>();

````

The box list are keyed on the space left.
The map is searched for the floor key matching the item value.
The first box in the list is returned.

### Status ###

To be implemented.

### Consequences ###

None.