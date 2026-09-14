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
package org.eclipse.sw360.clients.rest.resource.projects;

public enum SW360ProjectState {
    ACTIVE(0),
    PHASE_OUT(1),
    UNKNOWN(2),
    SVM_ONLY(3),
    PRIVATE(4),
    UNDER_DEVELOPMENT(5),
    RELEASED(6);

    private final int value;

    SW360ProjectState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SW360ProjectState findByValue(int value) {
        switch (value) {
            case 0:
                return ACTIVE;
            case 1:
                return PHASE_OUT;
            case 2:
                return UNKNOWN;
            case 3:
                return SVM_ONLY;
            case 4:
                return PRIVATE;
            case 5:
                return UNDER_DEVELOPMENT;
            case 6:
                return RELEASED;
            default:
                return null;
        }
    }
}
