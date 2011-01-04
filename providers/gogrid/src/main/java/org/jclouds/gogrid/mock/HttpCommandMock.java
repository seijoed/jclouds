/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.gogrid.mock;

import java.net.URI;

import org.jclouds.http.HttpCommand;
import org.jclouds.http.HttpRequest;

/**
 * @author Oleksiy Yarmula
 */
public class HttpCommandMock implements HttpCommand {

   @Override
   public int incrementRedirectCount() {
      return 0;
   }

   @Override
   public int getRedirectCount() {
      return 0;
   }

   @Override
   public boolean isReplayable() {
      return false;
   }

   @Override
   public int incrementFailureCount() {
      return 0;
   }

   @Override
   public int getFailureCount() {
      return 0;
   }

   @Override
   public HttpRequest getCurrentRequest() {
      return new HttpRequest("GET", URI.create("http://localhost"));
   }

   @Override
   public void setException(Exception exception) {
   }

   @Override
   public Exception getException() {
      return null;
   }

   @Override
   public void setCurrentRequest(HttpRequest request) {
      
   }
}