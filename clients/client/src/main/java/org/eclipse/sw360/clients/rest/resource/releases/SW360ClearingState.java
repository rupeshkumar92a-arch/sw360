/*
 * Copyright (c) Bosch.IO GmbH 2020.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.sw360.clients.rest.resource.releases;

/**
 * This enumeration class mimics the clearing states available in SW360.
 */
public enum SW360ClearingState {
    NEW_CLEARING(0),
    SENT_TO_CLEARING_TOOL(1),
    UNDER_CLEARING(2),
    REPORT_AVAILABLE(3),
    APPROVED(4),
    SCAN_AVAILABLE(5),
    INTERNAL_USE_SCAN_AVAILABLE(6);

    private final int value;

    SW360ClearingState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SW360ClearingState findByValue(int value) {
        switch (value) {
            case 0:
                return NEW_CLEARING;
            case 1:
                return SENT_TO_CLEARING_TOOL;
            case 2:
                return UNDER_CLEARING;
            case 3:
                return REPORT_AVAILABLE;
            case 4:
                return APPROVED;
            case 5:
                return SCAN_AVAILABLE;
            case 6:
                return INTERNAL_USE_SCAN_AVAILABLE;
            default:
                return null;
        }
    }
}
