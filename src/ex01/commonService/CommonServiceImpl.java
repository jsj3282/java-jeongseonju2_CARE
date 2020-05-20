package ex01.commonService;

import javafx.scene.Parent;

import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService{
	
	private Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

	@Override
	public void WindowClose() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		
	}


}
