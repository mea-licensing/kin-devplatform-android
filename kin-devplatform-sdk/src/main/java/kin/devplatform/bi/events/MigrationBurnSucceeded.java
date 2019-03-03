
package kin.devplatform.bi.events;

// Augmented by script

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kin.devplatform.bi.Event;
import kin.devplatform.bi.EventsStore;


/**
 * When successfully burning
 */
public class MigrationBurnSucceeded implements Event {

	public static final String EVENT_NAME = "migration_burn_succeeded";
	public static final String EVENT_TYPE = "log";

	// Augmented by script
	public static MigrationBurnSucceeded create(MigrationBurnSucceeded.BurnReason burnReason, String publicAddress) {
		return new MigrationBurnSucceeded(
			(Common) EventsStore.common(),
			(User) EventsStore.user(),
			(Client) EventsStore.client(),
			burnReason,
			publicAddress);
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
	@SerializedName("burn_reason")
	@Expose
	private MigrationBurnSucceeded.BurnReason burnReason;
	/**
	 * (Required)
	 */
	@SerializedName("public_address")
	@Expose
	private String publicAddress;

	/**
	 * No args constructor for use in serialization
	 */
	public MigrationBurnSucceeded() {
	}

	/**
	 *
	 * @param burnReason
	 * @param common

	 * @param client
	 * @param publicAddress

	 * @param user
	 */
	public MigrationBurnSucceeded(Common common, User user, Client client, MigrationBurnSucceeded.BurnReason burnReason,
		String publicAddress) {
		super();
		this.common = common;
		this.user = user;
		this.client = client;
		this.burnReason = burnReason;
		this.publicAddress = publicAddress;
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
	public MigrationBurnSucceeded.BurnReason getBurnReason() {
		return burnReason;
	}

	/**
	 * (Required)
	 */
	public void setBurnReason(MigrationBurnSucceeded.BurnReason burnReason) {
		this.burnReason = burnReason;
	}

	/**
	 * (Required)
	 */
	public String getPublicAddress() {
		return publicAddress;
	}

	/**
	 * (Required)
	 */
	public void setPublicAddress(String publicAddress) {
		this.publicAddress = publicAddress;
	}

	public enum BurnReason {

		@SerializedName("burned")
		BURNED("burned"),
		@SerializedName("already_burned")
		ALREADY_BURNED("already_burned"),
		@SerializedName("no_account")
		NO_ACCOUNT("no_account"),
		@SerializedName("no_trustline")
		NO_TRUSTLINE("no_trustline");
		private final String value;
		private final static Map<String, MigrationBurnSucceeded.BurnReason> CONSTANTS = new HashMap<String, MigrationBurnSucceeded.BurnReason>();

		static {
			for (MigrationBurnSucceeded.BurnReason c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private BurnReason(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String value() {
			return this.value;
		}

		public static MigrationBurnSucceeded.BurnReason fromValue(String value) {
			MigrationBurnSucceeded.BurnReason constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
