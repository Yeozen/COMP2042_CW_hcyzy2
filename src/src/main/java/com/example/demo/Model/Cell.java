package com.example.demo.Model;


import com.example.demo.Model.GameScene;
import com.example.demo.Model.TextMaker;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * public class that holds everything related to the individual blocks(cells) on the board
 */
public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;

    /**
     * setter method to changes value of modify
     * @param modify takes modify as input
     */
    void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * getter method to obtain value of modify
     * @return modify value of true/false
     */
    boolean getModify() {
        return modify;
    }

    /**
     * controls how the individual cell looks
     * @param x length
     * @param y height
     * @param scale how large
     * @param root the group
     */
    Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     * setter method to set the value of textClass
     * @param textClass takes textClass as input
     */
    void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * changes the cell
     * @param cell takes in a cell as its input
     */
    void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * combines 2 cells of same value into a higher value cell. E.g. 2+2 = 4
     * @param cell takes the cell to be combined
     */
    void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        GameScene.add = true;
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    /**
     * changes color of cell depending on what number it receives
     * @param number takes number as input
     */
    void setColorByNumber(int number) {
        switch (number) {
            case 0 -> rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
            case 2 -> rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
            case 4 -> rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
            case 8 -> rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
            case 16 -> rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
            case 32 -> rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
            case 64 -> rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
            case 128 -> rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
            case 256 -> rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
            case 512 -> rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
            case 1024 -> rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
            case 2048 -> rectangle.setFill(Color.rgb(250, 0, 0, 1));
        }

    }

    /**
     * @return x value of rectangle
     */
    double getX() {
        return rectangle.getX();
    }

    /**
     * @return y value of rectangle
     */
    double getY() {
        return rectangle.getY();
    }

    /**
     * getter method to obtain number of the cell
     * @return number of block/cell
     */
    int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }


}
