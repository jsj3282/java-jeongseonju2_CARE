package ex01.commonService.membership;

import java.util.ArrayList;

import ex01.Controller;
import ex01.Member;
import ex01.commonService.CommonService;
import ex01.commonService.CommonServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MembershipServiceImpl implements MembershipService{
	private Parent root;
	private Member mem;
	private TextField name;
	private TextField id;
	private PasswordField pw;
	private PasswordField pwChk;
	private RadioButton man;
	private RadioButton woman;
	private ComboBox<String> cmbAge;
	private ArrayList<CheckBox> checkBox;
	private int hobby;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void membershipProc() {
		mem = new Member();
		setFX();
		if(!checkField()) {
			return;
		}
		setMemberField();
		viewMember();
	}
	
	private void setFX() {
		checkBox = new ArrayList<>();
		name = (TextField) root.lookup("#fxName");
		id = (TextField) root.lookup("#fxID");
		pw = (PasswordField) root.lookup("#fxPw");
		pwChk = (PasswordField) root.lookup("#fxPwOk");
		man = (RadioButton) root.lookup("#rdoMan");
		woman = (RadioButton) root.lookup("#rdoWoman");
		cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		checkBox.add((CheckBox)root.lookup("#chkMusic"));
		checkBox.add((CheckBox)root.lookup("#chkSport"));
		checkBox.add((CheckBox)root.lookup("#chkMovie"));
	}
	private void setMemberField() {
		mem.setName(name.getText());
		mem.setId(id.getText());
		mem.setPw(pw.getText());
		mem.setGender(man.isSelected());
		mem.setAge(cmbAge.getValue().toString());
		if(checkBox.get(0).isSelected()) {
			hobby += 1;
		}if(checkBox.get(1).isSelected()) {
			hobby += 2;
		}if(checkBox.get(2).isSelected()) {
			hobby += 4;
		}
		mem.setHobby(hobby);
	}
	private void viewMember() {
		boolean bool = Controller.db.insert(mem);
		System.out.println("회원가입");
		if(bool) {
			CommonService.ErrorMsg("성공적으로 저장되었습니다.");
		}else {
			CommonService.ErrorMsg("문제가 발생했습니다!!!");
		}
		System.out.println("이름 : " + mem.getName());
		System.out.println("아이디 : " + mem.getId());
		System.out.println("비밀번호 : " + mem.getPw());
		System.out.println("성별 : " + mem.isGender());
		System.out.println("연령 : " + mem.getAge());
		System.out.println("좋아하는 것 : " + mem.getHobby());
	}
	
	private boolean checkField() {
		if (name.getText().length() == 0) {
			name.requestFocus();
			Alert alert1 = new Alert(AlertType.ERROR, "이름을 입력하세요");
			alert1.setTitle("error");
			alert1.setHeaderText("입력 창");
			alert1.show();
			return false;
		}if (id.getText().length() == 0) {
			id.requestFocus();
			Alert alert2 = new Alert(AlertType.ERROR, "아이디를 입력하세요.");
			alert2.setTitle("error");
			alert2.setHeaderText("입력 창");
			alert2.show();
			return false;
		}if (pw.getText().length() == 0) {
			pw.requestFocus();
			Alert alert3 = new Alert(AlertType.ERROR, "비밀번호를 입력하세요.");
			alert3.setTitle("error");
			alert3.setHeaderText("입력 창");
			alert3.show();
			return false;
		}if (!(pwChk.getText().equals(pw.getText()))) {
			Alert alert0 = new Alert(AlertType.ERROR, "비밀번호가 일치하지 않습니다.");
			alert0.setTitle("error");
			alert0.setHeaderText("입력 창");
			alert0.show();		
			return false;
		}if (!(man.isSelected() || woman.isSelected())) {
			Alert alert4 = new Alert(AlertType.ERROR, "성별을 선택하셔야 합니다.");
			alert4.setTitle("error");
			alert4.setHeaderText("입력 창");
			alert4.show();
			return false;
		}if (cmbAge == null) {
			return false;
		}else if (cmbAge.getValue() == null) {
			System.out.println("ComboBox를 선택하세요");
			cmbAge.requestFocus();
			Alert alert5 = new Alert(AlertType.ERROR, "ComboBox를 선택하셔야 합니다.");
			alert5.setTitle("error");
			alert5.setHeaderText("입력 창");
			alert5.show();
			return false;
		}
		return true;
	}
		
}
