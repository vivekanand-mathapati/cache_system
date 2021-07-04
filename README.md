CACHE MANAGEMENT SYSTEM

Your objective is to design a software cache management system (cms), which should
adhere to the following properties:
1. The system should have multiple levels of cache storage. The number of levels
should be configurable.
2. The data maintained in the system will be in the form of a (key, value) pair of
strings.
3. Each level of cache will have a pre-specified constant CAPACITY, READ_TIME
and WRITE_TIME. Any read operation for the corresponding cache will incur
READ_TIME delay and any write operation for the corresponding cache will incur
WRITE_TIME delay.
4. The cache levels will be chained (e.g. L1 -> L2 -> L3 ...). The data stored at any
level will be a subset of data stored at the next level.
5. The system should support following operations:
● READ <Key> : Prints the value stored corresponding to the key and read
time
● WRITE <Key> <Value> : Stores the (key, value) pair and prints the write
time

7. A data read operation is performed as below:
a. The cms will start reading the caches starting with the lowest level and
proceed towards next level if key is not found at current level. As soon as
it finds the key, it should fetch the value from the cache and propagate
backwards writing the same data at all the lower level caches. If the lower
level cache is already full, it will rewrite the new data over the oldest data
in the cache. 
8. A data write operation is performed as below:
a. The cms will first read the cache for existing duplicate data(having same key-value pair) starting with
the lowest level. If it is already present, it should not overwrite the data.
Otherwise, it should write the new data into the cache and proceed to the
next level. If the cache level is full, it will purge the oldest data (or based

on some other replacement policy) in the cache level before writing the
new data.
Sample input:
5 // Number of cache levels
10 15 20 25 30 // Cache size of each level
1 2 3 4 5 // READ time of each level
2 4 6 8 10 // WRITE time of each level
WRITE “abc” “def” // Should print “Write time: 45”
WRITE “ghi” “jkl” // Should print “Write time: 45”
READ “abc” // Should print “Value at abc is def”
“Read time: 1”
// Bonus Points:
STATS // Should print “Usage: 2 / 10 , 2 / 15 , 2 / 20 , 2 / 25 , 2 / 30”
“Avg Read Time: 1”
“Avg Write Time: 45”
Bonus Points:
The system should be able to provide statistics in the following manner:
A: STATS : Should print cache capacity details ( Filled / Total ) of each level and
average read and write times of last 10 operations.
Extension cases: Data type, Replacement Policy etc.

