/**
 *
 * Copyright (C) 2009 Global Cloud Specialists, Inc. <info@globalcloudspecialists.com>
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
package org.jclouds.rackspace.cloudservers.binders;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.http.binders.JsonBinder;
import org.jclouds.rackspace.cloudservers.domain.RebootType;

import com.google.common.collect.ImmutableMap;

/**
 * 
 * @author Adrian Cole
 * 
 */
public class RebootTypeBinder extends JsonBinder {

   @Override
   public void addEntityToRequest(Map<String, String> postParams, HttpRequest request) {
      throw new IllegalStateException("Reboot doesn't take map parameters");
   }

   @Override
   public void addEntityToRequest(Object toBind, HttpRequest request) {
      checkArgument(toBind instanceof RebootType, "this binder is only valid for RebootTypes!");
      super.addEntityToRequest(ImmutableMap.of("reboot", ImmutableMap.of("type", checkNotNull(
               toBind, "type"))), request);
   }
}