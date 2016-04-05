
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Cell extends JButton {

    public boolean _beenAlive = false;

    private int _maxSize = 10000;
    public boolean alive = false;

    public Cell() {
        super(" ");
        setFont(new Font("Courier", Font.PLAIN, 12));
        addActionListener(new CellButtonListener());
    }

    public Cell(boolean alive) {
        super(" ");
        setFont(new Font("Courier", Font.PLAIN, 12));
        addActionListener(new CellButtonListener());
        setAlive(alive);
    }

    public void resetBeenAlive() {
        _beenAlive = false;
    }

    public void reset() {
        resetBeenAlive();
        setAlive(false);
    }

    public boolean getAlive() {
        return (alive);
    }

    public boolean OldgetAlive() {
        String text = getText();
        return (text.equals("X"));
    }

    @Override
    public String toString() {
        if (alive) {
            return "X";
        } else {
            return ".";
        }
    }

    public String OldtoString() {
        String toReturn = new String("");
        String currentState = getText();
        for (int j = 0; j < _maxSize; j++) {
            toReturn += currentState;
        }
        if (toReturn.substring(0, 1).equals("X")) {
            return toReturn.substring(0, 1);
        } else {
            return ".";
        }
    }

    public void setAlive(boolean a) {
        // note that "if (a)" and "if (a == true)"
        // really say the same thing!
        if (a) {
            _beenAlive = true;
            alive = true;
            setText("X");
            setBackground(Color.RED);
        } else {
            setText(" ");
            alive = false;
            if (_beenAlive) {
                setBackground(Color.GREEN);
            } else {
                setBackground(Color.GRAY);
            }
        }
        setContentAreaFilled(true);
        setOpaque(true);
    }
    
    public void OldsetAlive(boolean a) {
	// note that "if (a)" and "if (a == true)"
	// really say the same thing!
	if (a) {
	    _beenAlive = true;
	    setText("X");
	    setBackground(Color.RED);
	} else {
	    setText(" ");
	    if (_beenAlive) {
		setBackground(Color.GREEN);
	    } else {
		setBackground(Color.GRAY);
	    }
	}
	setContentAreaFilled(true);
        setOpaque(true);
    }

    class CellButtonListener implements ActionListener {

        // Every time we click the button, it will perform
        // the following action.
        public void actionPerformed(ActionEvent e) {
            Cell source = (Cell) e.getSource();
            //String currentText = source.getText();
            resetBeenAlive();
            if (alive == false) {
                setAlive(true);
            } else if (alive == true) {
                setAlive(false);
            } else {
                // This shouldn't happen
                setAlive(false);
            }
        }

    }

}
