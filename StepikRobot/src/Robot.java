public class Robot {

    private Direction direction;
    private int x;
    private int y;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (direction){
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        switch (direction){
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {
        switch (direction){
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toX > robot.getX()) {
            while (robot.getDirection() != Direction.RIGHT) robot.turnRight();
        } else if (toX < robot.getX()) {
            while (robot.getDirection() != Direction.LEFT) robot.turnRight();
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }
        if (toY > robot.getY()) {
            while (robot.getDirection() != Direction.UP) robot.turnRight();
        } else if (toY < robot.getY()) {
            while (robot.getDirection() != Direction.DOWN) robot.turnRight();
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }



    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {

        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);

    }
}
