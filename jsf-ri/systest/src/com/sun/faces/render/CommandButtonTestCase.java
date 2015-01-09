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

package com.sun.faces.render;

import com.sun.faces.htmlunit.HtmlUnitFacesTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
import com.gargoylesoftware.htmlunit.html.*;

public class CommandButtonTestCase extends HtmlUnitFacesTestCase {

    public CommandButtonTestCase(String name) {
        super(name);
    }

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
        return (new TestSuite(CommandButtonTestCase.class));
    }


    /**
     * Tear down instance variables required by this test case.
     */
    public void tearDown() {
        super.tearDown();
    }


    public void testCommandButtonButton() throws Exception {
        getPage("/faces/render/commandButtonButton.xhtml");
        System.out.println("Start command Button type=button test");
        // First we'll check the first page was output correctly
        assertTrue(check("out1","0"));
        assertTrue(check("outside","1"));

        // Submit the ajax tagged request
        HtmlButtonInput button = (HtmlButtonInput) lastpage.getHtmlElementById("button1");
        lastpage = (HtmlPage) button.click();

        // Check that the ajax request succeeds
        assertTrue(check("out1","2"));

        // Check that the request did NOT update the rest of the page.
        assertTrue(check("outside","1"));

        // Submit the onclick enhanced request - with no return false
        button = (HtmlButtonInput) lastpage.getHtmlElementById("button2");
        lastpage = (HtmlPage) button.click();

        // Check that the ajax request succeeds
        assertTrue(check("out1","3"));

        // Check that the request did NOT update the rest of the page.
        assertTrue(check("outside","1"));

    }
}
