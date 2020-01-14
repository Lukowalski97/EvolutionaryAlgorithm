package model.AntLogic;
import org.junit.Before;
import org.junit.Test;
import utils.Point;

import static org.junit.Assert.*;

public class AntBoardTest {
    AntBoard board;
    AntBoard field;

    @Before
    public void init(){
        board = new AntBoard( 10 ,3);
    }

    @Test
    public void testToString() {
        String resultBoard = board.toString();
        assertNotEquals(null, resultBoard);
    }

    @Test
    public void chromosomePathAndResultToString() {
        String resultBoard = board.toString();
        assertNotEquals(null, resultBoard);

    }

    @Test
    public void getField() {
        AntBoardField gotField = board.getField(0, 0);
        assertNotEquals(null, gotField);
    }

    @Test
    public void isOnExitEdge() {
        Point point1 = new Point(9, 0);
        Point point3 = new Point(1, 2);
        Point point4 = new Point(1, 0);

        assertTrue(board.isOnExitEdge(point1));
        assertTrue(board.isOnExitEdge(point3));
        assertFalse(board.isOnExitEdge(point4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfBoardThrowing(){
        Point point2 = new Point(0, 10);
        board.isOnExitEdge(point2);
    }

    @Test
    public void areFieldsOnSameY() {
        int yValue = 3;
        AntBoardField field1 = new AntBoardField(0, 0, 0, yValue);
        AntBoardField field2 = new AntBoardField(0, 0, 0, yValue);
        AntBoardField field3 = new AntBoardField(0, 0, 0, yValue + 2);
        AntBoardField field4 = new AntBoardField(0, 0, 0, yValue + 2);
        assertTrue(board.areFieldsOnSameY(field1, field2));
        assertTrue(board.areFieldsOnSameY(field3, field4));
        assertFalse(board.areFieldsOnSameY(field1, field3));
    }
}