/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License).  You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://glassfish.dev.java.net/public/CDDLv1.0.html or
 * glassfish/bootstrap/legal/CDDLv1.0.txt.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at glassfish/bootstrap/legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 */

package com.sun.grizzly;

import java.io.IOException;

/**
 * A ProtocolFilter encapsulates a unit of processing work to be performed, 
 * whose purpose is to examine and/or modify the state of a transaction that is 
 * represented by a ProtocolContext. Individual ProtocolFilter can be assembled
 * into a ProtocolChain, which allows them to either complete the required 
 * processing or delegate further processing to the next ProtocolFilter in the 
 * ProtocolChain.
 *
 * ProtocolFilter implementations should be designed in a thread-safe manner, 
 * suitable for inclusion in multiple ProtocolChains that might be processed by
 * different threads simultaneously. In general, this implies that ProtocolFilter
 * classes should not maintain state information in instance variables. 
 * Instead, state information should be maintained via suitable modifications to
 * the attributes of the ProtocolContext that is passed to the execute() and
 * postExecute() methods.
 *
 * ProtocolFilter implementations typically retrieve and store state information
 * in the ProtocolContext instance that is passed as a parameter to the 
 * execute() and postExecute method, using particular keys into the Map that can
 * be acquired via ProtocolContext.getAttributes(). 
 *
 * @author Jeanfrancois Arcand
 */
public interface ProtocolFilter {
     
    
    public final static String SUCCESSFUL_READ = "succes_read";
    
    
    /**
     * Execute a unit of processing work to be performed. This ProtocolFilter
     * may either complete the required processing and return false, 
     * or delegate remaining processing to the next ProtocolFilter in a 
     * ProtocolChain containing this ProtocolFilter by returning true.
     * @param ctx <code>Context</code>
     * @return 
     * @throws java.io.IOException 
     */
    public boolean execute(Context ctx) throws IOException;
    
    
    /**
     * Execute any cleanup activities, such as releasing resources that were 
     * acquired during the execute() method of this ProtocolFilter instance.
     * @param ctx <code>Context</code>
     * @return 
     * @throws java.io.IOException 
     */
    public boolean postExecute(Context ctx) throws IOException;
}
