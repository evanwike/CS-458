package correct;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import correct.TriangleSides.TriangleType;

public class TriangleSidesGUI {
	
	   public static void main(String[] args) {
		      JTextField aField = new JTextField(5);
		      JTextField bField = new JTextField(5);
		      JTextField cField = new JTextField(5);

		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("a:"));
		      myPanel.add(aField);
		      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		      myPanel.add(new JLabel("b:"));
		      myPanel.add(bField);
		      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		      myPanel.add(new JLabel("c:"));
		      myPanel.add(cField);

		      int input = JOptionPane.showConfirmDialog(null, myPanel, 
		               "Please Enter values for three sides: a, b, c: ", JOptionPane.OK_CANCEL_OPTION);
		      if (input == JOptionPane.OK_OPTION) {
		         try {
		        	 int a = Integer.parseInt(aField.getText().trim());
		        	 int b = Integer.parseInt(bField.getText().trim());
		        	 int c = Integer.parseInt(cField.getText().trim());
		        	 TriangleType result = new TriangleSides(a, b, c).reportTriangleType();
		        	 JOptionPane.showMessageDialog(null, result.name());
			         System.out.println(result);		        	 
		         } catch (Exception e){
		        	 JOptionPane.showMessageDialog(null, "Invalid input!");
			         System.out.println("Invalid input!");
		         }
		      }

	   }
}
