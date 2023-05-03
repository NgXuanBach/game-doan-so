package model;

import java.time.LocalDateTime;

public class Player implements Comparable<Player> {
    private int clickCount;
    LocalDateTime timeDone;

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getTimeDone() {
        return timeDone;
    }

    public void setTimeDone(LocalDateTime timeDone) {
        this.timeDone = timeDone;
    }

    @Override
    public int compareTo(Player o) {
        int compareQuantity = ((Player) o).getClickCount();

        //ascending order
        return this.clickCount - compareQuantity;

    }
}
