/*
 * Fulfillment API
 * Use the Fulfillment API to complete the process of packaging, addressing, handling, and shipping each order on behalf of the seller, in accordance with the payment method and timing specified at checkout.
 *
 * The version of the OpenAPI document: v1.19.7
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package de.metas.camel.externalsystems.ebay.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.metas.camel.externalsystems.ebay.api.model.LegacyReference;
import de.metas.camel.externalsystems.ebay.api.model.SimpleAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * This type is used if the seller is issuing a refund for one or more individual order line items in a multiple line item order. Otherwise, the seller just uses the orderLevelRefundAmount container to specify the amount of the refund for the entire order.
 */
@ApiModel(description = "This type is used if the seller is issuing a refund for one or more individual order line items in a multiple line item order. Otherwise, the seller just uses the orderLevelRefundAmount container to specify the amount of the refund for the entire order.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class RefundItem
{
	public static final String SERIALIZED_NAME_REFUND_AMOUNT = "refundAmount";
	@SerializedName(SERIALIZED_NAME_REFUND_AMOUNT)
	private SimpleAmount refundAmount;

	public static final String SERIALIZED_NAME_LINE_ITEM_ID = "lineItemId";
	@SerializedName(SERIALIZED_NAME_LINE_ITEM_ID)
	private String lineItemId;

	public static final String SERIALIZED_NAME_LEGACY_REFERENCE = "legacyReference";
	@SerializedName(SERIALIZED_NAME_LEGACY_REFERENCE)
	private LegacyReference legacyReference;

	public RefundItem refundAmount(SimpleAmount refundAmount)
	{

		this.refundAmount = refundAmount;
		return this;
	}

	/**
	 * Get refundAmount
	 * 
	 * @return refundAmount
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public SimpleAmount getRefundAmount()
	{
		return refundAmount;
	}

	public void setRefundAmount(SimpleAmount refundAmount)
	{
		this.refundAmount = refundAmount;
	}

	public RefundItem lineItemId(String lineItemId)
	{

		this.lineItemId = lineItemId;
		return this;
	}

	/**
	 * The unique identifier of an order line item. This identifier is created once a buyer purchases a &#39;Buy It Now&#39; item or if an auction listing ends with a winning bidder. Either this field or the legacyReference container is needed to identify an individual order line item that will receive a refund. Note: The lineItemId field is used to identify an order line item in REST API format,
	 * and the legacyReference container is used to identify an order line item in Trading/legacy API format. Both legacy and REST API identifiers are returned in getOrder (Fulfillment API) and GetOrders (Trading API).
	 * 
	 * @return lineItemId
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The unique identifier of an order line item. This identifier is created once a buyer purchases a 'Buy It Now' item or if an auction listing ends with a winning bidder. Either this field or the legacyReference container is needed to identify an individual order line item that will receive a refund. Note: The lineItemId field is used to identify an order line item in REST API format, and the legacyReference container is used to identify an order line item in Trading/legacy API format. Both legacy and REST API identifiers are returned in getOrder (Fulfillment API) and GetOrders (Trading API).")

	public String getLineItemId()
	{
		return lineItemId;
	}

	public void setLineItemId(String lineItemId)
	{
		this.lineItemId = lineItemId;
	}

	public RefundItem legacyReference(LegacyReference legacyReference)
	{

		this.legacyReference = legacyReference;
		return this;
	}

	/**
	 * Get legacyReference
	 * 
	 * @return legacyReference
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public LegacyReference getLegacyReference()
	{
		return legacyReference;
	}

	public void setLegacyReference(LegacyReference legacyReference)
	{
		this.legacyReference = legacyReference;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		RefundItem refundItem = (RefundItem)o;
		return Objects.equals(this.refundAmount, refundItem.refundAmount) &&
				Objects.equals(this.lineItemId, refundItem.lineItemId) &&
				Objects.equals(this.legacyReference, refundItem.legacyReference);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(refundAmount, lineItemId, legacyReference);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class RefundItem {\n");
		sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
		sb.append("    lineItemId: ").append(toIndentedString(lineItemId)).append("\n");
		sb.append("    legacyReference: ").append(toIndentedString(legacyReference)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o)
	{
		if (o == null)
		{
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
