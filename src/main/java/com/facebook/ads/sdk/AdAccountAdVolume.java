/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdAccountAdVolume extends APINode {
  @SerializedName("actor_id")
  private String mActorId = null;
  @SerializedName("has_hit_total_live_ads_limit")
  private Boolean mHasHitTotalLiveAdsLimit = null;
  @SerializedName("live_ads_quota_left")
  private Long mLiveAdsQuotaLeft = null;
  @SerializedName("total_live_ads")
  private Long mTotalLiveAds = null;
  @SerializedName("total_live_ads_in_current_account")
  private Long mTotalLiveAdsInCurrentAccount = null;
  @SerializedName("total_live_ads_limit")
  private Long mTotalLiveAdsLimit = null;
  protected static Gson gson = null;

  public AdAccountAdVolume() {
  }

  public String getId() {
    return null;
  }
  public static AdAccountAdVolume loadJSON(String json, APIContext context, String header) {
    AdAccountAdVolume adAccountAdVolume = getGson().fromJson(json, AdAccountAdVolume.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adAccountAdVolume.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adAccountAdVolume.context = context;
    adAccountAdVolume.rawValue = json;
    adAccountAdVolume.header = header;
    return adAccountAdVolume;
  }

  public static APINodeList<AdAccountAdVolume> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdAccountAdVolume> adAccountAdVolumes = new APINodeList<AdAccountAdVolume>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adAccountAdVolumes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adAccountAdVolumes;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adAccountAdVolumes.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adAccountAdVolumes.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adAccountAdVolumes.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adAccountAdVolumes.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adAccountAdVolumes.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adAccountAdVolumes.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adAccountAdVolumes;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adAccountAdVolumes.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adAccountAdVolumes;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              adAccountAdVolumes.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adAccountAdVolumes;
          }

          // Sixth, check if it's pure JsonObject
          adAccountAdVolumes.clear();
          adAccountAdVolumes.add(loadJSON(json, context, header));
          return adAccountAdVolumes;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldActorId() {
    return mActorId;
  }

  public AdAccountAdVolume setFieldActorId(String value) {
    this.mActorId = value;
    return this;
  }

  public Boolean getFieldHasHitTotalLiveAdsLimit() {
    return mHasHitTotalLiveAdsLimit;
  }

  public AdAccountAdVolume setFieldHasHitTotalLiveAdsLimit(Boolean value) {
    this.mHasHitTotalLiveAdsLimit = value;
    return this;
  }

  public Long getFieldLiveAdsQuotaLeft() {
    return mLiveAdsQuotaLeft;
  }

  public AdAccountAdVolume setFieldLiveAdsQuotaLeft(Long value) {
    this.mLiveAdsQuotaLeft = value;
    return this;
  }

  public Long getFieldTotalLiveAds() {
    return mTotalLiveAds;
  }

  public AdAccountAdVolume setFieldTotalLiveAds(Long value) {
    this.mTotalLiveAds = value;
    return this;
  }

  public Long getFieldTotalLiveAdsInCurrentAccount() {
    return mTotalLiveAdsInCurrentAccount;
  }

  public AdAccountAdVolume setFieldTotalLiveAdsInCurrentAccount(Long value) {
    this.mTotalLiveAdsInCurrentAccount = value;
    return this;
  }

  public Long getFieldTotalLiveAdsLimit() {
    return mTotalLiveAdsLimit;
  }

  public AdAccountAdVolume setFieldTotalLiveAdsLimit(Long value) {
    this.mTotalLiveAdsLimit = value;
    return this;
  }




  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public AdAccountAdVolume copyFrom(AdAccountAdVolume instance) {
    this.mActorId = instance.mActorId;
    this.mHasHitTotalLiveAdsLimit = instance.mHasHitTotalLiveAdsLimit;
    this.mLiveAdsQuotaLeft = instance.mLiveAdsQuotaLeft;
    this.mTotalLiveAds = instance.mTotalLiveAds;
    this.mTotalLiveAdsInCurrentAccount = instance.mTotalLiveAdsInCurrentAccount;
    this.mTotalLiveAdsLimit = instance.mTotalLiveAdsLimit;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdAccountAdVolume> getParser() {
    return new APIRequest.ResponseParser<AdAccountAdVolume>() {
      public APINodeList<AdAccountAdVolume> parseResponse(String response, APIContext context, APIRequest<AdAccountAdVolume> request, String header) throws MalformedResponseException {
        return AdAccountAdVolume.parseResponse(response, context, request, header);
      }
    };
  }
}
