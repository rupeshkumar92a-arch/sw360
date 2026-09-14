/*
 * Copyright Siemens AG, 2013-2015. Part of the SW360 Portal Project.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.sw360.search;

import org.apache.thrift.TException;
import org.eclipse.sw360.datahandler.common.DatabaseSettingsTest;
import org.eclipse.sw360.datahandler.thrift.search.SearchResult;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class SearchHandlerTest {

    SearchHandler handler;

    @Before
    public void setUp() throws Exception {
        handler = new SearchHandler(DatabaseSettingsTest.getConfiguredClient(), DatabaseSettingsTest.COUCH_DB_DATABASE);
    }

    @Test(expected = TException.class)
    public void testSearchNull() throws Exception {
        handler.search(null, null);
    }

    public void testSearchEmpty() throws Exception {
        assertThat(handler.search("", null).size(), is(0));
    }

    @Test
    public void testSearchResultsAreSortedByScoreDescending() {
        List<SearchResult> results = new ArrayList<>(List.of(
                new SearchResult("low", "project", "Low", 0.2),
                new SearchResult("high", "project", "High", 0.9),
                new SearchResult("medium", "project", "Medium", 0.5)));

        results.sort(handler.new SearchResultComparator());

        for (int index = 0; index < results.size() - 1; index++) {
            assertThat(results.get(index).getScore(),
                    is(greaterThanOrEqualTo(results.get(index + 1).getScore())));
        }
    }
}
