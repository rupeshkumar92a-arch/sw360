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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SW360ClearingStateTest {
    private void checkFindByValue(SW360ClearingState state, int value) {
        SW360ClearingState result = SW360ClearingState.findByValue(value);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(state);
        assertThat(result.getValue()).isEqualTo(value);
    }

    @Test
    public void testFindByValueNewClearing() {
        checkFindByValue(SW360ClearingState.NEW_CLEARING, 0);
    }

    @Test
    public void testFindByValueSentToClearingTool() {
        checkFindByValue(SW360ClearingState.SENT_TO_CLEARING_TOOL, 1);
    }

    @Test
    public void testFindByValueUnderClearing() {
        checkFindByValue(SW360ClearingState.UNDER_CLEARING, 2);
    }

    @Test
    public void testFindByValueReportAvailable() {
        checkFindByValue(SW360ClearingState.REPORT_AVAILABLE, 3);
    }

    @Test
    public void testFindByValueApproved() {
        checkFindByValue(SW360ClearingState.APPROVED, 4);
    }

    @Test
    public void testFindByValueScanAvailable() {
        checkFindByValue(SW360ClearingState.SCAN_AVAILABLE, 5);
    }

    @Test
    public void testFindByValueInternalUseScanAvailable() {
        checkFindByValue(SW360ClearingState.INTERNAL_USE_SCAN_AVAILABLE, 6);
    }

    @Test
    public void testFindByValueUnknown() {
        SW360ClearingState result = SW360ClearingState.findByValue(111);

        assertThat(result).isNull();
    }
}
