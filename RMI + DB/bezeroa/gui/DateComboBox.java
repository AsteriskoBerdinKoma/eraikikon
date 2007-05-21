package bezeroa.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.motif.MotifComboBoxUI;
import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * Datak aukeratzeko egutegi bat panel batean sortzen duen klasea. Aukeratutako data ComboBox 
 * batean gordetzen da.
 * 
 * @author www.java.happycodings.com (5. Taldeak atondua)
 *
 */
public class DateComboBox extends JComboBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");

	/**
	 * ComboBox-aren Data formatua esleitzeko balio du.
	 * 
	 * @param dateFormat ComboBox-ak erabiliko duen data formatua
	 */
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComboBox#setSelectedItem(java.lang.Object)
	 */
	public void setSelectedItem(Object item) {
		// Could put extra logic here or in renderer when item is instanceof
		// Date, Calendar, or String
		// Dont keep a list ... just the currently selected item
		removeAllItems(); // hides the popup if visible
		addItem(item);
		super.setSelectedItem(item);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComboBox#updateUI()
	 */
	public void updateUI() {
		ComboBoxUI cui = (ComboBoxUI) UIManager.getUI(this);
		if (cui instanceof MetalComboBoxUI) {
			cui = new MetalDateComboBoxUI();
		} else if (cui instanceof MotifComboBoxUI) {
			cui = new MotifDateComboBoxUI();
		} else if (cui instanceof WindowsComboBoxUI) {
			cui = new WindowsDateComboBoxUI();
		}
		setUI(cui);
	}

	// Inner classes are used purely to keep DateComboBox component in one file
	// ////////////////////////////////////////////////////////////
	// UI Inner classes -- one for each supported Look and Feel
	// ////////////////////////////////////////////////////////////

	/**
	 * Egutegia egikaritzen duen panela sortzeko.
	 * 
	 * @author www.java.happycodings.com (5. Taldeak atondua)
	 *
	 */
	class MetalDateComboBoxUI extends MetalComboBoxUI {
		protected ComboPopup createPopup() {
			return new DatePopup(comboBox);
		}
	}

	/**
	 * Egutegia egikaritzen duen panela sortzeko.
	 * 
	 * @author www.java.happycodings.com (5. Taldeak atondua)
	 *
	 */
	class WindowsDateComboBoxUI extends WindowsComboBoxUI {
		protected ComboPopup createPopup() {
			return new DatePopup(comboBox);
		}
	}

	/**
	 * Egutegia egikaritzen duen panela sortzeko.
	 * 
	 * @author www.java.happycodings.com (5. Taldeak atondua)
	 */
	class MotifDateComboBoxUI extends MotifComboBoxUI {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected ComboPopup createPopup() {
			return new DatePopup(comboBox);
		}
	}

	// ////////////////////////////////////////////////////////////
	// DatePopup inner class
	// ////////////////////////////////////////////////////////////

	/**
	 * Egutegiari informazioa esleitzeko klasea
	 * 
	 * @author www.java.happycodings.com (5. Taldeak atondua)
	 *
	 */
	class DatePopup implements ComboPopup, MouseMotionListener, MouseListener,
			KeyListener, PopupMenuListener {

		protected JComboBox comboBox;

		protected Calendar calendar;

		protected JPopupMenu popup;

		protected JLabel monthLabel;

		protected JPanel days = null;

		protected String[] hilabeteak = { "Urtarrila", "Otsaila", "Martxoa",
				"Apirila", "Maiatza", "Ekaina", "Uztaia", "Abuztua", "Iraila",
				"Urria", "Azaroa", "Abendua" };

		protected String[] egunak = { "Al", "Ar", "Az", "Oe", "Oi", "La", "Ig" };
		
		protected Color selectedBackground;

		protected Color selectedForeground;

		protected Color background;

		protected Color foreground;

		/**
		 * Emandako ComboBox-ari egutegia hasieratu.
		 * 
		 * @param comboBox Egutegia edukitzea nahi dugun ComboBox-a
		 */
		public DatePopup(JComboBox comboBox) {
			this.comboBox = comboBox;
			calendar = Calendar.getInstance();
			// String[] dts = {dt};
			int yr = calendar.get(Calendar.YEAR);
			int mn = calendar.get(Calendar.MONTH);
			int dts = calendar.get(Calendar.DATE);
			String dt = yr + "/" + (mn + 1) + "/" + dts;
			comboBox.addItem(dt);
			// check Look and Feel
			background = UIManager.getColor("ComboBox.background");
			foreground = UIManager.getColor("ComboBox.foreground");
			selectedBackground = UIManager.getColor("ComboBox.selectionBackground");
			selectedForeground = UIManager.getColor("ComboBox.selectionForeground");
			initializePopup();
		}

		// ========================================
		// begin ComboPopup method implementations
		//
		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#show()
		 */
		public void show() {
			try {
				// if setSelectedItem() was called with a valid date, adjust the
				// calendar
				calendar.setTime(dateFormat.parse(comboBox.getSelectedItem().toString()));
			} catch (Exception e) {
			}
			updatePopup();
			popup.show(comboBox, 0, comboBox.getHeight());
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#hide()
		 */
		public void hide() {
			popup.setVisible(false);
		}

		protected JList list = new JList();

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#getList()
		 */
		public JList getList() {
			return list;
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#getMouseListener()
		 */
		public MouseListener getMouseListener() {
			return this;
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#getMouseMotionListener()
		 */
		public MouseMotionListener getMouseMotionListener() {
			return this;
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#getKeyListener()
		 */
		public KeyListener getKeyListener() {
			return this;
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#isVisible()
		 */
		public boolean isVisible() {
			return popup.isVisible();
		}

		/* (non-Javadoc)
		 * @see javax.swing.plaf.basic.ComboPopup#uninstallingUI()
		 */
		public void uninstallingUI() {
			popup.removePopupMenuListener(this);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
		 */
		public void mousePressed(MouseEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
		 */
		public void mouseReleased(MouseEvent e) {
		}

		// something else registered for MousePressed
		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 */
		public void mouseClicked(MouseEvent e) {
			if (!SwingUtilities.isLeftMouseButton(e))
				return;
			if (!comboBox.isEnabled())
				return;
			if (comboBox.isEditable()) {
				comboBox.getEditor().getEditorComponent().requestFocus();
			} else {
				comboBox.requestFocus();
			}
			togglePopup();
		}

		protected boolean mouseInside = false;

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
		 */
		public void mouseEntered(MouseEvent e) {
			mouseInside = true;
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
		 */
		public void mouseExited(MouseEvent e) {
			mouseInside = false;
		}

		// MouseMotionListener
		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
		 */
		public void mouseDragged(MouseEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
		 */
		public void mouseMoved(MouseEvent e) {
		}

		// KeyListener
		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		public void keyPressed(KeyEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
		public void keyTyped(KeyEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE
					|| e.getKeyCode() == KeyEvent.VK_ENTER) {
				togglePopup();
			}
		}

		/**
		 * Variables hideNext and mouseInside are used to hide the popupMenu by
		 * clicking the mouse in the JComboBox
		 */
		/* (non-Javadoc)
		 * @see javax.swing.event.PopupMenuListener#popupMenuCanceled(javax.swing.event.PopupMenuEvent)
		 */
		public void popupMenuCanceled(PopupMenuEvent e) {
		}

		protected boolean hideNext = false;

		/* (non-Javadoc)
		 * @see javax.swing.event.PopupMenuListener#popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent)
		 */
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			hideNext = mouseInside;
		}

		/* (non-Javadoc)
		 * @see javax.swing.event.PopupMenuListener#popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent)
		 */
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		}

		protected void togglePopup() {
			if (isVisible() || hideNext) {
				hide();
			} else {
				show();
			}
			hideNext = false;
		}

		// Note *** did not use JButton because Popup closes when pressed
		protected JLabel createUpdateButton(final int field, final int amount) {
			final JLabel label = new JLabel();
			final Border selectedBorder = new EtchedBorder();
			final Border unselectedBorder = new EmptyBorder(selectedBorder
					.getBorderInsets(new JLabel()));
			label.setBorder(unselectedBorder);
			label.setForeground(foreground);
			label.addMouseListener(new MouseAdapter() {
				/* (non-Javadoc)
				 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
				 */
				public void mouseReleased(MouseEvent e) {
					calendar.add(field, amount);
					updatePopup();
				}

				/* (non-Javadoc)
				 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
				 */
				public void mouseEntered(MouseEvent e) {
					label.setBorder(selectedBorder);
				}

				/* (non-Javadoc)
				 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
				 */
				public void mouseExited(MouseEvent e) {
					label.setBorder(unselectedBorder);
				}
			});
			return label;
		}

		protected void initializePopup() {
			JPanel header = new JPanel(); // used Box, but it wasn't Opaque
			header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
			header.setBackground(background);
			header.setOpaque(true);

			JLabel label;
			label = createUpdateButton(Calendar.YEAR, -1);
			label.setIcon(new ImageIcon(getClass().getResource("urte_ezk.png")));
			//label.setText("<<");
			label.setToolTipText("Aurreko Urtea");

			header.add(Box.createHorizontalStrut(12));
			header.add(label);
			header.add(Box.createHorizontalStrut(12));

			label = createUpdateButton(Calendar.MONTH, -1);
			label.setIcon(new ImageIcon(getClass().getResource("hil_ezk.png")));
			//label.setText("<");
			label.setToolTipText("Aurreko Hilabetea");
			header.add(label);

			monthLabel = new JLabel("", JLabel.CENTER);
			monthLabel.setForeground(foreground);
			header.add(Box.createHorizontalGlue());
			header.add(monthLabel);
			header.add(Box.createHorizontalGlue());

			label = createUpdateButton(Calendar.MONTH, 1);
			label.setIcon(new ImageIcon(getClass().getResource("hil_esk.png")));
			//label.setText(">");
			label.setToolTipText("Urrengo Hilabetea");
			header.add(label);

			label = createUpdateButton(Calendar.YEAR, 1);
			label.setIcon(new ImageIcon(getClass().getResource("urte_esk.png")));
			//label.setText(">>");
			label.setToolTipText("Hurrengo Urtea");

			header.add(Box.createHorizontalStrut(12));
			header.add(label);
			header.add(Box.createHorizontalStrut(12));

			popup = new JPopupMenu();
			popup.setBorder(BorderFactory.createLineBorder(Color.black));
			popup.setLayout(new BorderLayout());
			popup.setBackground(background);
			popup.addPopupMenuListener(this);
			popup.add(BorderLayout.NORTH, header);
		}

		// update the Popup when either the month or the year of the calendar
		// has been changed
		protected void updatePopup() {
			monthLabel.setText(hilabeteak[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR));
			if (days != null) {
				popup.remove(days);
			}
			days = new JPanel(new GridLayout(0, 7));
			days.setBackground(background);
			days.setOpaque(true);

			Calendar setupCalendar = (Calendar) calendar.clone();
			setupCalendar.set(Calendar.DAY_OF_WEEK, setupCalendar
					.getFirstDayOfWeek());
			for (int i = 0; i < 7; i++) {
				JLabel label = new JLabel();
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setForeground(Color.blue);
				label.setText(egunak[i]);
				days.add(label);
				setupCalendar.roll(Calendar.DAY_OF_WEEK, true);
			}

			setupCalendar = (Calendar) calendar.clone();
			setupCalendar.set(Calendar.DAY_OF_MONTH, 1);
			int first = setupCalendar.get(Calendar.DAY_OF_WEEK);
			if (first == 1)
				first += 6;
			else
				first -= 1;
			for (int i = 0; i < (first - 1); i++) {
				days.add(new JLabel(""));
			}
			for (int i = 1; i <= setupCalendar
					.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
				final int day = i;
				final JLabel label = new JLabel(String.valueOf(day));
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setForeground(foreground);
				label.addMouseListener(new MouseListener() {
					/* (non-Javadoc)
					 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
					 */
					public void mousePressed(MouseEvent e) {
					}

					/* (non-Javadoc)
					 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
					 */
					public void mouseClicked(MouseEvent e) {
					}

					/* (non-Javadoc)
					 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
					 */
					public void mouseReleased(MouseEvent e) {
						label.setOpaque(false);
						label.setBackground(background);
						label.setForeground(foreground);
						calendar.set(Calendar.DAY_OF_MONTH, day);
						String data = calendar.get(Calendar.YEAR) + "/"
								+ (calendar.get(Calendar.MONTH) + 1) + "/"
								+ calendar.get(Calendar.DAY_OF_MONTH);
						comboBox.setSelectedItem(data);
						hide();
						comboBox.requestFocus();
					}

					/* (non-Javadoc)
					 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
					 */
					public void mouseEntered(MouseEvent e) {
						label.setOpaque(true);
						label.setBackground(selectedBackground);
						label.setForeground(selectedForeground);
					}

					/* (non-Javadoc)
					 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
					 */
					public void mouseExited(MouseEvent e) {
						label.setOpaque(false);
						label.setBackground(background);
						label.setForeground(foreground);
					}
				});

				days.add(label);
			}

			popup.add(BorderLayout.CENTER, days);
			popup.pack();
		}
	}
}
