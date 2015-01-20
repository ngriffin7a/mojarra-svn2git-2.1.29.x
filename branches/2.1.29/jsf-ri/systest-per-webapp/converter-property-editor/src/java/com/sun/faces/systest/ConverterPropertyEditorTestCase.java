/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.faces.systest;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlBody;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.sun.faces.htmlunit.HtmlUnitFacesTestCase;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javax.faces.component.NamingContainer;


/**
 * <p>Make sure that an application that replaces the ApplicationFactory
 * but uses the decorator pattern to allow the existing ApplicationImpl
 * to do the bulk of the requests works.</p>
 */

public class ConverterPropertyEditorTestCase extends HtmlUnitFacesTestCase {


    // ------------------------------------------------------------ Constructors


    /**
     * Construct a new instance of this test case.
     *
     * @param name Name of the test case
     */
    public ConverterPropertyEditorTestCase(String name) {
        super(name);
    }


    // ------------------------------------------------------ Instance Variables


    // ---------------------------------------------------- Overall Test Methods


    /**
     * Set up instance variables required by this test case.
     */
    public void setUp() throws Exception {
        super.setUp();
    }


    /**
     * Return the tests included in this test suite.
     */
    public static Test suite() {
        return (new TestSuite(ConverterPropertyEditorTestCase.class));
    }


    /**
     * Tear down instance variables required by this test case.
     */
    public void tearDown() {
        super.tearDown();
    }


    // ------------------------------------------------------ Instance Variables



    // ------------------------------------------------- Individual Test Methods

    /**
     *
     * <p>Verify that selectOne conversion has successfully occurred.</p>
     */

    public void testConverterPropertyEditor() throws Exception {
	HtmlPage page;
	List list;
	HtmlSubmitInput button;

	page = getPage("/faces/selectone.jsp");
	list = getAllElementsOfGivenClass(page, null, 
					  HtmlSubmitInput.class); 
	button = (HtmlSubmitInput) list.get(0);
	page = (HtmlPage) button.click();

	assertTrue(-1 != page.asText().indexOf("This selectOneMenu is bound to a list of test.Payment"));
    assertTrue(!page.asText().contains("Validation Error"));

    page = getPage("/faces/selectoneRadio.jsp");
	list = getAllElementsOfGivenClass(page, null, HtmlSubmitInput.class); 
	button = (HtmlSubmitInput) list.get(0);
	page = (HtmlPage) button.click();

	assertTrue(-1 != page.asText().indexOf("This selectOneRadio is bound to a list of test.Payment"));
    assertTrue(!page.asText().contains("Validation Error"));

    page = getPage("/faces/selectmany.jsp");
	list = getAllElementsOfGivenClass(page, null, HtmlSubmitInput.class); 
	button = (HtmlSubmitInput) list.get(0);
	page = (HtmlPage) button.click();

	assertTrue(-1 != page.asText().indexOf("This selectManyMenu is bound to a list of test.Payment"));
    assertTrue(!page.asText().contains("Validation Error"));

        page = getPage("/faces/selectmanyListbox.jsp");
        list = getAllElementsOfGivenClass(page, null, HtmlSubmitInput.class); 
        button = (HtmlSubmitInput) list.get(0);
        page = (HtmlPage) button.click();

        assertTrue(-1 != page.asText().indexOf("This selectManyListbox is bound to a list of test.Payment"));
        assertTrue(!page.asText().contains("Validation Error"));

        page = getPage("/faces/selectmanyCheckbox.jsp");
        list = getAllElementsOfGivenClass(page, null, HtmlSubmitInput.class); 
        button = (HtmlSubmitInput) list.get(0);
        page = (HtmlPage) button.click();

        assertTrue(-1 != page.asText().indexOf("This selectManyCheckbox is bound to a list of test.Payment"));
        assertTrue(!page.asText().contains("Validation Error"));

    }

}