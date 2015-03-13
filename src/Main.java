import java.awt.Color;import java.awt.Dimension;import javax.swing.JFrame;import javax.swing.SpringLayout;import javax.swing.WindowConstants;/** * Displays a deck of draggable cards on a pale green background. * Uses a standard 52 card deck. * Cards are initially laid out in a grid of 13 by 4 cards, in random order. * Cards can be moved to any location within the window by clicking and dragging. *  * <p><b>Caveats:</b> The window can be NOT be resized freely under the current * implementation, so resizing is disabled. * Cards are not visible over the 10x10px boarder around the inside edge of the window. *  * @author Stephen Belden * @version 2015-02-13 */public class Main {    public static void main(String[] args) {    	/**     	 * The number of pixels that a single card .gif image takes up horizontally.    	 * Should always match the actual dimensions of the images being used.    	 * Should always be a nonnegative value.    	 */        final int CARD_WIDTH = 73;        /**          * The number of pixels that a single card .gif image takes up vertically.         * Should always match the actual dimensions of the images being used.         * Should always be a nonnegative value.         */        final int CARD_HEIGHT = 97;        /**          * The desired gap (in pixels) between each card displayed in the initial grid.         * Small values (less than 5) may produce rounding errors that affect         * other parts of the window.         * Should always be a nonnegative value.         */    	final int CARD_GAP = 10;    	/**     	 * The desired width of the blank boarder surrounding the initial grid of cards.    	 * Should always be a nonnegative value.    	 */    	final int BORDER = 10;    	/**    	 * The width of the area taken up by the initial grid of cards.    	 * Takes into account the desired card gap.    	 * Calculated at runtime, should not be manually defined.    	 */    	final int playWidth = (14 * (CARD_WIDTH + CARD_GAP));    	/**    	 * The height of the area taken up by the initial grid of cards.    	 * Takes into account the desired card gap.    	 * Calculated at runtime, should not be manually defined.    	 */    	final int playHeight = (4 * (CARD_HEIGHT + CARD_GAP));    	/**    	 * The initial width of the window.    	 * Takes into account the desired border.    	 * Calculated at runtime, should not be manually defined.    	 */    	final int windowWidth = playWidth + (BORDER * 2);    	/**    	 * The initial height of the window.    	 * Takes into account the desired border and includes an error    	 * compensation value of 30 px, which for some reason is necessary...    	 * Calculated at runtime, should not be manually defined.    	 */    	final int windowHeight = playHeight + (BORDER * 2) + 30;    	        /**         * A single instance of a playArea.         * All loading, logic, interaction and graphics are handled by this object.         */    	PlayArea playAreaInst = new PlayArea(playWidth, playHeight);                //create a window to display the card panel and the border around the cards        JFrame window = new JFrame("Cards");        Color paleGreen = new Color(100,200,100);        SpringLayout layout = new SpringLayout();        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        window.getContentPane().setBackground(paleGreen);        window.setPreferredSize(new Dimension(windowWidth, windowHeight));        window.setLayout(layout);        layout.putConstraint(SpringLayout.WEST, playAreaInst, BORDER, SpringLayout.WEST, window);        layout.putConstraint(SpringLayout.NORTH, playAreaInst, BORDER, SpringLayout.NORTH, window);        window.add(playAreaInst);        window.pack();        window.setResizable(false);        window.setVisible(true);    }}