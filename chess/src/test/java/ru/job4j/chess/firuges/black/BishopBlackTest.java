package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {
    @Test
    public void whenBishopPosihion() {
        BishopBlack BB = new BishopBlack(Cell.A1);
        assertThat(BB.position()).isEqualByComparingTo(Cell.A1);
    }

    @Test
    public void whenBishopCopy() {
        BishopBlack BB = new BishopBlack(Cell.A1);
        assertThat(BB.copy(Cell.B2).position()).isEqualByComparingTo(Cell.B2);
    }

    @Test
    public void whenWayC1ToG5() {
        BishopBlack BB = new BishopBlack(Cell.C1);
        Cell[] rsl = BB.way(Cell.G5);
        Cell[] expected = new Cell[]{
                Cell.D2,
                Cell.E3,
                Cell.F4,
                Cell.G5
        };
        Assertions.assertArrayEquals(expected, rsl);
    }

    @Test
    public void whenWayC1NotToC3() {
        BishopBlack BB = new BishopBlack(Cell.C1);
        Assertions.assertThrows(ImpossibleMoveException.class, () -> {
            BB.way(Cell.C3);
        });
    }
}