/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import gui.MyGUI;
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author hea113
 */
public class Lab2 {
    private static Robot robot = null; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        // Testing tool created      
        TestTool testTool = new TestTool();      
        testTool.setLocation(870, 90);
        testTool.setVisible(true);
        testTool.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        
               
        // event listener for the .Jar GUI application
        AWTEventListener ml = new AWTEventListener(){
            JTextField num1;
            JTextField num2;
            JTextField sum;
            JButton submitButton;
            int num1Count=0,num2Count=0, userClick=0;            
            @Override
            public void eventDispatched(AWTEvent event) {
                MouseEvent me = (MouseEvent) event;
                if(!testTool.getRecordButtonValue()){
                    mouseEvents.add(me);
                    System.out.println(me);
                }
                if(me.getID() == MouseEvent.MOUSE_CLICKED){
                    boolean allSelected = testTool.getCheckBox(1) && testTool.getCheckBox(2) && testTool.getCheckBox(3)
                                && testTool.getCheckBox(4);
                    try{
                        JTextField jtf = (JTextField) me.getSource();
                        int yCoord = jtf.getY(), xCoord = jtf.getX();               
                        // detects if num1 textbox is clicked
                        if(yCoord == 28){                           
                            if(allSelected == true){
                                num1 = jtf;
                                //num1.setText(Integer.toString(TestTool.num1InputFile.get(num1Count)));
                                //num1Count++;
                            }else{
                                testTool.setCheckBox(1);
                                testTool.setDirectionsLabel("Please click the second textbox!");
                            }
                        }
                        //detects if num2 textbox is clicked
                        if(yCoord == 108){
                            if(allSelected){
                                num2 = jtf;
                                //num2.setText(Integer.toString(TestTool.num2InputFile.get(num2Count)));
                                //num2Count++;
                            }else{
                                testTool.setCheckBox(2);
                                testTool.setDirectionsLabel("Please click the third textbox!");
                            }
                        }
                        // detects if the sum textbox is clicked
                        if(yCoord == 179){
                            if(allSelected){
                                if(isFileImported(TestTool.num1InputFile)){
                                    sum = jtf;
                                }
                            }else{
                                testTool.setCheckBox(3);
                                testTool.setDirectionsLabel("Please click the Submit Button!");
                            }
                        }
                    }catch(ClassCastException cce){
                        try{
                            if(testTool.getCheckBox(1) && testTool.getCheckBox(2) && testTool.getCheckBox(3)){
                                JButton jbt = (JButton) me.getSource();
                                submitButton = jbt;
                                testTool.setCheckBox(4);
                            }
                        }catch(ClassCastException cce2){
                            
                        }
                        // ok button is clicked
                        if(submitButton != null){
                            try{
                                if(userClick == 0){
                                    testTool.disableGUI(false);
                                }
                                userClick++;
                                //stores the numbers and prints them out to the textarea 
//                                int num1Input = Integer.parseInt(num1.getText());
//                                int num2Input = Integer.parseInt(num2.getText());
//                                int sumInput = Integer.parseInt(sum.getText());
//                                int diff = Math.abs((num1Input + num2Input) - sumInput);
//                                String validity = isValid(num1Input,num2Input,sumInput); 
//                                String textLine = "%s + %s = %s " + validity + " diff=" + diff +"\n";
//                                String textAreaText = num1Input + " +" + num2Input + " = " + sumInput + "       "+ validity +"    diff=" + diff +"\n"; 
//                                System.out.printf(textLine, num1.getText(),num2.getText(),sum.getText());
//                                printTextField(textAreaText);
                            }catch(NullPointerException npe){
                                //System.out.println("cool");
                            }
                        }
                    }      
                }
            }
            // prints the text field to the text area
            public void printTextField(String text) {
                testTool.validationTextArea.append(text);
            }
            
            // determines weather the case is valid or not
            private String isValid(int num1, int num2, int sum){
                if(num1 + num2 != sum){
                    return "Failed!";
                }
                return "Passed!";
            } 
        };
        tk.addAWTEventListener(ml, AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK); 
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param delay
     * simulates a mouse click with the robot
     * @throws AWTException 
     */
    public static void simulateMouseClick(int x,int y,int delay) throws AWTException{
        robot = new Robot();
        robot.mouseMove(x, y);
        robot.delay(delay);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
    }

