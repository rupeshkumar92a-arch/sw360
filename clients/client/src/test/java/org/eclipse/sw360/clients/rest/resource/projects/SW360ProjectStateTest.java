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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SW360ProjectStateTest {
    private void checkFindByValue(SW360ProjectState state, int value) {
        SW360ProjectState result = SW360ProjectState.findByValue(value);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(state);
        assertThat(result.getValue()).isEqualTo(value);
    }

    @Test
    public void testFindByValueActive() {
        checkFindByValue(SW360ProjectState.ACTIVE, 0);
    }

    @Test
    public void testFindByValuePhaseOut() {
        checkFindByValue(SW360ProjectState.PHASE_OUT, 1);
    }

    @Test
    public void testFindByValueUnknown() {
        checkFindByValue(SW360ProjectState.UNKNOWN, 2);
    }

    @Test
    public void testFindByValueSvmOnly() {
        checkFindByValue(SW360ProjectState.SVM_ONLY, 3);
    }

    @Test
    public void testFindByValuePrivate() {
        checkFindByValue(SW360ProjectState.PRIVATE, 4);
    }

    @Test
    public void testFindByValueUnderDevelopment() {
        checkFindByValue(SW360ProjectState.UNDER_DEVELOPMENT, 5);
    }

    @Test
    public void testFindByValueReleased() {
        checkFindByValue(SW360ProjectState.RELEASED, 6);
    }

    @Test
    public void testFindByValueUnknownState() {
        SW360ProjectState result = SW360ProjectState.findByValue(111);

        assertThat(result).isNull();
    }
}
