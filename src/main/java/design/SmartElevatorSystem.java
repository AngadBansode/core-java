package design;

import java.util.*;

// Class representing an elevator
class Elevator {
    private int id;
    private int currentFloor;
    private String direction; // "up", "down", "idle"
    private PriorityQueue<Integer> destinationQueue;

    public Elevator(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.direction = "idle";
        this.destinationQueue = new PriorityQueue<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getDirection() {
        return direction;
    }

    public PriorityQueue<Integer> getDestinationQueue() {
        return destinationQueue;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void addDestination(int floor) {
        destinationQueue.add(floor);
        updateDirection();
    }

    public void move() {
        if (!destinationQueue.isEmpty()) {
            int nextFloor = destinationQueue.poll();
            System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to floor " + nextFloor);
            currentFloor = nextFloor;
            updateDirection();
        } else {
            direction = "idle";
        }
    }

    private void updateDirection() {
        if (destinationQueue.isEmpty()) {
            direction = "idle";
        } else if (destinationQueue.peek() > currentFloor) {
            direction = "up";
        } else {
            direction = "down";
        }
    }
}

// Class representing the elevator controller
class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(int numberOfElevators, int startingFloor) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= numberOfElevators; i++) {
            elevators.add(new Elevator(i, startingFloor));
        }
    }

    public void requestElevator(int userFloor, String direction) {
        Elevator bestElevator = null;
        int minTime = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int responseTime = calculateResponseTime(elevator, userFloor, direction);
            if (responseTime < minTime) {
                minTime = responseTime;
                bestElevator = elevator;
            }
        }

        if (bestElevator != null) {
            System.out.println("Assigning Elevator " + bestElevator.getId() + " to user on floor " + userFloor);
            bestElevator.addDestination(userFloor);
        }
    }

    private int calculateResponseTime(Elevator elevator, int userFloor, String direction) {
        if (elevator.getDirection().equals("idle")) {
            return Math.abs(elevator.getCurrentFloor() - userFloor);
        }

        if ((direction.equals("up") && elevator.getDirection().equals("up") && userFloor >= elevator.getCurrentFloor()) ||
                (direction.equals("down") && elevator.getDirection().equals("down") && userFloor <= elevator.getCurrentFloor())) {
            return Math.abs(elevator.getCurrentFloor() - userFloor);
        }

        return Integer.MAX_VALUE; // High cost for incompatible directions
    }

    public void moveElevators() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }
}

// Main class
public class SmartElevatorSystem {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2, 0);

        // Simulate user requests
        controller.requestElevator(6, "up");
        controller.requestElevator(3, "down");

        // Simulate elevator movements
        for (int i = 0; i < 5; i++) {
            controller.moveElevators();
        }
    }
}
