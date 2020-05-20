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
		System.out.println("ȸ������");
		if(bool) {
			CommonService.ErrorMsg("���������� ����Ǿ����ϴ�.");
		}else {
			CommonService.ErrorMsg("������ �߻��߽��ϴ�!!!");
		}
		System.out.println("�̸� : " + mem.getName());
		System.out.println("���̵� : " + mem.getId());
		System.out.println("��й�ȣ : " + mem.getPw());
		System.out.println("���� : " + mem.isGender());
		System.out.println("���� : " + mem.getAge());
		System.out.println("�����ϴ� �� : " + mem.getHobby());
	}
	
	private boolean checkField() {
		if (name.getText().length() == 0) {
			name.requestFocus();
			Alert alert1 = new Alert(AlertType.ERROR, "�̸��� �Է��ϼ���");
			alert1.setTitle("error");
			alert1.setHeaderText("�Է� â");
			alert1.show();
			return false;
		}if (id.getText().length() == 0) {
			id.requestFocus();
			Alert alert2 = new Alert(AlertType.ERROR, "���̵� �Է��ϼ���.");
			alert2.setTitle("error");
			alert2.setHeaderText("�Է� â");
			alert2.show();
			return false;
		}if (pw.getText().length() == 0) {
			pw.requestFocus();
			Alert alert3 = new Alert(AlertType.ERROR, "��й�ȣ�� �Է��ϼ���.");
			alert3.setTitle("error");
			alert3.setHeaderText("�Է� â");
			alert3.show();
			return false;
		}if (!(pwChk.getText().equals(pw.getText()))) {
			Alert alert0 = new Alert(AlertType.ERROR, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			alert0.setTitle("error");
			alert0.setHeaderText("�Է� â");
			alert0.show();		
			return false;
		}if (!(man.isSelected() || woman.isSelected())) {
			Alert alert4 = new Alert(AlertType.ERROR, "������ �����ϼž� �մϴ�.");
			alert4.setTitle("error");
			alert4.setHeaderText("�Է� â");
			alert4.show();
			return false;
		}if (cmbAge == null) {
			return false;
		}else if (cmbAge.getValue() == null) {
			System.out.println("ComboBox�� �����ϼ���");
			cmbAge.requestFocus();
			Alert alert5 = new Alert(AlertType.ERROR, "ComboBox�� �����ϼž� �մϴ�.");
			alert5.setTitle("error");
			alert5.setHeaderText("�Է� â");
			alert5.show();
			return false;
		}
		return true;
	}
		
}
