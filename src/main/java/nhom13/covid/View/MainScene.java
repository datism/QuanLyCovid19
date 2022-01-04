package nhom13.covid.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import nhom13.covid.Model.Account;
import nhom13.covid.Model.UserHolder;
import nhom13.covid.View.SoHoKhau.Tach;
import nhom13.covid.View.SoHoKhau.Them;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScene implements Initializable {
    @FXML
    private VBox menuVbox;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MenuItem TachHoKhauItem;

    @FXML
    private MenuItem themThayDoiChuHoItem;

    @FXML
    private MenuItem themChuyenDenItem;

    @FXML
    private MenuItem themChuyenDiItem;

    @FXML
    private MenuItem themHoKhauItem;

    @FXML
    private MenuItem themKhaiBaoYTeItem;

    @FXML
    private MenuButton themMenu;

    @FXML
    private MenuItem themNhanKhauItem;

    @FXML
    private MenuItem themTamTruItem;

    @FXML
    private MenuItem themTamVangItem;

    @FXML
    private MenuItem themTestCovidItem;

    @FXML
    private MenuItem thongKeBenhNhanQuocGiaItem;

    @FXML
    private MenuItem thongKeCachLyDiaPhuongItem;

    @FXML
    private MenuItem thongKeKhaiBaoYTeItem;

    @FXML
    private MenuButton thongKeMenu;

    @FXML
    private MenuItem thongKeTestCovidItem;

    @FXML
    private Button tongQuanButton;

    @FXML
    private MenuItem xemBenhNhanQuocGiaItem;

    @FXML
    private MenuItem xemCachLyDiaPhuongItem;

    @FXML
    private MenuItem xemChuyenDenItem;

    @FXML
    private MenuItem xemChuyenDiItem;

    @FXML
    private MenuItem xemHoKhauItem;

    @FXML
    private MenuItem xemKhaiBaoYTeItem;

    @FXML
    private MenuButton xemMenu;

    @FXML
    private MenuItem xemNhanKhauItem;

    @FXML
    private MenuItem xemTamTruItem;

    @FXML
    private MenuItem xemTamVangItem;

    @FXML
    private MenuItem xemTestCovidItem;

    @FXML
    private MenuItem xemThayDoiChuHoItem;

    @FXML
    void TachHoKhau(ActionEvent event) {
        try {
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("SoHoKhau/StepScene.fxml"));
            loader.setController(new Tach());
            AnchorPane pane = loader.load();
            anchorPane.getChildren().setAll(pane);

        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }


    @FXML
    void ThemChuyenDen(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDen/ThemChuyenDen.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThemChuyenDi(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDi/ThemChuyenDi.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThemHoKhau(ActionEvent event) {
        try {
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("SoHoKhau/StepScene.fxml"));
            loader.setController(new Them());
            AnchorPane pane = loader.load();
            anchorPane.getChildren().setAll(pane);

        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            e.printStackTrace();
        }
    }

    @FXML
    void ThemKhaiBaoYTe(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("KhaiBaoYTe/FormKhaiBaoYTe.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThemNhanKhau(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("NhanKhau/ThemNhanKhau.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThemTamTru(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TamTru/ThemTamTru.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            e.printStackTrace();
        }
    }

    @FXML
    void ThemTamVang(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TamVang/ThemTamVang.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            e.printStackTrace();
        }
    }

    @FXML
    void ThemTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TestCovid/ThemTestCovid.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void Thoat(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    void ThongKeBenhNhanQuocGia(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BenhNhanQuocGia/ThongKeBenhNhanquocGia.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThongKeCachLyDiaPhuong(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("CachLy/ThongKeCachLy.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThongKeKhaiBaoYTe(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("KhaiBaoYTe/ThongKeKhaiBaoYTe.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void ThongKeTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TestCovid/ThongKeTestCovid.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemBenhNhanQuocGia(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BenhNhanQuocGia/XemBenhNhanQuocGia.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemCachLyDiaPHuong(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("CachLy/XemCachLy.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemChuyenDen(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDen/XemChuyenDen.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemChuyenDi(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ChuyenDi/XemChuyenDi.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemHoKhau(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("SoHoKhau/XemSoHoKhau.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemKhaiBaoYTe(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("KhaiBaoYTe/XemKhaiBaoYTe.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemNhanKhau(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("NhanKhau/XemNhanKhau.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    @FXML
    void XemTamTru(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TamTru/XemTamTru.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            e.printStackTrace();
        }
    }

    @FXML
    void XemTamVang(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TamVang/XemTamVang.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            e.printStackTrace();
        }
    }

    @FXML
    void XemTestCovid(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("TestCovid/XemTestCovid.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    private Account account;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account = UserHolder.getInstance().getUser();

        Integer access = account.getAccess();

        switch (access){
            case 1: userScene(); break;
            case 2: yTeScene(); break;
            case 3: toTruongScene(); break;
        }

        tongQuanButton.fire();
    }

    private void userScene() {
        tongQuanButton.setOnAction(event -> {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("UserTongQuan.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                Notifications.create()
                        .title("Lỗi!")
                        .text("Lỗi hệ thống")
                        .position(Pos.TOP_RIGHT)
                        .hideAfter(Duration.seconds(5))
                        .showError();
            }
        });
        themMenu.getItems().removeAll(themNhanKhauItem, themHoKhauItem, TachHoKhauItem, themTestCovidItem);
        xemMenu.getItems().retainAll(xemBenhNhanQuocGiaItem, xemCachLyDiaPhuongItem);
        menuVbox.getChildren().remove(thongKeMenu);
    }

    private void toTruongScene() {
        tongQuanButton.setOnAction(event -> {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("ToTruongTongQuan.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                Notifications.create()
                        .title("Lỗi!")
                        .text("Lỗi hệ thống")
                        .position(Pos.TOP_RIGHT)
                        .hideAfter(Duration.seconds(5))
                        .showError();
            }
        });
        themMenu.getItems().retainAll(themNhanKhauItem, themHoKhauItem, themTestCovidItem, TachHoKhauItem);
    }

    private void yTeScene() {
        tongQuanButton.setOnAction(event -> {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("YTeTongQuan.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                Notifications.create()
                        .title("Lỗi!")
                        .text("Lỗi hệ thống")
                        .position(Pos.TOP_RIGHT)
                        .hideAfter(Duration.seconds(5))
                        .showError();
            }
        });
        themMenu.getItems().retainAll(themTestCovidItem);
        xemMenu.getItems().retainAll(xemKhaiBaoYTeItem, xemTestCovidItem, xemBenhNhanQuocGiaItem, xemCachLyDiaPhuongItem);
    }
}
