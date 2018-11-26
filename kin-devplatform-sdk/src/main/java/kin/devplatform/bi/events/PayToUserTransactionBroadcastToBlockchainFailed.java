
package kin.devplatform.bi.events;

// Augmented by script

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kin.devplatform.bi.Event;
import kin.devplatform.bi.EventsStore;


/**
 * Client failed to submit payment to the blockchain
 */
public class PayToUserTransactionBroadcastToBlockchainFailed implements Event {

	public static final String EVENT_NAME = "pay_to_user_transaction_broadcast_to_blockchain_failed";
	public static final String EVENT_TYPE = "log";

	// Augmented by script
	public static PayToUserTransactionBroadcastToBlockchainFailed create(String errorReason, String offerId,
		String orderId, String errorCode, String errorMessage) {
		return new PayToUserTransactionBroadcastToBlockchainFailed(
			(Common) EventsStore.common(),
			(User) EventsStore.user(),
			(Client) EventsStore.client(),
			errorReason,
			offerId,
			orderId,
			errorCode,
			errorMessage);
	}

	/**
	 * (Required)
	 */
	@SerializedName("event_name")
	@Expose
	private String eventName = EVENT_NAME;
	/**
	 * (Required)
	 */
	@SerializedName("event_type")
	@Expose
	private String eventType = EVENT_TYPE;
	/**
	 * common properties for all events (Required)
	 */
	@SerializedName("common")
	@Expose
	private Common common;
	/**
	 * common user properties (Required)
	 */
	@SerializedName("user")
	@Expose
	private User user;
	/**
	 * common properties for all client events (Required)
	 */
	@SerializedName("client")
	@Expose
	private Client client;
	/**
	 * (Required)
	 */
	@SerializedName("error_reason")
	@Expose
	private String errorReason;
	/**
	 * (Required)
	 */
	@SerializedName("offer_id")
	@Expose
	private String offerId;
	/**
	 * (Required)
	 */
	@SerializedName("order_id")
	@Expose
	private String orderId;
	/**
	 * (Required)
	 */
	@SerializedName("error_code")
	@Expose
	private String errorCode;
	/**
	 * (Required)
	 */
	@SerializedName("error_message")
	@Expose
	private String errorMessage;

	/**
	 * No args constructor for use in serialization
	 */
	public PayToUserTransactionBroadcastToBlockchainFailed() {
	}

	/**
	 *
	 * @param common
	 * @param orderId
	 * @param errorReason
	 * @param errorMessage

	 * @param client
	 * @param offerId
	 * @param errorCode

	 * @param user
	 */
	public PayToUserTransactionBroadcastToBlockchainFailed(Common common, User user, Client client, String errorReason,
		String offerId, String orderId, String errorCode, String errorMessage) {
		super();
		this.common = common;
		this.user = user;
		this.client = client;
		this.errorReason = errorReason;
		this.offerId = offerId;
		this.orderId = orderId;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * (Required)
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * (Required)
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * (Required)
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * (Required)
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * common properties for all events (Required)
	 */
	public Common getCommon() {
		return common;
	}

	/**
	 * common properties for all events (Required)
	 */
	public void setCommon(Common common) {
		this.common = common;
	}

	/**
	 * common user properties (Required)
	 */
	public User getUser() {
		return user;
	}

	/**
	 * common user properties (Required)
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * common properties for all client events (Required)
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * common properties for all client events (Required)
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * (Required)
	 */
	public String getErrorReason() {
		return errorReason;
	}

	/**
	 * (Required)
	 */
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	/**
	 * (Required)
	 */
	public String getOfferId() {
		return offerId;
	}

	/**
	 * (Required)
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	/**
	 * (Required)
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * (Required)
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * (Required)
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * (Required)
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * (Required)
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * (Required)
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
