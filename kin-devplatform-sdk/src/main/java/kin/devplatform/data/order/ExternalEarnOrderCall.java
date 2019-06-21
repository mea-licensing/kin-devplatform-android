package kin.devplatform.data.order;

import androidx.annotation.NonNull;
import kin.devplatform.bi.EventLogger;
import kin.devplatform.data.blockchain.BlockchainSource;
import kin.devplatform.data.order.OrderDataSource.Remote;

class ExternalEarnOrderCall extends CreateExternalOrderCall {

	ExternalEarnOrderCall(
		@NonNull Remote remote,
		@NonNull BlockchainSource blockchainSource,
		@NonNull String orderJwt,
		@NonNull EventLogger eventLogger,
		long paymentListenerTimeout,
		@NonNull ExternalOrderCallbacks externalEarnOrderCallbacks) {
		super(remote, blockchainSource, orderJwt, eventLogger, externalEarnOrderCallbacks, paymentListenerTimeout);
	}
}