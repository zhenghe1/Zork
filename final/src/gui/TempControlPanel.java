package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TempControlPanel {
	JButton createAdventurer;
	JButton createMonster;
	JButton pokeMonster;
	JPanel  tempPanel;
	
	public TempControlPanel()
	{
		createAdventurer = new JButton("Create Adventurer");
		createMonster = new JButton("Create Monster");
		pokeMonster = new JButton("Poke Monster");
		createAdventurer.setEnabled(false);
		createMonster.setEnabled(false);
		pokeMonster.setEnabled(false);
		tempPanel = new JPanel();
		tempPanel.setLayout(new GridLayout(3,1));
		tempPanel.add(createAdventurer);
		tempPanel.add(createMonster);
		tempPanel.add(pokeMonster);
	}
	
	public JButton getCreateAdventurer()
	{
		return createAdventurer;
	}
	
	public JButton getCreateMonster()
	{
		return createMonster;
	}
	
	public JButton getPokeMonster()
	{
		return pokeMonster;
	}
	
	public JPanel getTempPanel()
	{
		return tempPanel;
	}
	
	public void enableCreateAdventurer()
	{
		createAdventurer.setEnabled(true);
	}
	
	public void enableCreateMonster()
	{
		createMonster.setEnabled(true);
	}
	
	public void enablePokeMonster()
	{
		pokeMonster.setEnabled(true);
	}
	
	public void disableCreateAdventurer()
	{
		createAdventurer.setEnabled(false);
	}
	
	public void disableCreateMonster()
	{
		createMonster.setEnabled(false);
	}
	
	public void disablePokeMonster()
	{
		pokeMonster.setEnabled(false);
	}
}
