/* Copyright (c) 2014 Pozirk Games
 * http://www.pozirk.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pozirk.ads.admob;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.pozirk.ads.admob.context.ExtensionContext;

public class Extension implements FREExtension
{
  public FREContext createContext(String contextType)
  {
  	return new ExtensionContext();
  }

  public void dispose()
  {
  }

  public void initialize()
  {
  }
}