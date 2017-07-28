package com.github.adchilds.pas;

import com.github.adchilds.pas.ui.UserInterface;

import javax.swing.SwingUtilities;

/**
 * Main entry point for the Paging Allocation Simulator application.
 *
 * @author Adam Childs (adchilds@eckerd.edu
 * @author Shawn Craine (spcraine@eckerd.edu)
 * @author Dylan Meyer (dmeyer@eckerd.edu)
 * @since 1.0
 */
public class AllocationApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(UserInterface::new);
	}

}