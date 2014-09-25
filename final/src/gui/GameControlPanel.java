package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameControlPanel {
	JButton newGame;
	JButton save;
	JButton load;
	JPanel gamePanel;
	
	public GameControlPanel()
	{
		newGame = new JButton("New Game");
		save = new JButton("Save");
		load = new JButton("Load");
		newGame.setEnabled(true);
		save.setEnabled(false);
		load.setEnabled(true);
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,1));
		gamePanel.add(newGame);
		gamePanel.add(save);
		gamePanel.add(load);
	}
	
	public JPanel getGamePanel()
	{
		return gamePanel;
	}
	
	public JButton getNewGame()
	{
		return newGame;
	}
	
	public JButton getSave()
	{
		return save;
	}
	
	public JButton getLoad()
	{
		return load;
	}
	
	public void enableNewGame()
	{
		newGame.setEnabled(true);
	}
	
	public void enableSave()
	{
		save.setEnabled(true);
	}
	
	public void enableLoad()
	{
		load.setEnabled(true);
	}
	
	public void disableNewGame()
	{
		newGame.setEnabled(false);
	}
	
	public void disableSave()
	{
		save.setEnabled(false);
	}
	
	public void disableLoad()
	{
		load.setEnabled(false);
	}
}
