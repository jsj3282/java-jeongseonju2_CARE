package ex01.commonService;


import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public interface CommonService {
	public void setRoot(Parent root);
	public void WindowClose();
	public static void ErrorMsg(String ContentTxt) {
		Alert alert = new Alert(AlertType.INFORMATION);
		if(ContentTxt.equals("로그인 성공")){
			alert.setTitle("login");
		}else {
			alert.setTitle("error");
		}
		alert.setHeaderText("입력 창");
		alert.setContentText(ContentTxt);
		alert.show();
		
	}
}
