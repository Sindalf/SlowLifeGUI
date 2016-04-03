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

    
    @Test
    public void testGetAlive() {
        Cell cell = new Cell();
        assertEquals(cell.getAlive(),cell.OldgetAlive());
        cell.setAlive(true);
        assertEquals(cell.getAlive(),cell.OldgetAlive());
        cell.setAlive(false);
        assertEquals(cell.getAlive(),cell.OldgetAlive());
    }

    /*
    * Tests backup functinality for equal behavior 
    * New method intilizes the _backup array once while
    * the old version makes a new cell object every single time
    * this function is called. 
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

    /**
     * Tests toString functionality for equal behavior
     */
    @Test
    public void TestToString() {
        Cell cell = new Cell();
        assertEquals(cell.toString(), cell.OldtoString());
        cell = new Cell(true);
        assertEquals(cell.toString(), cell.OldtoString());
        cell = new Cell(false);
        assertEquals(cell.toString(), cell.OldtoString());
    }

}
