/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.simpledb.model.transform;

import org.w3c.dom.Node;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import com.amazonaws.transform.LegacyErrorUnmarshaller;

import com.amazonaws.services.simpledb.model.NumberDomainBytesExceededException;

public class NumberDomainBytesExceededExceptionUnmarshaller extends
        LegacyErrorUnmarshaller {

    public NumberDomainBytesExceededExceptionUnmarshaller() {
        super(NumberDomainBytesExceededException.class);
    }

    @Override
    public AmazonServiceException unmarshall(Node node) throws Exception {
        // Bail out if this isn't the right error code that this
        // marshaller understands
        String errorCode = parseErrorCode(node);
        if (errorCode == null || !errorCode.equals("NumberDomainBytesExceeded"))
            return null;

        NumberDomainBytesExceededException e = (NumberDomainBytesExceededException) super
                .unmarshall(node);
        e.setBoxUsage(XpathUtils
                .asFloat(getErrorPropertyPath("BoxUsage"), node));

        return e;
    }
}
