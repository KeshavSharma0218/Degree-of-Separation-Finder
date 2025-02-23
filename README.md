# Degree-of-Separation-Finder
This Java program calculates the degree of separation between two individuals in a network of friendships. Given a list of friendships, the program finds the shortest path (degree of separation) between two people and displays the sequence of friendships that connects them.

Features:
Accepts multiple test cases to calculate degrees of separation.
Uses BFS (Breadth-First Search) to find the shortest path between two people.
Outputs the degree of separation and the sequence of friends connecting the two individuals.
Handles cases where no connection exists between the two people.
Instructions:
Input the number of test cases N.
For each test case:
Input the number of friendships K.
For each friendship, input the person and their list of friends.
Input the two people whose degree of separation needs to be calculated.
The program will output the degree of separation and the friendship chain for each test case.
Example Input:
1
3
Alice: Bob Charlie
Bob: Alice
Charlie: Alice
Alice Bob
Example Output:
The degree of separation between Alice and Bob is 1.
Alice is a friend of Bob.
