import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorWindow extends JFrame
{	
	//declaring panels
	private JPanel choicePanel; //non-scientific / scientific calculator choice
	private JPanel buttonPanel; //panel for numbers / decimal buttons
	private JPanel inputPanel; //panel for displaying userInput
	private JPanel scientificPanel; //panel for scientific calculator buttons
	private JPanel memoryPanel; //panel for memory buttons
	
	//declaring textField
	private JTextField userInputTextField;
	//declaring radio buttons
	private JRadioButton nonScientificCalculatorButton;
	private JRadioButton scientificCalculatorButton;
	private ButtonGroup radioButtonGroup;//grouping buttons
	//setting window size
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 450;
	
	//declaring operation buttons
	private JButton additionButton;
	private JButton subtractionButton;
	private JButton multiplicationButton;
	private JButton divisionButton;
	private JButton decimalPointButton;
	private JButton equalsButton;
	
	//declaring more buttons
	private JButton allClearButton;
	private JButton positiveNegativeButton;

	//declaring scientific buttons
	private JButton ln;
	private JButton log;
	private JButton reciprical;
	private JButton sin;
	private JButton cos;
	private JButton tan;
	private JButton inverseSin;
	private JButton inverseCos;
	private JButton inverseTan;
	private JButton squared;
	private JButton cubed;
	private JButton squareRoot;
	private JButton cubeRoot;
	
	//declaring memory buttons
	private JButton saveMemory;
	private JButton addMemory;
	private JButton deleteMemory;
	private JButton clearMemory;
	private JButton readMemory;
	
	//declaring number buttons
	private JButton digit1Button;
	private JButton digit2Button;
	private JButton digit3Button;
	private JButton digit4Button;
	private JButton digit5Button;
	private JButton digit6Button;
	private JButton digit7Button;
	private JButton digit8Button;
	private JButton digit9Button;
	private JButton digit0Button;
	
	//set variables
	char operation;
	double number1;
	double number2;
	String getInput;
	double result;
	String memory;
	
	public CalculatorWindow()
	{
		super ("Calculator");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
				
		setVisible(true);
	}
	
	//buildpanels and buttons
	private void buildPanel()
	{			
		choicePanel = new JPanel();
		inputPanel = new JPanel();
		buttonPanel = new JPanel();
		scientificPanel = new JPanel();
		memoryPanel = new JPanel();
		
		choicePanel.setLayout(new GridLayout(1,1));
		choicePanel.setBackground(Color.BLACK);
		choicePanel.setForeground(Color.GREEN);
		
		inputPanel.setLayout(new BorderLayout(7, 7));
		inputPanel.setBackground(Color.BLACK);
		inputPanel.setForeground(Color.GREEN);
		
  		buttonPanel.setLayout(new GridLayout(4, 4));
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.setForeground(Color.GREEN);
		
		scientificPanel.setLayout(new GridLayout(5,3));
		scientificPanel.setBackground(Color.BLACK);
		scientificPanel.setForeground(Color.BLUE);
				
		memoryPanel.setLayout(new GridLayout(5,1));
		memoryPanel.setBackground(Color.BLACK);
		memoryPanel.setForeground(Color.ORANGE);
		
		userInputTextField = new JTextField(10);
		
		nonScientificCalculatorButton = new JRadioButton("Non-Scientific Calculator");
		scientificCalculatorButton = new JRadioButton("Scientific Calculator");
		
		additionButton = new JButton("+");
		subtractionButton = new JButton("-");
		multiplicationButton = new JButton("X");
		divisionButton = new JButton("/");
		decimalPointButton = new JButton(".");
		equalsButton = new JButton("=");
		 
		allClearButton = new JButton("Clear All");
		positiveNegativeButton = new JButton("+/-");
		ln = new JButton("LN");
		log = new JButton("LOG");
		sin = new JButton("SIN");
		cos = new JButton("COS");
		tan = new JButton("TAN");
		inverseSin = new JButton("sin-1");
		inverseCos = new JButton("cos-1");
		inverseTan = new JButton("tan-1");
		squared = new JButton("x^2");
		cubed = new JButton("x^3");
		squareRoot = new JButton("Square Root");
		cubeRoot = new JButton("Cube Root");
		reciprical = new JButton("1/x");

		
		saveMemory = new JButton("Save#");
		addMemory = new JButton("M+"); 
		deleteMemory = new JButton("M-");
		clearMemory = new JButton("MC");
		readMemory = new JButton("MR");
		
		additionButton.addActionListener(new ButtonListener());
		subtractionButton.addActionListener(new ButtonListener());
		multiplicationButton.addActionListener(new ButtonListener());
		divisionButton.addActionListener(new ButtonListener());
		decimalPointButton.addActionListener(new ButtonListener());
		allClearButton.addActionListener(new ButtonListener());
		positiveNegativeButton.addActionListener(new ButtonListener());
		sin.addActionListener(new ButtonListener());
		cos.addActionListener(new ButtonListener());
		tan.addActionListener(new ButtonListener());
		inverseSin.addActionListener(new ButtonListener());
		inverseCos.addActionListener(new ButtonListener());
		inverseTan.addActionListener(new ButtonListener());
		ln.addActionListener(new ButtonListener());
		log.addActionListener(new ButtonListener());
		squared.addActionListener(new ButtonListener());
		cubed.addActionListener(new ButtonListener());
		reciprical.addActionListener(new ButtonListener());
		squareRoot.addActionListener(new ButtonListener());
		cubeRoot.addActionListener(new ButtonListener());
		
		saveMemory.addActionListener(new ButtonListener());
		addMemory.addActionListener(new ButtonListener());
		deleteMemory.addActionListener(new ButtonListener());
		clearMemory.addActionListener(new ButtonListener());
		readMemory.addActionListener(new ButtonListener());
		
		equalsButton.addActionListener(new ButtonListener());
		
		digit1Button = new JButton("1");
		digit2Button = new JButton("2");
		digit3Button = new JButton("3");
		digit4Button = new JButton("4");
		digit5Button = new JButton("5");
		digit6Button = new JButton("6");
		digit7Button = new JButton("7");
		digit8Button = new JButton("8");
		digit9Button = new JButton("9");
		digit0Button = new JButton("0");
		
		digit1Button.addActionListener(new ButtonListener());
		digit2Button.addActionListener(new ButtonListener());
		digit3Button.addActionListener(new ButtonListener());
		digit4Button.addActionListener(new ButtonListener());
		digit5Button.addActionListener(new ButtonListener());
		digit6Button.addActionListener(new ButtonListener());
		digit7Button.addActionListener(new ButtonListener());
		digit8Button.addActionListener(new ButtonListener());
		digit9Button.addActionListener(new ButtonListener());
		digit0Button.addActionListener(new ButtonListener());
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(nonScientificCalculatorButton);
		radioButtonGroup.add(scientificCalculatorButton);
		
		nonScientificCalculatorButton.addActionListener(new RadioButtonListener());
		scientificCalculatorButton.addActionListener(new RadioButtonListener());

		
		choicePanel.add(nonScientificCalculatorButton);
		choicePanel.add(scientificCalculatorButton);
		 
		memoryPanel.add(saveMemory);
		memoryPanel.add(addMemory);
		memoryPanel.add(deleteMemory);
		memoryPanel.add(clearMemory);
		memoryPanel.add(readMemory);
		
		scientificPanel.add(allClearButton);
		scientificPanel.add(sin);
		scientificPanel.add(inverseSin);

		scientificPanel.add(positiveNegativeButton);
		scientificPanel.add(cos);
		scientificPanel.add(inverseCos);
		
		scientificPanel.add(ln);
		scientificPanel.add(tan);
		scientificPanel.add(inverseTan);

		scientificPanel.add(log);
		scientificPanel.add(squared);
		scientificPanel.add(cubed);
		
		scientificPanel.add(reciprical);
		scientificPanel.add(squareRoot);
		scientificPanel.add(cubeRoot);
		
		buttonPanel.add(digit7Button);
		buttonPanel.add(digit8Button);
		buttonPanel.add(digit9Button);
		buttonPanel.add(divisionButton);
		
		buttonPanel.add(digit4Button);
		buttonPanel.add(digit5Button);
		buttonPanel.add(digit6Button);
		buttonPanel.add(multiplicationButton);
		
		buttonPanel.add(digit1Button);
		buttonPanel.add(digit2Button);
		buttonPanel.add(digit3Button);
		buttonPanel.add(subtractionButton);
		
		buttonPanel.add(decimalPointButton);
		buttonPanel.add(digit0Button);
		buttonPanel.add(equalsButton);
		buttonPanel.add(additionButton);
		
		nonScientificCalculatorButton.setBackground(Color.BLACK);
		nonScientificCalculatorButton.setForeground(Color.GREEN);
		nonScientificCalculatorButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		scientificCalculatorButton.setBackground(Color.BLACK);
		scientificCalculatorButton.setForeground(Color.GREEN);
		scientificCalculatorButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));

		
		additionButton.setBackground(Color.BLACK);
		additionButton.setForeground(Color.GREEN);
		additionButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		subtractionButton.setBackground(Color.BLACK);
		subtractionButton.setForeground(Color.GREEN);
		subtractionButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		multiplicationButton.setBackground(Color.BLACK);
		multiplicationButton.setForeground(Color.GREEN);
		multiplicationButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		divisionButton.setBackground(Color.BLACK);
		divisionButton.setForeground(Color.GREEN);
		divisionButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		equalsButton.setBackground(Color.BLACK);
		equalsButton.setForeground(Color.GREEN);
		equalsButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		decimalPointButton.setBackground(Color.BLACK);
		decimalPointButton.setForeground(Color.GREEN);
		decimalPointButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		
		allClearButton.setBackground(Color.BLACK);
		allClearButton.setForeground(Color.CYAN);
		allClearButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		positiveNegativeButton.setBackground(Color.BLACK);
		positiveNegativeButton.setForeground(Color.CYAN);
		positiveNegativeButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));				
		ln.setBackground(Color.BLACK);
		ln.setForeground(Color.CYAN);
		ln.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		log.setBackground(Color.BLACK);
		log.setForeground(Color.CYAN);
		log.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		sin.setBackground(Color.BLACK);
		sin.setForeground(Color.CYAN);
		sin.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		cos.setBackground(Color.BLACK);
		cos.setForeground(Color.CYAN);
		cos.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		tan.setBackground(Color.BLACK);
		tan.setForeground(Color.CYAN);
		tan.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		inverseSin.setBackground(Color.BLACK);
		inverseSin.setForeground(Color.CYAN);
		inverseSin.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		inverseCos.setBackground(Color.BLACK);
		inverseCos.setForeground(Color.CYAN);
		inverseCos.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		inverseTan.setBackground(Color.BLACK);
		inverseTan.setForeground(Color.CYAN);
		inverseTan.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		squared.setBackground(Color.BLACK);
		squared.setForeground(Color.CYAN);
		squared.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		cubed.setBackground(Color.BLACK);
		cubed.setForeground(Color.CYAN);
		cubed.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		squareRoot.setBackground(Color.BLACK);
		squareRoot.setForeground(Color.CYAN);
		squareRoot.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		cubeRoot.setBackground(Color.BLACK);
		cubeRoot.setForeground(Color.CYAN);
		cubeRoot.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		reciprical.setBackground(Color.BLACK);
		reciprical.setForeground(Color.CYAN);
		reciprical.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		
		saveMemory.setBackground(Color.BLACK);
		saveMemory.setForeground(Color.ORANGE);
		saveMemory.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		addMemory.setBackground(Color.BLACK);
		addMemory.setForeground(Color.ORANGE);
		addMemory.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		deleteMemory.setBackground(Color.BLACK);
		deleteMemory.setForeground(Color.ORANGE);
		deleteMemory.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		clearMemory.setBackground(Color.BLACK);
		clearMemory.setForeground(Color.ORANGE);
		clearMemory.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		readMemory.setBackground(Color.BLACK);
		readMemory.setForeground(Color.ORANGE);
		readMemory.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));

		
		digit1Button.setBackground(Color.BLACK);
		digit1Button.setForeground(Color.GREEN);
		digit1Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit2Button.setBackground(Color.BLACK);
		digit2Button.setForeground(Color.GREEN);
		digit2Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit3Button.setBackground(Color.BLACK);
		digit3Button.setForeground(Color.GREEN);
		digit3Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit4Button.setBackground(Color.BLACK);
		digit4Button.setForeground(Color.GREEN);
		digit4Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit5Button.setBackground(Color.BLACK);
		digit5Button.setForeground(Color.GREEN);
		digit5Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit6Button.setBackground(Color.BLACK);
		digit6Button.setForeground(Color.GREEN);
		digit6Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit7Button.setBackground(Color.BLACK);
		digit7Button.setForeground(Color.GREEN);
		digit7Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit8Button.setBackground(Color.BLACK);
		digit8Button.setForeground(Color.GREEN);
		digit8Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit9Button.setBackground(Color.BLACK);
		digit9Button.setForeground(Color.GREEN);
		digit9Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		digit0Button.setBackground(Color.BLACK);
		digit0Button.setForeground(Color.GREEN);
		digit0Button.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		
		inputPanel.add(userInputTextField);		
		add(choicePanel, BorderLayout.SOUTH);
		add(inputPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(memoryPanel, BorderLayout.WEST);
		add(scientificPanel, BorderLayout.EAST);
		
	}
	
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == nonScientificCalculatorButton)
			{
				choicePanel.setVisible(true);
				inputPanel.setVisible(true);
				buttonPanel.setVisible(true);
				scientificPanel.setVisible(false);
				memoryPanel.setVisible(false);
			}
			else if (e.getSource() == scientificCalculatorButton)
			{
				choicePanel.setVisible(true);
				inputPanel.setVisible(true);
				buttonPanel.setVisible(true);
				scientificPanel.setVisible(true);
				memoryPanel.setVisible(true);
			}
		}
	}
	
	//assign actions to buttons
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {	
			String button1;
			String button2;
			String button3;
			String button4;
			String button5;
			String button6;
			String button7;
			String button8;
			String button9;
			String button0;
			
			String digit1;
			String digit2;
			String digit3;
			String digit4;
			String digit5;
			String digit6;
			String digit7;
			String digit8;
			String digit9;
			String digit0;
			
			if (e.getSource() == digit1Button)
			{
				digit1 = userInputTextField.getText();
				button1 = digit1.concat("1");
				userInputTextField.setText(button1);
			}
			else if (e.getSource() == digit2Button)
			{
				digit2 = userInputTextField.getText();
				button2 = digit2.concat("2");
				userInputTextField.setText(button2);
			}
			else if (e.getSource() == digit3Button)
			{
				digit3 = userInputTextField.getText();
				button3 = digit3.concat("3");
				userInputTextField.setText(button3);
			}
			else if (e.getSource() == digit4Button)
			{
				digit4 = userInputTextField.getText();
				button4 = digit4.concat("4");
				userInputTextField.setText(button4);
			}
			else if (e.getSource() == digit5Button)
			{
				digit5 = userInputTextField.getText();
				button5 = digit5.concat("5");
				userInputTextField.setText(button5);
			}
			else if (e.getSource() == digit6Button)
			{
				digit6 = userInputTextField.getText();
				button6 = digit6.concat("6");
				userInputTextField.setText(button6);
			}
			else if (e.getSource() == digit7Button)
			{
				digit7 = userInputTextField.getText();
				button7 = digit7.concat("7");
				userInputTextField.setText(button7);
			}
			else if (e.getSource() == digit8Button)
			{
				digit8 = userInputTextField.getText();
				button8 = digit8.concat("8");
				userInputTextField.setText(button8);
			}
			else if (e.getSource() == digit9Button)
			{
				digit9 = userInputTextField.getText();
				button9 = digit9.concat("9");
				userInputTextField.setText(button9);
			}
			else if (e.getSource() == digit0Button)
			{
				digit0 = userInputTextField.getText();
				button0 = digit0.concat("0");
				userInputTextField.setText(button0);
			}
			else if (e.getSource() == additionButton)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				userInputTextField.setText(null);
				operation = '+';
			}
			else if (e.getSource() == subtractionButton)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				userInputTextField.setText(null);
				operation = '-';
			}
			else if (e.getSource() == multiplicationButton)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				userInputTextField.setText(null);
				operation = '*';
			}
			else if (e.getSource() == divisionButton)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				userInputTextField.setText(null);
				operation = '/';
			}
			else if (e.getSource() == decimalPointButton)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				userInputTextField.setText(getInput + ".");
			}
			else if (e.getSource() == allClearButton)
			{
				userInputTextField.setText(null);
			}
			else if (e.getSource() == positiveNegativeButton)
			{
				getInput = userInputTextField.getText();
				number2 = Double.parseDouble(getInput);
				result = number2*(-1);
				userInputTextField.setText(Double.toString(result)); 
			}	
			else if (e.getSource() == saveMemory)
			{
				memory = userInputTextField.getText();
			}
			else if (e.getSource() == addMemory)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				number2 = Double.parseDouble(memory);
				result = number1 + number2;
				memory = Double.toString(result);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == deleteMemory)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				number2 = Double.parseDouble(memory);
				result = number1 - number2;
				memory = Double.toString(result);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == clearMemory)
			{
				memory = null;
				userInputTextField.setText("0");
			}
			else if (e.getSource() == readMemory)
			{
				userInputTextField.setText(memory);
			}
			else if (e.getSource() == sin)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.sin(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == cos)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.cos(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == tan)
			{			
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.tan(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == inverseSin)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.asin(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == inverseCos)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.acos(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == inverseTan)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.atan(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == ln)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.log(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == log)
			{	
				double base = 10;
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = (Math.log(number1)) / (Math.log(base));
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == squared)
			{	
				double power = 2;
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.pow(number1, power);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == cubed)
			{
				double power = 3;
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.pow(number1, power);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == squareRoot)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.sqrt(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == cubeRoot)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = Math.cbrt(number1);
				userInputTextField.setText(Double.toString(result));
			}
			else if (e.getSource() == reciprical)
			{
				getInput = userInputTextField.getText();
				number1 = Double.parseDouble(getInput);
				result = 1 / number1;
				userInputTextField.setText(Double.toString(result));
			}
			//
			else if (e.getSource() == equalsButton)
			{
				getInput = userInputTextField.getText();
				number2 = Double.parseDouble(getInput);
				
				if(operation == '+')
				{
					result = number1 + number2;
					userInputTextField.setText(Double.toString(result));
				}
				else if(operation == '-')
				{
					result = number1 - number2;
					userInputTextField.setText(Double.toString(result));
				}
				else if (operation == '*')
				{
					result = number1 * number1;
					userInputTextField.setText(Double.toString(result));
				}
				else if (operation == '/')
				{
					result = number1/number2;
					userInputTextField.setText(Double.toString(result));
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		new CalculatorWindow();
	}
}