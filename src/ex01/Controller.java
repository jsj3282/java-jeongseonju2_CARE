package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.dao.DatabaseServiceImpl;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable {
	private Parent root;
	private LoginService loginService;
	public static DatabaseServiceImpl db;
	
	static {
		try {
			db = new DatabaseServiceImpl();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void LoginProc() {
		loginService = new LoginServiceImpl();
		loginService.LoginProc(root);
		//System.out.println("controller ·Î±×ÀÎ");
		
	}
	
	public void CancelProc() {
		loginService = new LoginServiceImpl();
		loginService.CancelProc(root);
		//System.out.println("controller Äµ½½");
	}
	public void OpenMemberShipForm()  {
		loginService = new LoginServiceImpl();
		loginService.OpenMembershipForm();
		//System.out.println("controller ¸â¹ö");
	}

}
