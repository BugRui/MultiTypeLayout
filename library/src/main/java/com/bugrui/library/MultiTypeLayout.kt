package com.bugrui.library

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout

class MultiTypeLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mInflater: LayoutInflater

    private val contentViewResId: Int
    private val emptyViewResId: Int
    private val errorViewResId: Int
    private val loadingViewResId: Int
    private val noNetworkViewResId: Int

    init {
        val a =
            context.obtainStyledAttributes(attrs, R.styleable.MultiTypeLayout, defStyleAttr, 0)

        contentViewResId = a.getResourceId(
            R.styleable.MultiTypeLayout_contentLayout,
            NULL_RESOURCE_ID
        )

        emptyViewResId = a.getResourceId(
            R.styleable.MultiTypeLayout_emptyLayout,
            NULL_RESOURCE_ID
        )
        errorViewResId = a.getResourceId(
            R.styleable.MultiTypeLayout_errorLayout,
            NULL_RESOURCE_ID
        )
        loadingViewResId = a.getResourceId(
            R.styleable.MultiTypeLayout_loadingLayout,
            NULL_RESOURCE_ID
        )
        noNetworkViewResId = a.getResourceId(
            R.styleable.MultiTypeLayout_noNetworkLayout,
            NULL_RESOURCE_ID
        )

        a.recycle()
        mInflater = LayoutInflater.from(getContext())

        addShowView(
            inflateView(contentViewResId),
            STATUS_CONTENT
        )
        addHideView(
            inflateView(loadingViewResId),
            STATUS_LOADING
        )
        addHideView(
            inflateView(emptyViewResId),
            STATUS_EMPTY
        )
        addHideView(
            inflateView(errorViewResId),
            STATUS_ERROR
        )
        addHideView(
            inflateView(noNetworkViewResId),
            STATUS_NO_NETWORK
        )
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeAllViews()
    }

    private fun addHideView(view: View, index: Int, params: LayoutParams? = null) {
        view.visibility = View.GONE
        addView(
            view, index,
            params ?: DEFAULT_LAYOUT_PARAMS
        )
    }

    private fun addShowView(view: View, index: Int, params: LayoutParams? = null) {
        view.visibility = View.VISIBLE
        addView(
            view, index,
            params ?: DEFAULT_LAYOUT_PARAMS
        )
    }

    private fun inflateView(layoutId: Int): View {
        if (layoutId == NULL_RESOURCE_ID) return View(context)
        return mInflater.inflate(layoutId, null)
    }


    private fun showView(viewIndex: Int) {
        for (index in 0..childCount) {
            val childAt = getChildAt(index) ?: continue
            childAt.visibility = if (index == viewIndex) View.VISIBLE else View.GONE
        }
    }


    fun setContentLayout(view: View, params: LayoutParams? = null) {
        removeViewAt(STATUS_CONTENT)
        addShowView(
            view,
            STATUS_CONTENT,
            params
        )
    }

    fun setContentLayout(layoutId: Int, params: LayoutParams? = null) {
        removeViewAt(STATUS_CONTENT)
        addShowView(
            inflateView(layoutId),
            STATUS_CONTENT,
            params
        )
    }

    fun setLoadingLayout(view: View, params: LayoutParams? = null) {
        removeViewAt(STATUS_LOADING)
        addHideView(
            view,
            STATUS_LOADING,
            params
        )
    }

    fun setLoadingLayout(layoutId: Int, params: LayoutParams? = null) {
        removeViewAt(STATUS_LOADING)
        addHideView(
            inflateView(layoutId),
            STATUS_LOADING,
            params
        )
    }

    fun setEmptyLayout(view: View, params: LayoutParams? = null) {
        removeViewAt(STATUS_EMPTY)
        addHideView(
            view,
            STATUS_EMPTY,
            params
        )
    }

    fun setEmptyLayout(layoutId: Int, params: LayoutParams? = null) {
        removeViewAt(STATUS_EMPTY)
        addHideView(
            inflateView(layoutId),
            STATUS_EMPTY,
            params
        )
    }

    fun setErrorLayout(view: View, params: LayoutParams? = null) {
        removeViewAt(STATUS_ERROR)
        addHideView(
            view,
            STATUS_ERROR,
            params
        )
    }

    fun setErrorLayout(layoutId: Int, params: LayoutParams? = null) {
        removeViewAt(STATUS_ERROR)
        addHideView(
            inflateView(layoutId),
            STATUS_ERROR,
            params
        )
    }

    fun setNoNetworkLayout(view: View, params: LayoutParams? = null) {
        removeViewAt(STATUS_NO_NETWORK)
        addHideView(
            view,
            STATUS_NO_NETWORK,
            params
        )
    }

    fun setNoNetworkLayout(layoutId: Int, params: LayoutParams? = null) {
        removeViewAt(STATUS_NO_NETWORK)
        addHideView(
            inflateView(layoutId),
            STATUS_NO_NETWORK,
            params
        )
    }


    fun showContent() = showView(STATUS_CONTENT)

    fun showLoading() = showView(STATUS_LOADING)

    fun showEmpty() = showView(STATUS_EMPTY)

    fun showError() = showView(STATUS_ERROR)

    fun showNoNetwork() = showView(STATUS_NO_NETWORK)

    fun getContentView(): View? = getChildAt(STATUS_CONTENT)

    fun getLoadingView(): View? = getChildAt(STATUS_LOADING)

    fun getEmptyView(): View? = getChildAt(STATUS_EMPTY)

    fun getErrorView(): View? = getChildAt(STATUS_ERROR)

    fun getNoNetworkView(): View? = getChildAt(STATUS_NO_NETWORK)

    companion object {
        private val TAG = MultiTypeLayout::class.java.simpleName
        private val DEFAULT_LAYOUT_PARAMS = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        private const val STATUS_CONTENT = 0
        private const val STATUS_LOADING = 1
        private const val STATUS_EMPTY = 2
        private const val STATUS_ERROR = 3
        private const val STATUS_NO_NETWORK = 4
        private const val NULL_RESOURCE_ID = -1
    }


}