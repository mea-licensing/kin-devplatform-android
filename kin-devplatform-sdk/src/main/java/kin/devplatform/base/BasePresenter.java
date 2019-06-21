package kin.devplatform.base;

import androidx.annotation.CallSuper;

public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

	protected T view;

	@CallSuper
	@Override
	public void onAttach(T view) {
		this.view = view;

	}

	@CallSuper
	@Override
	public void onDetach() {
		view = null;
	}

	@Override
	public T getView() {
		return view;
	}
}
