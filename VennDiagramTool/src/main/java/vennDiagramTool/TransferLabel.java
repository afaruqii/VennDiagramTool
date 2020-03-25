package vennDiagramTool;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

public class TransferLabel extends JLabel {
	public TransferLabel(String text) {

		this.setText(text);

		this.setTransferHandler(new ValueExportTransferHandler(text));

		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				TransferHandler handle = lbl.getTransferHandler();
				handle.exportAsDrag(lbl, e, TransferHandler.COPY);
				Point p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), getParent()); 
				e.getComponent().setLocation(p.x,p.y);
			}
			
			
		});

	}

	protected static class ValueExportTransferHandler extends TransferHandler {

		public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
		private String value;
		public ValueExportTransferHandler(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public int getSourceActions(JComponent c) {
			return DnDConstants.ACTION_COPY_OR_MOVE;
		}

		@Override
		protected Transferable createTransferable(JComponent c) {
			Transferable t = new StringSelection(getValue());
			return t;
			
		}

		@Override
		protected void exportDone(JComponent source, Transferable data, int action) {
			super.exportDone(source, data, action);
			// Clean up and remove the LayerItem that was moved
			//((TransferLabel) source).setVisible(false);
//			((LayerItem) source).getParent().remove((LayerItem) source);
		}

	}
}