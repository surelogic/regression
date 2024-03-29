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

import com.sun.grizzly.Controller.Protocol;

/**
 * Interface representing ConnectorHandler pool
 * Implementation of this interface will be responsible for
 * allocating/releasing client side <code>ConnectorHandler</code>s
 * 
 * @param E ConnectorHandler implementation class
 * 
 * @author Alexey Stashok
 */
public interface ConnectorHandlerPool<E extends ConnectorHandler> {
    /**
     * Return an instance of <code>ConnectorHandler</code>,
     * which corresponds to the protocol
     * @param protocol a <code>Protocol</code>
     * @return <code>ConnectorHandler</code>
     */
    public E acquireConnectorHandler(Protocol protocol);
    
    /**
     * Release a ConnectorHandler.
     * @param connectorHandler - a <code>ConnectorHandler</code>
     */
    public void releaseConnectorHandler(E connectorHandler);
}
