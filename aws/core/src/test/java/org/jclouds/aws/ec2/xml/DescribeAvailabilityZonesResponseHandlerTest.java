/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 */
package org.jclouds.aws.ec2.xml;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.util.Set;

import org.jclouds.aws.ec2.domain.AvailabilityZone;
import org.jclouds.aws.ec2.domain.AvailabilityZoneInfo;
import org.jclouds.aws.ec2.domain.Region;
import org.jclouds.http.functions.BaseHandlerTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;

/**
 * Tests behavior of {@code DescribeAvailabilityZonesResponseHandler}
 * 
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "ec2.DescribeAvailabilityZonesResponseHandlerTest")
public class DescribeAvailabilityZonesResponseHandlerTest extends BaseHandlerTest {

   public void testApplyInputStream() {

      InputStream is = getClass().getResourceAsStream("/ec2/availabilityZones.xml");

      Set<AvailabilityZoneInfo> expected = ImmutableSet.<AvailabilityZoneInfo> of(
               new AvailabilityZoneInfo("us-east-1a", AvailabilityZone.US_EAST_1A,
                        AvailabilityZoneInfo.State.AVAILABLE, Region.US_EAST_1, ImmutableSet
                                 .<String> of()), new AvailabilityZoneInfo("us-east-1b",
                        AvailabilityZone.US_EAST_1B, AvailabilityZoneInfo.State.AVAILABLE,
                        Region.US_EAST_1, ImmutableSet.<String> of()), new AvailabilityZoneInfo(
                        "us-east-1c", AvailabilityZone.US_EAST_1C,
                        AvailabilityZoneInfo.State.AVAILABLE, Region.US_EAST_1, ImmutableSet
                                 .<String> of("our service is awesome")), new AvailabilityZoneInfo(
                        "us-east-1d", AvailabilityZone.US_EAST_1D,
                        AvailabilityZoneInfo.State.UNKNOWN, Region.US_EAST_1, ImmutableSet
                                 .<String> of()));
      Set<AvailabilityZoneInfo> result = factory.create(
               injector.getInstance(DescribeAvailabilityZonesResponseHandler.class)).parse(is);

      assertEquals(result, expected);
   }

}