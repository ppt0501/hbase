/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.snapshot;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.testclassification.SmallTests;
import org.apache.hadoop.hbase.mob.MobConstants;
import org.apache.hadoop.hbase.snapshot.MobSnapshotTestingUtils.SnapshotMock;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

/**
 * Test the restore/clone operation from a file-system point of view.
 */
@Category(SmallTests.class)
public class TestMobRestoreSnapshotHelper extends TestRestoreSnapshotHelper {
  final Log LOG = LogFactory.getLog(getClass());

  @Override
  protected void setupConf(Configuration conf) {
    conf.setInt(MobConstants.MOB_FILE_CACHE_SIZE_KEY, 0);
  }

  @Override
  protected SnapshotMock createSnapshotMock() throws IOException {
    return new SnapshotMock(TEST_UTIL.getConfiguration(), fs, rootDir);
  }
}