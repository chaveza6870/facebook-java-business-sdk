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
public class AdReportRun extends APINode {
  @SerializedName("account_id")
  private String mAccountId = null;
  @SerializedName("async_percent_completion")
  private Long mAsyncPercentCompletion = null;
  @SerializedName("async_status")
  private String mAsyncStatus = null;
  @SerializedName("date_start")
  private String mDateStart = null;
  @SerializedName("date_stop")
  private String mDateStop = null;
  @SerializedName("emails")
  private List<String> mEmails = null;
  @SerializedName("friendly_name")
  private String mFriendlyName = null;
  @SerializedName("id")
  private String mId = null;
  @SerializedName("is_bookmarked")
  private Boolean mIsBookmarked = null;
  @SerializedName("is_running")
  private Boolean mIsRunning = null;
  @SerializedName("schedule_id")
  private String mScheduleId = null;
  @SerializedName("time_completed")
  private Long mTimeCompleted = null;
  @SerializedName("time_ref")
  private Long mTimeRef = null;
  protected static Gson gson = null;

  AdReportRun() {
  }

  public AdReportRun(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdReportRun(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdReportRun fetch() throws APIException{
    AdReportRun newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdReportRun fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdReportRun> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdReportRun fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdReportRun> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdReportRun> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdReportRun>)(
      new APIRequest<AdReportRun>(context, "", "/", "GET", AdReportRun.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdReportRun>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdReportRun.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdReportRun loadJSON(String json, APIContext context, String header) {
    AdReportRun adReportRun = getGson().fromJson(json, AdReportRun.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adReportRun.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adReportRun.context = context;
    adReportRun.rawValue = json;
    adReportRun.header = header;
    JsonParser parser = new JsonParser();
    JsonObject o = parser.parse(json).getAsJsonObject();
    String reportRunId = null;
    if (o.has("report_run_id")) {
      reportRunId = o.get("report_run_id").getAsString();
      if (reportRunId != null) {
        adReportRun.mId = reportRunId;
      }
    }
    return adReportRun;
  }

  public static APINodeList<AdReportRun> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdReportRun> adReportRuns = new APINodeList<AdReportRun>(request, json, header);
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
          adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adReportRuns;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adReportRuns.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adReportRuns.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adReportRuns.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adReportRuns.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
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
                  adReportRuns.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adReportRuns.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adReportRuns;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adReportRuns.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adReportRuns;
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
              adReportRuns.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adReportRuns;
          }

          // Sixth, check if it's pure JsonObject
          adReportRuns.clear();
          adReportRuns.add(loadJSON(json, context, header));
          return adReportRuns;
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

  public APIRequestGetInsights getInsights() {
    return new APIRequestGetInsights(this.getPrefixedId().toString(), context);
  }

  public APIRequestDelete delete() {
    return new APIRequestDelete(this.getPrefixedId().toString(), context);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }

  public APIRequestUpdate update() {
    return new APIRequestUpdate(this.getPrefixedId().toString(), context);
  }


  public String getFieldAccountId() {
    return mAccountId;
  }

  public Long getFieldAsyncPercentCompletion() {
    return mAsyncPercentCompletion;
  }

  public String getFieldAsyncStatus() {
    return mAsyncStatus;
  }

  public String getFieldDateStart() {
    return mDateStart;
  }

  public String getFieldDateStop() {
    return mDateStop;
  }

  public List<String> getFieldEmails() {
    return mEmails;
  }

  public String getFieldFriendlyName() {
    return mFriendlyName;
  }

  public String getFieldId() {
    return mId;
  }

  public Boolean getFieldIsBookmarked() {
    return mIsBookmarked;
  }

  public Boolean getFieldIsRunning() {
    return mIsRunning;
  }

  public String getFieldScheduleId() {
    return mScheduleId;
  }

  public Long getFieldTimeCompleted() {
    return mTimeCompleted;
  }

  public Long getFieldTimeRef() {
    return mTimeRef;
  }



  public static class APIRequestGetInsights extends APIRequest<AdsInsights> {

    APINodeList<AdsInsights> lastResponse = null;
    @Override
    public APINodeList<AdsInsights> getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_currency",
      "account_id",
      "account_name",
      "action_values",
      "actions",
      "actions_per_impression",
      "actions_results",
      "activity_recency",
      "ad_bid_type",
      "ad_bid_value",
      "ad_click_actions",
      "ad_delivery",
      "ad_format_asset",
      "ad_id",
      "ad_impression_actions",
      "ad_name",
      "adset_bid_type",
      "adset_bid_value",
      "adset_budget_type",
      "adset_budget_value",
      "adset_delivery",
      "adset_end",
      "adset_id",
      "adset_name",
      "adset_start",
      "age",
      "age_targeting",
      "amount_in_catalog_currency",
      "app_store_clicks",
      "attention_events_per_impression",
      "attention_events_unq_per_reach",
      "auction_bid",
      "auction_competitiveness",
      "auction_max_competitor_bid",
      "body_asset",
      "buying_type",
      "call_to_action_asset",
      "call_to_action_clicks",
      "campaign_delivery",
      "campaign_end",
      "campaign_id",
      "campaign_name",
      "campaign_start",
      "cancel_subscription_actions",
      "canvas_avg_view_percent",
      "canvas_avg_view_time",
      "card_views",
      "catalog_segment_actions",
      "catalog_segment_value_in_catalog_currency",
      "catalog_segment_value_mobile_purchase_roas",
      "catalog_segment_value_website_purchase_roas",
      "clicks",
      "conditional_time_spent_ms_over_10s_actions",
      "conditional_time_spent_ms_over_15s_actions",
      "conditional_time_spent_ms_over_2s_actions",
      "conditional_time_spent_ms_over_3s_actions",
      "conditional_time_spent_ms_over_6s_actions",
      "contact_actions",
      "contact_value",
      "conversion_rate_ranking",
      "conversion_values",
      "conversions",
      "cost_per_10_sec_video_view",
      "cost_per_15_sec_video_view",
      "cost_per_2_sec_continuous_video_view",
      "cost_per_action_result",
      "cost_per_action_type",
      "cost_per_ad_click",
      "cost_per_completed_video_view",
      "cost_per_contact",
      "cost_per_conversion",
      "cost_per_customize_product",
      "cost_per_dda_countby_convs",
      "cost_per_donate",
      "cost_per_dwell",
      "cost_per_dwell_3_sec",
      "cost_per_dwell_5_sec",
      "cost_per_dwell_7_sec",
      "cost_per_estimated_ad_recallers",
      "cost_per_find_location",
      "cost_per_inline_link_click",
      "cost_per_inline_post_engagement",
      "cost_per_one_thousand_ad_impression",
      "cost_per_outbound_click",
      "cost_per_schedule",
      "cost_per_start_trial",
      "cost_per_submit_application",
      "cost_per_subscribe",
      "cost_per_thruplay",
      "cost_per_total_action",
      "cost_per_unique_action_type",
      "cost_per_unique_click",
      "cost_per_unique_conversion",
      "cost_per_unique_inline_link_click",
      "cost_per_unique_outbound_click",
      "country",
      "cpc",
      "cpm",
      "cpp",
      "created_time",
      "creative_fingerprint",
      "ctr",
      "customize_product_actions",
      "customize_product_value",
      "date_start",
      "date_stop",
      "dda_countby_convs",
      "deduping_1st_source_ratio",
      "deduping_2nd_source_ratio",
      "deduping_3rd_source_ratio",
      "deduping_ratio",
      "deeplink_clicks",
      "description_asset",
      "device_platform",
      "dma",
      "donate_actions",
      "donate_value",
      "dwell_3_sec",
      "dwell_5_sec",
      "dwell_7_sec",
      "dwell_rate",
      "earned_impression",
      "engagement_rate_ranking",
      "estimated_ad_recall_rate",
      "estimated_ad_recall_rate_lower_bound",
      "estimated_ad_recall_rate_upper_bound",
      "estimated_ad_recallers",
      "estimated_ad_recallers_lower_bound",
      "estimated_ad_recallers_upper_bound",
      "find_location_actions",
      "find_location_value",
      "frequency",
      "frequency_value",
      "full_view_impressions",
      "full_view_reach",
      "gender",
      "gender_targeting",
      "hourly_stats_aggregated_by_advertiser_time_zone",
      "hourly_stats_aggregated_by_audience_time_zone",
      "image_asset",
      "impression_device",
      "impressions",
      "impressions_auto_refresh",
      "impressions_gross",
      "inline_link_click_ctr",
      "inline_link_clicks",
      "inline_post_engagement",
      "instant_experience_clicks_to_open",
      "instant_experience_clicks_to_start",
      "instant_experience_outbound_clicks",
      "interactive_component_tap",
      "labels",
      "link_url_asset",
      "location",
      "media_asset",
      "mobile_app_purchase_roas",
      "newsfeed_avg_position",
      "newsfeed_clicks",
      "newsfeed_impressions",
      "objective",
      "optimization_goal",
      "outbound_clicks",
      "outbound_clicks_ctr",
      "performance_indicator",
      "place_page_id",
      "place_page_name",
      "placement",
      "platform_position",
      "product_id",
      "publisher_platform",
      "purchase_roas",
      "quality_ranking",
      "quality_score_ectr",
      "quality_score_ecvr",
      "quality_score_enfbr",
      "quality_score_organic",
      "reach",
      "recurring_subscription_payment_actions",
      "region",
      "relevance_score",
      "rule_asset",
      "schedule_actions",
      "schedule_value",
      "social_spend",
      "spend",
      "start_trial_actions",
      "start_trial_value",
      "submit_application_actions",
      "submit_application_value",
      "subscribe_actions",
      "subscribe_value",
      "thumb_stops",
      "title_asset",
      "today_spend",
      "total_action_value",
      "total_actions",
      "total_unique_actions",
      "unique_actions",
      "unique_clicks",
      "unique_conversions",
      "unique_ctr",
      "unique_impressions",
      "unique_inline_link_click_ctr",
      "unique_inline_link_clicks",
      "unique_link_clicks_ctr",
      "unique_outbound_clicks",
      "unique_outbound_clicks_ctr",
      "unique_video_continuous_2_sec_watched_actions",
      "unique_video_view_10_sec",
      "unique_video_view_15_sec",
      "updated_time",
      "video_10_sec_watched_actions",
      "video_15_sec_watched_actions",
      "video_30_sec_watched_actions",
      "video_asset",
      "video_avg_time_watched_actions",
      "video_complete_watched_actions",
      "video_completed_view_or_15s_passed_actions",
      "video_continuous_2_sec_watched_actions",
      "video_p100_watched_actions",
      "video_p25_watched_actions",
      "video_p50_watched_actions",
      "video_p75_watched_actions",
      "video_p95_watched_actions",
      "video_play_actions",
      "video_play_curve_actions",
      "video_play_retention_0_to_15s_actions",
      "video_play_retention_20_to_60s_actions",
      "video_play_retention_graph_actions",
      "video_thruplay_watched_actions",
      "video_time_watched_actions",
      "website_clicks",
      "website_ctr",
      "website_purchase_roas",
      "wish_bid",
    };

    @Override
    public APINodeList<AdsInsights> parseResponse(String response, String header) throws APIException {
      return AdsInsights.parseResponse(response, getContext(), this, header);
    }

    @Override
    public APINodeList<AdsInsights> execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINodeList<AdsInsights> execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(),rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINodeList<AdsInsights>> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINodeList<AdsInsights>>() {
           public APINodeList<AdsInsights> apply(ResponseWrapper result) {
             try {
               return APIRequestGetInsights.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGetInsights(String nodeId, APIContext context) {
      super(context, nodeId, "/insights", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGetInsights setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGetInsights setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGetInsights requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGetInsights requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGetInsights requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGetInsights requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGetInsights requestAccountCurrencyField () {
      return this.requestAccountCurrencyField(true);
    }
    public APIRequestGetInsights requestAccountCurrencyField (boolean value) {
      this.requestField("account_currency", value);
      return this;
    }
    public APIRequestGetInsights requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGetInsights requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGetInsights requestAccountNameField () {
      return this.requestAccountNameField(true);
    }
    public APIRequestGetInsights requestAccountNameField (boolean value) {
      this.requestField("account_name", value);
      return this;
    }
    public APIRequestGetInsights requestActionValuesField () {
      return this.requestActionValuesField(true);
    }
    public APIRequestGetInsights requestActionValuesField (boolean value) {
      this.requestField("action_values", value);
      return this;
    }
    public APIRequestGetInsights requestActionsField () {
      return this.requestActionsField(true);
    }
    public APIRequestGetInsights requestActionsField (boolean value) {
      this.requestField("actions", value);
      return this;
    }
    public APIRequestGetInsights requestActionsPerImpressionField () {
      return this.requestActionsPerImpressionField(true);
    }
    public APIRequestGetInsights requestActionsPerImpressionField (boolean value) {
      this.requestField("actions_per_impression", value);
      return this;
    }
    public APIRequestGetInsights requestActionsResultsField () {
      return this.requestActionsResultsField(true);
    }
    public APIRequestGetInsights requestActionsResultsField (boolean value) {
      this.requestField("actions_results", value);
      return this;
    }
    public APIRequestGetInsights requestActivityRecencyField () {
      return this.requestActivityRecencyField(true);
    }
    public APIRequestGetInsights requestActivityRecencyField (boolean value) {
      this.requestField("activity_recency", value);
      return this;
    }
    public APIRequestGetInsights requestAdBidTypeField () {
      return this.requestAdBidTypeField(true);
    }
    public APIRequestGetInsights requestAdBidTypeField (boolean value) {
      this.requestField("ad_bid_type", value);
      return this;
    }
    public APIRequestGetInsights requestAdBidValueField () {
      return this.requestAdBidValueField(true);
    }
    public APIRequestGetInsights requestAdBidValueField (boolean value) {
      this.requestField("ad_bid_value", value);
      return this;
    }
    public APIRequestGetInsights requestAdClickActionsField () {
      return this.requestAdClickActionsField(true);
    }
    public APIRequestGetInsights requestAdClickActionsField (boolean value) {
      this.requestField("ad_click_actions", value);
      return this;
    }
    public APIRequestGetInsights requestAdDeliveryField () {
      return this.requestAdDeliveryField(true);
    }
    public APIRequestGetInsights requestAdDeliveryField (boolean value) {
      this.requestField("ad_delivery", value);
      return this;
    }
    public APIRequestGetInsights requestAdFormatAssetField () {
      return this.requestAdFormatAssetField(true);
    }
    public APIRequestGetInsights requestAdFormatAssetField (boolean value) {
      this.requestField("ad_format_asset", value);
      return this;
    }
    public APIRequestGetInsights requestAdIdField () {
      return this.requestAdIdField(true);
    }
    public APIRequestGetInsights requestAdIdField (boolean value) {
      this.requestField("ad_id", value);
      return this;
    }
    public APIRequestGetInsights requestAdImpressionActionsField () {
      return this.requestAdImpressionActionsField(true);
    }
    public APIRequestGetInsights requestAdImpressionActionsField (boolean value) {
      this.requestField("ad_impression_actions", value);
      return this;
    }
    public APIRequestGetInsights requestAdNameField () {
      return this.requestAdNameField(true);
    }
    public APIRequestGetInsights requestAdNameField (boolean value) {
      this.requestField("ad_name", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetBidTypeField () {
      return this.requestAdsetBidTypeField(true);
    }
    public APIRequestGetInsights requestAdsetBidTypeField (boolean value) {
      this.requestField("adset_bid_type", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetBidValueField () {
      return this.requestAdsetBidValueField(true);
    }
    public APIRequestGetInsights requestAdsetBidValueField (boolean value) {
      this.requestField("adset_bid_value", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetBudgetTypeField () {
      return this.requestAdsetBudgetTypeField(true);
    }
    public APIRequestGetInsights requestAdsetBudgetTypeField (boolean value) {
      this.requestField("adset_budget_type", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetBudgetValueField () {
      return this.requestAdsetBudgetValueField(true);
    }
    public APIRequestGetInsights requestAdsetBudgetValueField (boolean value) {
      this.requestField("adset_budget_value", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetDeliveryField () {
      return this.requestAdsetDeliveryField(true);
    }
    public APIRequestGetInsights requestAdsetDeliveryField (boolean value) {
      this.requestField("adset_delivery", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetEndField () {
      return this.requestAdsetEndField(true);
    }
    public APIRequestGetInsights requestAdsetEndField (boolean value) {
      this.requestField("adset_end", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetIdField () {
      return this.requestAdsetIdField(true);
    }
    public APIRequestGetInsights requestAdsetIdField (boolean value) {
      this.requestField("adset_id", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetNameField () {
      return this.requestAdsetNameField(true);
    }
    public APIRequestGetInsights requestAdsetNameField (boolean value) {
      this.requestField("adset_name", value);
      return this;
    }
    public APIRequestGetInsights requestAdsetStartField () {
      return this.requestAdsetStartField(true);
    }
    public APIRequestGetInsights requestAdsetStartField (boolean value) {
      this.requestField("adset_start", value);
      return this;
    }
    public APIRequestGetInsights requestAgeField () {
      return this.requestAgeField(true);
    }
    public APIRequestGetInsights requestAgeField (boolean value) {
      this.requestField("age", value);
      return this;
    }
    public APIRequestGetInsights requestAgeTargetingField () {
      return this.requestAgeTargetingField(true);
    }
    public APIRequestGetInsights requestAgeTargetingField (boolean value) {
      this.requestField("age_targeting", value);
      return this;
    }
    public APIRequestGetInsights requestAmountInCatalogCurrencyField () {
      return this.requestAmountInCatalogCurrencyField(true);
    }
    public APIRequestGetInsights requestAmountInCatalogCurrencyField (boolean value) {
      this.requestField("amount_in_catalog_currency", value);
      return this;
    }
    public APIRequestGetInsights requestAppStoreClicksField () {
      return this.requestAppStoreClicksField(true);
    }
    public APIRequestGetInsights requestAppStoreClicksField (boolean value) {
      this.requestField("app_store_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestAttentionEventsPerImpressionField () {
      return this.requestAttentionEventsPerImpressionField(true);
    }
    public APIRequestGetInsights requestAttentionEventsPerImpressionField (boolean value) {
      this.requestField("attention_events_per_impression", value);
      return this;
    }
    public APIRequestGetInsights requestAttentionEventsUnqPerReachField () {
      return this.requestAttentionEventsUnqPerReachField(true);
    }
    public APIRequestGetInsights requestAttentionEventsUnqPerReachField (boolean value) {
      this.requestField("attention_events_unq_per_reach", value);
      return this;
    }
    public APIRequestGetInsights requestAuctionBidField () {
      return this.requestAuctionBidField(true);
    }
    public APIRequestGetInsights requestAuctionBidField (boolean value) {
      this.requestField("auction_bid", value);
      return this;
    }
    public APIRequestGetInsights requestAuctionCompetitivenessField () {
      return this.requestAuctionCompetitivenessField(true);
    }
    public APIRequestGetInsights requestAuctionCompetitivenessField (boolean value) {
      this.requestField("auction_competitiveness", value);
      return this;
    }
    public APIRequestGetInsights requestAuctionMaxCompetitorBidField () {
      return this.requestAuctionMaxCompetitorBidField(true);
    }
    public APIRequestGetInsights requestAuctionMaxCompetitorBidField (boolean value) {
      this.requestField("auction_max_competitor_bid", value);
      return this;
    }
    public APIRequestGetInsights requestBodyAssetField () {
      return this.requestBodyAssetField(true);
    }
    public APIRequestGetInsights requestBodyAssetField (boolean value) {
      this.requestField("body_asset", value);
      return this;
    }
    public APIRequestGetInsights requestBuyingTypeField () {
      return this.requestBuyingTypeField(true);
    }
    public APIRequestGetInsights requestBuyingTypeField (boolean value) {
      this.requestField("buying_type", value);
      return this;
    }
    public APIRequestGetInsights requestCallToActionAssetField () {
      return this.requestCallToActionAssetField(true);
    }
    public APIRequestGetInsights requestCallToActionAssetField (boolean value) {
      this.requestField("call_to_action_asset", value);
      return this;
    }
    public APIRequestGetInsights requestCallToActionClicksField () {
      return this.requestCallToActionClicksField(true);
    }
    public APIRequestGetInsights requestCallToActionClicksField (boolean value) {
      this.requestField("call_to_action_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignDeliveryField () {
      return this.requestCampaignDeliveryField(true);
    }
    public APIRequestGetInsights requestCampaignDeliveryField (boolean value) {
      this.requestField("campaign_delivery", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignEndField () {
      return this.requestCampaignEndField(true);
    }
    public APIRequestGetInsights requestCampaignEndField (boolean value) {
      this.requestField("campaign_end", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignIdField () {
      return this.requestCampaignIdField(true);
    }
    public APIRequestGetInsights requestCampaignIdField (boolean value) {
      this.requestField("campaign_id", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignNameField () {
      return this.requestCampaignNameField(true);
    }
    public APIRequestGetInsights requestCampaignNameField (boolean value) {
      this.requestField("campaign_name", value);
      return this;
    }
    public APIRequestGetInsights requestCampaignStartField () {
      return this.requestCampaignStartField(true);
    }
    public APIRequestGetInsights requestCampaignStartField (boolean value) {
      this.requestField("campaign_start", value);
      return this;
    }
    public APIRequestGetInsights requestCancelSubscriptionActionsField () {
      return this.requestCancelSubscriptionActionsField(true);
    }
    public APIRequestGetInsights requestCancelSubscriptionActionsField (boolean value) {
      this.requestField("cancel_subscription_actions", value);
      return this;
    }
    public APIRequestGetInsights requestCanvasAvgViewPercentField () {
      return this.requestCanvasAvgViewPercentField(true);
    }
    public APIRequestGetInsights requestCanvasAvgViewPercentField (boolean value) {
      this.requestField("canvas_avg_view_percent", value);
      return this;
    }
    public APIRequestGetInsights requestCanvasAvgViewTimeField () {
      return this.requestCanvasAvgViewTimeField(true);
    }
    public APIRequestGetInsights requestCanvasAvgViewTimeField (boolean value) {
      this.requestField("canvas_avg_view_time", value);
      return this;
    }
    public APIRequestGetInsights requestCardViewsField () {
      return this.requestCardViewsField(true);
    }
    public APIRequestGetInsights requestCardViewsField (boolean value) {
      this.requestField("card_views", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentActionsField () {
      return this.requestCatalogSegmentActionsField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentActionsField (boolean value) {
      this.requestField("catalog_segment_actions", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueInCatalogCurrencyField () {
      return this.requestCatalogSegmentValueInCatalogCurrencyField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueInCatalogCurrencyField (boolean value) {
      this.requestField("catalog_segment_value_in_catalog_currency", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueMobilePurchaseRoasField () {
      return this.requestCatalogSegmentValueMobilePurchaseRoasField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueMobilePurchaseRoasField (boolean value) {
      this.requestField("catalog_segment_value_mobile_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestCatalogSegmentValueWebsitePurchaseRoasField () {
      return this.requestCatalogSegmentValueWebsitePurchaseRoasField(true);
    }
    public APIRequestGetInsights requestCatalogSegmentValueWebsitePurchaseRoasField (boolean value) {
      this.requestField("catalog_segment_value_website_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestClicksField () {
      return this.requestClicksField(true);
    }
    public APIRequestGetInsights requestClicksField (boolean value) {
      this.requestField("clicks", value);
      return this;
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver10sActionsField () {
      return this.requestConditionalTimeSpentMsOver10sActionsField(true);
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver10sActionsField (boolean value) {
      this.requestField("conditional_time_spent_ms_over_10s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver15sActionsField () {
      return this.requestConditionalTimeSpentMsOver15sActionsField(true);
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver15sActionsField (boolean value) {
      this.requestField("conditional_time_spent_ms_over_15s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver2sActionsField () {
      return this.requestConditionalTimeSpentMsOver2sActionsField(true);
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver2sActionsField (boolean value) {
      this.requestField("conditional_time_spent_ms_over_2s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver3sActionsField () {
      return this.requestConditionalTimeSpentMsOver3sActionsField(true);
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver3sActionsField (boolean value) {
      this.requestField("conditional_time_spent_ms_over_3s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver6sActionsField () {
      return this.requestConditionalTimeSpentMsOver6sActionsField(true);
    }
    public APIRequestGetInsights requestConditionalTimeSpentMsOver6sActionsField (boolean value) {
      this.requestField("conditional_time_spent_ms_over_6s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestContactActionsField () {
      return this.requestContactActionsField(true);
    }
    public APIRequestGetInsights requestContactActionsField (boolean value) {
      this.requestField("contact_actions", value);
      return this;
    }
    public APIRequestGetInsights requestContactValueField () {
      return this.requestContactValueField(true);
    }
    public APIRequestGetInsights requestContactValueField (boolean value) {
      this.requestField("contact_value", value);
      return this;
    }
    public APIRequestGetInsights requestConversionRateRankingField () {
      return this.requestConversionRateRankingField(true);
    }
    public APIRequestGetInsights requestConversionRateRankingField (boolean value) {
      this.requestField("conversion_rate_ranking", value);
      return this;
    }
    public APIRequestGetInsights requestConversionValuesField () {
      return this.requestConversionValuesField(true);
    }
    public APIRequestGetInsights requestConversionValuesField (boolean value) {
      this.requestField("conversion_values", value);
      return this;
    }
    public APIRequestGetInsights requestConversionsField () {
      return this.requestConversionsField(true);
    }
    public APIRequestGetInsights requestConversionsField (boolean value) {
      this.requestField("conversions", value);
      return this;
    }
    public APIRequestGetInsights requestCostPer10SecVideoViewField () {
      return this.requestCostPer10SecVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPer10SecVideoViewField (boolean value) {
      this.requestField("cost_per_10_sec_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPer15SecVideoViewField () {
      return this.requestCostPer15SecVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPer15SecVideoViewField (boolean value) {
      this.requestField("cost_per_15_sec_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPer2SecContinuousVideoViewField () {
      return this.requestCostPer2SecContinuousVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPer2SecContinuousVideoViewField (boolean value) {
      this.requestField("cost_per_2_sec_continuous_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerActionResultField () {
      return this.requestCostPerActionResultField(true);
    }
    public APIRequestGetInsights requestCostPerActionResultField (boolean value) {
      this.requestField("cost_per_action_result", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerActionTypeField () {
      return this.requestCostPerActionTypeField(true);
    }
    public APIRequestGetInsights requestCostPerActionTypeField (boolean value) {
      this.requestField("cost_per_action_type", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerAdClickField () {
      return this.requestCostPerAdClickField(true);
    }
    public APIRequestGetInsights requestCostPerAdClickField (boolean value) {
      this.requestField("cost_per_ad_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerCompletedVideoViewField () {
      return this.requestCostPerCompletedVideoViewField(true);
    }
    public APIRequestGetInsights requestCostPerCompletedVideoViewField (boolean value) {
      this.requestField("cost_per_completed_video_view", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerContactField () {
      return this.requestCostPerContactField(true);
    }
    public APIRequestGetInsights requestCostPerContactField (boolean value) {
      this.requestField("cost_per_contact", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerConversionField () {
      return this.requestCostPerConversionField(true);
    }
    public APIRequestGetInsights requestCostPerConversionField (boolean value) {
      this.requestField("cost_per_conversion", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerCustomizeProductField () {
      return this.requestCostPerCustomizeProductField(true);
    }
    public APIRequestGetInsights requestCostPerCustomizeProductField (boolean value) {
      this.requestField("cost_per_customize_product", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDdaCountbyConvsField () {
      return this.requestCostPerDdaCountbyConvsField(true);
    }
    public APIRequestGetInsights requestCostPerDdaCountbyConvsField (boolean value) {
      this.requestField("cost_per_dda_countby_convs", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDonateField () {
      return this.requestCostPerDonateField(true);
    }
    public APIRequestGetInsights requestCostPerDonateField (boolean value) {
      this.requestField("cost_per_donate", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDwellField () {
      return this.requestCostPerDwellField(true);
    }
    public APIRequestGetInsights requestCostPerDwellField (boolean value) {
      this.requestField("cost_per_dwell", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDwell3SecField () {
      return this.requestCostPerDwell3SecField(true);
    }
    public APIRequestGetInsights requestCostPerDwell3SecField (boolean value) {
      this.requestField("cost_per_dwell_3_sec", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDwell5SecField () {
      return this.requestCostPerDwell5SecField(true);
    }
    public APIRequestGetInsights requestCostPerDwell5SecField (boolean value) {
      this.requestField("cost_per_dwell_5_sec", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerDwell7SecField () {
      return this.requestCostPerDwell7SecField(true);
    }
    public APIRequestGetInsights requestCostPerDwell7SecField (boolean value) {
      this.requestField("cost_per_dwell_7_sec", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerEstimatedAdRecallersField () {
      return this.requestCostPerEstimatedAdRecallersField(true);
    }
    public APIRequestGetInsights requestCostPerEstimatedAdRecallersField (boolean value) {
      this.requestField("cost_per_estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerFindLocationField () {
      return this.requestCostPerFindLocationField(true);
    }
    public APIRequestGetInsights requestCostPerFindLocationField (boolean value) {
      this.requestField("cost_per_find_location", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerInlineLinkClickField () {
      return this.requestCostPerInlineLinkClickField(true);
    }
    public APIRequestGetInsights requestCostPerInlineLinkClickField (boolean value) {
      this.requestField("cost_per_inline_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerInlinePostEngagementField () {
      return this.requestCostPerInlinePostEngagementField(true);
    }
    public APIRequestGetInsights requestCostPerInlinePostEngagementField (boolean value) {
      this.requestField("cost_per_inline_post_engagement", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerOneThousandAdImpressionField () {
      return this.requestCostPerOneThousandAdImpressionField(true);
    }
    public APIRequestGetInsights requestCostPerOneThousandAdImpressionField (boolean value) {
      this.requestField("cost_per_one_thousand_ad_impression", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerOutboundClickField () {
      return this.requestCostPerOutboundClickField(true);
    }
    public APIRequestGetInsights requestCostPerOutboundClickField (boolean value) {
      this.requestField("cost_per_outbound_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerScheduleField () {
      return this.requestCostPerScheduleField(true);
    }
    public APIRequestGetInsights requestCostPerScheduleField (boolean value) {
      this.requestField("cost_per_schedule", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerStartTrialField () {
      return this.requestCostPerStartTrialField(true);
    }
    public APIRequestGetInsights requestCostPerStartTrialField (boolean value) {
      this.requestField("cost_per_start_trial", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerSubmitApplicationField () {
      return this.requestCostPerSubmitApplicationField(true);
    }
    public APIRequestGetInsights requestCostPerSubmitApplicationField (boolean value) {
      this.requestField("cost_per_submit_application", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerSubscribeField () {
      return this.requestCostPerSubscribeField(true);
    }
    public APIRequestGetInsights requestCostPerSubscribeField (boolean value) {
      this.requestField("cost_per_subscribe", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerThruplayField () {
      return this.requestCostPerThruplayField(true);
    }
    public APIRequestGetInsights requestCostPerThruplayField (boolean value) {
      this.requestField("cost_per_thruplay", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerTotalActionField () {
      return this.requestCostPerTotalActionField(true);
    }
    public APIRequestGetInsights requestCostPerTotalActionField (boolean value) {
      this.requestField("cost_per_total_action", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueActionTypeField () {
      return this.requestCostPerUniqueActionTypeField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueActionTypeField (boolean value) {
      this.requestField("cost_per_unique_action_type", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueClickField () {
      return this.requestCostPerUniqueClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueClickField (boolean value) {
      this.requestField("cost_per_unique_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueConversionField () {
      return this.requestCostPerUniqueConversionField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueConversionField (boolean value) {
      this.requestField("cost_per_unique_conversion", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueInlineLinkClickField () {
      return this.requestCostPerUniqueInlineLinkClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueInlineLinkClickField (boolean value) {
      this.requestField("cost_per_unique_inline_link_click", value);
      return this;
    }
    public APIRequestGetInsights requestCostPerUniqueOutboundClickField () {
      return this.requestCostPerUniqueOutboundClickField(true);
    }
    public APIRequestGetInsights requestCostPerUniqueOutboundClickField (boolean value) {
      this.requestField("cost_per_unique_outbound_click", value);
      return this;
    }
    public APIRequestGetInsights requestCountryField () {
      return this.requestCountryField(true);
    }
    public APIRequestGetInsights requestCountryField (boolean value) {
      this.requestField("country", value);
      return this;
    }
    public APIRequestGetInsights requestCpcField () {
      return this.requestCpcField(true);
    }
    public APIRequestGetInsights requestCpcField (boolean value) {
      this.requestField("cpc", value);
      return this;
    }
    public APIRequestGetInsights requestCpmField () {
      return this.requestCpmField(true);
    }
    public APIRequestGetInsights requestCpmField (boolean value) {
      this.requestField("cpm", value);
      return this;
    }
    public APIRequestGetInsights requestCppField () {
      return this.requestCppField(true);
    }
    public APIRequestGetInsights requestCppField (boolean value) {
      this.requestField("cpp", value);
      return this;
    }
    public APIRequestGetInsights requestCreatedTimeField () {
      return this.requestCreatedTimeField(true);
    }
    public APIRequestGetInsights requestCreatedTimeField (boolean value) {
      this.requestField("created_time", value);
      return this;
    }
    public APIRequestGetInsights requestCreativeFingerprintField () {
      return this.requestCreativeFingerprintField(true);
    }
    public APIRequestGetInsights requestCreativeFingerprintField (boolean value) {
      this.requestField("creative_fingerprint", value);
      return this;
    }
    public APIRequestGetInsights requestCtrField () {
      return this.requestCtrField(true);
    }
    public APIRequestGetInsights requestCtrField (boolean value) {
      this.requestField("ctr", value);
      return this;
    }
    public APIRequestGetInsights requestCustomizeProductActionsField () {
      return this.requestCustomizeProductActionsField(true);
    }
    public APIRequestGetInsights requestCustomizeProductActionsField (boolean value) {
      this.requestField("customize_product_actions", value);
      return this;
    }
    public APIRequestGetInsights requestCustomizeProductValueField () {
      return this.requestCustomizeProductValueField(true);
    }
    public APIRequestGetInsights requestCustomizeProductValueField (boolean value) {
      this.requestField("customize_product_value", value);
      return this;
    }
    public APIRequestGetInsights requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGetInsights requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGetInsights requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGetInsights requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGetInsights requestDdaCountbyConvsField () {
      return this.requestDdaCountbyConvsField(true);
    }
    public APIRequestGetInsights requestDdaCountbyConvsField (boolean value) {
      this.requestField("dda_countby_convs", value);
      return this;
    }
    public APIRequestGetInsights requestDeduping1stSourceRatioField () {
      return this.requestDeduping1stSourceRatioField(true);
    }
    public APIRequestGetInsights requestDeduping1stSourceRatioField (boolean value) {
      this.requestField("deduping_1st_source_ratio", value);
      return this;
    }
    public APIRequestGetInsights requestDeduping2ndSourceRatioField () {
      return this.requestDeduping2ndSourceRatioField(true);
    }
    public APIRequestGetInsights requestDeduping2ndSourceRatioField (boolean value) {
      this.requestField("deduping_2nd_source_ratio", value);
      return this;
    }
    public APIRequestGetInsights requestDeduping3rdSourceRatioField () {
      return this.requestDeduping3rdSourceRatioField(true);
    }
    public APIRequestGetInsights requestDeduping3rdSourceRatioField (boolean value) {
      this.requestField("deduping_3rd_source_ratio", value);
      return this;
    }
    public APIRequestGetInsights requestDedupingRatioField () {
      return this.requestDedupingRatioField(true);
    }
    public APIRequestGetInsights requestDedupingRatioField (boolean value) {
      this.requestField("deduping_ratio", value);
      return this;
    }
    public APIRequestGetInsights requestDeeplinkClicksField () {
      return this.requestDeeplinkClicksField(true);
    }
    public APIRequestGetInsights requestDeeplinkClicksField (boolean value) {
      this.requestField("deeplink_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestDescriptionAssetField () {
      return this.requestDescriptionAssetField(true);
    }
    public APIRequestGetInsights requestDescriptionAssetField (boolean value) {
      this.requestField("description_asset", value);
      return this;
    }
    public APIRequestGetInsights requestDevicePlatformField () {
      return this.requestDevicePlatformField(true);
    }
    public APIRequestGetInsights requestDevicePlatformField (boolean value) {
      this.requestField("device_platform", value);
      return this;
    }
    public APIRequestGetInsights requestDmaField () {
      return this.requestDmaField(true);
    }
    public APIRequestGetInsights requestDmaField (boolean value) {
      this.requestField("dma", value);
      return this;
    }
    public APIRequestGetInsights requestDonateActionsField () {
      return this.requestDonateActionsField(true);
    }
    public APIRequestGetInsights requestDonateActionsField (boolean value) {
      this.requestField("donate_actions", value);
      return this;
    }
    public APIRequestGetInsights requestDonateValueField () {
      return this.requestDonateValueField(true);
    }
    public APIRequestGetInsights requestDonateValueField (boolean value) {
      this.requestField("donate_value", value);
      return this;
    }
    public APIRequestGetInsights requestDwell3SecField () {
      return this.requestDwell3SecField(true);
    }
    public APIRequestGetInsights requestDwell3SecField (boolean value) {
      this.requestField("dwell_3_sec", value);
      return this;
    }
    public APIRequestGetInsights requestDwell5SecField () {
      return this.requestDwell5SecField(true);
    }
    public APIRequestGetInsights requestDwell5SecField (boolean value) {
      this.requestField("dwell_5_sec", value);
      return this;
    }
    public APIRequestGetInsights requestDwell7SecField () {
      return this.requestDwell7SecField(true);
    }
    public APIRequestGetInsights requestDwell7SecField (boolean value) {
      this.requestField("dwell_7_sec", value);
      return this;
    }
    public APIRequestGetInsights requestDwellRateField () {
      return this.requestDwellRateField(true);
    }
    public APIRequestGetInsights requestDwellRateField (boolean value) {
      this.requestField("dwell_rate", value);
      return this;
    }
    public APIRequestGetInsights requestEarnedImpressionField () {
      return this.requestEarnedImpressionField(true);
    }
    public APIRequestGetInsights requestEarnedImpressionField (boolean value) {
      this.requestField("earned_impression", value);
      return this;
    }
    public APIRequestGetInsights requestEngagementRateRankingField () {
      return this.requestEngagementRateRankingField(true);
    }
    public APIRequestGetInsights requestEngagementRateRankingField (boolean value) {
      this.requestField("engagement_rate_ranking", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateField () {
      return this.requestEstimatedAdRecallRateField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateField (boolean value) {
      this.requestField("estimated_ad_recall_rate", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateLowerBoundField () {
      return this.requestEstimatedAdRecallRateLowerBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateLowerBoundField (boolean value) {
      this.requestField("estimated_ad_recall_rate_lower_bound", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateUpperBoundField () {
      return this.requestEstimatedAdRecallRateUpperBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallRateUpperBoundField (boolean value) {
      this.requestField("estimated_ad_recall_rate_upper_bound", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersField () {
      return this.requestEstimatedAdRecallersField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersField (boolean value) {
      this.requestField("estimated_ad_recallers", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersLowerBoundField () {
      return this.requestEstimatedAdRecallersLowerBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersLowerBoundField (boolean value) {
      this.requestField("estimated_ad_recallers_lower_bound", value);
      return this;
    }
    public APIRequestGetInsights requestEstimatedAdRecallersUpperBoundField () {
      return this.requestEstimatedAdRecallersUpperBoundField(true);
    }
    public APIRequestGetInsights requestEstimatedAdRecallersUpperBoundField (boolean value) {
      this.requestField("estimated_ad_recallers_upper_bound", value);
      return this;
    }
    public APIRequestGetInsights requestFindLocationActionsField () {
      return this.requestFindLocationActionsField(true);
    }
    public APIRequestGetInsights requestFindLocationActionsField (boolean value) {
      this.requestField("find_location_actions", value);
      return this;
    }
    public APIRequestGetInsights requestFindLocationValueField () {
      return this.requestFindLocationValueField(true);
    }
    public APIRequestGetInsights requestFindLocationValueField (boolean value) {
      this.requestField("find_location_value", value);
      return this;
    }
    public APIRequestGetInsights requestFrequencyField () {
      return this.requestFrequencyField(true);
    }
    public APIRequestGetInsights requestFrequencyField (boolean value) {
      this.requestField("frequency", value);
      return this;
    }
    public APIRequestGetInsights requestFrequencyValueField () {
      return this.requestFrequencyValueField(true);
    }
    public APIRequestGetInsights requestFrequencyValueField (boolean value) {
      this.requestField("frequency_value", value);
      return this;
    }
    public APIRequestGetInsights requestFullViewImpressionsField () {
      return this.requestFullViewImpressionsField(true);
    }
    public APIRequestGetInsights requestFullViewImpressionsField (boolean value) {
      this.requestField("full_view_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestFullViewReachField () {
      return this.requestFullViewReachField(true);
    }
    public APIRequestGetInsights requestFullViewReachField (boolean value) {
      this.requestField("full_view_reach", value);
      return this;
    }
    public APIRequestGetInsights requestGenderField () {
      return this.requestGenderField(true);
    }
    public APIRequestGetInsights requestGenderField (boolean value) {
      this.requestField("gender", value);
      return this;
    }
    public APIRequestGetInsights requestGenderTargetingField () {
      return this.requestGenderTargetingField(true);
    }
    public APIRequestGetInsights requestGenderTargetingField (boolean value) {
      this.requestField("gender_targeting", value);
      return this;
    }
    public APIRequestGetInsights requestHourlyStatsAggregatedByAdvertiserTimeZoneField () {
      return this.requestHourlyStatsAggregatedByAdvertiserTimeZoneField(true);
    }
    public APIRequestGetInsights requestHourlyStatsAggregatedByAdvertiserTimeZoneField (boolean value) {
      this.requestField("hourly_stats_aggregated_by_advertiser_time_zone", value);
      return this;
    }
    public APIRequestGetInsights requestHourlyStatsAggregatedByAudienceTimeZoneField () {
      return this.requestHourlyStatsAggregatedByAudienceTimeZoneField(true);
    }
    public APIRequestGetInsights requestHourlyStatsAggregatedByAudienceTimeZoneField (boolean value) {
      this.requestField("hourly_stats_aggregated_by_audience_time_zone", value);
      return this;
    }
    public APIRequestGetInsights requestImageAssetField () {
      return this.requestImageAssetField(true);
    }
    public APIRequestGetInsights requestImageAssetField (boolean value) {
      this.requestField("image_asset", value);
      return this;
    }
    public APIRequestGetInsights requestImpressionDeviceField () {
      return this.requestImpressionDeviceField(true);
    }
    public APIRequestGetInsights requestImpressionDeviceField (boolean value) {
      this.requestField("impression_device", value);
      return this;
    }
    public APIRequestGetInsights requestImpressionsField () {
      return this.requestImpressionsField(true);
    }
    public APIRequestGetInsights requestImpressionsField (boolean value) {
      this.requestField("impressions", value);
      return this;
    }
    public APIRequestGetInsights requestImpressionsAutoRefreshField () {
      return this.requestImpressionsAutoRefreshField(true);
    }
    public APIRequestGetInsights requestImpressionsAutoRefreshField (boolean value) {
      this.requestField("impressions_auto_refresh", value);
      return this;
    }
    public APIRequestGetInsights requestImpressionsGrossField () {
      return this.requestImpressionsGrossField(true);
    }
    public APIRequestGetInsights requestImpressionsGrossField (boolean value) {
      this.requestField("impressions_gross", value);
      return this;
    }
    public APIRequestGetInsights requestInlineLinkClickCtrField () {
      return this.requestInlineLinkClickCtrField(true);
    }
    public APIRequestGetInsights requestInlineLinkClickCtrField (boolean value) {
      this.requestField("inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestInlineLinkClicksField () {
      return this.requestInlineLinkClicksField(true);
    }
    public APIRequestGetInsights requestInlineLinkClicksField (boolean value) {
      this.requestField("inline_link_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestInlinePostEngagementField () {
      return this.requestInlinePostEngagementField(true);
    }
    public APIRequestGetInsights requestInlinePostEngagementField (boolean value) {
      this.requestField("inline_post_engagement", value);
      return this;
    }
    public APIRequestGetInsights requestInstantExperienceClicksToOpenField () {
      return this.requestInstantExperienceClicksToOpenField(true);
    }
    public APIRequestGetInsights requestInstantExperienceClicksToOpenField (boolean value) {
      this.requestField("instant_experience_clicks_to_open", value);
      return this;
    }
    public APIRequestGetInsights requestInstantExperienceClicksToStartField () {
      return this.requestInstantExperienceClicksToStartField(true);
    }
    public APIRequestGetInsights requestInstantExperienceClicksToStartField (boolean value) {
      this.requestField("instant_experience_clicks_to_start", value);
      return this;
    }
    public APIRequestGetInsights requestInstantExperienceOutboundClicksField () {
      return this.requestInstantExperienceOutboundClicksField(true);
    }
    public APIRequestGetInsights requestInstantExperienceOutboundClicksField (boolean value) {
      this.requestField("instant_experience_outbound_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestInteractiveComponentTapField () {
      return this.requestInteractiveComponentTapField(true);
    }
    public APIRequestGetInsights requestInteractiveComponentTapField (boolean value) {
      this.requestField("interactive_component_tap", value);
      return this;
    }
    public APIRequestGetInsights requestLabelsField () {
      return this.requestLabelsField(true);
    }
    public APIRequestGetInsights requestLabelsField (boolean value) {
      this.requestField("labels", value);
      return this;
    }
    public APIRequestGetInsights requestLinkUrlAssetField () {
      return this.requestLinkUrlAssetField(true);
    }
    public APIRequestGetInsights requestLinkUrlAssetField (boolean value) {
      this.requestField("link_url_asset", value);
      return this;
    }
    public APIRequestGetInsights requestLocationField () {
      return this.requestLocationField(true);
    }
    public APIRequestGetInsights requestLocationField (boolean value) {
      this.requestField("location", value);
      return this;
    }
    public APIRequestGetInsights requestMediaAssetField () {
      return this.requestMediaAssetField(true);
    }
    public APIRequestGetInsights requestMediaAssetField (boolean value) {
      this.requestField("media_asset", value);
      return this;
    }
    public APIRequestGetInsights requestMobileAppPurchaseRoasField () {
      return this.requestMobileAppPurchaseRoasField(true);
    }
    public APIRequestGetInsights requestMobileAppPurchaseRoasField (boolean value) {
      this.requestField("mobile_app_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestNewsfeedAvgPositionField () {
      return this.requestNewsfeedAvgPositionField(true);
    }
    public APIRequestGetInsights requestNewsfeedAvgPositionField (boolean value) {
      this.requestField("newsfeed_avg_position", value);
      return this;
    }
    public APIRequestGetInsights requestNewsfeedClicksField () {
      return this.requestNewsfeedClicksField(true);
    }
    public APIRequestGetInsights requestNewsfeedClicksField (boolean value) {
      this.requestField("newsfeed_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestNewsfeedImpressionsField () {
      return this.requestNewsfeedImpressionsField(true);
    }
    public APIRequestGetInsights requestNewsfeedImpressionsField (boolean value) {
      this.requestField("newsfeed_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestObjectiveField () {
      return this.requestObjectiveField(true);
    }
    public APIRequestGetInsights requestObjectiveField (boolean value) {
      this.requestField("objective", value);
      return this;
    }
    public APIRequestGetInsights requestOptimizationGoalField () {
      return this.requestOptimizationGoalField(true);
    }
    public APIRequestGetInsights requestOptimizationGoalField (boolean value) {
      this.requestField("optimization_goal", value);
      return this;
    }
    public APIRequestGetInsights requestOutboundClicksField () {
      return this.requestOutboundClicksField(true);
    }
    public APIRequestGetInsights requestOutboundClicksField (boolean value) {
      this.requestField("outbound_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestOutboundClicksCtrField () {
      return this.requestOutboundClicksCtrField(true);
    }
    public APIRequestGetInsights requestOutboundClicksCtrField (boolean value) {
      this.requestField("outbound_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestPerformanceIndicatorField () {
      return this.requestPerformanceIndicatorField(true);
    }
    public APIRequestGetInsights requestPerformanceIndicatorField (boolean value) {
      this.requestField("performance_indicator", value);
      return this;
    }
    public APIRequestGetInsights requestPlacePageIdField () {
      return this.requestPlacePageIdField(true);
    }
    public APIRequestGetInsights requestPlacePageIdField (boolean value) {
      this.requestField("place_page_id", value);
      return this;
    }
    public APIRequestGetInsights requestPlacePageNameField () {
      return this.requestPlacePageNameField(true);
    }
    public APIRequestGetInsights requestPlacePageNameField (boolean value) {
      this.requestField("place_page_name", value);
      return this;
    }
    public APIRequestGetInsights requestPlacementField () {
      return this.requestPlacementField(true);
    }
    public APIRequestGetInsights requestPlacementField (boolean value) {
      this.requestField("placement", value);
      return this;
    }
    public APIRequestGetInsights requestPlatformPositionField () {
      return this.requestPlatformPositionField(true);
    }
    public APIRequestGetInsights requestPlatformPositionField (boolean value) {
      this.requestField("platform_position", value);
      return this;
    }
    public APIRequestGetInsights requestProductIdField () {
      return this.requestProductIdField(true);
    }
    public APIRequestGetInsights requestProductIdField (boolean value) {
      this.requestField("product_id", value);
      return this;
    }
    public APIRequestGetInsights requestPublisherPlatformField () {
      return this.requestPublisherPlatformField(true);
    }
    public APIRequestGetInsights requestPublisherPlatformField (boolean value) {
      this.requestField("publisher_platform", value);
      return this;
    }
    public APIRequestGetInsights requestPurchaseRoasField () {
      return this.requestPurchaseRoasField(true);
    }
    public APIRequestGetInsights requestPurchaseRoasField (boolean value) {
      this.requestField("purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestQualityRankingField () {
      return this.requestQualityRankingField(true);
    }
    public APIRequestGetInsights requestQualityRankingField (boolean value) {
      this.requestField("quality_ranking", value);
      return this;
    }
    public APIRequestGetInsights requestQualityScoreEctrField () {
      return this.requestQualityScoreEctrField(true);
    }
    public APIRequestGetInsights requestQualityScoreEctrField (boolean value) {
      this.requestField("quality_score_ectr", value);
      return this;
    }
    public APIRequestGetInsights requestQualityScoreEcvrField () {
      return this.requestQualityScoreEcvrField(true);
    }
    public APIRequestGetInsights requestQualityScoreEcvrField (boolean value) {
      this.requestField("quality_score_ecvr", value);
      return this;
    }
    public APIRequestGetInsights requestQualityScoreEnfbrField () {
      return this.requestQualityScoreEnfbrField(true);
    }
    public APIRequestGetInsights requestQualityScoreEnfbrField (boolean value) {
      this.requestField("quality_score_enfbr", value);
      return this;
    }
    public APIRequestGetInsights requestQualityScoreOrganicField () {
      return this.requestQualityScoreOrganicField(true);
    }
    public APIRequestGetInsights requestQualityScoreOrganicField (boolean value) {
      this.requestField("quality_score_organic", value);
      return this;
    }
    public APIRequestGetInsights requestReachField () {
      return this.requestReachField(true);
    }
    public APIRequestGetInsights requestReachField (boolean value) {
      this.requestField("reach", value);
      return this;
    }
    public APIRequestGetInsights requestRecurringSubscriptionPaymentActionsField () {
      return this.requestRecurringSubscriptionPaymentActionsField(true);
    }
    public APIRequestGetInsights requestRecurringSubscriptionPaymentActionsField (boolean value) {
      this.requestField("recurring_subscription_payment_actions", value);
      return this;
    }
    public APIRequestGetInsights requestRegionField () {
      return this.requestRegionField(true);
    }
    public APIRequestGetInsights requestRegionField (boolean value) {
      this.requestField("region", value);
      return this;
    }
    public APIRequestGetInsights requestRelevanceScoreField () {
      return this.requestRelevanceScoreField(true);
    }
    public APIRequestGetInsights requestRelevanceScoreField (boolean value) {
      this.requestField("relevance_score", value);
      return this;
    }
    public APIRequestGetInsights requestRuleAssetField () {
      return this.requestRuleAssetField(true);
    }
    public APIRequestGetInsights requestRuleAssetField (boolean value) {
      this.requestField("rule_asset", value);
      return this;
    }
    public APIRequestGetInsights requestScheduleActionsField () {
      return this.requestScheduleActionsField(true);
    }
    public APIRequestGetInsights requestScheduleActionsField (boolean value) {
      this.requestField("schedule_actions", value);
      return this;
    }
    public APIRequestGetInsights requestScheduleValueField () {
      return this.requestScheduleValueField(true);
    }
    public APIRequestGetInsights requestScheduleValueField (boolean value) {
      this.requestField("schedule_value", value);
      return this;
    }
    public APIRequestGetInsights requestSocialSpendField () {
      return this.requestSocialSpendField(true);
    }
    public APIRequestGetInsights requestSocialSpendField (boolean value) {
      this.requestField("social_spend", value);
      return this;
    }
    public APIRequestGetInsights requestSpendField () {
      return this.requestSpendField(true);
    }
    public APIRequestGetInsights requestSpendField (boolean value) {
      this.requestField("spend", value);
      return this;
    }
    public APIRequestGetInsights requestStartTrialActionsField () {
      return this.requestStartTrialActionsField(true);
    }
    public APIRequestGetInsights requestStartTrialActionsField (boolean value) {
      this.requestField("start_trial_actions", value);
      return this;
    }
    public APIRequestGetInsights requestStartTrialValueField () {
      return this.requestStartTrialValueField(true);
    }
    public APIRequestGetInsights requestStartTrialValueField (boolean value) {
      this.requestField("start_trial_value", value);
      return this;
    }
    public APIRequestGetInsights requestSubmitApplicationActionsField () {
      return this.requestSubmitApplicationActionsField(true);
    }
    public APIRequestGetInsights requestSubmitApplicationActionsField (boolean value) {
      this.requestField("submit_application_actions", value);
      return this;
    }
    public APIRequestGetInsights requestSubmitApplicationValueField () {
      return this.requestSubmitApplicationValueField(true);
    }
    public APIRequestGetInsights requestSubmitApplicationValueField (boolean value) {
      this.requestField("submit_application_value", value);
      return this;
    }
    public APIRequestGetInsights requestSubscribeActionsField () {
      return this.requestSubscribeActionsField(true);
    }
    public APIRequestGetInsights requestSubscribeActionsField (boolean value) {
      this.requestField("subscribe_actions", value);
      return this;
    }
    public APIRequestGetInsights requestSubscribeValueField () {
      return this.requestSubscribeValueField(true);
    }
    public APIRequestGetInsights requestSubscribeValueField (boolean value) {
      this.requestField("subscribe_value", value);
      return this;
    }
    public APIRequestGetInsights requestThumbStopsField () {
      return this.requestThumbStopsField(true);
    }
    public APIRequestGetInsights requestThumbStopsField (boolean value) {
      this.requestField("thumb_stops", value);
      return this;
    }
    public APIRequestGetInsights requestTitleAssetField () {
      return this.requestTitleAssetField(true);
    }
    public APIRequestGetInsights requestTitleAssetField (boolean value) {
      this.requestField("title_asset", value);
      return this;
    }
    public APIRequestGetInsights requestTodaySpendField () {
      return this.requestTodaySpendField(true);
    }
    public APIRequestGetInsights requestTodaySpendField (boolean value) {
      this.requestField("today_spend", value);
      return this;
    }
    public APIRequestGetInsights requestTotalActionValueField () {
      return this.requestTotalActionValueField(true);
    }
    public APIRequestGetInsights requestTotalActionValueField (boolean value) {
      this.requestField("total_action_value", value);
      return this;
    }
    public APIRequestGetInsights requestTotalActionsField () {
      return this.requestTotalActionsField(true);
    }
    public APIRequestGetInsights requestTotalActionsField (boolean value) {
      this.requestField("total_actions", value);
      return this;
    }
    public APIRequestGetInsights requestTotalUniqueActionsField () {
      return this.requestTotalUniqueActionsField(true);
    }
    public APIRequestGetInsights requestTotalUniqueActionsField (boolean value) {
      this.requestField("total_unique_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueActionsField () {
      return this.requestUniqueActionsField(true);
    }
    public APIRequestGetInsights requestUniqueActionsField (boolean value) {
      this.requestField("unique_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueClicksField () {
      return this.requestUniqueClicksField(true);
    }
    public APIRequestGetInsights requestUniqueClicksField (boolean value) {
      this.requestField("unique_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueConversionsField () {
      return this.requestUniqueConversionsField(true);
    }
    public APIRequestGetInsights requestUniqueConversionsField (boolean value) {
      this.requestField("unique_conversions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueCtrField () {
      return this.requestUniqueCtrField(true);
    }
    public APIRequestGetInsights requestUniqueCtrField (boolean value) {
      this.requestField("unique_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueImpressionsField () {
      return this.requestUniqueImpressionsField(true);
    }
    public APIRequestGetInsights requestUniqueImpressionsField (boolean value) {
      this.requestField("unique_impressions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueInlineLinkClickCtrField () {
      return this.requestUniqueInlineLinkClickCtrField(true);
    }
    public APIRequestGetInsights requestUniqueInlineLinkClickCtrField (boolean value) {
      this.requestField("unique_inline_link_click_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueInlineLinkClicksField () {
      return this.requestUniqueInlineLinkClicksField(true);
    }
    public APIRequestGetInsights requestUniqueInlineLinkClicksField (boolean value) {
      this.requestField("unique_inline_link_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueLinkClicksCtrField () {
      return this.requestUniqueLinkClicksCtrField(true);
    }
    public APIRequestGetInsights requestUniqueLinkClicksCtrField (boolean value) {
      this.requestField("unique_link_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueOutboundClicksField () {
      return this.requestUniqueOutboundClicksField(true);
    }
    public APIRequestGetInsights requestUniqueOutboundClicksField (boolean value) {
      this.requestField("unique_outbound_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueOutboundClicksCtrField () {
      return this.requestUniqueOutboundClicksCtrField(true);
    }
    public APIRequestGetInsights requestUniqueOutboundClicksCtrField (boolean value) {
      this.requestField("unique_outbound_clicks_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueVideoContinuous2SecWatchedActionsField () {
      return this.requestUniqueVideoContinuous2SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestUniqueVideoContinuous2SecWatchedActionsField (boolean value) {
      this.requestField("unique_video_continuous_2_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueVideoView10SecField () {
      return this.requestUniqueVideoView10SecField(true);
    }
    public APIRequestGetInsights requestUniqueVideoView10SecField (boolean value) {
      this.requestField("unique_video_view_10_sec", value);
      return this;
    }
    public APIRequestGetInsights requestUniqueVideoView15SecField () {
      return this.requestUniqueVideoView15SecField(true);
    }
    public APIRequestGetInsights requestUniqueVideoView15SecField (boolean value) {
      this.requestField("unique_video_view_15_sec", value);
      return this;
    }
    public APIRequestGetInsights requestUpdatedTimeField () {
      return this.requestUpdatedTimeField(true);
    }
    public APIRequestGetInsights requestUpdatedTimeField (boolean value) {
      this.requestField("updated_time", value);
      return this;
    }
    public APIRequestGetInsights requestVideo10SecWatchedActionsField () {
      return this.requestVideo10SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo10SecWatchedActionsField (boolean value) {
      this.requestField("video_10_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideo15SecWatchedActionsField () {
      return this.requestVideo15SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo15SecWatchedActionsField (boolean value) {
      this.requestField("video_15_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideo30SecWatchedActionsField () {
      return this.requestVideo30SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideo30SecWatchedActionsField (boolean value) {
      this.requestField("video_30_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAssetField () {
      return this.requestVideoAssetField(true);
    }
    public APIRequestGetInsights requestVideoAssetField (boolean value) {
      this.requestField("video_asset", value);
      return this;
    }
    public APIRequestGetInsights requestVideoAvgTimeWatchedActionsField () {
      return this.requestVideoAvgTimeWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoAvgTimeWatchedActionsField (boolean value) {
      this.requestField("video_avg_time_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoCompleteWatchedActionsField () {
      return this.requestVideoCompleteWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoCompleteWatchedActionsField (boolean value) {
      this.requestField("video_complete_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoCompletedViewOr15sPassedActionsField () {
      return this.requestVideoCompletedViewOr15sPassedActionsField(true);
    }
    public APIRequestGetInsights requestVideoCompletedViewOr15sPassedActionsField (boolean value) {
      this.requestField("video_completed_view_or_15s_passed_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoContinuous2SecWatchedActionsField () {
      return this.requestVideoContinuous2SecWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoContinuous2SecWatchedActionsField (boolean value) {
      this.requestField("video_continuous_2_sec_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP100WatchedActionsField () {
      return this.requestVideoP100WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP100WatchedActionsField (boolean value) {
      this.requestField("video_p100_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP25WatchedActionsField () {
      return this.requestVideoP25WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP25WatchedActionsField (boolean value) {
      this.requestField("video_p25_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP50WatchedActionsField () {
      return this.requestVideoP50WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP50WatchedActionsField (boolean value) {
      this.requestField("video_p50_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP75WatchedActionsField () {
      return this.requestVideoP75WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP75WatchedActionsField (boolean value) {
      this.requestField("video_p75_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoP95WatchedActionsField () {
      return this.requestVideoP95WatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoP95WatchedActionsField (boolean value) {
      this.requestField("video_p95_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayActionsField () {
      return this.requestVideoPlayActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayActionsField (boolean value) {
      this.requestField("video_play_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayCurveActionsField () {
      return this.requestVideoPlayCurveActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayCurveActionsField (boolean value) {
      this.requestField("video_play_curve_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayRetention0To15sActionsField () {
      return this.requestVideoPlayRetention0To15sActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayRetention0To15sActionsField (boolean value) {
      this.requestField("video_play_retention_0_to_15s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayRetention20To60sActionsField () {
      return this.requestVideoPlayRetention20To60sActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayRetention20To60sActionsField (boolean value) {
      this.requestField("video_play_retention_20_to_60s_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoPlayRetentionGraphActionsField () {
      return this.requestVideoPlayRetentionGraphActionsField(true);
    }
    public APIRequestGetInsights requestVideoPlayRetentionGraphActionsField (boolean value) {
      this.requestField("video_play_retention_graph_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoThruplayWatchedActionsField () {
      return this.requestVideoThruplayWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoThruplayWatchedActionsField (boolean value) {
      this.requestField("video_thruplay_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestVideoTimeWatchedActionsField () {
      return this.requestVideoTimeWatchedActionsField(true);
    }
    public APIRequestGetInsights requestVideoTimeWatchedActionsField (boolean value) {
      this.requestField("video_time_watched_actions", value);
      return this;
    }
    public APIRequestGetInsights requestWebsiteClicksField () {
      return this.requestWebsiteClicksField(true);
    }
    public APIRequestGetInsights requestWebsiteClicksField (boolean value) {
      this.requestField("website_clicks", value);
      return this;
    }
    public APIRequestGetInsights requestWebsiteCtrField () {
      return this.requestWebsiteCtrField(true);
    }
    public APIRequestGetInsights requestWebsiteCtrField (boolean value) {
      this.requestField("website_ctr", value);
      return this;
    }
    public APIRequestGetInsights requestWebsitePurchaseRoasField () {
      return this.requestWebsitePurchaseRoasField(true);
    }
    public APIRequestGetInsights requestWebsitePurchaseRoasField (boolean value) {
      this.requestField("website_purchase_roas", value);
      return this;
    }
    public APIRequestGetInsights requestWishBidField () {
      return this.requestWishBidField(true);
    }
    public APIRequestGetInsights requestWishBidField (boolean value) {
      this.requestField("wish_bid", value);
      return this;
    }
  }

  public static class APIRequestDelete extends APIRequest<APINode> {

    APINode lastResponse = null;
    @Override
    public APINode getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
    };

    @Override
    public APINode parseResponse(String response, String header) throws APIException {
      return APINode.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public APINode execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public APINode execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<APINode> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<APINode> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, APINode>() {
           public APINode apply(ResponseWrapper result) {
             try {
               return APIRequestDelete.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestDelete(String nodeId, APIContext context) {
      super(context, nodeId, "/", "DELETE", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestDelete setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestDelete setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestDelete requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestDelete requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestDelete requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestDelete requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static class APIRequestGet extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "account_id",
      "async_percent_completion",
      "async_status",
      "date_start",
      "date_stop",
      "emails",
      "friendly_name",
      "id",
      "is_bookmarked",
      "is_running",
      "schedule_id",
      "time_completed",
      "time_ref",
    };

    @Override
    public AdReportRun parseResponse(String response, String header) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdReportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdReportRun>() {
           public AdReportRun apply(ResponseWrapper result) {
             try {
               return APIRequestGet.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestAccountIdField () {
      return this.requestAccountIdField(true);
    }
    public APIRequestGet requestAccountIdField (boolean value) {
      this.requestField("account_id", value);
      return this;
    }
    public APIRequestGet requestAsyncPercentCompletionField () {
      return this.requestAsyncPercentCompletionField(true);
    }
    public APIRequestGet requestAsyncPercentCompletionField (boolean value) {
      this.requestField("async_percent_completion", value);
      return this;
    }
    public APIRequestGet requestAsyncStatusField () {
      return this.requestAsyncStatusField(true);
    }
    public APIRequestGet requestAsyncStatusField (boolean value) {
      this.requestField("async_status", value);
      return this;
    }
    public APIRequestGet requestDateStartField () {
      return this.requestDateStartField(true);
    }
    public APIRequestGet requestDateStartField (boolean value) {
      this.requestField("date_start", value);
      return this;
    }
    public APIRequestGet requestDateStopField () {
      return this.requestDateStopField(true);
    }
    public APIRequestGet requestDateStopField (boolean value) {
      this.requestField("date_stop", value);
      return this;
    }
    public APIRequestGet requestEmailsField () {
      return this.requestEmailsField(true);
    }
    public APIRequestGet requestEmailsField (boolean value) {
      this.requestField("emails", value);
      return this;
    }
    public APIRequestGet requestFriendlyNameField () {
      return this.requestFriendlyNameField(true);
    }
    public APIRequestGet requestFriendlyNameField (boolean value) {
      this.requestField("friendly_name", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
    public APIRequestGet requestIsBookmarkedField () {
      return this.requestIsBookmarkedField(true);
    }
    public APIRequestGet requestIsBookmarkedField (boolean value) {
      this.requestField("is_bookmarked", value);
      return this;
    }
    public APIRequestGet requestIsRunningField () {
      return this.requestIsRunningField(true);
    }
    public APIRequestGet requestIsRunningField (boolean value) {
      this.requestField("is_running", value);
      return this;
    }
    public APIRequestGet requestScheduleIdField () {
      return this.requestScheduleIdField(true);
    }
    public APIRequestGet requestScheduleIdField (boolean value) {
      this.requestField("schedule_id", value);
      return this;
    }
    public APIRequestGet requestTimeCompletedField () {
      return this.requestTimeCompletedField(true);
    }
    public APIRequestGet requestTimeCompletedField (boolean value) {
      this.requestField("time_completed", value);
      return this;
    }
    public APIRequestGet requestTimeRefField () {
      return this.requestTimeRefField(true);
    }
    public APIRequestGet requestTimeRefField (boolean value) {
      this.requestField("time_ref", value);
      return this;
    }
  }

  public static class APIRequestUpdate extends APIRequest<AdReportRun> {

    AdReportRun lastResponse = null;
    @Override
    public AdReportRun getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
      "emails",
      "is_bookmarked",
    };

    public static final String[] FIELDS = {
    };

    @Override
    public AdReportRun parseResponse(String response, String header) throws APIException {
      return AdReportRun.parseResponse(response, getContext(), this, header).head();
    }

    @Override
    public AdReportRun execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdReportRun execute(Map<String, Object> extraParams) throws APIException {
      ResponseWrapper rw = executeInternal(extraParams);
      lastResponse = parseResponse(rw.getBody(), rw.getHeader());
      return lastResponse;
    }

    public ListenableFuture<AdReportRun> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdReportRun> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<ResponseWrapper, AdReportRun>() {
           public AdReportRun apply(ResponseWrapper result) {
             try {
               return APIRequestUpdate.this.parseResponse(result.getBody(), result.getHeader());
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestUpdate(String nodeId, APIContext context) {
      super(context, nodeId, "/", "POST", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestUpdate setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestUpdate setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestUpdate setEmails (List<String> emails) {
      this.setParam("emails", emails);
      return this;
    }
    public APIRequestUpdate setEmails (String emails) {
      this.setParam("emails", emails);
      return this;
    }

    public APIRequestUpdate setIsBookmarked (Boolean isBookmarked) {
      this.setParam("is_bookmarked", isBookmarked);
      return this;
    }
    public APIRequestUpdate setIsBookmarked (String isBookmarked) {
      this.setParam("is_bookmarked", isBookmarked);
      return this;
    }

    public APIRequestUpdate requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestUpdate requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestUpdate requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestUpdate requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

  }

  public static enum EnumActionAttributionWindows {
      @SerializedName("1d_click")
      VALUE_1D_CLICK("1d_click"),
      @SerializedName("1d_view")
      VALUE_1D_VIEW("1d_view"),
      @SerializedName("28d_click")
      VALUE_28D_CLICK("28d_click"),
      @SerializedName("28d_view")
      VALUE_28D_VIEW("28d_view"),
      @SerializedName("7d_click")
      VALUE_7D_CLICK("7d_click"),
      @SerializedName("7d_view")
      VALUE_7D_VIEW("7d_view"),
      @SerializedName("default")
      VALUE_DEFAULT("default"),
      ;

      private String value;

      private EnumActionAttributionWindows(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionBreakdowns {
      @SerializedName("action_canvas_component_name")
      VALUE_ACTION_CANVAS_COMPONENT_NAME("action_canvas_component_name"),
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_converted_product_id")
      VALUE_ACTION_CONVERTED_PRODUCT_ID("action_converted_product_id"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_reaction")
      VALUE_ACTION_REACTION("action_reaction"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      ;

      private String value;

      private EnumActionBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumActionReportTime {
      @SerializedName("conversion")
      VALUE_CONVERSION("conversion"),
      @SerializedName("impression")
      VALUE_IMPRESSION("impression"),
      ;

      private String value;

      private EnumActionReportTime(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumBreakdowns {
      @SerializedName("ad_format_asset")
      VALUE_AD_FORMAT_ASSET("ad_format_asset"),
      @SerializedName("age")
      VALUE_AGE("age"),
      @SerializedName("body_asset")
      VALUE_BODY_ASSET("body_asset"),
      @SerializedName("call_to_action_asset")
      VALUE_CALL_TO_ACTION_ASSET("call_to_action_asset"),
      @SerializedName("country")
      VALUE_COUNTRY("country"),
      @SerializedName("description_asset")
      VALUE_DESCRIPTION_ASSET("description_asset"),
      @SerializedName("device_platform")
      VALUE_DEVICE_PLATFORM("device_platform"),
      @SerializedName("dma")
      VALUE_DMA("dma"),
      @SerializedName("frequency_value")
      VALUE_FREQUENCY_VALUE("frequency_value"),
      @SerializedName("gender")
      VALUE_GENDER("gender"),
      @SerializedName("hourly_stats_aggregated_by_advertiser_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_ADVERTISER_TIME_ZONE("hourly_stats_aggregated_by_advertiser_time_zone"),
      @SerializedName("hourly_stats_aggregated_by_audience_time_zone")
      VALUE_HOURLY_STATS_AGGREGATED_BY_AUDIENCE_TIME_ZONE("hourly_stats_aggregated_by_audience_time_zone"),
      @SerializedName("image_asset")
      VALUE_IMAGE_ASSET("image_asset"),
      @SerializedName("impression_device")
      VALUE_IMPRESSION_DEVICE("impression_device"),
      @SerializedName("link_url_asset")
      VALUE_LINK_URL_ASSET("link_url_asset"),
      @SerializedName("place_page_id")
      VALUE_PLACE_PAGE_ID("place_page_id"),
      @SerializedName("platform_position")
      VALUE_PLATFORM_POSITION("platform_position"),
      @SerializedName("product_id")
      VALUE_PRODUCT_ID("product_id"),
      @SerializedName("publisher_platform")
      VALUE_PUBLISHER_PLATFORM("publisher_platform"),
      @SerializedName("region")
      VALUE_REGION("region"),
      @SerializedName("title_asset")
      VALUE_TITLE_ASSET("title_asset"),
      @SerializedName("video_asset")
      VALUE_VIDEO_ASSET("video_asset"),
      ;

      private String value;

      private EnumBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumDatePreset {
      @SerializedName("last_14d")
      VALUE_LAST_14D("last_14d"),
      @SerializedName("last_28d")
      VALUE_LAST_28D("last_28d"),
      @SerializedName("last_30d")
      VALUE_LAST_30D("last_30d"),
      @SerializedName("last_3d")
      VALUE_LAST_3D("last_3d"),
      @SerializedName("last_7d")
      VALUE_LAST_7D("last_7d"),
      @SerializedName("last_90d")
      VALUE_LAST_90D("last_90d"),
      @SerializedName("last_month")
      VALUE_LAST_MONTH("last_month"),
      @SerializedName("last_quarter")
      VALUE_LAST_QUARTER("last_quarter"),
      @SerializedName("last_week_mon_sun")
      VALUE_LAST_WEEK_MON_SUN("last_week_mon_sun"),
      @SerializedName("last_week_sun_sat")
      VALUE_LAST_WEEK_SUN_SAT("last_week_sun_sat"),
      @SerializedName("last_year")
      VALUE_LAST_YEAR("last_year"),
      @SerializedName("lifetime")
      VALUE_LIFETIME("lifetime"),
      @SerializedName("this_month")
      VALUE_THIS_MONTH("this_month"),
      @SerializedName("this_quarter")
      VALUE_THIS_QUARTER("this_quarter"),
      @SerializedName("this_week_mon_today")
      VALUE_THIS_WEEK_MON_TODAY("this_week_mon_today"),
      @SerializedName("this_week_sun_today")
      VALUE_THIS_WEEK_SUN_TODAY("this_week_sun_today"),
      @SerializedName("this_year")
      VALUE_THIS_YEAR("this_year"),
      @SerializedName("today")
      VALUE_TODAY("today"),
      @SerializedName("yesterday")
      VALUE_YESTERDAY("yesterday"),
      ;

      private String value;

      private EnumDatePreset(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumLevel {
      @SerializedName("account")
      VALUE_ACCOUNT("account"),
      @SerializedName("ad")
      VALUE_AD("ad"),
      @SerializedName("adset")
      VALUE_ADSET("adset"),
      @SerializedName("campaign")
      VALUE_CAMPAIGN("campaign"),
      ;

      private String value;

      private EnumLevel(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
  }

  public static enum EnumSummaryActionBreakdowns {
      @SerializedName("action_canvas_component_name")
      VALUE_ACTION_CANVAS_COMPONENT_NAME("action_canvas_component_name"),
      @SerializedName("action_carousel_card_id")
      VALUE_ACTION_CAROUSEL_CARD_ID("action_carousel_card_id"),
      @SerializedName("action_carousel_card_name")
      VALUE_ACTION_CAROUSEL_CARD_NAME("action_carousel_card_name"),
      @SerializedName("action_converted_product_id")
      VALUE_ACTION_CONVERTED_PRODUCT_ID("action_converted_product_id"),
      @SerializedName("action_destination")
      VALUE_ACTION_DESTINATION("action_destination"),
      @SerializedName("action_device")
      VALUE_ACTION_DEVICE("action_device"),
      @SerializedName("action_reaction")
      VALUE_ACTION_REACTION("action_reaction"),
      @SerializedName("action_target_id")
      VALUE_ACTION_TARGET_ID("action_target_id"),
      @SerializedName("action_type")
      VALUE_ACTION_TYPE("action_type"),
      @SerializedName("action_video_sound")
      VALUE_ACTION_VIDEO_SOUND("action_video_sound"),
      @SerializedName("action_video_type")
      VALUE_ACTION_VIDEO_TYPE("action_video_type"),
      ;

      private String value;

      private EnumSummaryActionBreakdowns(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value;
      }
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

  public AdReportRun copyFrom(AdReportRun instance) {
    this.mAccountId = instance.mAccountId;
    this.mAsyncPercentCompletion = instance.mAsyncPercentCompletion;
    this.mAsyncStatus = instance.mAsyncStatus;
    this.mDateStart = instance.mDateStart;
    this.mDateStop = instance.mDateStop;
    this.mEmails = instance.mEmails;
    this.mFriendlyName = instance.mFriendlyName;
    this.mId = instance.mId;
    this.mIsBookmarked = instance.mIsBookmarked;
    this.mIsRunning = instance.mIsRunning;
    this.mScheduleId = instance.mScheduleId;
    this.mTimeCompleted = instance.mTimeCompleted;
    this.mTimeRef = instance.mTimeRef;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdReportRun> getParser() {
    return new APIRequest.ResponseParser<AdReportRun>() {
      public APINodeList<AdReportRun> parseResponse(String response, APIContext context, APIRequest<AdReportRun> request, String header) throws MalformedResponseException {
        return AdReportRun.parseResponse(response, context, request, header);
      }
    };
  }
}
