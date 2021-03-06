/*
 * Copyright 2004-2016 EPAM Systems
 *
 * This file is part of JDI project.
 *
 * JDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JDI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty ofMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JDI. If not, see <http://www.gnu.org/licenses/>.
 */
package com.ggasoftware.jdiuitest.core.interfaces.settings;

import com.ggasoftware.jdiuitest.core.utils.linqinterfaces.JFuncT;
import com.ggasoftware.jdiuitest.core.utils.linqinterfaces.JFuncTEx;

/**
 * Created by Roman_Iovlev on 6/9/2015.
 */
public interface IAsserter {
    RuntimeException exception(String message, Object... args);

    <TResult> TResult silent(JFuncTEx<TResult> func);

    <T> void areEquals(T actual, T expected);

    void matches(String actual, String regEx);

    void contains(String actual, String expected);

    void isTrue(Boolean actual);

    void isTrue(JFuncT<Boolean> actual);
}