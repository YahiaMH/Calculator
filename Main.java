/////////////////////////////////////////////
// ICS4U
// Practicing with GUIs
// The Calculator
////////////////////////////////////////////

import javax.swing.*;
import java.util.EventObject;

class Main{
  public static JButton calcButton (String label){
    JButton newB = new JButton(label);
    JBox.setSize(newB, 75, 75);
    return newB;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Calculator");
    frame.setSize(400, 400); // 800 pixels wide, 800 pixels tall
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    // The Buttons
    JLabel display = new JLabel("0");
    JBox.setSize(display, 400, 75);
    frame.add(display);

    JButton bNum0 = calcButton("0");
    JButton bNum1 = calcButton("1");
    JButton bNum2 = calcButton("2");
    JButton bNum3 = calcButton("3");
    JButton bNum4 = calcButton("4");
    JButton bNum5 = calcButton("5");
    JButton bNum6 = calcButton("6");
    JButton bNum7 = calcButton("7");
    JButton bNum8 = calcButton("8");
    JButton bNum9 = calcButton("9");
    JButton bDeci = calcButton(".");
    JButton bNegative = calcButton("+/-");
    JButton bClear = calcButton("C");
    JButton bPlus = calcButton("+");
    JButton bMinus = calcButton("-");
    JButton bMultiply = calcButton("x");
    JButton bDivide = calcButton("÷");
    JButton bEquals = new JButton("=");
    JBox.setSize(bEquals, 75, 150);
    JBox.setSize(bClear, 75, 150);
    
    display.setHorizontalAlignment(SwingConstants.RIGHT);

    JBox layout = JBox.vbox(
      display, 
    JBox.hbox(
      JBox.vbox(
        JBox.hbox(bNum7,bNum8, bNum9), 
        JBox.hbox(bNum4, bNum5, bNum6),
        JBox.hbox(bNum1, bNum2, bNum3),
        JBox.hbox(bDeci, bNum0, bNegative)),
        JBox.hglue(),
        JBox.vbox(
          bPlus,
          bMinus,
          bMultiply,
          bDivide
        ),
        JBox.hglue(),
        JBox.vbox(bClear, bEquals))
    );
    frame.add(layout);

    frame.setVisible(true);

    JEventQueue events = new JEventQueue();

    events.listenTo(bNum0, "0");
    events.listenTo(bNum1, "1");
    events.listenTo(bNum2, "2");
    events.listenTo(bNum3, "3");
    events.listenTo(bNum4, "4");
    events.listenTo(bNum5, "5");
    events.listenTo(bNum6, "6");
    events.listenTo(bNum7, "7");
    events.listenTo(bNum8, "8");
    events.listenTo(bNum9, "9");
    events.listenTo(bDeci, ".");
    events.listenTo(bPlus, "+");
    events.listenTo(bMinus, "-");
    events.listenTo(bMultiply, "x");
    events.listenTo(bDivide, "÷");
    events.listenTo(bEquals, "=");
    events.listenTo(bNegative, "+/-");
    events.listenTo(bClear, "C");

    String whatIsShowing = "0";
    double [] value = new double[10];
    char [] operation = new char [10];

    int i = 0;
    int s = 0;

    while(true){
      EventObject event = events.waitEvent();
      String whatHappened = events.getName(event);
      
      
      if(whatHappened.equals("0")){
        if(whatIsShowing.equals("0")){

        }else{
          whatIsShowing = whatIsShowing + "0";
        }
        display.setText(whatIsShowing);
      }

      
      if(whatHappened.equals("1")){
        if(whatIsShowing.equals("1")){

        }else{
          whatIsShowing = whatIsShowing + "1";
        }
        display.setText(whatIsShowing);
      }
      
      if(whatHappened.equals("2")){
        if(whatIsShowing.equals("2")){

        }else{
          whatIsShowing = whatIsShowing + "2";
        }
        display.setText(whatIsShowing);
      }
      
      if(whatHappened.equals("3")){
        if(whatIsShowing.equals("3")){

        }else{
          whatIsShowing = whatIsShowing + "3";
        }
        display.setText(whatIsShowing);
      }
      
      if(whatHappened.equals("4")){
        if(whatIsShowing.equals("4")){

        }else{
          whatIsShowing = whatIsShowing + "4";
        }
        display.setText(whatIsShowing);
      }
      
      if(whatHappened.equals("5")){
        if(whatIsShowing.equals("5")){

        }else{
          whatIsShowing = whatIsShowing + "5";
        }
        display.setText(whatIsShowing);
      }
      
      if(whatHappened.equals("6")){
        if(whatIsShowing.equals("6")){

        }else{
          whatIsShowing = whatIsShowing + "6";
        }
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("7")){
        if(whatIsShowing.equals("7")){

        }else{
          whatIsShowing = whatIsShowing + "7";
        }
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("8")){
        if(whatIsShowing.equals("8")){

        }else{
          whatIsShowing = whatIsShowing + "8";
        }
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("9")){
        if(whatIsShowing.equals("9")){

        }else{
          whatIsShowing = whatIsShowing + "9";
        }
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("=")){
        double answer = value[0];
        for(int r = 1; r<=s; r++){
          value[s] = Double.parseDouble(whatIsShowing);
          
            switch(operation[r-1]){
          case '+':
            answer = answer+value[r];
            break;
          case '-':
            answer = answer-value[r];
            break;
          case 'x':
            answer = answer*value[r];
            break;
          case '÷':
            answer = answer/value[r];
            break;
        }
          
          
        }
        whatIsShowing = "0";
        display.setText(""+answer);
        for(int e = 0; e<value.length;e++){
          value[e] = 0;
          operation[e] = ' ';
        }
        s = 0;
        i = 0;
      }
      if(whatHappened.equals("+")){
        operation[s] = '+';
        value[s] = Double.parseDouble(whatIsShowing);
        whatIsShowing = "0";
        s++;
        i = 0;
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("-")){
        operation[s] = '-';
        value[s] = Double.parseDouble(whatIsShowing);
        whatIsShowing = "0";
        s++;
        i = 0;
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("x")){
        operation[s] = 'x';
        value[s] = Double.parseDouble(whatIsShowing);
        whatIsShowing = "0";
        s++;
        i = 0;
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals("÷")){
        operation[s] = '÷';
        value[s] = Double.parseDouble(whatIsShowing);
        whatIsShowing = "0";
        s++;
        i = 0;
        display.setText(whatIsShowing);
      }
      if(whatHappened.equals(".")){
        if(i>0){
        }else{
        whatIsShowing = whatIsShowing + ".";
        display.setText(whatIsShowing);
        i++;
        }

      }
      if(whatHappened.equals("C")){
        for(int e = 0; e<value.length;e++){
          value[e] = 0;
          operation[e] = ' ';
        }
        s = 0;
        i = 0;
          whatIsShowing = "0";
        display.setText(whatIsShowing);
      }

      if(whatHappened.equals("+/-")){
        if(whatIsShowing.charAt(0) == '-'){
          String [] split = whatIsShowing.split("-");
          whatIsShowing = split[1];
        }else{
          whatIsShowing = "-" + whatIsShowing;
        }
        display.setText(whatIsShowing);
      }
      

    }
    
  }
}