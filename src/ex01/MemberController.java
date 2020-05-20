package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.commonService.CommonService;
import ex01.commonService.CommonServiceImpl;
import ex01.commonService.membership.MembershipService;
import ex01.commonService.membership.MembershipServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;

public class MemberController implements Initializable {
	private Parent root;
	private CommonService service;
	MembershipService memservice;
	public void setRoot(Parent root) {
		this.root = root;
		AddComboBox();
	}
	public void AddComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge!=null) {
			cmbAge.getItems().addAll("20�� �̸�", "20��", "30��", "40��", "50��", "60�� �̻�");
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void memberCancle() {
		service = new CommonServiceImpl();
		service.setRoot(root);
		service.WindowClose();
	
	}
	public void membershipProc() {
		memservice = new MembershipServiceImpl();
		memservice.setRoot(root);
		memservice.membershipProc();
		
	}

}
