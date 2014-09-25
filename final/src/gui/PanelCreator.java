package gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import game.*;

/**
 * 
 * Creates control and view panels for given model
 *
 */
public class PanelCreator 
{
	//-- Instance variables -----------------------------------------------------

	/**
	 * Instance of MODEL
	 */
	public Game game;

	/**
	 * Portion of VIEW
	 * Used to display the state of MODEL
	 */
	SubPanelCreator adventurer;
	SubPanelCreator monster;
	GameControlPanel gamePanelCreator;
	TempControlPanel tempPanelCreator;


	public PanelCreator()
	{
		game = null;
		adventurer = null;
		monster = null;
	}

	/**
	 * Responsibility:
	 *     create a panel with control widgets
	 * 
	 * @return a panel with a button to advance the counter
	 */
	public JPanel getControlPanel() //CONTROLLER
	{
		/*JButton createA;
    JButton createM;
    final JButton poke = new JButton("Poke Monster");
    poke.setEnabled(false);
		 **/
		game = new Game();
		gamePanelCreator = new GameControlPanel();
		tempPanelCreator = new TempControlPanel();
		setUpGameControlPanel();
		setUpTempControlPanel();
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
		controlPanel.add(gamePanelCreator.getGamePanel());
		controlPanel.add(tempPanelCreator.getTempPanel());
		return controlPanel;
	
	}
	/*
    // INNER CLASS
    // (What is scope of this class?)
    // Listener for button event
    // When button event is "heard", 
    //    event handler is executed automatically
    //    Note that event handler is NEVER invoked explicitly

    //Create button controller
    createA = new JButton("Create Adventurer");
    createM = new JButton("Create Monster");
    //Create listener:  instance of inner class
    
    //Create a new panel
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout());
    //Add the button to the panel
    panel.add(createA);
    panel.add(createM);
    panel.add(poke);
    //Give it to the frame
    return panel;
  }*/

  /**
	 * Responsibility:
	 *    constructs a panel with a label which displays (views) 
	 *    the state of the counter (model)
	 * 
	 * @return JPanel which displays the state of the counter
	 */
	public JPanel getViewPanel() //VIEW
	{
		class AdventurerStatus implements CharacterStatus
		{
			public String getStatus()
			{
				String status = "No Adventurer Defined";
				if(game.hasAdventurer())
					status = game.adventurerString();
				return status;
			}
		}

		class MonsterStatus implements CharacterStatus
		{
			public String getStatus()
			{
				String status = "No Adventurer Defined";
				if(game.hasMonster())
					status = game.monsterString();
				return status;
			}
		}

		adventurer = new SubPanelCreator(new AdventurerStatus());
		monster = new SubPanelCreator(new MonsterStatus());
		
		//Create a new panel
		JPanel panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		//Add the label that will display info about the MODEL
		panel.add(adventurer.getViewPanel(), BorderLayout.PAGE_START);
		panel.add(monster.getViewPanel(), BorderLayout.PAGE_END);
		//Give it to the frame
		return panel;
	}
	
	public void setNewGame()
	{
		gamePanelCreator.enableSave();
		tempPanelCreator.enableCreateMonster();
		adventurer.updateView();
		monster.updateView();
	}
	
	public void setUpTempControlPanel()
	{
		class AdventurerListener implements ActionListener 
    {
      //Event handler that responds to button event
    	public void actionPerformed(ActionEvent event) 
      {
    		game.createNewAdventurer();
    		adventurer.updateView();
    		tempPanelCreator.disableCreateAdventurer();
    		if(game.hasAdventurer() && game.hasMonster() && game.hasMonsterSacks())
    			tempPanelCreator.enablePokeMonster();
      }
    }

    class MonsterListener implements ActionListener 
    {
      //Event handler that responds to button event
    	public void actionPerformed(ActionEvent event) 
      {
    		game.createNewMonster();
    		monster.updateView();
    		if(game.hasAdventurer() && game.hasMonster() && game.hasMonsterSacks())
    			tempPanelCreator.enablePokeMonster();
      }
    }

    class PokeListener implements ActionListener 
    {
      //Event handler that responds to button event
    	public void actionPerformed(ActionEvent event) 
      {
    		game.defendMonster(game.attackAdventurer());
    		adventurer.updateView();
    		monster.updateView();
    		if(!game.hasMonsterSacks())
    			tempPanelCreator.disablePokeMonster();
      }
    }
    
    ActionListener adventurerListener = new AdventurerListener();
    ActionListener monsterListener = new MonsterListener();
    ActionListener pokeListener = new PokeListener();
    //REGISTER the listener with the button
    tempPanelCreator.getCreateAdventurer().addActionListener(adventurerListener);
    tempPanelCreator.getCreateMonster().addActionListener(monsterListener);
    tempPanelCreator.getPokeMonster().addActionListener(pokeListener);
	}
	
	public void setUpGameControlPanel()
	{
		class NewGameListener implements ActionListener 
    {
      //Event handler that responds to button event
    	public void actionPerformed(ActionEvent event) 
      {
    		game = new Game();
    		tempPanelCreator.enableCreateAdventurer();
    		tempPanelCreator.disablePokeMonster();
    		setNewGame();
      }
    }

    class LoadListener implements ActionListener 
    {
      //Event handler that responds to button event
    	public void actionPerformed(ActionEvent event) 
      {
    		Game g = game.loadGame();
    		if(g != null)
    		{
    			game = g;
    			setNewGame();
    			tempPanelCreator.disableCreateAdventurer();
    			if(!game.hasAdventurer())
    				tempPanelCreator.enableCreateAdventurer();
    			if(game.hasMonster())
    					tempPanelCreator.enablePokeMonster();
    		}
      }
    }

    class SaveListener implements ActionListener 
    {
      //Event handler that responds to button event
    	public void actionPerformed(ActionEvent event) 
      {
    		game.saveGame();
      }
    }
    
    ActionListener newGameListener = new NewGameListener();
    ActionListener loadListener = new LoadListener();
    ActionListener saveListener = new SaveListener();
    //REGISTER the listener with the button
    gamePanelCreator.getNewGame().addActionListener(newGameListener);
    gamePanelCreator.getLoad().addActionListener(loadListener);
    gamePanelCreator.getSave().addActionListener(saveListener);
	}
}