package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferMoneyPage {
    private SelenideElement transferPage = $(withText("Пополнение карты"));
    private SelenideElement amount =  $$(".input__control[type=text]").first();
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement button = $(withText("Пополнить"));

    public void moneyTransferVisible() {
        transferPage.shouldBe(Condition.visible);
    }

    public DashboardPage addToFirstCard(Integer transfer) {
        amount.setValue(transfer.toString());
        from.setValue(DataHelper.getNumberOfSecondCard());
        button.click();
        return new DashboardPage();
    }

    public DashboardPage addToSecondCard(Integer transfer) {
        amount.setValue(transfer.toString());
        from.setValue(DataHelper.getNumberOfFirstCard());
        button.click();
        return new DashboardPage();
    }

}
