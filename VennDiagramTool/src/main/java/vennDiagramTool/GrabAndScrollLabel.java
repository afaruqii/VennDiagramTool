package vennDiagramTool;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GrabAndScrollLabel extends JLabel{
public GrabAndScrollLabel(String s) {
super(s);

addMouseListener(new MouseAdapter() {
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
});
}

}

