
package kin.devplatform.bi.events;

// Augmented by script

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kin.devplatform.bi.Event;
import kin.devplatform.bi.EventsStore;


/**
 * Client receives the spending offer he purchased (e.g. coupon code) 
 * 
 */
public class SpendOrderCompleted implements Event {
    public static final String EVENT_NAME = "spend_order_completed";
    public static final String EVENT_TYPE = "business";

    // Augmented by script
	public static SpendOrderCompleted create(String offerId, String orderId, SpendOrderCompleted.Origin origin,
		Double kinAmount) {
        return new SpendOrderCompleted(
            (Common) EventsStore.common(),
            (User) EventsStore.user(),
            (Client) EventsStore.client(),
            offerId,
            orderId,
            origin,
            kinAmount);
    }

    /**
	 *
     * (Required)
	 *
     */
    @SerializedName("event_name")
    @Expose
    private String eventName = EVENT_NAME;
    /**
	 *
     * (Required)
	 *
     */
    @SerializedName("event_type")
    @Expose
    private String eventType = EVENT_TYPE;
    /**
	 * common properties for all events
	 * (Required)
	 *
     */
    @SerializedName("common")
    @Expose
    private Common common;
    /**
	 * common user properties
	 * (Required)
	 *
     */
    @SerializedName("user")
    @Expose
    private User user;
    /**
	 * common properties for all client events
	 * (Required)
	 *
     */
    @SerializedName("client")
    @Expose
    private Client client;
    /**
	 *
     * (Required)
	 *
     */
    @SerializedName("offer_id")
    @Expose
    private String offerId;
    /**
	 *
     * (Required)
	 *
     */
    @SerializedName("order_id")
    @Expose
    private String orderId;
    /**
	 *
     * (Required)
	 *
     */
    @SerializedName("origin")
    @Expose
    private SpendOrderCompleted.Origin origin;
    /**
	 *
     * (Required)
	 *
     */
    @SerializedName("kin_amount")
    @Expose
    private Double kinAmount;

    /**
     * No args constructor for use in serialization
	 *
     */
    public SpendOrderCompleted() {
    }

    /**
	 *
     * @param common
     * @param orderId
     * @param origin

     * @param client
     * @param offerId
     * @param kinAmount

     * @param user
     */
	public SpendOrderCompleted(Common common, User user, Client client, String offerId, String orderId,
		SpendOrderCompleted.Origin origin, Double kinAmount) {
        super();
        this.common = common;
        this.user = user;
        this.client = client;
        this.offerId = offerId;
        this.orderId = orderId;
        this.origin = origin;
        this.kinAmount = kinAmount;
    }

    /**
	 *
     * (Required)
	 *
     */
    public String getEventName() {
        return eventName;
    }

    /**
	 *
     * (Required)
	 *
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
	 *
     * (Required)
	 *
     */
    public String getEventType() {
        return eventType;
    }

    /**
	 *
     * (Required)
	 *
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
	 * common properties for all events
	 * (Required)
	 *
     */
    public Common getCommon() {
        return common;
    }

    /**
	 * common properties for all events
	 * (Required)
	 *
     */
    public void setCommon(Common common) {
        this.common = common;
    }

    /**
	 * common user properties
	 * (Required)
	 *
     */
    public User getUser() {
        return user;
    }

    /**
	 * common user properties
	 * (Required)
	 *
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
	 * common properties for all client events
	 * (Required)
	 *
     */
    public Client getClient() {
        return client;
    }

    /**
	 * common properties for all client events
	 * (Required)
	 *
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
	 *
     * (Required)
	 *
     */
    public String getOfferId() {
        return offerId;
    }

    /**
	 *
     * (Required)
	 *
     */
    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    /**
	 *
     * (Required)
	 *
     */
    public String getOrderId() {
        return orderId;
    }

    /**
	 *
     * (Required)
	 *
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
	 *
     * (Required)
	 *
     */
    public SpendOrderCompleted.Origin getOrigin() {
        return origin;
    }

    /**
	 *
     * (Required)
	 *
     */
    public void setOrigin(SpendOrderCompleted.Origin origin) {
        this.origin = origin;
    }

    /**
	 *
     * (Required)
	 *
     */
    public Double getKinAmount() {
        return kinAmount;
    }

    /**
	 *
     * (Required)
	 *
     */
    public void setKinAmount(Double kinAmount) {
        this.kinAmount = kinAmount;
    }

    public enum Origin {

        @SerializedName("marketplace")
        MARKETPLACE("marketplace"),
        @SerializedName("external")
        EXTERNAL("external");
        private final String value;
        private final static Map<String, SpendOrderCompleted.Origin> CONSTANTS = new HashMap<String, SpendOrderCompleted.Origin>();

        static {
			for (SpendOrderCompleted.Origin c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Origin(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static SpendOrderCompleted.Origin fromValue(String value) {
            SpendOrderCompleted.Origin constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
