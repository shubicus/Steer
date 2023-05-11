package org.shubicus.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.tinylog.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {

    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $x("//button[.='Log In']");

    @Step
    public LoginPage openLoginPage() {
        Logger.info("Open Login page");
        Selenide.open("/");
        return new LoginPage();
    }

    @Step
    public ShopPage loginByUser(String username, String password) {
        Logger.info("Input Login credentials");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ShopPage();
    }

}
