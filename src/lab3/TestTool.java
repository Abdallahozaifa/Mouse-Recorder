/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import gui.MyGUI;
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hea113
 */
public class TestTool extends javax.swing.JFrame {

    /**
     * Creates new form TestTool
     */
    public TestTool() {
        initComponents();
        setMGUI();        
    }

    // GUI Frame
    public static MyGUI mgui = new MyGUI();
    // sets the properties for the GUI
    private void setMGUI(){
        mgui.setLocation(200, 90);
        mgui.setSize(500,400);
        mgui.setVisible(true);
        mgui.setResizable(false);
    } 
    
    // ArrayList to store the first,second, and expected sum digit    
    public static ArrayList<Integer> num1InputFile = new ArrayList();
    public static ArrayList<Integer> num2InputFile = new ArrayList();
    public static ArrayList<Integer> expectedSum = new ArrayList();
    public JFileChooser testingFileChooser = new JFileChooser(new File("").getAbsolutePath()); // allows users to select a file
    
    public void disableGUI(boolean isDisabled){
        mgui.setEnabled(isDisabled);
        System.out.println("Whats up!");
    }
    public void setCheckBox(int num){
        switch(num){
            case 1:
                num1CheckBox.doClick();
                num1CheckBox.setEnabled(false);
                break;
            case 2:
                num2CheckBox.doClick();
                num2CheckBox.setEnabled(false);
                break;
            case 3:
                sumCheckBox.doClick();
                sumCheckBox.setEnabled(false);
                break;
            case 4:
                submitButtonCheckBox.doClick();
                submitButtonCheckBox.setEnabled(false);
                break;
        }
    }
    
    public boolean getCheckBox(int num){
        boolean isSelected = false;
        switch(num){
            case 1:
                isSelected = num1CheckBox.isSelected();
                break;
            case 2:
                isSelected = num2CheckBox.isSelected();
                break;
            case 3:
                isSelected = sumCheckBox.isSelected();
                break;
            case 4:
                isSelected = submitButtonCheckBox.isSelected();
                break;
        }
        return isSelected;
    }
    
    // determines weather a file is selected or not
    private boolean fileSelected(){
        if(testingFileChooser.getSelectedFile() == null){
            return false;
        }
        return true;
    }
    
    // obtains the selected files name
     private String getSelectedFileName(){
        String selectedFile = null;
        if(fileSelected()){
            selectedFile = testingFileChooser.getSelectedFile().getName();
        }
        return selectedFile;
    }
     
     //validates the file to make sure it has the .txt extension
    private boolean validateFile(){
        String extension = null;
        String acceptedExtension = "txt";
        if(fileSelected()){
            extension = getSelectedFileName().substring(getSelectedFileName().lastIndexOf(".") + 1, getSelectedFileName().length());
            if (!extension.equals(acceptedExtension)) {
                JOptionPane.showMessageDialog(null, "Please select your Text File!", "Error", JOptionPane.ERROR_MESSAGE);
                testingFileChooser.showDialog(new JFrame(""), null);
                return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Upload Successful!");    
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    // reads the file
    private void readFile(String fileName){
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =  new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

           // reads the text and adds it to 3 separate arrays
            while((line = bufferedReader.readLine()) != null) {
                String firstNum = line.substring(0, line.indexOf(" "));
                String[] nums = line.split(" ");
                num1InputFile.add(Integer.parseInt(nums[0]));
                num2InputFile.add(Integer.parseInt(nums[1]));
                expectedSum.add(Integer.parseInt(nums[2]));              
        }   

        // Always close files.
        bufferedReader.close();         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
    }
    
    // obtains the GUI's x and y location on the screen for the robot
    public static int getGuiXLoc(){
        return mgui.getLocation().x;
    }
    public static int getGuiYLoc(){
        return mgui.getLocation().y;
    }
    
    public void setDirectionsLabel(String directionsText){
        directionsLabel.setText(directionsText);
    }
    
    public void setRecordButton(boolean enabled){
        recordButton.setEnabled(enabled);
    }
    public boolean getRecordButtonValue(){
        boolean recordButtonEnabled = recordButton.isEnabled();
        if(recordButtonEnabled && !fileSelected()){
            mgui.setEnabled(false);
        }else{
            mgui.setEnabled(true);
        }
        return recordButtonEnabled;
    }
    
    public long getBeginTime(){
        return System.currentTimeMillis();
    }
    
    public static void printToTextField(String text){
        validationTextArea.append(text);
    }
    long[] time = new long[2];
    int arrayElem=0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        importFileButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        validationTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        num1CheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        num2CheckBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        sumCheckBox = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        submitButtonCheckBox = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        recordButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        directionsLabel = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TestTool", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        importFileButton.setText("Start Test");
        importFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFileButtonActionPerformed(evt);
            }
        });

        validationTextArea.setColumns(20);
        validationTextArea.setRows(5);
        jScrollPane1.setViewportView(validationTextArea);

        num1CheckBox.setText("Number 1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(num1CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(num1CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        num2CheckBox.setText("Number 2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(num2CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(num2CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sumCheckBox.setText("Sum");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sumCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sumCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        submitButtonCheckBox.setText("Submit Button");
        submitButtonCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitButtonCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitButtonCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        recordButton.setText("Record");
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });
        jPanel6.add(recordButton);

        directionsLabel.setText("Please Select the Record Button!");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(directionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(directionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7);

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jPanel6.add(stopButton);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to Test Tool 1.0");
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(importFileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileButtonActionPerformed
        // specifies location and shows the JFileChooser      
        int guiXLoc = mgui.getLocation().x;
        int guiYLoc = mgui.getLocation().y;
        testingFileChooser.showDialog(new JFrame(""), null);
        
        //sees weather a file is selected or not
        if(testingFileChooser.getSelectedFile() != null){
            File selectedFile = testingFileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            
            //validates the file
            if(validateFile()){
                //mgui.setEnabled(true);
                readFile(fileName);
                    new Thread(() -> {
                    try{
                        mgui.setEnabled(true);
                        //Lab2.robotAdd(100);
                        int timeTaken = (int) (time[1] - time[0]);
                        while(arrayElem < 4){
                            Lab2.mimicMouseMovement(timeTaken, arrayElem);
                            arrayElem++;
                        }
                        mgui.setEnabled(false);
                    }catch (AWTException ex) {
                        Logger.getLogger(TestTool.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start();
            }
        }
    }//GEN-LAST:event_importFileButtonActionPerformed

    private void submitButtonCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonCheckBoxActionPerformed

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        Lab2.emptyEventsArray();
        setDirectionsLabel("Please Click the first textbox!");
        setRecordButton(false);
        long timeNow = System.currentTimeMillis();
        time[0] = timeNow;
        System.out.println(timeNow);
    }//GEN-LAST:event_recordButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        JButton castedRecordButtonc = (JButton) evt.getSource();
        setRecordButton(true);
        disableGUI(true);
        setDirectionsLabel("Please start test now!");
        long timeNow = System.currentTimeMillis();
        time[1] = timeNow;
        System.out.println(time[1] - time[0]);
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestTool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestTool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel directionsLabel;
    private javax.swing.JButton importFileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox num1CheckBox;
    private javax.swing.JCheckBox num2CheckBox;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JCheckBox submitButtonCheckBox;
    private javax.swing.JCheckBox sumCheckBox;
    public static javax.swing.JTextArea validationTextArea;
    // End of variables declaration//GEN-END:variables
}
