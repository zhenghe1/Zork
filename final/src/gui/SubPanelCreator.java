package gui;
import javax.swing.*;

public class SubPanelCreator
{
	private CharacterStatus status;
	private JLabel viewModel;
	
	SubPanelCreator(CharacterStatus status)
	{
		this.status = status;
		viewModel = new JLabel(status.getStatus(), JLabel.LEFT);
	}
	
	public void updateView()
	{
		viewModel.setText(status.getStatus());
	}
	
	public JPanel getViewPanel()
	{
		JPanel panel = new JPanel();
		panel.add(viewModel);
		return panel;
	}
}
