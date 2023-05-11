package abstraction;

import com.codeborne.selenide.Selenide;

public interface Gherkin {

    default <T> T at(Class<T> page) {
        return Selenide.page(page);
    }

    default <T> T given(Class<T> page) {
        return Selenide.page(page);
    }

    default <T> T when(Class<T> page) {
        return Selenide.page(page);
    }

    default <T> T then(Class<T> page) {
        return Selenide.page(page);
    }

    default <T> T and(Class<T> page) {
        return Selenide.page(page);
    }

}
