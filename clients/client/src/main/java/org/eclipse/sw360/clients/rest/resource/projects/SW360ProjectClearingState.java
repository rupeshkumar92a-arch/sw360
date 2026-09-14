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

public enum SW360ProjectClearingState {
    OPEN(0),
    IN_PROGRESS(1),
    CLOSED(2);

    private final int value;

    SW360ProjectClearingState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SW360ProjectClearingState findByValue(int value) {
        switch (value) {
            case 0:
                return OPEN;
            case 1:
                return IN_PROGRESS;
            case 2:
                return CLOSED;
            default:
                return null;
        }
    }
}
