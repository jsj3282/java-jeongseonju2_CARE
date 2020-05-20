package ex01.loginService;

import java.io.IOException;

import ex01.Controller;
import ex01.Member;
import ex01.MemberController;
import ex01.commonService.CommonService;
import ex01.commonService.CommonServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl implements LoginService{
	
	@Override
	public void LoginProc(Parent root) {
		
		TextField txtField = (TextField) root.lookup("#fxId");
		System.out.println(txtField.getText());
		PasswordField passwordField = (PasswordField) root.lookup("#fxPw");
		System.out.println(passwordField.getText());
		Member mem = Controller.db.select(txtField.getText());
		System.out.println("-----------------------------------------");
		if(mem==null) {
			System.out.println("���̵�, ��й�ȣ ����");
			CommonService.ErrorMsg("�α��� ����");
			txtField.clear();
			passwordField.clear();
			txtField.requestFocus();
		}else {
			System.out.println(mem.getPw());
			if(mem.getPw().equals(passwordField.getText())) {
				CommonService.ErrorMsg("�α��� ����");
			}else {
				System.out.println("��й�ȣ ����");
				CommonService.ErrorMsg("��й�ȣ ����");
				passwordField.clear();
				passwordField.requestFocus();
			}
		}
		//System.out.println("id : " + txtField.getText());
		//System.out.println("pwd : " + passwordField.getText());
		
	}

	@Override
	public void CancelProc(Parent root) {
		
		System.out.println("������ ����");
		
		TextField id = (TextField)root.lookup("#fxId");
		id.clear();
		
		PasswordField pw = (PasswordField)root.lookup("#fxPw");
		pw.clear();
		CommonService.ErrorMsg("������ ����");
		CommonService service = new CommonServiceImpl();
		service.setRoot(root);
		service.WindowClose();
		
	}

	@Override
	public void OpenMembershipForm() {
		System.out.println("ȸ������.");
		Stage membershipForm = new Stage();
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ex01/Membership1.fxml"));
		try {
			root = loader.load();
			System.out.println(root);
		}catch(IOException e) {
			e.printStackTrace();
		}
		membershipForm.setScene(new Scene(root));
		MemberController ctrler = loader.getController();
		ctrler.setRoot(root);
		membershipForm.show();
		
	}

}
