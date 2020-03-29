# Masters_Project_Autonomous_Driving
This is my master's thesis project on autonomous driving of trucks
The code is based on OSGI, which is based on Java
The overall application is modularized and there is a lot of reuse in the code
The application is developed for controlling a truck's driving, in this case is a truck in a docking station,
virtually represented in the Unity simulator
The application will communicated back and forth with untiy by generating UDP signlas.
The launcher activates the necessary bundles with information about destination and sets the waypoints
The pathplanner uses Astar algorithm which takes the dimension of the docking station as a 2d grid input and returns the path between the source and destination
The pathcontroller incorporates a novel motion planning framework which computes based on the result of Astar, i.e. the closed list
The reversecontroller is invoked when required and it incorporates the same motion planninf framework but in a reverse sense
The unity communication generates the approriate steering and velocity accoridng to the results of pathcontroller
The truck moves as intended in the unity avoiding collsions in the forward direction
and then reverses and docks itself in the chosen docking station:-)
