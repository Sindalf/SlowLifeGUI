/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/*
* All tests test for functionality, not expected output
 */
public class GameOfLifeTest {

    /*
    Testing true behavior in getalive
     */
    @Test
    public void testGetAliveTrue() {
        Cell cell = new Cell(true);
        assertEquals(cell.getAlive(), cell.OldgetAlive());
    }

    /*
    testing false behavior in getalive
     */
    @Test
    public void testGetAliveFalse() {
        Cell cell = new Cell(false);
        assertEquals(cell.getAlive(), cell.OldgetAlive());
    }

    /*
    Making sure get alive works with default behavior
     */
    @Test
    public void testGetAliveDefault() {
        Cell cell = new Cell();
        assertEquals(cell.getAlive(), cell.OldgetAlive());
    }

    /*
    Test that set alive text is still displays given the change in variables
     */
    @Test
    public void testSetAliveTrue() {
        Cell cell = new Cell();
        Cell cell2 = new Cell();
        cell.setAlive(true);
        cell2.OldsetAlive(true);
        assertEquals(cell.getText(), cell2.getText());
    }

    /*
    Testing that seeting something false should create the behavior
     */
    @Test
    public void testSetAliveFalse() {
        Cell cell = new Cell();
        Cell cell2 = new Cell();
        cell.setAlive(false);
        cell2.OldsetAlive(false);
        assertEquals(cell.getText(), cell2.getText());
    }

    /*
    Testing that the variables in setAlive are equilivent 
    to the variable they replaced
     */
    @Test
    public void testSetAliveVariableEquivlence() {
        Cell cell = new Cell();
        Cell cell2 = new Cell();
        cell.setAlive(false);
        cell2.setAlive(false);
        assertNotEquals(cell.alive, cell2.getText().equals(" "));

        cell.setAlive(true);
        cell2.setAlive(true);
        assertEquals(cell.alive, cell2.getText().equals("X"));
    }

    /*
    * Tests backup functinality for equal behavior 
    * New method intilizes the _backup array once while
    * the old version makes a new cell object every single time
    * this function is called. 
    * All unit tests are combined into one test for simplicity. 
    * Exhaustively test the variables in Cell. 
     */
    @Test
    public void TestBackup() {
        MainPanel p = new MainPanel(10);
        MainPanel q = new MainPanel(10, true);
        p.backup();
        q.Oldbackup();
        Cell[][] cell1 = p.getbackup();
        Cell[][] cell2 = q.getbackup();
        for (int i = 0; i < cell1.length; i++) {
            for (int j = 0; j < cell1.length; j++) {
                assertEquals(cell1[i][j].getAlive(), cell2[i][j].getAlive());
                assertEquals(cell1[i][j].getAlive(), false);

            }
        }

        cell1 = p.getCells();
        cell2 = q.getCells();
        for (int i = 0; i < cell1.length; i++) {
            for (int j = 0; j < cell1.length; j++) {
                int comp = (int) (100 * Math.random());
                if (comp > 50) {
                    cell1[i][j].setAlive(true);
                    cell2[i][j].setAlive(true);
                }
            }
        }

        p.backup();
        q.Oldbackup();
        cell1 = p.getbackup();
        cell2 = q.getbackup();
        for (int i = 0; i < cell1.length; i++) {
            for (int j = 0; j < cell1.length; j++) {
                assertEquals(cell1[i][j].getAlive(), cell2[i][j].getAlive());
                assertEquals(cell1[i][j]._beenAlive, cell2[i][j]._beenAlive);
                assertEquals(cell1[i][j].getText(), cell2[i][j].getText());
                assertEquals(cell1[i][j].getBackground(), cell2[i][j].getBackground());
            }
        }
    }

    /*
    Tests convertToInt for equal behavior.
    Tested up to 100k ints but is slow. All tests passed up to 100k
     */
    @Test
    public void TestConvertToInt() {
        MainPanel p = new MainPanel(1);
        for (int i = 0; i < 10000; i++) {
            assertEquals(p.convertToInt(i), p.OldconvertToInt(i));

        }
    }

    /*
     Tests convertToInt for equal behavior
     */
    @Test
    public void TestConvertToNegativeInt() {
        MainPanel p = new MainPanel(1);
        for (int i = 0; i > -10000; i--) {
            assertEquals(p.convertToInt(i), p.OldconvertToInt(i));
        }
    }

    /*
    Testing max value of int with convert to int
     */
    @Test
    public void TestConvertToMaxInt() {
        MainPanel p = new MainPanel(1);
        assertEquals(p.convertToInt(Integer.MAX_VALUE), p.OldconvertToInt(Integer.MAX_VALUE));
    }

    /**
     * Tests toString functionality for equal behavior. Testing default behavior
     */
    @Test
    public void TestToStringDefault() {
        Cell cell = new Cell();
        assertEquals(cell.toString(), cell.OldtoString());
    }

    /**
     * Tests toString functionality for equal behavior. Testing true behavior
     */
    @Test
    public void TestToStringTrue() {
        Cell cell = new Cell(true);
        assertEquals(cell.toString(), cell.OldtoString());
    }

    /**
     * Tests toString functionality for equal behavior. Testing false behavior
     */
    @Test
    public void TestToStringFalse() {
        Cell cell = new Cell(false);
        assertEquals(cell.toString(), cell.OldtoString());
    }
}