    /**
     * 
     * @param delay
     * robot clicks all the text boxes then submits
     * @throws AWTException 
     */
    public static void robotAdd(int delay) throws AWTException{
        int guiXLoc = TestTool.getGuiXLoc();
        int guiYLoc = TestTool.getGuiYLoc();
        // simulates the robot clicks
        for(int i=0;i<20;i++){
            Lab2.simulateMouseClick(guiXLoc + 300, guiYLoc + 80, delay);
            Lab2.simulateMouseClick(guiXLoc + 300, guiYLoc + 160, delay);
            Lab2.simulateMouseClick(guiXLoc + 300, guiYLoc + 240, delay);
            Lab2.simulateMouseClick(guiXLoc + 290, guiYLoc + 360, delay);
        }   
    }
    
    /**
     * 
     * @param array
     * determines if the file is imported
     * @return weather the file is imported or not 
     */
    public static boolean isFileImported(ArrayList array){
        if(array.size() == 0){
            return false;
        }
        return true;
    }
    // array list that holds all the mouse events
    public static ArrayList<MouseEvent> mouseEvents = new ArrayList<MouseEvent>();
    /**
     * trims the mouse events from the back of the array to remove when the users presses the stop button 
     */   
    public static void trimBack(){
        do{
            mouseEvents.remove(mouseEvents.size()-1);
        }while(mouseEvents.get(mouseEvents.size() - 1).getID() == MouseEvent.MOUSE_CLICKED);
    }
    /**
     * trims the mouse events from the front of the array to remove when the user presses the record button
     */
    public static void trimFront(){
        do{
            mouseEvents.remove(0);
        }while(mouseEvents.get(0).getID() == MouseEvent.MOUSE_CLICKED);
    }
    // empties the events array incase user wants to record again a new pattern
    public static void emptyEventsArray(){
        mouseEvents.removeAll(mouseEvents);
    }
    /**
     * 
     * @param delay
     * @param arrayElem
     * mimics the mouses movement from when the user presses record till the user presses stop
     * @throws AWTException 
     */
    public static void  mimicMouseMovement(int delay, int arrayElem) throws AWTException{
        robot = new Robot();
        trimBack();
        trimFront();
        int mouseClickedTimes=0;
        // iterates through each mouse event and moves the mouse to each location the user was on
        for(int i=0;i<mouseEvents.size();i++){
            robot.mouseMove(mouseEvents.get(i).getXOnScreen(), mouseEvents.get(i).getYOnScreen());
            //obtains the timestamp of the each next event and current event to measure the proper time between each even
            //for the speed
            if(i < mouseEvents.size()-1){
                robot.delay((int) ((int)mouseEvents.get(i+1).getWhen() - mouseEvents.get(i).getWhen()));
            }            
            switch(mouseEvents.get(i).getID()){
                case MouseEvent.MOUSE_CLICKED:
                    robot.mousePress(MouseEvent.BUTTON1_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_MASK);
                    inputText(mouseClickedTimes, arrayElem);
                    mouseClickedTimes++;
                    break;
            }
        }
    }
    /**
     * 
     * @param mouseClickedTimes
     * @param arrayElem
     * inputs the the numbers into the text field from each Array list
     */
    public static void inputText(int mouseClickedTimes, int arrayElem){
        String fileNum1 = Integer.toString(TestTool.num1InputFile.get(arrayElem));
        String fileNum2 = Integer.toString(TestTool.num2InputFile.get(arrayElem));
        
        if(mouseClickedTimes == 0){
            removeAllInTextBox(arrayElem,1);
            for(int i=0;i<fileNum1.length();i++){
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(fileNum1.charAt(i)));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(fileNum1.charAt(i)));
                robot.delay(1000);
                //TestTool.validationTextArea.append(fileNum1.charAt(i)));
            }
        }else if(mouseClickedTimes == 1){
            removeAllInTextBox(arrayElem,2);
            for(int i=0;i<fileNum2.length();i++){
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(fileNum2.charAt(i)));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(fileNum2.charAt(i)));
                robot.delay(1000);
            }
        }        
    }
    /**
     * 
     * @param arrayElem
     * @param numOfArray
     * removes all the characters currently in each textbox for the new numbers
     */
    public static void removeAllInTextBox(int arrayElem, int numOfArray){
        if(arrayElem>0){
            if(numOfArray == 1){
                numOfArray = TestTool.num1InputFile.get(arrayElem-1);
            }else{
                numOfArray = TestTool.num2InputFile.get(arrayElem-1);
            }
            String lastNum = Integer.toString(numOfArray);
            int cutOff= lastNum.length(), start=0;
            while(start<cutOff){
                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                start++;
            }
        }
    }
}

