package es.jaberoma.aoc.day5;

public class MatchingSeatIds {

    int seatId1;
    int seatId2;

    public MatchingSeatIds(int seatId1, int seatId2) {
        this.seatId1 = seatId1;
        this.seatId2 = seatId2;
    }

    public int getSeatId1() {
        return seatId1;
    }

    public int getSeatId2() {
        return seatId2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingSeatIds that = (MatchingSeatIds) o;
        return (seatId1 == that.seatId1 && seatId2 == that.seatId2) ||
                (seatId1 == that.seatId2 && seatId2 == that.seatId1);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int seatIdInBetween() {
        return seatId1 > seatId2 ? seatId1 - 1 : seatId2 - 1;
    }
}
