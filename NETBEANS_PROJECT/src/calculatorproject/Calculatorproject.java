package calculatorproject;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Calculatorproject extends Frame implements ActionListener, WindowListener {
  private final TextField textField;
  private double num1, num2;
  private String operator;
  private Image image;
  Calculatorproject() {
    super("Advanced Calculator Project");
    setLayout(null);
    try{
    image = ImageIO.read(getClass().getResource("bg.jpg"));
    }catch (IOException e) {
    }
    Canvas canvas; 
      canvas = new Canvas() {
          @Override
          public void paint(Graphics graphics) {
              graphics.drawImage(image, 0, 0, null);
          } 
      };
    textField = new TextField();
    textField.setBounds(10, 40, 305, 50);
    textField.setEditable(false);
    textField.setFont(new Font("Arial", Font.BOLD, 20));
    add(textField);
    Button zeroButton = new Button("0");
    zeroButton.setBounds(95, 400, 80, 50);
    zeroButton.addActionListener(this);
    add(zeroButton);
    Button calcButton = new Button("=");
    calcButton.setBounds(265, 400, 50, 50);
    calcButton.addActionListener(this);
    add(calcButton);
    Button resetButton = new Button("C");
    resetButton.setBounds(10, 400, 80, 50);
    resetButton.addActionListener(this);
    add(resetButton);
    Button oneButton = new Button("1");
    oneButton.setBounds(10, 340, 80, 50);
    oneButton.addActionListener(this);
    add(oneButton);
    Button twoButton = new Button("2");
    twoButton.setBounds(95, 340, 80, 50);
    twoButton.addActionListener(this);
    add(twoButton);
    Button threeButton = new Button("3");
    threeButton.setBounds(180, 340, 80, 50);
    threeButton.addActionListener(this);
    add(threeButton);
    Button fourButton = new Button("4");
    fourButton.setBounds(10, 280, 80, 50);
    fourButton.addActionListener(this);
    add(fourButton);
    Button fiveButton = new Button("5");
    fiveButton.setBounds(95, 280, 80, 50);
    fiveButton.addActionListener(this);
    add(fiveButton);
    Button sixButton = new Button("6");
    sixButton.setBounds(180, 280, 80, 50);
    sixButton.addActionListener(this);
    add(sixButton);
    Button sevenButton = new Button("7");
    sevenButton.setBounds(10, 220, 80, 50);
    sevenButton.addActionListener(this);
    add(sevenButton);
    Button eightButton = new Button("8");
    eightButton.setBounds(95, 220, 80, 50);
    eightButton.addActionListener(this);
    add(eightButton);
    Button nineButton = new Button("9");
    nineButton.setBounds(180, 220, 80, 50);
    nineButton.addActionListener(this);
    add(nineButton);
    Button plusButton = new Button("+");
    plusButton.setBounds(265, 280, 50, 50);
    plusButton.addActionListener(this);
    add(plusButton);
    Button minusButton = new Button("-");
    minusButton.setBounds(265, 220, 50, 50);
    minusButton.addActionListener(this);
    add(minusButton);
    Button multiplyButton = new Button("*");
    multiplyButton.setBounds(265, 160, 50, 50);
    multiplyButton.addActionListener(this);
    add(multiplyButton);
    Button divideButton = new Button("/");
    divideButton.setBounds(265, 100, 50, 50);
    divideButton.addActionListener(this);
    add(divideButton);
    Button dotButton = new Button(".");
    dotButton.setBounds(95, 340, 80, 50);
    dotButton.addActionListener(this);
    add(dotButton);
    Button negButton = new Button("Neg");
    negButton.setBounds(10, 100, 80, 50);
    negButton.addActionListener(this);
    add(negButton);
    Button sqrtButton = new Button("√");
    sqrtButton.setBounds(95, 100, 80, 50);
    sqrtButton.addActionListener(this);
    add(sqrtButton);
    Button eButton = new Button("e");
    eButton.setBounds(180, 100, 80, 50);
    eButton.addActionListener(this);
    add(eButton);
    Button powerButton = new Button("^");
    powerButton.setBounds(265, 340, 50, 50);
    powerButton.addActionListener(this);
    add(powerButton);
    Button factorialButton = new Button("!");
    factorialButton.setBounds(180, 400, 80, 50);
    factorialButton.addActionListener(this);
    add(factorialButton);
    Button sinButton = new Button("sin");
    sinButton.setBounds(10, 160, 80, 50);
    sinButton.addActionListener(this);
    add(sinButton);
    Button cosButton = new Button("cos");
    cosButton.setBounds(95, 160, 80, 50);
    cosButton.addActionListener(this);
    add(cosButton);
    Button tanButton = new Button("tan");
    tanButton.setBounds(180, 160, 80, 50);
    tanButton.addActionListener(this);
    add(tanButton);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
        canvas.setBounds(0, 0, 325, 465);
    add(canvas);
    setBounds(700, 300, 325, 465);
    setResizable(false);
    setVisible(true);
  }
  public static void main(String[] args) {
    Calculatorproject frame = new Calculatorproject();
  }
  @Override
  public void actionPerformed(ActionEvent e) { 
    String buttonLabel = e.getActionCommand();
    String currentText = textField.getText();
    switch (buttonLabel) {
    case "0":
    case "1":
    case "2":
    case "3":
    case "4":
    case "5":
    case "6":
    case "7":
    case "8":
    case "9":
      textField.setText(currentText + buttonLabel);
      break;
    case "+":
    case "-":   
    case "*":
    case "/":
    case "^":
      num1 = Double.parseDouble(currentText);
      operator = buttonLabel;
      textField.setText("");
      break;
    case ".":
      textField.setText(currentText + ".");
      break;
    case "π":
      textField.setText(String.valueOf(Math.PI));
      break;
    case "Neg":
      textField.setText(currentText + "-");
      break;
    case "√":
      double sqrt = Math.sqrt(Double.parseDouble(currentText));
      textField.setText(String.valueOf(sqrt));
      break;
    case "e":
      textField.setText(String.valueOf(Math.E));
      break;
    case "!":
      double fact = 1;
      int n = Integer.parseInt(currentText);
      for (int i = 2; i <= n; i++) {
        fact *= i;
      }
      textField.setText(String.valueOf(fact));
      break;
    case "sin":
      double sin = Math.sin(Double.parseDouble(currentText));
      textField.setText(String.valueOf(sin));
      break;
    case "cos":
      double cos = Math.cos(Double.parseDouble(currentText));
      textField.setText(String.valueOf(cos));
      break;
    case "tan":
      double tan = Math.tan(Double.parseDouble(currentText));
      textField.setText(String.valueOf(tan));
      break;
    case "=":
      num2 = Double.parseDouble(currentText);
      double result;
      switch (operator) {
      case "+":
        result = num1 + num2;
        break;
      case "-":
        result = num1 - num2;
        break;
      case "*":
        result = num1 * num2;
        break;
      case "/":
        result = num1 / num2;
        break;
      case "^":
        result = Math.pow(num1, num2);
        break;
      default:
        result = 0;
        break;
      }
      textField.setText(String.valueOf(result));
      break;
    case "C":
      textField.setText("");
      break;
    }
  }
  @Override
  public void windowOpened(WindowEvent e) {
  }
  @Override
  public void windowClosing(WindowEvent e) {
  }
  @Override
  public void windowClosed(WindowEvent e) {
  }
  @Override
  public void windowIconified(WindowEvent e) {
  }
  @Override
  public void windowDeiconified(WindowEvent e) {
  }
  @Override
  public void windowActivated(WindowEvent e) {
  }
  @Override
  public void windowDeactivated(WindowEvent e) {
  }
}