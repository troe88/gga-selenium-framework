package com.epam.jditests.tests.common.utils;

import com.epam.jditests.enums.Preconditions;
import com.ggasoftware.jdiuitest.core.interfaces.common.IText;
import com.ggasoftware.jdiuitest.core.utils.linqinterfaces.JFuncT;
import com.ggasoftware.jdiuitest.web.selenium.elements.base.Element;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.epam.jditests.enums.Preconditions.SUPPORT_PAGE;
import static com.epam.jditests.pageobjects.EpamJDISite.isInState;
import static com.epam.jditests.tests.complex.CommonActionsData.*;
import static com.ggasoftware.jdiuitest.web.testng.asserter.Assert.isTrue;

public class MatchTextTests {
    private String _expected;
    private String _regex;
    private Preconditions _onPage;
    private JFuncT<Element> _element;

    public MatchTextTests(String expected, String regex, Preconditions onPage, JFuncT<Element> element) {
        _expected = expected;
        _regex = regex;
        _onPage = onPage;
        _element = element;
    }

    @BeforeMethod
    public void before(final Method method) {
        isInState(_onPage, method);
    }

    @Test
    public void waitMatchText() throws Exception {
        checkText(() -> ((IText) _element.invoke()).waitMatchText(_regex), _expected);
    }

    @Test
    public void waitMatchTextParallel() throws Exception {
        isInState(SUPPORT_PAGE);
        runParallel(_onPage::open);
        checkText(() -> ((IText) _element.invoke()).waitMatchText(_regex), _expected);
        isTrue(timer.timePassedInMSec() > waitTimeOut);
    }

}
