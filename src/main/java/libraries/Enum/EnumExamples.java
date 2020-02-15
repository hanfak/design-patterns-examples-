package libraries.Enum;

public class EnumExamples {
    public static void main(String[] args) {
        Direction aDirection = Direction.EAST;
        System.out.println("aDirection = " + aDirection);

        int ordinal = Direction.WEST.ordinal();
        System.out.println("ordinal = " + ordinal);

        String nameOfEnum = Direction.NORTH.name();
        System.out.println("nameOfEnum = " + nameOfEnum);

        for (Laugh cmd : Gender.values()) {
            System.out.println(cmd.execute());
        }

        int levelValue = Level.LOW.getLevelValue();
        System.out.println("levelValue = " + levelValue);

    }
}


enum Direction {
    EAST, SOUTH, WEST, NORTH // Generally all capitals
}


interface Laugh {
    String execute();
}

enum Gender implements Laugh {
    FEMALE {
        @Override
        public String execute() {
            return "HA HA";
        }
    },
    MALE {
        @Override
        public String execute() {
            return "Ho HO";
        }
    };

    @Override
    public abstract String execute();
}

enum Level {
    LOW(30), MEDIUM(15), HIGH(7), URGENT(1);

    private int levelValue;

    private Level(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }
}