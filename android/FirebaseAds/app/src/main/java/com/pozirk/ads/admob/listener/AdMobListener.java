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

package com.pozirk.ads.admob.listener;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.pozirk.ads.admob.manager.AdTypesSupportedEnum;
import com.pozirk.ads.admob.context.ExtensionContext;

public class AdMobListener extends AdListener
{
	protected ExtensionContext _ctx ;
	protected AdTypesSupportedEnum _who;
	
	public AdMobListener(ExtensionContext ctx, AdTypesSupportedEnum type)
	{
		_ctx = ctx;
		_who = type;
	}
	
    @Override
    public void onAdLoaded()
    {
        if(_who == AdTypesSupportedEnum.BANNER)
        {
            _ctx.getAdMobMan().bannerOnTop();
            _ctx.dispatchStatusEventAsync(_who.getType()+"_SHOW_OK", "");
        }
        else {
            _ctx.dispatchStatusEventAsync(_who.getType()+"_CACHE_OK", "");
        }

    }

   @Override
   public void onAdFailedToLoad(int errorCode)
   {
     String errorReason = "";
     switch(errorCode)
     {
       case AdRequest.ERROR_CODE_INTERNAL_ERROR:
         errorReason = "Internal error";
         break;
       case AdRequest.ERROR_CODE_INVALID_REQUEST:
         errorReason = "Invalid request";
         break;
       case AdRequest.ERROR_CODE_NETWORK_ERROR:
         errorReason = "Network Error";
         break;
       case AdRequest.ERROR_CODE_NO_FILL:
         errorReason = "No fill";
         break;
     }
    
     if(_who == AdTypesSupportedEnum.BANNER) {
         _ctx.dispatchStatusEventAsync(_who.getType() + "_SHOW_FAIL", errorReason);
     }
     else {
         _ctx.dispatchStatusEventAsync(_who.getType() + "_CACHE_FAIL", errorReason);
     }
   }

   @Override
   public void onAdOpened()
   {
  	 _ctx.dispatchStatusEventAsync(_who.getType()+"_OPENED", "So, you've just earned some money, huh?");
   }

   @Override
   public void onAdClosed()
   {
  	 _ctx.dispatchStatusEventAsync(_who.getType()+"_CLOSED", "");
   }
   
   @Override
   public void onAdLeftApplication()
   {
  	 _ctx.dispatchStatusEventAsync(_who.getType()+"_LEFT_APP", "");
   }
}